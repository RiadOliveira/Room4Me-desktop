package controller;

import errors.ValidationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.VO.UserVO;
import utils.Gender;
import utils.ScreensName;
import view.MainScreen;

public class LoginController{

    static UserVO userLogin = new UserVO();
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
    void login(ActionEvent event) throws Exception {
		escuro.setStyle(escuro.getStyle()+"visibility: true"); 
		// emailField.setStyle(emailField.getStyle() + "-fx-border-width: 4;");
		// passwordField.setStyle(passwordField.getStyle() + "-fx-border-width: 4;");
        
        MainScreen.load(ScreensName.Search);
        
        try {
            userLogin.setName("Dewp");
            userLogin.setAvatar(null);
            userLogin.setEmail("Dewp@ufersa.com");
            userLogin.setGender(Gender.other);
            userLogin.setPassword("1234");
            userLogin.setPhoneNumber("+55(99)9.4444-4444");
            
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    void signUp(ActionEvent event) {
        MainScreen.load(ScreensName.SignUp);
    }
}

