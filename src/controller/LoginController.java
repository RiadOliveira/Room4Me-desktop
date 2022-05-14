package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.MainScreen;
import view.screens.ScreensName;

public class LoginController extends changeScreen{
    
    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    void login(ActionEvent event) {
        MainScreen.load(ScreensName.Search);
    }
    
    @FXML
    void signUp(ActionEvent event) {
        MainScreen.load(ScreensName.SignUp);
    }
}


