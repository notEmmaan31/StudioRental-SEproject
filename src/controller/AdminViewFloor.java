package controller;

import java.io.File;
import java.io.FileInputStream;
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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.UpdateRoomService;
import services.UpdateScheduledRoomService;
import util.SceneUtil;

public class AdminViewFloor implements Initializable {

	static String curLocation;

	@FXML
	private Label lbl_day;

	@FXML
	private Button btn_logout;

	@FXML
	private Button btn_transaction;

	@FXML
	private Button btn_floor2;

	@FXML
	private Button btn_floor3;

	@FXML
	private Button btn_floor5;

	@FXML
	private Button btn_floor6;

	@FXML
	private Button btn_rent;

	@FXML
	private Button btn_remove;

	@FXML
	private Button btn_update;

	@FXML
	private ToggleGroup toggleGroup;

	@FXML
	private Button btn_exit;

	@FXML
	private Label lbl_rm;

	@FXML
	private TextField tf_studNum;

	@FXML
	private TextField tf_firstName;

	@FXML
	private TextField tf_lastName;

	@FXML
	private Label lbl_studNum;

	@FXML
	private Label lbl_lastName;

	@FXML
	private Label lbl_firstName;

	@FXML
	private Button btn_updateConfirmed;

	@FXML
	private Button btn_checkRent;

	@FXML
	private Button btn_confirmRent;

	@FXML
	private Button btn_toMain;

	@FXML
	private Label lbl_time;

	@FXML
	private Label lbl_alert;

	@FXML
	private Button btn_confirmRemove;

	@FXML
	private Button btn_manage;

	@FXML
	private Button btn_open;

	@FXML
	private Button btn_confirmUpdate;

	@FXML
	private Label lbl_file;

	static String alert;
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
	static Date now = new Date();
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
				&& tf_lastName.getText().trim().isEmpty() == false && NumberUtils.isParsable(tf_studNum.getText())) {
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

			alert = "Please input a valid information";
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));
			SceneUtil.openWindow(root);
		}

	}

	@FXML
	void confirmRent(ActionEvent event) {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
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
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
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
									Class.forName("org.apache.derby.jdbc.ClientDriver");
									Connection con = DriverManager
											.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
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
									Class.forName("org.apache.derby.jdbc.ClientDriver");
									Connection con = DriverManager
											.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
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

			workbook.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		oldStage = (Stage) btn_exit.getScene().getWindow();
		root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Update_Confirmation_Success.fxml"));
		SceneUtil.nextScene(root, "Success", oldStage);
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
		try {
			newRoom = null;
			newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
			if (newRoom.getStyleClass().toString().contains("toggle-button-UI-rented") == false) {
				alert = "Please select a rented room";
				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));

				SceneUtil.openWindow(root);

			} else {
				roomInfo = newRoom.getId().split("_");
				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Remove_Confirmation.fxml"));
				SceneUtil.openWindow(root);
			}
		} catch (NullPointerException e) {
			alert = "Please select a rented room";
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));

			SceneUtil.openWindow(root);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if (location.toString().contains("Main")) {
			curLocation = location.toString();
			Date now = new Date();
			SimpleDateFormat day = new SimpleDateFormat("EEEE");
			lbl_day.setText(day.format(now));
			reload();
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
			lbl_alert.setText(alert);
		}

		if (location.toString().contains("Remove_Confirmation.fxml")) {
			try {

				System.out.println(roomInfo[1]);
				System.out.println(roomInfo[0].replaceAll("rm", "").toUpperCase());
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
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
				lbl_time.setText(roomInfo[1]);

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
			lbl_time.setText(roomInfo[1]);
		}
	}

	public void reload() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
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
		service.setPeriod(Duration.millis(1000));
		service.setOnSucceeded((t) -> {
			for (Toggle toggle : toggleGroup.getToggles()) {
				for (String rentRoom : service.getValue()) {
					if (toggle.toString().contains(rentRoom)) {
						toggle.setSelected(true);
						newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
						newRoom.getStyleClass().clear();
						newRoom.getStyleClass().add("toggle-button-UI-rented");
						newRoom.setSelected(false);
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
		service.setPeriod(Duration.millis(1000));
		service.setOnSucceeded((t) -> {
			for (Toggle toggle : toggleGroup.getToggles()) {
				for (String rentRoom : service.getValue()) {
					if (toggle.toString().contains(rentRoom.toLowerCase()) || toggle.toString().contains(rentRoom)) {
						toggle.setSelected(true);
						newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
						newRoom.getStyleClass().clear();
						newRoom.getStyleClass().add("toggle-button-UI-rented");
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

			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
			PreparedStatement ps = con.prepareStatement(
					"UPDATE APP.ORDERS SET CANCELLED = ? WHERE STUDENT_NUMBER = ? AND DATE_RENTED = ? AND TIME_RENTED = ? AND ROOM_RENTED = ?");
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
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
