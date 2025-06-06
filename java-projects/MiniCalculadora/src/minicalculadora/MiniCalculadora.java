package minicalculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MiniCalculadora extends Application{
    
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXML_MiniCalculadora.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Mini Calculadora");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
