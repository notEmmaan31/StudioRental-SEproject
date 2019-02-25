package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginSuccess {

    @FXML
    private Button btn_confirm;

    @FXML
    void confirm(ActionEvent event) throws IOException {
    	Stage stage = (Stage)btn_confirm.getScene().getWindow();
    	Stage primaryStage = new Stage();
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fxml/adminMain.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
		stage.close();
    }

}
