package util;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneUtil {
	
	public static void nextScene(Parent root,String title,Stage oldStage) {
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene(root));
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
		oldStage.close();
	}
	
	public static void openWindow(Parent root) {
		Stage primaryStage = new Stage();
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setScene(new Scene(root));
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.showAndWait();
	}
	
	public static void alert(Parent root,String text) {
		Stage primaryStage = new Stage();
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setScene(new Scene(root));
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.showAndWait();
	}
	
	
}
