package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.BO.UserBO;
import model.VO.UserVO;
import utils.ScreensName;
import view.MainScreen;

public class LoginController{

    public static UserVO userLogin = new UserVO();
	@FXML
	private Label errorMessage;
	
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
		
	
        // try {
        //     userLogin.setName("Dewp");
        //     userLogin.setAvatar(null);
        //     userLogin.setEmail("Dewp@ufersa.com");
        //     userLogin.setGender(Gender.other);
        //     userLogin.setPassword("1234");
        //     userLogin.setPhoneNumber("+55(99)9.4444-4444");
            
        // } catch (ValidationException e) {
        //     e.printStackTrace();
        // }
        UserBO userBO = new UserBO();
		UserVO userVO = new UserVO();

        try {         
            userVO.setEmail(emailField.getText());
		    userVO.setPassword(passwordField.getText());           

        } catch (Exception e) {
            System.out.println(e.getMessage());

            errorMessage.setStyle(errorMessage.getStyle()+"visibility: true;"); 
            emailField.setStyle(emailField.getStyle() + "-fx-border-width: 4;");
		    passwordField.setStyle(passwordField.getStyle() + "-fx-border-width: 4;");
            passwordField.setText("");
        }
		userVO.setEmail(emailField.getText());
		userVO.setPassword(passwordField.getText());

		userLogin = userBO.auth(userVO);

		if (userLogin == null) {
            errorMessage.setStyle(errorMessage.getStyle()+"visibility: true"); 
			emailField.setStyle(emailField.getStyle() + "-fx-border-width: 4;");
		    passwordField.setStyle(passwordField.getStyle() + "-fx-border-width: 4;");
            passwordField.setText("");
		} else {
			MainScreen.load(ScreensName.Search);
		}
        
    }
    
    @FXML
    void signUp(ActionEvent event) {
        MainScreen.load(ScreensName.SignUp);
    }
}

