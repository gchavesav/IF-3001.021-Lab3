package controller;

import domain.Vector;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;

import java.util.Optional;

public class DivideConquerController
{
    @javafx.fxml.FXML
    private Pane buttonsPane;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private TextField nTextField;
    private Alert alert;
    private Vector vector;

    @javafx.fxml.FXML
    public void initialize() {
        alert = util.UtilityFX.alert("Vector Algorithm", "There was an error");
        alert.setAlertType(Alert.AlertType.ERROR);
    }

    private boolean isValid() {
        return !nTextField.getText().isEmpty()
                &&Integer.valueOf(this.nTextField.getText())>0;
    }

    @javafx.fxml.FXML
    public void createOnAction(ActionEvent actionEvent) {
        if(isValid()){
            vector = new Vector(Integer.valueOf(this.nTextField.getText()));
            this.textArea.setText("The vector has been created for "
                    +Integer.valueOf(this.nTextField.getText())+" elements");
            this.buttonsPane.setDisable(false); //habilita el panel de botones
        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again...");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void fillShowOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void removeByIndexOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addByIndexOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void containsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void removeByValueOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addByValueOnAction(ActionEvent actionEvent) {
        if(isValid()){
            if(vector==null)
                vector = new Vector(Integer.valueOf(this.nTextField.getText()));
            else
            if(vector.getCounter()<vector.getLength()){
                TextInputDialog dialog = util.UtilityFX.dialog("Vector - Add by value", "Enter the element to add");
                dialog.setTitle("Vector - Manual Filling");
                Optional<String> result = dialog.showAndWait();
                if((result.isPresent())&&(result.get().compareTo("")!=0)) {
                    int value = Integer.parseInt(result.get());
                    this.vector.add(value);
                    this.textArea.setText(vector.toString());
                }
            }else{
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Vector is full...");
                alert.showAndWait();
            }
        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Vector missing information...");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void sizeOnAction(ActionEvent actionEvent) {
    }
}