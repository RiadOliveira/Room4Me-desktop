package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.VO.ApartmentVO;
import utils.ScreensName;
import view.CreateApartmentScreen;

public class AnnounceController extends BaseController{

    @FXML
    private Button announceButton;
    @FXML
    private TableView<ApartmentVO> announceTable;

    @FXML
    private TableColumn<ApartmentVO, String> aspectsColumn;

    @FXML
    private TableColumn<ApartmentVO, String> cityColumn;

    @FXML
    private TableColumn<ApartmentVO, String> descriptionColumn;

    @FXML
    private TableColumn<ApartmentVO, String> districtColumn;

    @FXML
    private TableColumn<ApartmentVO, String> rentColumn;

    @FXML
    void announce(ActionEvent event) {
        CreateApartmentScreen.load(ScreensName.Address);
    }

}
