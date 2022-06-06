package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.BO.UserBO;
import model.VO.UserVO;
import utils.Gender;
import utils.ScreensName;
import view.MainScreen;

public class SignUpController extends BaseController implements Initializable{
    
    @FXML
    private Label errorMessage;

    @FXML
    private TextField nameField;
    @FXML
    private ChoiceBox<Gender> genderBox;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmationPasswordField;

    @FXML
    private Button signUpButton;

    @FXML
    void signUp(ActionEvent event) {
        errorMessage.setStyle(errorMessage.getStyle()+"visibility: true;"); 
        UserBO userBO = new UserBO();
        UserVO user = new UserVO();

        try {
            if(!passwordField.getText().equals(confirmationPasswordField.getText())){
                throw new Exception();
            } 

            user.setName(nameField.getText());
            user.setGender(genderBox.getValue());
            user.setEmail(emailField.getText());
            user.setPhoneNumber(phoneNumberField.getText());
            user.setPassword(passwordField.getText());
            
            userBO.insert(user);
            MainScreen.load(ScreensName.Login);

        } catch (Exception e) {
            System.out.println(e.getMessage());

            errorMessage.setStyle(errorMessage.getStyle()+"visibility: true;"); 

            if(nameField.getText().trim().length()==0){
                nameField.setStyle(nameField.getStyle() + "-fx-border-width: 4;");
            } else {
                nameField.setStyle(nameField.getStyle() + "-fx-border-width: 0;");
            }
            if(genderBox.getValue()==null){
                genderBox.setStyle(genderBox.getStyle() + "-fx-border-width: 4;");
            } else {
                genderBox.setStyle(genderBox.getStyle() + "-fx-border-width: 0;");
            }
            if(emailField.getText().trim().length()==0){
                emailField.setStyle(emailField.getStyle() + "-fx-border-width: 4;");
            } else {
                emailField.setStyle(emailField.getStyle() + "-fx-border-width: 0;");
            }
            if(phoneNumberField.getText().trim().length()==0){
                phoneNumberField.setStyle(phoneNumberField.getStyle() + "-fx-border-width: 4;");
            } else {
                phoneNumberField.setStyle(phoneNumberField.getStyle() + "-fx-border-width: 0;");
            }
            if(passwordField.getText().trim().length()==0){
                passwordField.setStyle(passwordField.getStyle() + "-fx-border-width: 4;");
                confirmationPasswordField.setStyle(confirmationPasswordField.getStyle() + "-fx-border-width: 4;");
            } else{
                passwordField.setStyle(passwordField.getStyle() + "-fx-border-width: 4;");
                confirmationPasswordField.setStyle(confirmationPasswordField.getStyle() + "-fx-border-width: 4;");
            }
            
            passwordField.setText("");
            confirmationPasswordField.setText("");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderBox.getItems().addAll(Gender.values());
    }

    
}
