package factorial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Factorial extends Application{
    
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXML_Factorial.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("fxml_factorial.css");
        stage.setScene(scene);
        stage.setTitle("Factorial");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
