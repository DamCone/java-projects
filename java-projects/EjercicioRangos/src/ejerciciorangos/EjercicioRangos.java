package ejerciciorangos;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EjercicioRangos extends Application{
 @Override
public void start(Stage primaryStage) throws IOException {
 Parent root = FXMLLoader.load(getClass().getResource("/ejRangos/EjercicioRangosFXML.fxml"));
 Scene scene = new Scene(root);
 primaryStage.setTitle("RGB");
 primaryStage.setScene(scene);
 primaryStage.show();
}

public static void main(String[] args) {
launch(args);
}
}