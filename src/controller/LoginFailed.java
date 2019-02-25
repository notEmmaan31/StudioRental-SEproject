package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginFailed {

    @FXML
    private Button btn_confirm;
    
    
    
    @FXML
    void confirm(ActionEvent event) {
    	Stage stage = (Stage)btn_confirm.getScene().getWindow();
    	stage.close();
    }

}
