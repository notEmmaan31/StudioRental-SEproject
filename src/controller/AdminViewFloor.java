package controller;

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

import javafx.collections.ObservableList;
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
import javafx.stage.Stage;
import util.SceneUtil;

public class AdminViewFloor implements Initializable{

	
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
	
	// floor 2
	@FXML
	private ToggleButton s21_7;

	@FXML
	private ToggleButton s21_8;

	@FXML
	private ToggleButton s21_9;

	@FXML
	private ToggleButton s21_10;

	@FXML
	private ToggleButton s21_11;

	@FXML
	private ToggleButton s21_12;

	@FXML
	private ToggleButton s21_13;

	@FXML
	private ToggleButton s21_14;

	@FXML
	private ToggleButton s21_15;

	@FXML
	private ToggleButton s21_16;

	@FXML
	private ToggleButton s21_17;

	@FXML
	private ToggleButton s21_18;

	@FXML
	private ToggleButton s21_19;

	@FXML
	private ToggleButton s22_7;

	@FXML
	private ToggleButton s22_8;

	@FXML
	private ToggleButton s22_9;

	@FXML
	private ToggleButton s22_10;

	@FXML
	private ToggleButton s22_11;

	@FXML
	private ToggleButton s22_12;

	@FXML
	private ToggleButton s22_13;

	@FXML
	private ToggleButton s22_14;

	@FXML
	private ToggleButton s22_15;

	@FXML
	private ToggleButton s22_16;

	@FXML
	private ToggleButton s22_17;

	@FXML
	private ToggleButton s22_18;

	@FXML
	private ToggleButton s22_19;

	// floor3
	@FXML
	private ToggleButton s1_7;

	@FXML
	private ToggleButton s1_8;

	@FXML
	private ToggleButton s1_9;

	@FXML
	private ToggleButton s1_10;

	@FXML
	private ToggleButton s1_11;

	@FXML
	private ToggleButton s1_12;

	@FXML
	private ToggleButton s1_13;

	@FXML
	private ToggleButton s1_14;

	@FXML
	private ToggleButton s1_15;

	@FXML
	private ToggleButton s1_16;

	@FXML
	private ToggleButton s1_17;

	@FXML
	private ToggleButton s1_18;

	@FXML
	private ToggleButton s1_19;

	@FXML
	private ToggleButton s2_7;

	@FXML
	private ToggleButton s2_8;

	@FXML
	private ToggleButton s2_9;

	@FXML
	private ToggleButton s2_10;

	@FXML
	private ToggleButton s2_11;

	@FXML
	private ToggleButton s2_12;

	@FXML
	private ToggleButton s2_13;

	@FXML
	private ToggleButton s2_14;

	@FXML
	private ToggleButton s2_15;

	@FXML
	private ToggleButton s2_16;

	@FXML
	private ToggleButton s2_17;

	@FXML
	private ToggleButton s2_18;

	@FXML
	private ToggleButton s2_19;

	@FXML
	private ToggleButton s3_7;

	@FXML
	private ToggleButton s3_8;

	@FXML
	private ToggleButton s3_9;

	@FXML
	private ToggleButton s3_10;

	@FXML
	private ToggleButton s3_11;

	@FXML
	private ToggleButton s3_12;

	@FXML
	private ToggleButton s3_13;

	@FXML
	private ToggleButton s3_14;

	@FXML
	private ToggleButton s3_15;

	@FXML
	private ToggleButton s3_16;

	@FXML
	private ToggleButton s3_17;

	@FXML
	private ToggleButton s3_18;

	@FXML
	private ToggleButton s3_19;

	@FXML
	private ToggleButton s4_7;

	@FXML
	private ToggleButton s4_8;

	@FXML
	private ToggleButton s4_9;

	@FXML
	private ToggleButton s4_10;

	@FXML
	private ToggleButton s4_11;

	@FXML
	private ToggleButton s4_12;

	@FXML
	private ToggleButton s4_13;

