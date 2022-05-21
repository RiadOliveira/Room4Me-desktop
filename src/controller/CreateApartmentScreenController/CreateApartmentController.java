package controller.CreateApartmentScreenController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.CreateApartmentScreen;
import view.ScreensName;

public class CreateApartmentController {

    @FXML
    private Button adressScreenButton;
    @FXML
    void adressScreen(ActionEvent event) {
        CreateApartmentScreen.load(ScreensName.Address);
    }

    @FXML
    private Button aspectsScreenButton;
    @FXML
    void aspectsScreen(ActionEvent event) {
        CreateApartmentScreen.load(ScreensName.Aspects);
    }

    @FXML
    private Button concludeScreenButton;
    @FXML
    void concludeScreen(ActionEvent event) {
        CreateApartmentScreen.load(ScreensName.ConcludeApartment);
    }

}

