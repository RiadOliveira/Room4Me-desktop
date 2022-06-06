package controller.CreateApartmentScreenController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utils.ScreensName;
import view.CreateApartmentScreen;

public class ConcludeApartmentController extends CreateApartmentController {

    @FXML
    private TextField rentField;
    @FXML
    private Label errorMessage;
    @FXML
    private Pane rendBack;
    @FXML
    private Button concludeButton;
    @FXML
    void conclude(ActionEvent event) {
        

        try {
            apartment.setOwner(owner);
            apartment.setAddress(address);
            apartment.setAspects(aspects);
            double rent = Double.parseDouble(rentField.getText());
            apartment.setRent(rent);
            
            apartmentBO.insert(apartment);
            CreateApartmentScreen.load(ScreensName.ConcludeMesage);
            

        } catch (Exception e) {
            System.out.println(e.getMessage());

            errorMessage.setStyle(errorMessage.getStyle()+"visibility: true;"); 

            if(rentField.getText().trim().length()==0){
                rentField.setStyle(rentField.getStyle() + "-fx-border-width: 4;");
                rendBack.setStyle(rendBack.getStyle() + "-fx-border-width: 4;");
            } else {
                rentField.setStyle(rentField.getStyle() + "-fx-border-width: 0;");
                rendBack.setStyle(rendBack.getStyle() + "-fx-border-width: 0;");
            }
        }
        
    }
    @FXML
    private Button returnScreenButton;
    @FXML
    void returnScreen(ActionEvent event) {
        CreateApartmentScreen.load(ScreensName.Aspects);
    }
    

}