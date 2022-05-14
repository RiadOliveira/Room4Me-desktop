package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController extends BaseController implements Initializable{
    @FXML
    private PasswordField confirmationPasswordField;

    @FXML
    private TextField emailField;

    @FXML
    private ChoiceBox<String> genderBox;
    private String[] genders = {"Masculino","Feminino", "Não se identificar"};

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField phoneField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderBox.getItems().addAll(genders);
        
    }

}
