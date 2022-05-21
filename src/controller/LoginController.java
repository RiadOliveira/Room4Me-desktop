package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.ScreensName;
import view.MainScreen;

public class LoginController{
	@FXML
	private Label escuro;
	
    @FXML
    private TextField emailField;    
	@FXML
    private PasswordField passwordField;
	
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
	
    @FXML
    void login(ActionEvent event) {
		escuro.setStyle(escuro.getStyle()+"visibility: true"); 
		// emailField.setStyle(emailField.getStyle() + "-fx-border-width: 4;");
		// passwordField.setStyle(passwordField.getStyle() + "-fx-border-width: 4;");
		// MainScreen.load(ScreensName.Search);
    }
    
    @FXML
    void signUp(ActionEvent event) {
        MainScreen.load(ScreensName.SignUp);
    }
}

