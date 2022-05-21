package controller.CreateApartmentScreenController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class AddressController extends CreateApartmentController{

    @FXML
    private TextField apartmentNumberField;

    @FXML
    private TextField buildingField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField complementField;

    @FXML
    private TextField districtField;

    @FXML
    private TextField referencePointField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField zipCodeField;

    @FXML
    private Button nextScreenButton;
    
    @FXML
    void nextScreen(ActionEvent event) {

    }
}
