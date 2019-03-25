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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.xml.internal.ws.util.StringUtils;

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
import javafx.stage.FileChooser;
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

    @FXML
    private ToggleGroup toggleGroup;

	// floor 2
	   @FXML
	    private ToggleButton S21_7;

	    @FXML
	    private ToggleButton S21_8;

	    @FXML
	    private ToggleButton S21_9;

	    @FXML
	    private ToggleButton S21_10;

	    @FXML
	    private ToggleButton S21_11;

	    @FXML
	    private ToggleButton S21_12;

	    @FXML
	    private ToggleButton S21_13;

	    @FXML
	    private ToggleButton S21_14;

	    @FXML
	    private ToggleButton S21_15;

	    @FXML
	    private ToggleButton S21_16;

	    @FXML
	    private ToggleButton S21_17;

	    @FXML
	    private ToggleButton S21_18;

	    @FXML
	    private ToggleButton S21_19;

	    @FXML
	    private ToggleButton S22_7;

	    @FXML
	    private ToggleButton S22_8;

	    @FXML
	    private ToggleButton S22_9;

	    @FXML
	    private ToggleButton S22_10;

	    @FXML
	    private ToggleButton S22_11;

	    @FXML
	    private ToggleButton S22_12;

	    @FXML
	    private ToggleButton S22_13;

	    @FXML
	    private ToggleButton S22_14;

	    @FXML
	    private ToggleButton S22_15;

	    @FXML
	    private ToggleButton S22_16;

	    @FXML
	    private ToggleButton S22_17;

	    @FXML
	    private ToggleButton S22_18;

	    @FXML
	    private ToggleButton S22_19;
	    
	// floor3
	    @FXML
	    private ToggleButton S1_8;

	    @FXML
	    private ToggleButton S1_9;

	    @FXML
	    private ToggleButton S1_10;

	    @FXML
	    private ToggleButton S1_11;

	    @FXML
	    private ToggleButton S1_12;

	    @FXML
	    private ToggleButton S1_13;

	    @FXML
	    private ToggleButton S1_14;

	    @FXML
	    private ToggleButton S1_15;

	    @FXML
	    private ToggleButton S1_16;

	    @FXML
	    private ToggleButton S1_17;

	    @FXML
	    private ToggleButton S1_18;

	    @FXML
	    private ToggleButton S1_19;

	    @FXML
	    private ToggleButton S2_7;

	    @FXML
	    private ToggleButton S2_8;

	    @FXML
	    private ToggleButton S2_9;

	    @FXML
	    private ToggleButton S2_10;

	    @FXML
	    private ToggleButton S2_11;

	    @FXML
	    private ToggleButton S2_12;

	    @FXML
	    private ToggleButton S2_13;

	    @FXML
	    private ToggleButton S2_14;

	    @FXML
	    private ToggleButton S2_15;

	    @FXML
	    private ToggleButton S2_16;

	    @FXML
	    private ToggleButton S2_17;

	    @FXML
	    private ToggleButton S2_18;

	    @FXML
	    private ToggleButton S2_19;

	    @FXML
	    private ToggleButton S3_7;

	    @FXML
	    private ToggleButton S3_8;

	    @FXML
	    private ToggleButton S3_9;

	    @FXML
	    private ToggleButton S3_10;

	    @FXML
	    private ToggleButton S3_11;

	    @FXML
	    private ToggleButton S3_12;

	    @FXML
	    private ToggleButton S3_13;

	    @FXML
	    private ToggleButton S3_14;

	    @FXML
	    private ToggleButton S3_15;

	    @FXML
	    private ToggleButton S3_16;

	    @FXML
	    private ToggleButton S3_17;

	    @FXML
	    private ToggleButton S3_18;

	    @FXML
	    private ToggleButton S3_19;

	    @FXML
	    private ToggleButton S4_7;

	    @FXML
	    private ToggleButton S4_8;

	    @FXML
	    private ToggleButton S4_9;

	    @FXML
	    private ToggleButton S4_10;

	    @FXML
	    private ToggleButton S4_11;

	    @FXML
	    private ToggleButton S4_12;

	    @FXML
	    private ToggleButton S4_13;

	    @FXML
	    private ToggleButton S4_14;

	    @FXML
	    private ToggleButton S4_15;

	    @FXML
	    private ToggleButton S4_16;

	    @FXML
	    private ToggleButton S4_17;

	    @FXML
	    private ToggleButton S4_18;

	    @FXML
	    private ToggleButton S4_19;

	    @FXML
	    private ToggleButton S5_7;

	    @FXML
	    private ToggleButton S5_8;

	    @FXML
	    private ToggleButton S5_9;

	    @FXML
	    private ToggleButton S5_10;

	    @FXML
	    private ToggleButton S5_11;

	    @FXML
	    private ToggleButton S5_12;

	    @FXML
	    private ToggleButton S5_13;

	    @FXML
	    private ToggleButton S5_14;

	    @FXML
	    private ToggleButton S5_15;

	    @FXML
	    private ToggleButton S5_16;

	    @FXML
	    private ToggleButton S5_17;

	    @FXML
	    private ToggleButton S5_18;

	    @FXML
	    private ToggleButton S5_19;

	    @FXML
	    private ToggleButton S6_7;

	    @FXML
	    private ToggleButton S6_8;

	    @FXML
	    private ToggleButton S6_9;

	    @FXML
	    private ToggleButton S6_10;

	    @FXML
	    private ToggleButton S6_11;

	    @FXML
	    private ToggleButton S6_12;

	    @FXML
	    private ToggleButton S6_13;

	    @FXML
	    private ToggleButton S6_14;

	    @FXML
	    private ToggleButton S6_15;

	    @FXML
	    private ToggleButton S6_16;

	    @FXML
	    private ToggleButton S6_17;

	    @FXML
	    private ToggleButton S6_18;

	    @FXML
	    private ToggleButton S6_19;

	    @FXML
	    private ToggleButton S7_7;

	    @FXML
	    private ToggleButton S7_8;

	    @FXML
	    private ToggleButton S7_9;

	    @FXML
	    private ToggleButton S7_10;

	    @FXML
	    private ToggleButton S7_11;

	    @FXML
	    private ToggleButton S7_12;

	    @FXML
	    private ToggleButton S7_13;

	    @FXML
	    private ToggleButton S7_14;

	    @FXML
	    private ToggleButton S7_15;

	    @FXML
	    private ToggleButton S7_16;

	    @FXML
	    private ToggleButton S7_17;

	    @FXML
	    private ToggleButton S7_18;

	    @FXML
	    private ToggleButton S7_19;

	    @FXML
	    private ToggleButton S8_7;

	    @FXML
	    private ToggleButton S8_8;

	    @FXML
	    private ToggleButton S8_9;

	    @FXML
	    private ToggleButton S8_10;

	    @FXML
	    private ToggleButton S8_11;

	    @FXML
	    private ToggleButton S8_12;

	    @FXML
	    private ToggleButton S8_13;

	    @FXML
	    private ToggleButton S8_14;

	    @FXML
	    private ToggleButton S8_15;

	    @FXML
	    private ToggleButton S8_16;

	    @FXML
	    private ToggleButton S8_17;

	    @FXML
	    private ToggleButton S8_18;

	    @FXML
	    private ToggleButton S8_19;

	    @FXML
	    private ToggleButton S9_7;

	    @FXML
	    private ToggleButton S9_8;

	    @FXML
	    private ToggleButton S9_9;

	    @FXML
	    private ToggleButton S9_10;

	    @FXML
	    private ToggleButton S9_11;

	    @FXML
	    private ToggleButton S9_12;

	    @FXML
	    private ToggleButton S9_13;

	    @FXML
	    private ToggleButton S9_14;

	    @FXML
	    private ToggleButton S9_15;

	    @FXML
	    private ToggleButton S9_16;

	    @FXML
	    private ToggleButton S9_17;

	    @FXML
	    private ToggleButton S9_18;

	    @FXML
	    private ToggleButton S9_19;

	    @FXML
	    private ToggleButton S10_7;

	    @FXML
	    private ToggleButton S10_8;

	    @FXML
	    private ToggleButton S10_9;

	    @FXML
	    private ToggleButton S10_10;

	    @FXML
	    private ToggleButton S10_11;

	    @FXML
	    private ToggleButton S10_12;

	    @FXML
	    private ToggleButton S10_13;

	    @FXML
	    private ToggleButton S10_14;

	    @FXML
	    private ToggleButton S10_15;

	    @FXML
	    private ToggleButton S10_16;

	    @FXML
	    private ToggleButton S10_17;

	    @FXML
	    private ToggleButton S10_18;

	    @FXML
	    private ToggleButton S10_19;

	    @FXML
	    private ToggleButton S11_7;

	    @FXML
	    private ToggleButton S11_8;

	    @FXML
	    private ToggleButton S11_9;

	    @FXML
	    private ToggleButton S11_10;

	    @FXML
	    private ToggleButton S11_11;

	    @FXML
	    private ToggleButton S11_12;

	    @FXML
	    private ToggleButton S11_13;

	    @FXML
	    private ToggleButton S11_14;

	    @FXML
	    private ToggleButton S11_15;

	    @FXML
	    private ToggleButton S11_16;

	    @FXML
	    private ToggleButton S11_17;

	    @FXML
	    private ToggleButton S11_18;

	    @FXML
	    private ToggleButton S11_19;

	    @FXML
	    private ToggleButton S12_7;

	    @FXML
	    private ToggleButton S12_8;

	    @FXML
	    private ToggleButton S12_9;

	    @FXML
	    private ToggleButton S12_10;

	    @FXML
	    private ToggleButton S12_11;

	    @FXML
	    private ToggleButton S12_12;

	    @FXML
	    private ToggleButton S12_13;

	    @FXML
	    private ToggleButton S12_14;

	    @FXML
	    private ToggleButton S12_15;

	    @FXML
	    private ToggleButton S12_16;

	    @FXML
	    private ToggleButton S12_17;

	    @FXML
	    private ToggleButton S12_18;

	    @FXML
	    private ToggleButton S12_19;

	    @FXML
	    private ToggleButton EXT1_7;

	    @FXML
	    private ToggleButton EXT1_8;

	    @FXML
	    private ToggleButton EXT1_9;

	    @FXML
	    private ToggleButton EXT1_10;

	    @FXML
	    private ToggleButton EXT1_11;

	    @FXML
	    private ToggleButton EXT1_12;

	    @FXML
	    private ToggleButton EXT1_13;

	    @FXML
	    private ToggleButton EXT1_14;

	    @FXML
	    private ToggleButton EXT1_15;

	    @FXML
	    private ToggleButton EXT1_16;

	    @FXML
	    private ToggleButton EXT1_17;

	    @FXML
	    private ToggleButton EXT1_18;

	    @FXML
	    private ToggleButton EXT1_19;

	    @FXML
	    private ToggleButton EXT2_7;

	    @FXML
	    private ToggleButton EXT2_8;

	    @FXML
	    private ToggleButton EXT2_9;

	    @FXML
	    private ToggleButton EXT2_10;

	    @FXML
	    private ToggleButton EXT2_11;

	    @FXML
	    private ToggleButton EXT2_12;

	    @FXML
	    private ToggleButton EXT2_13;

	    @FXML
	    private ToggleButton EXT2_14;

	    @FXML
	    private ToggleButton EXT2_15;

	    @FXML
	    private ToggleButton EXT2_16;

	    @FXML
	    private ToggleButton EXT2_17;

	    @FXML
	    private ToggleButton EXT2_18;

	    @FXML
	    private ToggleButton EXT2_19;

	// floor5
	    @FXML
	    private ToggleButton DS1_7;


	    @FXML
	    private ToggleButton DS1_8;

	    @FXML
	    private ToggleButton DS1_9;

	    @FXML
	    private ToggleButton DS1_10;

	    @FXML
	    private ToggleButton DS1_11;

	    @FXML
	    private ToggleButton DS1_12;

	    @FXML
	    private ToggleButton DS1_13;

	    @FXML
	    private ToggleButton DS1_14;

	    @FXML
	    private ToggleButton DS1_15;

	    @FXML
	    private ToggleButton DS1_16;

	    @FXML
	    private ToggleButton DS1_17;

	    @FXML
	    private ToggleButton DS1_18;

	    @FXML
	    private ToggleButton DS1_19;

	    @FXML
	    private ToggleButton DS2_7;

	    @FXML
	    private ToggleButton DS2_8;

	    @FXML
	    private ToggleButton DS2_9;

	    @FXML
	    private ToggleButton DS2_10;

	    @FXML
	    private ToggleButton DS2_11;

	    @FXML
	    private ToggleButton DS2_12;

	    @FXML
	    private ToggleButton DS2_13;

	    @FXML
	    private ToggleButton DS2_14;

	    @FXML
	    private ToggleButton DS2_15;

	    @FXML
	    private ToggleButton DS2_16;

	    @FXML
	    private ToggleButton DS2_17;

	    @FXML
	    private ToggleButton DS2_18;

	    @FXML
	    private ToggleButton DS2_19;

	    @FXML
	    private ToggleButton PERC_7;

	    @FXML
	    private ToggleButton PERC_8;

	    @FXML
	    private ToggleButton PERC_9;

	    @FXML
	    private ToggleButton PERC_10;

	    @FXML
	    private ToggleButton PERC_11;

	    @FXML
	    private ToggleButton PERC_12;

	    @FXML
	    private ToggleButton PERC_13;

	    @FXML
	    private ToggleButton PERC_14;

	    @FXML
	    private ToggleButton PERC_15;

	    @FXML
	    private ToggleButton PERC_16;

	    @FXML
	    private ToggleButton PERC_17;

	    @FXML
	    private ToggleButton PERC_18;

	    @FXML
	    private ToggleButton PERC_19;

	    @FXML
	    private ToggleButton OPR1_7;

	    @FXML
	    private ToggleButton OPR1_8;

	    @FXML
	    private ToggleButton OPR1_9;

	    @FXML
	    private ToggleButton OPR1_10;

	    @FXML
	    private ToggleButton OPR1_11;

	    @FXML
	    private ToggleButton OPR1_12;

	    @FXML
	    private ToggleButton OPR1_13;

	    @FXML
	    private ToggleButton OPR1_14;

	    @FXML
	    private ToggleButton OPR1_15;

	    @FXML
	    private ToggleButton OPR1_16;

	    @FXML
	    private ToggleButton OPR1_17;

	    @FXML
	    private ToggleButton OPR1_18;

	    @FXML
	    private ToggleButton OPR1_19;

	    @FXML
	    private ToggleButton OPR2_7;

	    @FXML
	    private ToggleButton OPR2_8;

	    @FXML
	    private ToggleButton OPR2_9;

	    @FXML
	    private ToggleButton OPR2_10;

	    @FXML
	    private ToggleButton OPR2_11;

	    @FXML
	    private ToggleButton OPR2_12;

	    @FXML
	    private ToggleButton OPR2_13;

	    @FXML
	    private ToggleButton OPR2_14;

	    @FXML
	    private ToggleButton OPR2_15;

	    @FXML
	    private ToggleButton OPR2_16;

	    @FXML
	    private ToggleButton OPR2_17;

	    @FXML
	    private ToggleButton OPR2_18;

	    @FXML
	    private ToggleButton OPR2_19;

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
    static ObservableList<Toggle> rooms = null;
    static File file = null;
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
		try {
		newRoom = null;
		newRoom = (ToggleButton) toggleGroup.getSelectedToggle();
		if(newRoom.getStyleClass().toString().contains("toggle-button-UI-rented")) {
			alert = "Please select a vacant room";
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));
			
			SceneUtil.openWindow(root);
			
		} else {
			System.out.println(newRoom.getId());
			roomInfo = newRoom.getId().split("_");
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Rent_Confirmation.fxml"));
			SceneUtil.openWindow(root);
			
			}
		} catch(NullPointerException e) {
			alert = "Please select a vacant room";
			root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));
		
			SceneUtil.openWindow(root);
		}
	}
	
	 @FXML
	 void checkRent(ActionEvent event) {
		 
		 if(tf_studNum.getText().trim().isEmpty() == false && tf_firstName.getText().trim().isEmpty() == false && tf_lastName.getText().trim().isEmpty() == false && NumberUtils.isParsable(tf_studNum.getText()) ){
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
		
		root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Update.fxml"));
		SceneUtil.openWindow(root);

	}
	
	@FXML
	void confirmUpdate(ActionEvent event) throws IOException {
		if(file != null) {
		oldStage = (Stage) btn_exit.getScene().getWindow();
		root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Update_Confirmation.fxml"));
		SceneUtil.nextScene(root,"Confirmation",oldStage);
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
		XSSFRow row = null;
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
		for(int i = 0; i < 6; i++) {
			sheet = workbook.getSheetAt(i);
			for (int j = 6; j < 36; j++) {
				if(j == 20) {
					j += 3;
					continue;
				}
				for(int k = 1; k < 17 ; k++) {
					if(j < 20 && k == 12) {
						continue;
					}
					if (j < 20) {
						if (sheet.getRow(j).getCell(k).toString().isEmpty() == false) {
							try {
								Class.forName("org.apache.derby.jdbc.ClientDriver");
								Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
								PreparedStatement ps = con.prepareStatement("INSERT INTO APP.SCHEDULED_RENT (DAY_RENTED, NAME, ROOM_RENTED, TIME_RENTED) VALUES (?, ?, ?, ?)");
								ps.setString(1, workbook.getSheetAt(i).getSheetName());
								ps.setString(2, sheet.getRow(j).getCell(k).toString());
								ps.setString(3, sheet.getRow(4).getCell(k).toString().replaceAll(" ", "").replaceAll("rm", ""));
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
					else {
						if (sheet.getRow(j).getCell(k).toString().isEmpty() == false) {
							try {
								Class.forName("org.apache.derby.jdbc.ClientDriver");
								Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/srmsDB;create=true");
								PreparedStatement ps = con.prepareStatement("INSERT INTO APP.SCHEDULED_RENT (DAY_RENTED, NAME, ROOM_RENTED, TIME_RENTED) VALUES (?, ?, ?, ?)");
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
		root = (Parent) (Parent) FXMLLoader.load(getClass().getResource("/fxml/Update_Confirmation_Success.fxml"));
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
		roomInfo = newRoom.getId().split("_");
		
		root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/Remove_Confirmation.fxml"));
		SceneUtil.openWindow(root);
	} catch(NullPointerException e) {
		alert = "Please select a rented room";
		root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/alert.fxml"));
		
		SceneUtil.openWindow(root);
	}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		if(location.toString().contains("Main")) {
			curLocation = location.toString();
			Date now = new Date();
			SimpleDateFormat day = new SimpleDateFormat("EEEE");
			lbl_day.setText(day.format(now));
			
			rooms = toggleGroup.getToggles();
			System.out.print(rooms.size());
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
		
		if(location.toString().contains("alert.fxml")) {
			lbl_alert.setText(alert);
		}
		if(location.toString().contains("Remove_Confirmation.fxml")) {
			try {

				System.out.println(roomInfo[1]);
				System.out.println(roomInfo[0].replaceAll("rm", "").toUpperCase());
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
					if(lastName.trim().isEmpty() == false) {
						lbl_lastName.setText(lastName);
						lbl_firstName.setText(firstName);
						lbl_studNum.setText(studNum);
					} 
					}
					
					else {
						
						Date now = new Date();
						SimpleDateFormat day = new SimpleDateFormat("EEEE");
						System.out.println(day.format(now).toUpperCase());
						ps = con.prepareStatement("SELECT * FROM APP.SCHEDULED_RENT WHERE DAY_RENTED = ? AND TIME_RENTED = ? AND ROOM_RENTED = ?");
						ps.setString(1, day.format(now).toUpperCase());
						ps.setString(2, roomInfo[1]);
						ps.setString(3, roomInfo[0].replaceAll("rm", "").toUpperCase());
						rs = ps.executeQuery();
						while(rs.next()) {
							lastName = rs.getString("NAME");
							lbl_lastName.setText(lastName);
							
						}
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
			
			Date now = new Date();
			SimpleDateFormat day = new SimpleDateFormat("EEEE");
			
			ps = con.prepareStatement("SELECT * FROM APP.SCHEDULED_RENT WHERE DAY_RENTED = ? ORDER BY ROOM_RENTED");
			ps.setString(1, day.format(now).toUpperCase());
			rs = ps.executeQuery();
			while(rs.next()) {
				
				StringBuffer sb = new StringBuffer("");
				sb.append(rs.getString("ROOM_RENTED"));
				sb.append("_");
				sb.append(rs.getString("TIME_RENTED"));
				int size = rooms.size();
				
				for(int i = 0; i < size; i++)
					if(rooms.get(i).toString().contains(sb.toString().toLowerCase()) || rooms.get(i).toString().contains(sb.toString())) {
						
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
