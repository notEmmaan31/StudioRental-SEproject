package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.SceneUtil;
import util.Encryption;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoginManage {
	
	//LoginFXML
    @FXML
    private Label btn_forgotpass;

    @FXML
    private Button btn_cancellogin;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_username;
    
    // confirm successful login
    @FXML
    private Button btn_confirmLogin;
    
    
    //generic Exit button
    @FXML
    private Button btn_exit;
    
    //Login_Forgot FXML
    @FXML
    private Button btn_confirm;
    
    @FXML
    private TextField tf_email;

    @FXML
    private Button btn_retryError;
    
    //Change pass FXML
    @FXML
    private PasswordField pf_newPass;
    
    @FXML
    private PasswordField pf_newPassRetype;
    

	private static String connectionUrl = "jdbc:derby:C:\\Users\\kyosk\\MyDB;create=true";
	private static String driver =  "org.apache.derby.jdbc.EmbeddedDriver";
	private static Connection connection;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static String email = "";
	
    //LoginFXML
    @FXML
    void login(ActionEvent event) throws IOException {
    	String user = tf_username.getText();
    	String pass = tf_password.getText();
    	Stage oldStage;
    	Parent root;
    	try {
    		Class.forName(driver);
    		try {
    			connection = DriverManager.getConnection(connectionUrl);
    			ps = connection.prepareStatement("SELECT * FROM ACCOUNT.USERS");
    			rs = ps.executeQuery();
    			while(rs.next()) {
    				if(rs.getString("USERNAME").equalsIgnoreCase(user) && rs.getString("PASSWORD").equals(Encryption.encrypt(pass))) {
            			oldStage = (Stage) btn_exit.getScene().getWindow();
       					root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Login_Manage_Success.fxml"));
       					SceneUtil.nextScene(root, "Login Successful", oldStage);
        			}
        			else {
        				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Login_Manage_Failed.fxml"));
        				SceneUtil.openWindow(root);
        			}
    		    }

    			rs.close();
    			ps.close();
    			connection.close();
    		} catch (SQLException e) {
				root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Login_Manage_Failed.fxml"));
				SceneUtil.openWindow(root);
    		}
    	} catch (ClassNotFoundException e) {
    		root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Login_Manage_Failed.fxml"));
			SceneUtil.openWindow(root);
		}
    }
    
    @FXML
    void toMain(ActionEvent event) {
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/adminMain.fxml"));
			Stage stage = (Stage) btn_confirmLogin.getScene().getWindow();
			SceneUtil.nextScene(root, "Login Success", stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    //ForgotFXML
    @FXML
    void forgotPass(ActionEvent event) throws IOException {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Login_Forgot.fxml"));
		SceneUtil.openWindow(root);
    }
    
    @FXML
    void emailMatch(ActionEvent event) throws IOException {
    	
    	try {
    		Class.forName(driver);
			connection = DriverManager.getConnection(connectionUrl);
			ps = connection.prepareStatement("SELECT * FROM ACCOUNT.USERS");
			rs = ps.executeQuery();
			while(rs.next()) {
				email = rs.getString("EMAIL").trim();
				if(email.equalsIgnoreCase(tf_email.getText().trim())) {
					Stage oldStage = (Stage)btn_confirm.getScene().getWindow();
		    		Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/LogIn_Forgot_Match.fxml"));
		    		SceneUtil.nextScene(root, "Change password", oldStage);
				}
				else {
					Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/LogIn_Forgot_Error.fxml"));
		    		SceneUtil.openWindow(root);
				}
		    }
			
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/LogIn_Forgot_Error.fxml"));
    		SceneUtil.openWindow(root);
		} catch (ClassNotFoundException e) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/LogIn_Forgot_Error.fxml"));
    		SceneUtil.openWindow(root);
		}
    }
        
    @FXML
    void retryError(ActionEvent event) throws IOException {
    	Stage oldStage = (Stage)btn_retryError.getScene().getWindow();
    	oldStage.close();
    }
    
    //Forgot password email match FXML
    
    @FXML
    void changePass(ActionEvent event) throws IOException {
    	if (pf_newPass.getText().equals(pf_newPassRetype.getText())) {
    		try {
        		Class.forName(driver);
    			connection = DriverManager.getConnection(connectionUrl);
    			ps = connection.prepareStatement("UPDATE ACCOUNT.USERS SET PASSWORD = ? WHERE EMAIL = ?");
    			ps.setString(1, Encryption.encrypt(pf_newPass.getText()));
    			ps.setString(2, email);
    			ps.executeUpdate();
    			ps.close();
    			connection.close();
    		} catch (SQLException e) {
    			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/LogIn_Forgot_Error.fxml"));
        		SceneUtil.openWindow(root);
    		} catch (ClassNotFoundException e) {
    			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/LogIn_Forgot_Error.fxml"));
        		SceneUtil.openWindow(root);
    		}
    		
    		
    		Stage oldStage = (Stage)btn_exit.getScene().getWindow();
    		Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/LogIn_Forgot_Success.fxml"));
    		SceneUtil.nextScene(root, "Password changed", oldStage);
    	}
    	
    }
    
    //Generic exit method
    @FXML
    void exit(ActionEvent event) {
    	Stage stage = (Stage)btn_exit.getScene().getWindow();
    	stage.close();
    }


}