package dataproject;

import static javafx.application.Application.launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by mait on 1/22/18.
 */
public class Main extends Application{

  @Override
  public void start(Stage primaryStage) throws Exception{
    Parent root = FXMLLoader.load(getClass().getResource("sortColorsFX.fxml"));
    primaryStage.setTitle("Color Data");
    primaryStage.setScene(new Scene(root, 700, 375));
    primaryStage.setResizable(false);
    primaryStage.show();
  }


  public static void main(String[] args) {
    launch(args);
    new ReadCatPics();

  }
}