	@FXML
	private ToggleButton s4_14;

	@FXML
	private ToggleButton s4_15;

	@FXML
	private ToggleButton s4_16;

	@FXML
	private ToggleButton s4_17;

	@FXML
	private ToggleButton s4_18;

	@FXML
	private ToggleButton s4_19;

	@FXML
	private ToggleButton s5_7;

	@FXML
	private ToggleButton s5_8;

	@FXML
	private ToggleButton s5_9;

	@FXML
	private ToggleButton s5_10;

	@FXML
	private ToggleButton s5_11;

	@FXML
	private ToggleButton s5_12;

	@FXML
	private ToggleButton s5_13;

	@FXML
	private ToggleButton s5_14;

	@FXML
	private ToggleButton s5_15;

	@FXML
	private ToggleButton s5_16;

	@FXML
	private ToggleButton s5_17;

	@FXML
	private ToggleButton s5_18;

	@FXML
	private ToggleButton s5_19;

	@FXML
	private ToggleButton s6_7;

	@FXML
	private ToggleButton s6_8;

	@FXML
	private ToggleButton s6_9;

	@FXML
	private ToggleButton s6_10;

	@FXML
	private ToggleButton s6_11;

	@FXML
	private ToggleButton s6_12;

	@FXML
	private ToggleButton s6_13;

	@FXML
	private ToggleButton s6_14;

	@FXML
	private ToggleButton s6_15;

	@FXML
	private ToggleButton s6_16;

	@FXML
	private ToggleButton s6_17;

	@FXML
	private ToggleButton s6_18;

	@FXML
	private ToggleButton s6_19;

	@FXML
	private ToggleButton s7_7;

	@FXML
	private ToggleButton s7_8;

	@FXML
	private ToggleButton s7_9;

	@FXML
	private ToggleButton s7_10;

	@FXML
	private ToggleButton s7_11;

	@FXML
	private ToggleButton s7_12;

	@FXML
	private ToggleButton s7_13;

	@FXML
	private ToggleButton s7_14;

	@FXML
	private ToggleButton s7_15;

	@FXML
	private ToggleButton s7_16;

	@FXML
	private ToggleButton s7_17;

	@FXML
	private ToggleButton s7_18;

	@FXML
	private ToggleButton s7_19;

	@FXML
	private ToggleButton s8_7;

	@FXML
	private ToggleButton s8_8;

	@FXML
	private ToggleButton s8_9;

	@FXML
	private ToggleButton s8_10;

	@FXML
	private ToggleButton s8_11;

	@FXML
	private ToggleButton s8_12;

	@FXML
	private ToggleButton s8_13;

	@FXML
	private ToggleButton s8_14;

	@FXML
	private ToggleButton s8_15;

	@FXML
	private ToggleButton s8_16;

	@FXML
	private ToggleButton s8_17;

	@FXML
	private ToggleButton s8_18;

	@FXML
	private ToggleButton s8_19;

	@FXML
	private ToggleButton s9_7;

	@FXML
	private ToggleButton s9_8;

	@FXML
	private ToggleButton s9_9;

	@FXML
	private ToggleButton s9_10;

	@FXML
	private ToggleButton s9_11;

	@FXML
	private ToggleButton s9_12;

	@FXML
	private ToggleButton s9_13;

	@FXML
	private ToggleButton s9_14;

	@FXML
	private ToggleButton s9_15;

	@FXML
	private ToggleButton s9_16;

	@FXML
	private ToggleButton s9_17;

	@FXML
	private ToggleButton s9_18;

	@FXML
	private ToggleButton s9_19;

	@FXML
	private ToggleButton s10_7;

	@FXML
	private ToggleButton s10_8;

	@FXML
	private ToggleButton s10_9;

	@FXML
	private ToggleButton s10_10;

	@FXML
	private ToggleButton s10_11;

	@FXML
	private ToggleButton s10_12;

	@FXML
	private ToggleButton s10_13;

