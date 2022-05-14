package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class SearchController extends BaseController implements Initializable{
    
    @FXML
    private ChoiceBox<String> bairroBox;
    private String[] bairros = {"BH","AB","SIM","RICÃO"};
    @FXML
    private ChoiceBox<String> cidadeBox;
    private String[] cidades = {"Mossoró", "White Sand", "Limoeiro"};
    @FXML
    private ChoiceBox<String> valorBox;
    private String[] valores = {"ate 500", "ate 1000", "acima de 1000"};


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bairroBox.getItems().addAll(bairros);
        cidadeBox.getItems().addAll(cidades);
        valorBox.getItems().addAll(valores);
        
    }

}
