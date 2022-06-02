package controller;

import errors.ValidationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.BO.UserBO;
import model.VO.UserVO;
import utils.Gender;
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
    void login(ActionEvent event) throws Exception {
		escuro.setStyle(escuro.getStyle()+"visibility: true"); 
		// emailField.setStyle(emailField.getStyle() + "-fx-border-width: 4;");
		// passwordField.setStyle(passwordField.getStyle() + "-fx-border-width: 4;");
		// MainScreen.load(ScreensName.Search);
        MainScreen.load(ScreensName.Search);
        UserVO user = new UserVO();
        UserBO userBO = new UserBO();
        
        try {
            user.setName("Dewp");
            user.setAvatar(null);
            user.setEmail("Dewp@ufersa.com");
            user.setGender(Gender.other);
            user.setPassword("1234");
            user.setPhoneNumber("+55(99)9.4444-4444");

            userBO.insert(user);
            
        } catch (ValidationException e) {
            e.printStackTrace();
        }
            
    }
    
    @FXML
    void signUp(ActionEvent event) {
        MainScreen.load(ScreensName.SignUp);
    }
}