	@FXML
	private ToggleButton s10_14;

	@FXML
	private ToggleButton s10_15;

	@FXML
	private ToggleButton s10_16;

	@FXML
	private ToggleButton s10_17;

	@FXML
	private ToggleButton s10_18;

	@FXML
	private ToggleButton s10_19;

	@FXML
	private ToggleButton s11_7;

	@FXML
	private ToggleButton s11_8;

	@FXML
	private ToggleButton s11_9;

	@FXML
	private ToggleButton s11_10;

	@FXML
	private ToggleButton s11_11;

	@FXML
	private ToggleButton s11_12;

	@FXML
	private ToggleButton s11_13;

	@FXML
	private ToggleButton s11_14;

	@FXML
	private ToggleButton s11_15;

	@FXML
	private ToggleButton s11_16;

	@FXML
	private ToggleButton s11_17;

	@FXML
	private ToggleButton s11_18;

	@FXML
	private ToggleButton s11_19;

	@FXML
	private ToggleButton ext1_7;

	@FXML
	private ToggleButton ext1_8;

	@FXML
	private ToggleButton ext1_9;

	@FXML
	private ToggleButton ext1_10;

	@FXML
	private ToggleButton ext1_11;

	@FXML
	private ToggleButton ext1_12;

	@FXML
	private ToggleButton ext1_13;

	@FXML
	private ToggleButton ext1_14;

	@FXML
	private ToggleButton ext1_15;

	@FXML
	private ToggleButton ext1_16;

	@FXML
	private ToggleButton ext1_17;

	@FXML
	private ToggleButton ext1_18;

	@FXML
	private ToggleButton ext1_19;

	@FXML
	private ToggleButton ext2_7;

	@FXML
	private ToggleButton ext2_8;

	@FXML
	private ToggleButton ext2_9;

	@FXML
	private ToggleButton ext2_10;

	@FXML
	private ToggleButton ext2_11;

	@FXML
	private ToggleButton ext2_12;

	@FXML
	private ToggleButton ext2_13;

	@FXML
	private ToggleButton ext2_14;

	@FXML
	private ToggleButton ext2_15;

	@FXML
	private ToggleButton ext2_16;

	@FXML
	private ToggleButton ext2_17;

	@FXML
	private ToggleButton ext2_18;

	@FXML
	private ToggleButton ext2_19;

	// floor5
	@FXML
	private ToggleButton ds1_7;

	@FXML
	private ToggleButton ds1_8;

	@FXML
	private ToggleButton ds1_9;

	@FXML
	private ToggleButton ds1_10;

	@FXML
	private ToggleButton ds1_11;

	@FXML
	private ToggleButton ds1_12;

	@FXML
	private ToggleButton ds1_13;

	@FXML
	private ToggleButton ds1_14;

	@FXML
	private ToggleButton ds1_15;

	@FXML
	private ToggleButton ds1_16;

	@FXML
	private ToggleButton ds1_17;

	@FXML
	private ToggleButton ds1_18;

	@FXML
	private ToggleButton ds1_19;

	@FXML
	private ToggleButton ds2_7;

	@FXML
	private ToggleButton ds2_8;

	@FXML
	private ToggleButton ds2_9;

	@FXML
	private ToggleButton ds2_10;

	@FXML
	private ToggleButton ds2_11;

	@FXML
	private ToggleButton ds2_12;

	@FXML
	private ToggleButton ds2_13;

	@FXML
	private ToggleButton ds2_14;

	@FXML
	private ToggleButton ds2_15;

	@FXML
	private ToggleButton ds2_16;

	@FXML
	private ToggleButton ds2_17;

	@FXML
	private ToggleButton ds2_18;

	@FXML
	private ToggleButton ds2_19;

	@FXML
	private ToggleButton perc_7;

	@FXML
	private ToggleButton perc_8;

	@FXML
	private ToggleButton perc_9;

	@FXML
	private ToggleButton perc_10;

