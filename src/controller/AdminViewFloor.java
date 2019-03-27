package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.derby.drda.NetworkServerControl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.UpdateRoomService;
import services.UpdateScheduledRoomService;
import util.SceneUtil;

public class AdminViewFloor implements Initializable {
	
	private static final String CONNECTION_URL = "jdbc:derby://localhost:1527/srmsDB;create=true";
	private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";

	@FXML
    private DatePicker dp_datepicker;
    
    @FXML
    private Button btn_saveDaily, btn_saveMonthly;
        
	@FXML
	private Label lbl_day, lbl_rm, lbl_time, lbl_alert ,lbl_daily, lbl_monthly;

	@FXML
	private ToggleGroup toggleGroup;

	@FXML
	private TextField tf_studNum, tf_firstName, tf_lastName;
	
	@FXML
	private Label lbl_file;

	@FXML
	private Label lbl_studNum, lbl_lastName, lbl_firstName;
	
	@FXML
	private Button btn_checkRent, btn_rent;

	@FXML
	private Button btn_floor2, btn_floor3, btn_floor5, btn_floor6;
	
	@FXML
	private Button btn_logout, btn_transaction, btn_remove, btn_update, btn_exit, btn_toMain, btn_manage;

	@FXML
	private Button btn_updateConfirmed, btn_confirmRent, btn_confirmRemove, btn_confirmUpdate, btn_open;

	private static String alert;
	private static String curLocation;
	
	static File file = null;

