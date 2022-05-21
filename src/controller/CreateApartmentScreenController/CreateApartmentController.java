package controller.CreateApartmentScreenController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.CreateApartmentScreen;

public class CreateApartmentController {

    @FXML
    private Button adressScreenButton;

    @FXML
    private Button aspectsScreenButton;

    @FXML
    private Button concludeScreenButton;

    @FXML
    private Button nextScreenButton;

    @FXML
    private Button returnScreenButton;

    @FXML
    private Button cancelButton;

    @FXML
    void adressScreen(ActionEvent event) {

    }

    @FXML
    void aspectsScreen(ActionEvent event) {

    }

    @FXML
    void concludeScreen(ActionEvent event) {

    }

    @FXML
    void nextScreen(ActionEvent event) {

    }

    @FXML
    void returnScreen(ActionEvent event) {
        
    }

    @FXML
    void cancel(ActionEvent event) {
        CreateApartmentScreen.fechar();
    }

}

