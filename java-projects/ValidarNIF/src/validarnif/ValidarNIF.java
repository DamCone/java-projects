package validarnif;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ValidarNIF extends Application{
    
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXML_ValidarNIF.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Validar NIF");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
