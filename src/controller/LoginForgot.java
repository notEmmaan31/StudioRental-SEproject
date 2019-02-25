package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginForgot {

    @FXML
    private TextField tf_email;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_confirm;
    
    @FXML
    private Button btn_cancelError;

    @FXML
    private Button btn_retryError;
    
    @FXML
    private Button btn_cancelMatch;

    @FXML
    private Button btn_changePass;
    
    @FXML
    private Button btn_confirmPass;

    @FXML
    void confirmPass(ActionEvent event) {
    	Stage stage = (Stage)btn_confirmPass.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void cancelMatch(ActionEvent event) {
    	Stage stage = (Stage)btn_cancelMatch.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void changePass(ActionEvent event) throws IOException {
    	Stage stage = (Stage)btn_cancelMatch.getScene().getWindow();
    	Stage primaryStage = new Stage();
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fxml/LogIn_Forgot_Success.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
    	stage.close();
    }
    @FXML
    void cancelError(ActionEvent event) {
    	Stage stage = (Stage)btn_cancelError.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void retryError(ActionEvent event) throws IOException {
    	Stage stage = (Stage)btn_cancelError.getScene().getWindow();
    	Stage primaryStage = new Stage();
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fxml/LogIn_Forgot.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
    	stage.close();
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage)btn_cancel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void confirm(ActionEvent event) throws IOException {
    	String email = "test@gmail.com";
    	if (email.equalsIgnoreCase(tf_email.getText())) {
    		Stage stage = (Stage)btn_confirm.getScene().getWindow();
    		Stage primaryStage = new Stage();
    		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fxml/LogIn_Forgot_Match.fxml"));
    		Scene scene = new Scene(root);
    		primaryStage.setScene(scene);
    		primaryStage.initStyle(StageStyle.UNDECORATED);
    		primaryStage.show();
    		stage.close();
    		
    	}
    	else {
    		Stage stage = (Stage)btn_confirm.getScene().getWindow();
        	Stage primaryStage = new Stage();
    		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fxml/LogIn_Forgot_Error.fxml"));
    		Scene scene = new Scene(root);
    		primaryStage.setScene(scene);
    		primaryStage.initStyle(StageStyle.UNDECORATED);
    		primaryStage.show();
    		stage.close();
    		
    	}
    }

}
