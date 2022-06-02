package controller.CreateApartmentScreenController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.ScreensName;
import view.CreateApartmentScreen;

public class ConcludeApartmentController extends CreateApartmentController {

    @FXML
    private TextField rentField;
    @FXML
    private Label errorMessage;
    
    @FXML
    private Button returnScreenButton;
    @FXML
    void returnScreen(ActionEvent event) {
        CreateApartmentScreen.load(ScreensName.Aspects);
    }
    
    @FXML
    private Button concludeButton;
    @FXML
    void conclude(ActionEvent event) {
        CreateApartmentScreen.fechar();
    }

}