	@FXML
	private ToggleButton perc_11;

	@FXML
	private ToggleButton perc_12;

	@FXML
	private ToggleButton perc_13;

	@FXML
	private ToggleButton perc_14;

	@FXML
	private ToggleButton perc_15;

	@FXML
	private ToggleButton perc_16;

	@FXML
	private ToggleButton perc_17;

	@FXML
	private ToggleButton perc_18;

	@FXML
	private ToggleButton perc_19;

	@FXML
	private ToggleButton opr1_7;

	@FXML
	private ToggleButton opr1_8;

	@FXML
	private ToggleButton opr1_9;

	@FXML
	private ToggleButton opr1_10;

	@FXML
	private ToggleButton opr1_11;

	@FXML
	private ToggleButton opr1_12;

	@FXML
	private ToggleButton opr1_13;

	@FXML
	private ToggleButton opr1_14;

	@FXML
	private ToggleButton opr1_15;

	@FXML
	private ToggleButton opr1_16;

	@FXML
	private ToggleButton opr1_17;

	@FXML
	private ToggleButton opr1_18;

	@FXML
	private ToggleButton opr1_19;

	@FXML
	private ToggleButton opr2_7;

	@FXML
	private ToggleButton opr2_8;

	@FXML
	private ToggleButton opr2_9;

	@FXML
	private ToggleButton opr2_10;

	@FXML
	private ToggleButton opr2_11;

	@FXML
	private ToggleButton opr2_12;

	@FXML
	private ToggleButton opr2_13;

	@FXML
	private ToggleButton opr2_14;

	@FXML
	private ToggleButton opr2_15;

	@FXML
	private ToggleButton opr2_16;

	@FXML
	private ToggleButton opr2_17;

	@FXML
	private ToggleButton opr2_18;

	@FXML
	private ToggleButton opr2_19;

	// floor6

	@FXML
	private ToggleButton rm6A_7;

	@FXML
	private ToggleButton rm6A_8;

	@FXML
	private ToggleButton rm6A_9;

	@FXML
	private ToggleButton rm6A_10;

	@FXML
	private ToggleButton rm6A_11;

	@FXML
	private ToggleButton rm6A_12;

	@FXML
	private ToggleButton rm6A_13;

	@FXML
	private ToggleButton rm6A_14;

	@FXML
	private ToggleButton rm6A_15;

	@FXML
	private ToggleButton rm6A_16;

	@FXML
	private ToggleButton rm6A_17;

	@FXML
	private ToggleButton rm6A_18;

	@FXML
	private ToggleButton rm6A_19;

	@FXML
	private ToggleButton rm6B_7;

	@FXML
	private ToggleButton rm6B_8;

	@FXML
	private ToggleButton rm6B_9;
	
    @FXML
    private ToggleGroup toggleGroup;

	@FXML
	private ToggleButton rm6B_10;

	@FXML
	private ToggleButton rm6B_11;

	@FXML
	private ToggleButton rm6B_12;

	@FXML
	private ToggleButton rm6B_13;

	@FXML
	private ToggleButton rm6B_14;

	@FXML
	private ToggleButton rm6B_15;

	@FXML
	private ToggleButton rm6B_16;

	@FXML
	private ToggleButton rm6B_17;

	@FXML
	private ToggleButton rm6B_18;

	@FXML
	private ToggleButton rm6B_19;

	@FXML
	private ToggleButton rm6C_7;

	@FXML
	private ToggleButton rm6C_8;

	@FXML
	private ToggleButton rm6C_9;

	@FXML
	private ToggleButton rm6C_10;

	@FXML
	private ToggleButton rm6C_11;

	@FXML
	private ToggleButton rm6C_12;

	@FXML
	private ToggleButton rm6C_13;

	@FXML
	private ToggleButton rm6C_14;

	@FXML
	private ToggleButton rm6C_15;

	@FXML
	private ToggleButton rm6C_16;

