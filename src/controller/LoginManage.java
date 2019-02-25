package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;


public class LoginManage {
	static String user;
	static String pass;
    @FXML
    private Label btn_forgotpass;

    @FXML
    private Button btn_cancellogin;

    @FXML
    private Button btn_confirmlogin;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_username;
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Button btn_forgot;

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage)btn_forgot.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void forgotPass(ActionEvent event) throws IOException {
    	Stage primaryStage = new Stage();
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fxml/Login_Forgot.fxml"));
		Scene scene = new Scene(root);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.showAndWait();
    }
    
    @FXML
    void login(ActionEvent event) throws IOException {
    	user = tf_username.getText();
    	pass = tf_password.getText();
    	String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=testDB;user=" + user + ";password="
    		                         + pass;
    		          
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		// Load SQL Server JDBC driver and establish connection.
    		
    		try (Connection connection = DriverManager.getConnection(connectionUrl)) {
    			
    			
				Stage primaryStage = new Stage();
				Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fxml/Login_Manage_Success.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.initStyle(StageStyle.UNDECORATED);
				Stage oldStage = (Stage) btn_confirmlogin.getScene().getWindow();
				oldStage.close();
				primaryStage.show();
				
					
				
    		    }
    		} catch (Exception ee) {
    			Stage primaryStage = new Stage();
				Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fxml/Login_Manage_Failed.fxml"));
				Scene scene = new Scene(root);
				primaryStage.initModality(Modality.APPLICATION_MODAL);
				primaryStage.setScene(scene);
				primaryStage.initStyle(StageStyle.UNDECORATED);
				primaryStage.showAndWait();
    		}
    	
        }

}