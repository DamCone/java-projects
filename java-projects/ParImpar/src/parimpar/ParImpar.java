package parimpar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ParImpar extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML_ParImpar.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Par o Impar");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