	@FXML
	void floor2(ActionEvent event) throws IOException {
		Stage oldStage = (Stage) btn_floor2.getScene().getWindow();
		if (curLocation.contains("Admin")) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main2F_Admin.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms (Administrator)", oldStage);
		} else {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main2F.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms", oldStage);
		}

	}

	@FXML
	void floor3(ActionEvent event) throws IOException {
		Stage oldStage = (Stage) btn_floor3.getScene().getWindow();
		if (curLocation.contains("Admin")) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main3F_Admin.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms (Administrator)", oldStage);
		} else {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main3F.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms", oldStage);
		}

	}

	@FXML
	void floor5(ActionEvent event) throws IOException {

		Stage oldStage = (Stage) btn_floor5.getScene().getWindow();
		if (curLocation.contains("Admin")) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main5F_Admin.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms (Administrator)", oldStage);
		} else {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main5F.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms", oldStage);
		}

	}

	@FXML
	void floor6(ActionEvent event) throws IOException {
		Stage oldStage = (Stage) btn_floor6.getScene().getWindow();
		if (curLocation.contains("Admin")) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main6F_Admin.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms (Administrator)", oldStage);
		} else {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main6F.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms", oldStage);
		}

	}

	@FXML
	void logout(ActionEvent event) throws IOException {
		Stage oldStage = (Stage) btn_logout.getScene().getWindow();
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main2F.fxml"));
		SceneUtil.nextScene(root, "View Rooms", oldStage);
		root.requestFocus();
	}

	@FXML
	void manage(ActionEvent event) throws IOException {
		Stage oldStage = (Stage) btn_manage.getScene().getWindow();
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Manage.fxml"));
		SceneUtil.nextScene(root, "Login", oldStage);
	}

	@FXML
	void exit(ActionEvent event) throws IOException {
		Stage stage = (Stage) btn_exit.getScene().getWindow();
		stage.close();
	}

	static ToggleButton oldRoom;
	static ToggleButton newRoom;
	static ToggleButton updateRoom;

	@FXML
	void select(ActionEvent event) throws IOException {

		newRoom = (ToggleButton) event.getSource();

		if (newRoom.isSelected()) {

			if (oldRoom != null) {
				if (oldRoom != newRoom) {
					oldRoom.setSelected(false);
					oldRoom = newRoom;
				}
			} else {
				if (oldRoom != newRoom) {
					oldRoom = newRoom;
				}
			}

		} else {
			newRoom = null;
		}

	}

	static Parent root;
	static Stage oldStage;
	static String[] roomInfo;
	static String studNum, firstName, lastName;

	@FXML
	void rent(ActionEvent event) throws IOException {
		try {
			newRoom = null;
			newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
			if (newRoom.getStyleClass().toString().contains("toggle-button-UI-rented")) {
				alert = "Please select a vacant room";
				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));

				SceneUtil.openWindow(root);

			} else {
				System.out.println(newRoom.getId());
				roomInfo = newRoom.getId().split("_");
				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Rent_Confirmation.fxml"));
				SceneUtil.openWindow(root);

			}
		} catch (NullPointerException e) {
			alert = "Please select a vacant room";
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));

			SceneUtil.openWindow(root);
		}
	}

	@FXML
	void checkRent(ActionEvent event) throws IOException {

		if (tf_studNum.getText().trim().isEmpty() == false && tf_firstName.getText().trim().isEmpty() == false
				&& tf_lastName.getText().trim().isEmpty() == false && NumberUtils.isParsable(tf_studNum.getText()) && tf_studNum.getText().toString().length() >= 10) {
			studNum = tf_studNum.getText().trim();
			firstName = tf_firstName.getText().trim();
			lastName = tf_lastName.getText().trim();

			try {
				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Rent_Confirmation_Check.fxml"));
				oldStage = (Stage) btn_exit.getScene().getWindow();
				SceneUtil.nextScene(root, "Rent confirmation", oldStage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			alert = "Please fill out requirements";
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));
			SceneUtil.openWindow(root);
		}

	}

	@FXML
	void confirmRent(ActionEvent event) {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(CONNECTION_URL);
			PreparedStatement ps = con.prepareStatement("SELECT OID FROM APP.ORDERS ORDER BY OID DESC ");
			ResultSet rs = ps.executeQuery();
			int oid = 1;
			if (rs.next()) {
				oid = Integer.parseInt(rs.getString("OID")) + 1;
			}
			// INSERT INTO ACCOUNT.USERS (ID,USERNAME,PASSWORD,EMAIL) VALUES (?, ?, ?, ?)
			ps = con.prepareStatement(
					"INSERT INTO APP.ORDERS (OID,STUDENT_NUMBER, LAST_NAME, FIRST_NAME, ROOM_RENTED, DATE_RENTED, TIME_RENTED, CANCELLED, PAYMENT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, Integer.toString(oid));
			ps.setString(2, studNum);
			ps.setString(3, lastName);
			ps.setString(4, firstName);
			ps.setString(5, roomInfo[0]);
			ps.setString(6, new java.sql.Date(System.currentTimeMillis()).toString());
			ps.setString(7, roomInfo[1]);
			ps.setString(8, "false");
			ps.setString(9, "15");
			ps.executeUpdate();
			rs.close();
			ps.close();
			con.close();
			newRoom.getStyleClass().clear();
			newRoom.getStyleClass().add("toggle-button-UI-rented");
			newRoom.setSelected(false);
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Rent_Confirmation_Success.fxml"));
			oldStage = (Stage) btn_exit.getScene().getWindow();
			SceneUtil.nextScene(root, "Rent confirmation", oldStage);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void update(ActionEvent event) throws IOException {
		root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Update.fxml"));
		SceneUtil.openWindow(root);
	}

	@FXML
	void confirmUpdate(ActionEvent event) throws IOException {
		if (file != null) {
			oldStage = (Stage) btn_exit.getScene().getWindow();
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Update_Confirmation.fxml"));
			SceneUtil.nextScene(root, "Confirmation", oldStage);
		} else {
			lbl_file.setText("Please choose a vaild excel file");
		}
	}

	@FXML
	void updateConfirmed(ActionEvent event) throws IOException {
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(new FileInputStream(file));

			XSSFSheet sheet = null;
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(CONNECTION_URL);
				PreparedStatement ps = con.prepareStatement("DELETE FROM APP.SCHEDULED_RENT WHERE 1=1");
				ps.executeUpdate();

				ps.close();
				con.close();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 6; i++) {
				sheet = workbook.getSheetAt(i);
				for (int j = 6; j < 36; j++) {
					if (j == 20) {
						j += 3;
						continue;
					}
					for (int k = 1; k < 17; k++) {
						if (j < 20 && k == 12) {
							continue;
						}
						if (j < 20) {
							if (sheet.getRow(j).getCell(k).toString().isEmpty() == false) {
								try {
									Class.forName(DRIVER);
									Connection con = DriverManager
											.getConnection(CONNECTION_URL);
									PreparedStatement ps = con.prepareStatement(
											"INSERT INTO APP.SCHEDULED_RENT (DAY_RENTED, NAME, ROOM_RENTED, TIME_RENTED) VALUES (?, ?, ?, ?)");
									ps.setString(1, workbook.getSheetAt(i).getSheetName());
									ps.setString(2, sheet.getRow(j).getCell(k).toString());
									ps.setString(3, sheet.getRow(4).getCell(k).toString().replaceAll(" ", "")
											.replaceAll("rm", ""));
									ps.setString(4, sheet.getRow(j).getCell(0).toString().replaceAll(":00", ""));
									ps.executeUpdate();
									ps.close();
									con.close();

								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}

							}
						} else {
							if (sheet.getRow(j).getCell(k).toString().isEmpty() == false) {
								try {
									Class.forName(DRIVER);
									Connection con = DriverManager
											.getConnection(CONNECTION_URL);
									PreparedStatement ps = con.prepareStatement(
											"INSERT INTO APP.SCHEDULED_RENT (DAY_RENTED, NAME, ROOM_RENTED, TIME_RENTED) VALUES (?, ?, ?, ?)");
									ps.setString(1, workbook.getSheetAt(i).getSheetName());
									ps.setString(2, sheet.getRow(j).getCell(k).toString());
									ps.setString(3, sheet.getRow(21).getCell(k).toString().replaceAll(" ", ""));
									ps.setString(4, sheet.getRow(j).getCell(0).toString().replaceAll(":00", ""));
									ps.executeUpdate();
									ps.close();
									con.close();

								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
			reload();
			workbook.close();
			
			oldStage = (Stage) btn_exit.getScene().getWindow();
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Update_Confirmation_Success.fxml"));
			SceneUtil.nextScene(root, "Success", oldStage);
		} catch (Exception e) {
			// TODO Auto-generated catch blockE
			e.printStackTrace();
			alert = "Please take the correct template";
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));
			SceneUtil.alert(root, alert);
		}
		
		
	}

	@FXML
	void openFile(ActionEvent event) throws IOException {

		file = null;
		FileChooser fc = new FileChooser();
		file = fc.showOpenDialog(null);
		lbl_file.setText(file.getPath());

	}

	@FXML
	void remove(ActionEvent event) throws IOException {
		
			newRoom = null;
			newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
			if(newRoom == null) {
				alert = "Please select a rented room";
				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));

				SceneUtil.openWindow(root);
				return;
			}
			if (newRoom.getStyleClass().toString().contains("toggle-button-UI-rented") == false) {
				alert = "Please select a rented room";
				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));

				SceneUtil.openWindow(root);

			} else {
				roomInfo = newRoom.getId().split("_");
				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Remove_Confirmation.fxml"));
				SceneUtil.openWindow(root);
			}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			NetworkServerControl server = new NetworkServerControl();
			server.start(null);
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
			PreparedStatement ps = null;
			ps = connection.prepareStatement("SELECT  * FROM    SYS.SYSSCHEMAS WHERE   SCHEMANAME = 'ACCOUNT'");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() == false) {
			ps = connection.prepareStatement("create SCHEMA account");
			ps.executeUpdate();
			}
			
			
			ps = connection.prepareStatement("SELECT  * FROM    SYS.SYSTABLES WHERE   TABLENAME = 'ORDERS'");
			rs = ps.executeQuery();
			if(!rs.next()) {
			ps = connection.prepareStatement("    	CREATE TABLE orders (\r\n" + 
					"    			OID INTEGER NOT NULL,\r\n" + 
					"    			STUDENT_NUMBER VARCHAR(20) ,\r\n" + 
					"    			LAST_NAME VARCHAR(30) ,\r\n" + 
					"    			FIRST_NAME VARCHAR(30) ,\r\n" + 
					"    			ROOM_RENTED VARCHAR(10) ,\r\n" + 
					"    			DATE_RENTED VARCHAR(20) ,\r\n" + 
					"    			TIME_RENTED VARCHAR(4) ,\r\n" + 
					"    			CANCELLED VARCHAR(5) ,\r\n" + 
					"    			PAYMENT INTEGER ,\r\n" + 
					"    			PRIMARY KEY (OID)\r\n" + 
					"    		)");
			ps.executeUpdate();
			}
			
			ps = connection.prepareStatement("SELECT  * FROM    SYS.SYSTABLES WHERE   TABLENAME = 'USERS'");
			rs = ps.executeQuery();
			if(!rs.next()) {
			ps = connection.prepareStatement("    	create TABLE account.users(\r\n" + 
					"    			id integer not NULL,\r\n" + 
					"    			username VARCHAR(120) not NULL,\r\n" + 
					"    			password VARCHAR(300) not NULL,\r\n" + 
					"    			email VARCHAR(120) not NULL,\r\n" + 
					"    			PRIMARY KEY (id)\r\n" + 
					"    		)");
			ps.executeUpdate();
			}
			
			ps = connection.prepareStatement("SELECT  * FROM    SYS.SYSTABLES WHERE   TABLENAME = 'SCHEDULED_RENT'");
			rs = ps.executeQuery();
			if(!rs.next()) {
			ps = connection.prepareStatement("create table scheduled_rent (\r\n" + 
					"	DAY_RENTED VARCHAR(20) NOT NULL,\r\n" + 
					"	NAME VARCHAR(30) NOT NULL,\r\n" + 
					"	ROOM_RENTED VARCHAR(10) NOT NULL,\r\n" + 
					"	TIME_RENTED VARCHAR(10) NOT NULL\r\n" + 
					")");
			ps.executeUpdate();
			}
		} catch (Exception e) {
			
		}

		if (location.toString().contains("Main") && !location.toString().contains("Admin")) {
			curLocation = location.toString();
			Date now = new Date();
			SimpleDateFormat day = new SimpleDateFormat("EEEE");
			lbl_day.setText(day.format(now));
			reload();
//			updateRentedRoom();
//			updateScheduledRoom();
//			updateRemovedRoom();
			
		}
		
		if (location.toString().contains("Main") && location.toString().contains("Admin")) {
			curLocation = location.toString();
			Date now = new Date();
			SimpleDateFormat day = new SimpleDateFormat("EEEE");
			lbl_day.setText(day.format(now));
			reload();
//			updateRentedRoom();
//			updateScheduledRoom();
			
		}

		if (location.toString().contains("Rent_Confirmation.fxml")) {
			lbl_rm.setText(roomInfo[0].replaceAll("rm", ""));

		}

		if (location.toString().contains("Rent_Confirmation_Check.fxml")) {
			lbl_rm.setText(roomInfo[0].replaceAll("rm", ""));
			lbl_studNum.setText(studNum);
			lbl_firstName.setText(firstName);
			lbl_lastName.setText(lastName);
		}

		if (location.toString().contains("Rent_Confirmation_Success.fxml")) {
			lbl_rm.setText(roomInfo[0].replaceAll("rm", "").toUpperCase());
		}

		if (location.toString().contains("alert.fxml")) {
			System.out.print(location);
			System.out.print(alert);
			lbl_alert.setText(alert);
		}

		if (location.toString().contains("Remove_Confirmation.fxml")) {
			
			try {

				System.out.println(roomInfo[1]);
				System.out.println(roomInfo[0].replaceAll("rm", "").toUpperCase());
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(CONNECTION_URL);
				PreparedStatement ps = con.prepareStatement(
						"SELECT * FROM APP.ORDERS WHERE DATE_RENTED = ? AND TIME_RENTED = ? AND ROOM_RENTED = ? ");
				ps.setString(1, new java.sql.Date(System.currentTimeMillis()).toString());
				ps.setString(2, roomInfo[1]);
				ps.setString(3, roomInfo[0]);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {

					lastName = rs.getString("LAST_NAME");
					firstName = rs.getString("FIRST_NAME");
					studNum = rs.getString("STUDENT_NUMBER");

					if (lastName.trim().isEmpty() == false) {

						lbl_lastName.setText(lastName);
						lbl_firstName.setText(firstName);
						lbl_studNum.setText(studNum);

					}
				}

				else {

					Date now = new Date();
					SimpleDateFormat day = new SimpleDateFormat("EEEE");
					System.out.println(day.format(now).toUpperCase());
					ps = con.prepareStatement(
							"SELECT * FROM APP.SCHEDULED_RENT WHERE DAY_RENTED = ? AND TIME_RENTED = ? AND ROOM_RENTED = ?");
					ps.setString(1, day.format(now).toUpperCase());
					ps.setString(2, roomInfo[1]);
					ps.setString(3, roomInfo[0].replaceAll("rm", "").toUpperCase());
					rs = ps.executeQuery();
					while (rs.next()) {
						lastName = rs.getString("NAME");
						lbl_lastName.setText(lastName);

					}
				}

				lbl_rm.setText(roomInfo[0]);
				lbl_time.setText(roomInfo[1] + ":00");

				rs.close();
				ps.close();
				con.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		if (location.toString().contains("Remove_Confirmation_Success.fxml")) {
			lbl_lastName.setText(lastName);
			lbl_firstName.setText(firstName);
			lbl_studNum.setText(studNum);
			lbl_rm.setText(roomInfo[0]);
			lbl_time.setText(roomInfo[1]+":00");
		}
	}
	

	public void reload() {
		for (Toggle toggle : toggleGroup.getToggles()) {
			
				toggle.setSelected(true);
				newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
				newRoom.getStyleClass().clear();
				newRoom.getStyleClass().add("toggle-button-UI");
				newRoom.setSelected(false);
				break;
			
		}
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(CONNECTION_URL);
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM APP.ORDERS WHERE DATE_RENTED = ? AND CANCELLED = ? ");
			ps.setString(1, new java.sql.Date(System.currentTimeMillis()).toString());
			ps.setString(2, "false");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				StringBuffer sb = new StringBuffer("");
				sb.append(rs.getString("ROOM_RENTED"));
				sb.append("_");
				sb.append(rs.getString("TIME_RENTED"));

				for (Toggle toggle : toggleGroup.getToggles()) {
					if (toggle.toString().contains(sb)) {
						toggle.setSelected(true);
						newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
						newRoom.getStyleClass().clear();
						newRoom.getStyleClass().add("toggle-button-UI-rented");
						newRoom.setSelected(false);
						break;
					}
				}
			}

			Date now = new Date();
			SimpleDateFormat day = new SimpleDateFormat("EEEE");

			ps = con.prepareStatement("SELECT * FROM APP.SCHEDULED_RENT WHERE DAY_RENTED = ? ORDER BY ROOM_RENTED");
			ps.setString(1, day.format(now).toUpperCase());
			rs = ps.executeQuery();

			while (rs.next()) {
				StringBuffer sb = new StringBuffer("");
				sb.append(rs.getString("ROOM_RENTED"));
				sb.append("_");
				sb.append(rs.getString("TIME_RENTED"));

				for (Toggle toggle : toggleGroup.getToggles()) {
					if (toggle.toString().contains(sb.toString().toLowerCase())
							|| toggle.toString().contains(sb.toString())) {

						toggle.setSelected(true);
						newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
						newRoom.getStyleClass().clear();
						newRoom.getStyleClass().add("toggle-button-UI-rented");
						newRoom.setSelected(false);
						break;
					}
				}
			}
			
			ps = con.prepareStatement("SELECT * FROM APP.ORDERS WHERE DATE_RENTED = ? AND CANCELLED = ? ");
			ps.setString(1, new java.sql.Date(System.currentTimeMillis()).toString());
			ps.setString(2, "true");
			rs = ps.executeQuery();
			

			while(rs.next()) {
				
				StringBuffer sb = new StringBuffer("");
				sb.append(rs.getString("ROOM_RENTED"));
				sb.append("_");
				sb.append(rs.getString("TIME_RENTED"));
				
				for (Toggle toggle : toggleGroup.getToggles()) {
					if (toggle.toString().contains(sb.toString().toLowerCase())
							|| toggle.toString().contains(sb.toString())) {

						toggle.setSelected(true);
						newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
						newRoom.getStyleClass().clear();
						newRoom.getStyleClass().add("toggle-button-UI");
						newRoom.setSelected(false);
						break;
					}
				}
			}
			
			rs.close();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// So eto yung part para doon sa
	// "SELECT * FROM APP.ORDERS WHERE DATE_RENTED = ? AND CANCELLED = ? "
	// na statement
	public void updateRentedRoom() {
		UpdateRoomService service = new UpdateRoomService();
		service.setPeriod(Duration.millis(3001));
		service.setOnSucceeded((t) -> {
			for (Toggle toggle : toggleGroup.getToggles()) {
				for (String rentRoom : service.getValue()) {
					if (toggle.toString().contains(rentRoom)) {
						toggle.setSelected(true);
						updateRoom = (ToggleButton) toggleGroup.getSelectedToggle();
						updateRoom.getStyleClass().clear();
						updateRoom.getStyleClass().add("toggle-button-UI-rented");
						updateRoom.setSelected(false);
						break;
					}
				}
			}
		});
		service.start();
	}

	// So eto yung part para doon sa
	// "SELECT * FROM APP.SCHEDULED_RENT WHERE DAY_RENTED = ? ORDER BY ROOM_RENTED"
	// na statement
	public void updateScheduledRoom() {
		UpdateScheduledRoomService service = new UpdateScheduledRoomService();
		service.setPeriod(Duration.millis(3001));
		service.setOnSucceeded((t) -> {
			for (Toggle toggle : toggleGroup.getToggles()) {
				for (String rentRoom : service.getValue()) {
					if (toggle.toString().contains(rentRoom.toLowerCase()) || toggle.toString().contains(rentRoom)) {
						toggle.setSelected(true);
						updateRoom = (ToggleButton) toggleGroup.getSelectedToggle();
						updateRoom.getStyleClass().clear();
						updateRoom.getStyleClass().add("toggle-button-UI-rented");
						updateRoom.setSelected(false);
						break;
					}
				}
			}
		});
		service.start();
	}
	
	public void updateRemovedRoom() {
		UpdateScheduledRoomService service = new UpdateScheduledRoomService();
		service.setPeriod(Duration.millis(500));
		service.setOnSucceeded((t) -> {
			for (Toggle toggle : toggleGroup.getToggles()) {
				for (String removedRoomed : service.getValue()) {
					if (toggle.toString().contains(removedRoomed.toLowerCase()) || toggle.toString().contains(removedRoomed)) {
						toggle.setSelected(true);
						newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
						newRoom.getStyleClass().clear();
						newRoom.getStyleClass().add("toggle-button-UI");
						newRoom.setSelected(false);
						break;
					}
				}
			}
		});
		service.start();
	}

	@FXML
	void confirmRemove(ActionEvent event) throws IOException {
		try {
			
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(CONNECTION_URL);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM APP.ORDERS WHERE STUDENT_NUMBER = ? AND DATE_RENTED = ? AND TIME_RENTED = ? AND ROOM_RENTED = ?");
			ps.setString(1, studNum);
			ps.setString(2, new java.sql.Date(System.currentTimeMillis()).toString());
			ps.setString(3, roomInfo[1]);
			ps.setString(4, roomInfo[0]);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			
				ps = con.prepareStatement("UPDATE APP.ORDERS SET CANCELLED = ? WHERE STUDENT_NUMBER = ? AND DATE_RENTED = ? AND TIME_RENTED = ? AND ROOM_RENTED = ?");
				ps.setString(1, "true");
				ps.setString(2, studNum);
				ps.setString(3, new java.sql.Date(System.currentTimeMillis()).toString());
				ps.setString(4, roomInfo[1]);
				ps.setString(5, roomInfo[0]);
				ps.executeUpdate();
				newRoom.getStyleClass().clear();
				newRoom.getStyleClass().add("toggle-button-UI");
				newRoom.setSelected(false);
			
				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Remove_Confirmation_Success.fxml"));
				oldStage = (Stage) btn_exit.getScene().getWindow();
				SceneUtil.nextScene(root, "Room removed successfully", oldStage);
				
			} else {
				String name = null;
				Date now = new Date();
				SimpleDateFormat day = new SimpleDateFormat("EEEE");
				
				ps = con.prepareStatement("SELECT OID FROM APP.ORDERS ORDER BY OID DESC ");
				rs = ps.executeQuery();
				int oid = 1;
				if(rs.next()) {
					oid = Integer.parseInt(rs.getString("OID")) + 1;
				}
				ps = con.prepareStatement("SELECT * FROM APP.SCHEDULED_RENT WHERE ROOM_RENTED = ? AND DAY_RENTED = ? AND TIME_RENTED = ?");
				ps.setString(1, roomInfo[0].toUpperCase());
				ps.setString(2, day.format(now).toUpperCase());
				ps.setString(3, roomInfo[1]);
				rs = ps.executeQuery();
				if(rs.next()) {
					name = rs.getString("NAME");
				}
				ps = con.prepareStatement("INSERT INTO APP.ORDERS (OID,STUDENT_NUMBER, LAST_NAME, FIRST_NAME, ROOM_RENTED, DATE_RENTED, TIME_RENTED, CANCELLED, PAYMENT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				ps.setString(1, Integer.toString(oid));
				ps.setString(2, "");
				ps.setString(3, name);
				ps.setString(4, "");
				ps.setString(5, roomInfo[0].toUpperCase());
				ps.setString(6, new java.sql.Date(System.currentTimeMillis()).toString());
				ps.setString(7, roomInfo[1]);
				ps.setString(8, "true");
				ps.setString(9, "0");
				ps.executeUpdate();
				rs.close();
				ps.close();
				newRoom.getStyleClass().clear();
				newRoom.getStyleClass().add("toggle-button-UI");
				newRoom.setSelected(false);
				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Remove_Confirmation_Success.fxml"));
				oldStage = (Stage) btn_exit.getScene().getWindow();
				SceneUtil.nextScene(root, "Room removed successfully", oldStage);
				
			}
			rs.close();
			ps.close();
			con.close();
			
			
			//INSERT INTO ACCOUNT.USERS (ID,USERNAME,PASSWORD,EMAIL) VALUES (?, ?, ?, ?)
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

		@FXML
	void transact(ActionEvent event) {
		try {
			
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Transaction.fxml"));
			SceneUtil.openWindow(root);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	void toDaily(MouseEvent event) {
		try {
			
			oldStage = (Stage) btn_exit.getScene().getWindow();
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Transaction_Daily.fxml"));
			SceneUtil.nextScene(root, "Print Daily", oldStage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@FXML
	void toMonthly(MouseEvent event) {
		try {
			
			//mn_month.
			oldStage = (Stage) btn_exit.getScene().getWindow();
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Transaction_Monthly.fxml"));
			SceneUtil.nextScene(root, "Print Monthly", oldStage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@FXML
	void save(ActionEvent event) {
		if(event.getSource().toString().contains("Daily")) {
			//dp_datepicker.getValue();
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(CONNECTION_URL);
				PreparedStatement ps = con.prepareStatement("SELECT * FROM APP.ORDERS WHERE DATE_RENTED = ?");
				ps.setString(1, dp_datepicker.getValue().toString());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					XSSFWorkbook workbook = new XSSFWorkbook();
					XSSFSheet sheet = workbook.createSheet("Transactions");
					XSSFRow row = sheet.createRow(2);
					CellStyle cs = workbook.createCellStyle();
					cs.setAlignment(HorizontalAlignment.CENTER);
					Cell cell = sheet.createRow(0).createCell(3);
					cell.setCellStyle(cs);
					cell.setCellValue("CONSERVATORY OF MUSIC");
					cell = sheet.createRow(1).createCell(3);
					cell.setCellValue("STUDIO RENTAL MONITORING SYSTEM");
					row.createCell(1).setCellValue("Order ID");
					row.createCell(2).setCellValue("Student number");
					row.createCell(3).setCellValue("Last name");
					row.createCell(4).setCellValue("First name");
					row.createCell(5).setCellValue("Room rented");
					row.createCell(6).setCellValue("Time rented");
					row.createCell(7).setCellValue("Date rented");
					row.createCell(8).setCellValue("Rent cancelled");
					row.createCell(9).setCellValue("Payment");
					int i = 3;
					while(rs.next()) {
						if(!rs.getString("STUDENT_NUMBER").isEmpty()) {
							row = sheet.createRow(i);
							row.createCell(1).setCellValue(rs.getString("OID"));
							row.createCell(2).setCellValue(rs.getString("STUDENT_NUMBER"));
							row.createCell(3).setCellValue(rs.getString("LAST_NAME"));
							row.createCell(4).setCellValue(rs.getString("FIRST_NAME"));
							row.createCell(5).setCellValue(rs.getString("ROOM_RENTED"));
							row.createCell(6).setCellValue(rs.getString("TIME_RENTED"));
							row.createCell(7).setCellValue(rs.getString("DATE_RENTED"));
							row.createCell(8).setCellValue(rs.getString("CANCELLED"));
							row.createCell(9).setCellValue(rs.getString("PAYMENT"));
							i++;
						}
					}
					sheet.autoSizeColumn(1);
					file = null;
					FileChooser fc = new FileChooser();
					fc.getExtensionFilters().add(new ExtensionFilter("Microsoft Excel", "*.xlsx"));
					file = fc.showSaveDialog(null);

//					lbl_file.setText(file.getPath());
					
					workbook.write(new FileOutputStream(file));
					workbook.close();
					Stage stage = (Stage) btn_exit.getScene().getWindow();
					stage.close();
				}
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
