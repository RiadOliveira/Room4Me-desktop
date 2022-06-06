package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.VO.UserVO;
import utils.ScreensName;
import view.MainScreen;

public class BaseController extends LoginController{
    public static UserVO user = LoginController.userLogin;

    @FXML
    public Label userName;
    
    @FXML
    private Button announceButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button userButton;

    @FXML
    void changeAnnounce(ActionEvent event) {
        MainScreen.load(ScreensName.Announce);        
    }

    @FXML
    void changeSearch(ActionEvent event) {
        MainScreen.load(ScreensName.Search);
    }

    @FXML
    void logout(ActionEvent event) {
        MainScreen.load(ScreensName.Login);
    }
        
        
}
