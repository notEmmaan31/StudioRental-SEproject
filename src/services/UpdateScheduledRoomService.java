package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class UpdateScheduledRoomService extends ScheduledService<List<String>> {

	private List<String> getScheduledRoom() throws ClassNotFoundException, SQLException {
		List<String> scheduledRoom = new ArrayList<>();
		SimpleDateFormat day = new SimpleDateFormat("EEEE");
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM APP.SCHEDULED_RENT WHERE DAY_RENTED = ? ORDER BY ROOM_RENTED");
		ps.setString(1, day.format(new Date()).toUpperCase());
		
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			scheduledRoom.add(String.format("%s_%s", rs.getString("ROOM_RENTED"), rs.getString("TIME_RENTED")));
		}
		return scheduledRoom;
	}

	@Override
	protected Task<List<String>> createTask() {
		return new Task<List<String>>() {
			@Override
			protected List<String> call() throws ClassNotFoundException, SQLException {
				return getScheduledRoom();
			}
		};
	}

}
