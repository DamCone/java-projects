
package newpackage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class ListsAndBoxesFXMLController implements Initializable {
    
    @FXML
    private ComboBox comboBox1;
    
    
    @FXML
    private ComboBox comboBox2;
    
    @FXML
    private ListView list;
    
    @FXML
    private TextField add;
    
    @FXML
    private void addElement(){
        comboBox2.getItems().add(add.getText());
        Alert a = new Alert(AlertType.NONE);
        a.setAlertType(AlertType.CONFIRMATION);
        a.setHeaderText("Information");
        a.setContentText("Has añadido ("+ add.getText() +") a ComboBox2");
    }
    
    @FXML
    private ComboBox<String> comboArray;

    @FXML
    private void removeElement(){
         if (comboBox2.getItems().contains(add.getText())) {
             comboBox2.getItems().remove(add.getText());
         }
    }
    
    @FXML
    private void setOnAction1(){
        Object selectedItem = comboBox1.getSelectionModel().getSelectedItem();
        list.getItems().add(selectedItem);
    }
    
    @FXML
    private void setOnAction2(){
        Object selectedItem = comboBox2.getSelectionModel().getSelectedItem();
        list.getItems().add(selectedItem);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox1.getItems().add("Option 1");
        comboBox1.getItems().add("Option 2");
        
        comboBox2.getItems().add("Option 1");
        comboBox2.getItems().add("Option 2");
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        list.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<String>() {
            public void onChanged(Change<? extends String> c) {
                ObservableList<String> selectedItems = list.getSelectionModel().getSelectedItems();

                if (selectedItems.size() > 1) {
                    StringBuilder message = new StringBuilder("Has seleccionado (" + selectedItems.size() + " elementos):\n");
                    for (String item : selectedItems) {
                        message.append("- ").append(item).append("\n");
                    }

                    Alert a1 = new Alert(AlertType.NONE);
                    a1.setAlertType(AlertType.CONFIRMATION);
                    a1.setHeaderText("Information");
                    a1.setContentText(message.toString());
                    a1.showAndWait(); 
                }
            }
        });
    }
    
}
