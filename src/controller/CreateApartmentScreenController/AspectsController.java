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
    
    private boolean availableToDivideChoice = false;
    @FXML
    private TextField capacityField;
    @FXML
    private TextField bedroomsQuantityField;
    @FXML
    private CheckBox availableToDivide;
    @FXML
    void availableToDivideChoice(ActionEvent event) {
        if(availableToDivideChoice){
            availableToDivideChoice = false;
        }else availableToDivideChoice = true;
        
    }
    @FXML
    private ChoiceBox<AllowedGender> allowedGenderBox;
    @FXML
    private TextField descriptionField;
    @FXML
    private Label errorMessage;
    @FXML
    private Button nextScreenButton;

    @FXML
    void nextScreen(ActionEvent event) {
        try {
            int capacity =  Integer.parseInt(capacityField.getText());
            CreateApartmentController.aspects.setCapacity(capacity);
            int bedroomsQuantity =  Integer.parseInt(bedroomsQuantityField.getText());
            CreateApartmentController.aspects.setBedroomsQuantity(bedroomsQuantity);
            CreateApartmentController.aspects.setAvailableToDivide(availableToDivideChoice);
            CreateApartmentController.aspects.setAllowedGender(allowedGenderBox.getValue());
            CreateApartmentController.aspects.setDescription(descriptionField.getText());

            CreateApartmentScreen.load(ScreensName.ConcludeApartment);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            errorMessage.setStyle(errorMessage.getStyle()+"visibility: true;"); 

            if(capacityField.getText().trim().length()==0){
                capacityField.setStyle(capacityField.getStyle() + "-fx-border-width: 4;");
            } else {
                capacityField.setStyle(capacityField.getStyle() + "-fx-border-width: 0;");
            }
            if(bedroomsQuantityField.getText().trim().length()==0){
                bedroomsQuantityField.setStyle(bedroomsQuantityField.getStyle() + "-fx-border-width: 4;");
            } else {
                bedroomsQuantityField.setStyle(bedroomsQuantityField.getStyle() + "-fx-border-width: 0;");
            }
            if(allowedGenderBox.getValue()==null){
                allowedGenderBox.setStyle(allowedGenderBox.getStyle() + "-fx-border-width: 4;");
            } else {
                allowedGenderBox.setStyle(allowedGenderBox.getStyle() + "-fx-border-width: 0;");
            }
            if(descriptionField.getText().trim().length()==0){
                descriptionField.setStyle(descriptionField.getStyle() + "-fx-border-width: 4;");
            } else {
                descriptionField.setStyle(descriptionField.getStyle() + "-fx-border-width: 0;");
            }
        }        
    }

    @FXML
    private Button returnScreenButton;
    @FXML
    void returnScreen(ActionEvent event) {
        CreateApartmentScreen.load(ScreensName.Address);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        allowedGenderBox.getItems().setAll(AllowedGender.values());
    }
    
}
