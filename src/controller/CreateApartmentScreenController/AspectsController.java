package controller.CreateApartmentScreenController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.AllowedGender;
import utils.ScreensName;
import view.CreateApartmentScreen;

public class AspectsController extends CreateApartmentController implements Initializable{
    
    
    @FXML
    private ChoiceBox<AllowedGender> allowedGenderBox;
    @FXML
    private CheckBox availableToDivide;
    @FXML
    private TextField bedroomsQuantityField;
    @FXML
    private TextField capacityField;
    @FXML
    private TextField descriptionField;
    @FXML
    private Label errorMessage;
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
