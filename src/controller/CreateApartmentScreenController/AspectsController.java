package controller.CreateApartmentScreenController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import view.CreateApartmentScreen;
import view.ScreensName;

public class AspectsController extends CreateApartmentController{
    
    @FXML
    private ToggleButton allowedGenderFemale;
    @FXML
    private ToggleButton allowedGenderMale;
    @FXML
    private ToggleButton allowedGenderOther;
    @FXML
    void allowedGenderOtherAction(ActionEvent event) {
        //allowedGenderOther.setStyle(allowedGenderOther.getStyle() + "-fx-background-color: #352D39;");
    }

    @FXML
    private CheckBox availableToDivide;
    @FXML
    private TextField bedroomsQuantityField;
    @FXML
    private TextField capacityField;
    @FXML
    private TextField descriptionField;

    @FXML
    private Button nextScreenButton;
    @FXML
    void nextScreen(ActionEvent event) {
        CreateApartmentScreen.load(ScreensName.ConcludeApartment);
    }

    @FXML
    private Button returnScreenButton;
    @FXML
    void returnScreen(ActionEvent event) {
        CreateApartmentScreen.load(ScreensName.Address);
    }
}
