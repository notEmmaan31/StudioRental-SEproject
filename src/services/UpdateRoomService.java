package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class UpdateRoomService extends ScheduledService<List<String>> {

	private List<String> getRentedRoom() throws ClassNotFoundException, SQLException {
		List<String> rentedRooms = new ArrayList<>();
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM APP.ORDERS WHERE DATE_RENTED = ? AND CANCELLED = ? ");
		ps.setString(1, new java.sql.Date(System.currentTimeMillis()).toString());
		ps.setString(2, "false");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			rentedRooms.add(String.format("%s_%s", rs.getString("ROOM_RENTED"), rs.getString("TIME_RENTED")));
		}
		return rentedRooms;
	}

	@Override
	protected Task<List<String>> createTask() {
		return new Task<List<String>>() {
			@Override
			protected List<String> call() throws ClassNotFoundException, SQLException {
				return getRentedRoom();
			}
		};
	}

}
