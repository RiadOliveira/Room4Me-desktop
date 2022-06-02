package controller.CreateApartmentScreenController;

import controller.BaseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.VO.AddressVO;
import model.VO.AspectsVO;
import utils.ScreensName;
import view.CreateApartmentScreen;

public class CreateApartmentController extends BaseController {
    public static AddressVO address = new AddressVO();
    public static AspectsVO aspects = new AspectsVO();

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