	@FXML
	private ToggleButton rm6C_17;

	@FXML
	private ToggleButton rm6C_18;

	@FXML
	private ToggleButton rm6C_19;

	@FXML
	private ToggleButton rm6D_7;

	@FXML
	private ToggleButton rm6D_8;

	@FXML
	private ToggleButton rm6D_9;

	@FXML
	private ToggleButton rm6D_10;

	@FXML
	private ToggleButton rm6D_11;

	@FXML
	private ToggleButton rm6D_12;

	@FXML
	private ToggleButton rm6D_13;

	@FXML
	private ToggleButton rm6D_14;

	@FXML
	private ToggleButton rm6D_15;

	@FXML
	private ToggleButton rm6D_16;

	@FXML
	private ToggleButton rm6D_17;

	@FXML
	private ToggleButton rm6D_18;

	@FXML
	private ToggleButton rm6D_19;

	@FXML
	private ToggleButton rm6E_7;

	@FXML
	private ToggleButton rm6E_8;

	@FXML
	private ToggleButton rm6E_9;

	@FXML
	private ToggleButton rm6E_10;

	@FXML
	private ToggleButton rm6E_11;

	@FXML
	private ToggleButton rm6E_12;

	@FXML
	private ToggleButton rm6E_13;

	@FXML
	private ToggleButton rm6E_14;

	@FXML
	private ToggleButton rm6E_15;

	@FXML
	private ToggleButton rm6E_16;

	@FXML
	private ToggleButton rm6E_17;

	@FXML
	private ToggleButton rm6E_18;

	@FXML
	private ToggleButton rm6E_19;

	@FXML
	private ToggleButton rm6F_7;

	@FXML
	private ToggleButton rm6F_8;

	@FXML
	private ToggleButton rm6F_9;

	@FXML
	private ToggleButton rm6F_10;

	@FXML
	private ToggleButton rm6F_11;

	@FXML
	private ToggleButton rm6F_12;

	@FXML
	private ToggleButton rm6F_13;

	@FXML
	private ToggleButton rm6F_14;

	@FXML
	private ToggleButton rm6F_15;

	@FXML
	private ToggleButton rm6F_16;

	@FXML
	private ToggleButton rm6F_17;

	@FXML
	private ToggleButton rm6F_18;

	@FXML
	private ToggleButton rm6F_19;

	@FXML
	private ToggleButton rm6G_7;

	@FXML
	private ToggleButton rm6G_8;

	@FXML
	private ToggleButton rm6G_9;

	@FXML
	private ToggleButton rm6G_10;

	@FXML
	private ToggleButton rm6G_11;

	@FXML
	private ToggleButton rm6G_12;

	@FXML
	private ToggleButton rm6G_13;

	@FXML
	private ToggleButton rm6G_14;

	@FXML
	private ToggleButton rm6G_15;

	@FXML
	private ToggleButton rm6G_16;

	@FXML
	private ToggleButton rm6G_17;

	@FXML
	private ToggleButton rm6G_18;

	@FXML
	private ToggleButton rm6G_19;

	@FXML
	private ToggleButton rm6H_7;

	@FXML
	private ToggleButton rm6H_8;

	@FXML
	private ToggleButton rm6H_9;

	@FXML
	private ToggleButton rm6H_10;

	@FXML
	private ToggleButton rm6H_11;

	@FXML
	private ToggleButton rm6H_12;

	@FXML
	private ToggleButton rm6H_13;

	@FXML
	private ToggleButton rm6H_14;

	@FXML
	private ToggleButton rm6H_15;

	@FXML
	private ToggleButton rm6H_16;

	@FXML
	private ToggleButton rm6H_17;

	@FXML
	private ToggleButton rm6H_18;

	@FXML
	private ToggleButton rm6H_19;

	@FXML
	private ToggleButton rm6I_7;

	@FXML
	private ToggleButton rm6I_8;

	@FXML
	private ToggleButton rm6I_9;

