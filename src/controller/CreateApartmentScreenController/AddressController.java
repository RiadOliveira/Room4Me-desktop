package controller.CreateApartmentScreenController;

import errors.ValidationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.ScreensName;
import view.CreateApartmentScreen;

public class AddressController extends CreateApartmentController{

    
    @FXML
    private Label errorMessage;
    @FXML
    private TextField streetField;
    @FXML
    private TextField apartmentNumberField;
    @FXML
    private TextField districtField;
    @FXML
    private TextField zipCodeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField stateField;
    @FXML
    private TextField complementField;
    
    @FXML
    private Button cancelButton;
    @FXML
    void cancel(ActionEvent event) {
        CreateApartmentScreen.fechar();
    }

    @FXML
    private Button nextScreenButton;
    @FXML
    void nextScreen(ActionEvent event) {
        try {
            CreateApartmentController.address.setStreet(streetField.getText());
            CreateApartmentController.address.setApartmentNumber(apartmentNumberField.getText());
            CreateApartmentController.address.setDistrict(districtField.getText());
            int zipCode = Integer.parseInt(zipCodeField.getText());
            CreateApartmentController.address.setZipCode(zipCode);
            CreateApartmentController.address.setCity(cityField.getText());
            CreateApartmentController.address.setState(stateField.getText());
            CreateApartmentController.address.setComplement(complementField.getText());

            CreateApartmentScreen.load(ScreensName.Aspects);
    
        } catch (ValidationException e) {
            System.out.println(e.getMessage());

            errorMessage.setStyle(errorMessage.getStyle()+"visibility: true;"); 

            if(streetField.getText().trim().length()==0){
                streetField.setStyle(streetField.getStyle() + "-fx-border-width: 4;");
            } else {
                streetField.setStyle(streetField.getStyle() + "-fx-border-width: 0;");
            }
            if(apartmentNumberField.getText().trim().length()==0){
                apartmentNumberField.setStyle(apartmentNumberField.getStyle() + "-fx-border-width: 4;");
            } else {
                apartmentNumberField.setStyle(apartmentNumberField.getStyle() + "-fx-border-width: 0;");
            }
            if(districtField.getText().trim().length()==0){
                districtField.setStyle(districtField.getStyle() + "-fx-border-width: 4;");
            } else {
                districtField.setStyle(districtField.getStyle() + "-fx-border-width: 0;");
            }
            if(zipCodeField.getText().trim().length()==0){
                zipCodeField.setStyle(zipCodeField.getStyle() + "-fx-border-width: 4;");
            } else {
                zipCodeField.setStyle(zipCodeField.getStyle() + "-fx-border-width: 0;");
            }
            if(cityField.getText().trim().length()==0){
                cityField.setStyle(cityField.getStyle() + "-fx-border-width: 4;");
            } else {
                cityField.setStyle(cityField.getStyle() + "-fx-border-width: 0;");
            }
            if(stateField.getText().trim().length()==0){
                stateField.setStyle(stateField.getStyle() + "-fx-border-width: 4;");
            } else {
                stateField.setStyle(stateField.getStyle() + "-fx-border-width: 0;");
            }
            if(complementField.getText().trim().length()==0){
                complementField.setStyle(complementField.getStyle() + "-fx-border-width: 4;");
            } else {
                complementField.setStyle(complementField.getStyle() + "-fx-border-width: 0;");
            }
            
        }
        

        
    }
}
