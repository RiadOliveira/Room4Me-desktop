package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import utils.ScreensName;
import view.CreateApartmentScreen;

public class AnnounceController extends BaseController{

    @FXML
    private Button announceButton;

    @FXML
    void announce(ActionEvent event) {
        CreateApartmentScreen.load(ScreensName.Address);
    }

}