	@FXML
	private ToggleButton rm6I_10;

	@FXML
	private ToggleButton rm6I_11;

	@FXML
	private ToggleButton rm6I_12;

	@FXML
	private ToggleButton rm6I_13;

	@FXML
	private ToggleButton rm6I_14;

	@FXML
	private ToggleButton rm6I_15;

	@FXML
	private ToggleButton rm6I_16;

	@FXML
	private ToggleButton rm6I_17;

	@FXML
	private ToggleButton rm6I_18;

	@FXML
	private ToggleButton rm6I_19;

	@FXML
	private ToggleButton rm6J_7;

	@FXML
	private ToggleButton rm6J_8;

	@FXML
	private ToggleButton rm6J_9;

	@FXML
	private ToggleButton rm6J_10;

	@FXML
	private ToggleButton rm6J_11;

	@FXML
	private ToggleButton rm6J_12;

	@FXML
	private ToggleButton rm6J_13;

	@FXML
	private ToggleButton rm6J_14;

	@FXML
	private ToggleButton rm6J_15;

	@FXML
	private ToggleButton rm6J_16;

	@FXML
	private ToggleButton rm6J_17;

	@FXML
	private ToggleButton rm6J_18;

	@FXML
	private ToggleButton rm6J_19;
	
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
    private Button btn_checkRent;
    
    @FXML
    private Button btn_confirmRent;
    
    @FXML
    private Button btn_toMain;
    
    @FXML
    private Label lbl_time;
    
    @FXML
    private Button btn_confirmRemove;
    
    @FXML
    private Button btn_manage;

