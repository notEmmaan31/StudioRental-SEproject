import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
  


    
    @Override
    public void start(Stage primaryStage) throws Exception{
//        Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fxml/Manage.fxml"));
    	Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fxml/Main3F_Admin.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Manage");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    
    }
}