	@FXML
	void floor2(ActionEvent event) throws IOException {
		Stage oldStage = (Stage) btn_floor2.getScene().getWindow();
		if(curLocation.contains("Admin")) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main2F_Admin.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms (Administrator)", oldStage);
		}
		else {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main2F.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms", oldStage);
		}
		
	}

	@FXML
	void floor3(ActionEvent event) throws IOException {
		Stage oldStage = (Stage) btn_floor3.getScene().getWindow();
		if(curLocation.contains("Admin")) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main3F_Admin.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms (Administrator)", oldStage);
		}
		else {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main3F.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms", oldStage);
		}
	
	}

	@FXML
	void floor5(ActionEvent event) throws IOException {

		Stage oldStage = (Stage) btn_floor5.getScene().getWindow();
		if(curLocation.contains("Admin")) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main5F_Admin.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms (Administrator)", oldStage);
		}
		else {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main5F.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms", oldStage);
		}
		

	}

	@FXML
	void floor6(ActionEvent event) throws IOException {
		Stage oldStage = (Stage) btn_floor6.getScene().getWindow();
		if(curLocation.contains("Admin")) {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Main6F_Admin.fxml"));
			SceneUtil.nextScene(root, "6th Floor Rooms (Administrator)", oldStage);
		}
		else {
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
		
		if(newRoom.isSelected()) {
			
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
			
			
		}else {
			newRoom = null;
			}
		
	}
		
	static Parent root;
	static Date now = new Date();
	static Stage oldStage;
	static String[] roomInfo;
	static String studNum,firstName,lastName;
	
	@FXML
	void rent(ActionEvent event) throws IOException {
		
		roomInfo = newRoom.getId().split("_");
		root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Rent_Confirmation.fxml"));
		SceneUtil.openWindow(root);
		
	}
	
	 @FXML
	 void checkRent(ActionEvent event) {
		 
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
		 

	 }
		
	    @FXML
	    void confirmRent(ActionEvent event) {
	   	 try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
			PreparedStatement ps = con.prepareStatement("SELECT OID FROM APP.ORDERS ORDER BY OID DESC ");
			ResultSet rs = ps.executeQuery();
			int oid = 1;
			if(rs.next()) {
				oid = Integer.parseInt(rs.getString("OID")) + 1;
			}
			//INSERT INTO ACCOUNT.USERS (ID,USERNAME,PASSWORD,EMAIL) VALUES (?, ?, ?, ?)
			ps = con.prepareStatement("INSERT INTO APP.ORDERS (OID,STUDENT_NUMBER, LAST_NAME, FIRST_NAME, ROOM_RENTED, DATE_RENTED, TIME_RENTED, CANCELLED, PAYMENT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
		Stage stage = (Stage) btn_update.getScene().getWindow();
		stage.close();

	}

	@FXML
	void remove(ActionEvent event) throws IOException {
		roomInfo = newRoom.getId().split("_");
		
		root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Remove_Confirmation.fxml"));
		SceneUtil.openWindow(root);
		
//		newRoom.getStyleClass().clear();
//		newRoom.getStyleClass().add("toggle-button-UI");
//		newRoom.setSelected(false);
//		newRoom = null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		curLocation = location.toString();
		
		
		if(location.toString().contains("Main")) {
			Date now = new Date();
			SimpleDateFormat day = new SimpleDateFormat("EEEE");
			lbl_day.setText(day.format(now));
		
			reload();
		}
		
		if(location.toString().contains("Rent_Confirmation.fxml")) {
			lbl_rm.setText(roomInfo[0].replaceAll("rm", ""));
			
		}
		
		if(location.toString().contains("Rent_Confirmation_Check.fxml")) {
			lbl_rm.setText(roomInfo[0].replaceAll("rm", ""));
			lbl_studNum.setText(studNum);
			lbl_firstName.setText(firstName);
			lbl_lastName.setText(lastName);
		}
		
		if(location.toString().contains("Remove_Confirmation.fxml")) {
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
				PreparedStatement ps = con.prepareStatement("SELECT * FROM APP.ORDERS WHERE DATE_RENTED = ? AND TIME_RENTED = ? AND ROOM_RENTED = ? ");
				ps.setString(1, new java.sql.Date(System.currentTimeMillis()).toString());
				ps.setString(2, roomInfo[1]);
				ps.setString(3, roomInfo[0]);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					lastName = rs.getString("LAST_NAME");
					firstName = rs.getString("FIRST_NAME");
					studNum = rs.getString("STUDENT_NUMBER");
					lbl_lastName.setText(lastName);
					lbl_firstName.setText(firstName);
					lbl_studNum.setText(studNum);
					lbl_rm.setText(roomInfo[0]);
					lbl_time.setText(roomInfo[1]);
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
			PreparedStatement ps = con.prepareStatement("SELECT * FROM APP.ORDERS WHERE DATE_RENTED = ? AND CANCELLED = ? ");
			ps.setString(1, new java.sql.Date(System.currentTimeMillis()).toString());
			ps.setString(2, "false");
			ResultSet rs = ps.executeQuery();
			ObservableList<Toggle> rooms = toggleGroup.getToggles();
			
			while(rs.next()) {
				
				StringBuffer sb = new StringBuffer("");
				sb.append(rs.getString("ROOM_RENTED"));
				sb.append("_");
				sb.append(rs.getString("TIME_RENTED"));
				int size = rooms.size();
				
				for(int i = 0; i < size; i++)
					if(rooms.get(i).toString().contains(sb)) {
						
						rooms.get(i).setSelected(true);
						newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
						newRoom.getStyleClass().clear();
						newRoom.getStyleClass().add("toggle-button-UI-rented");
						newRoom.setSelected(false);
						break;
						
					}
					
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
	void confirmRemove(ActionEvent event) throws IOException {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
			PreparedStatement ps = con.prepareStatement("UPDATE APP.ORDERS SET CANCELLED = ? WHERE STUDENT_NUMBER = ? AND DATE_RENTED = ? AND TIME_RENTED = ? AND ROOM_RENTED = ?");
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
			
			
			//INSERT INTO ACCOUNT.USERS (ID,USERNAME,PASSWORD,EMAIL) VALUES (?, ?, ?, ?)
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
