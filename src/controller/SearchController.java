package controller;

import java.net.URL;
import java.util.ResourceBundle;

import filter.FilterList;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.ApartmentBO;
import model.VO.ApartmentVO;
import utils.ApartmentDataToFilter;

public class SearchController extends BaseController implements Initializable{
    
    @FXML
    private ChoiceBox<String> bairroBox;
    @FXML
    private ChoiceBox<String> cidadeBox;
    @FXML
    private ChoiceBox<String> valorBox;
    @FXML
    private ChoiceBox<String> estadoBox;
    @FXML
    private CheckBox availableToDivideCheck;
    public boolean availableToDivideState = false;
    @FXML
    void availableToDivideChoice(ActionEvent event) {
        if(availableToDivideState){
            availableToDivideState = false;
        }else availableToDivideState = true;
    }
    @FXML
    private CheckBox allowedGenderCheck;
    public boolean allowedGenderState = false;
    @FXML
    void allowedGenderChoice(ActionEvent event) {
        if(allowedGenderState){
            allowedGenderState = false;
        }else allowedGenderState = true;
        
    }
    @FXML
    private TextField capacidadeField;

    @FXML
    private Button searchFiltredButton;
    @FXML
    private Button searchDataButton;
    @FXML
    private Button printButton;

    @FXML
    private TableView<ApartmentVO> searchTable;
    @FXML
    private TableColumn<ApartmentVO, String> OwnerColumn;
    @FXML
    private TableColumn<ApartmentVO, String> descriptionColumn;
    @FXML
    private TableColumn<ApartmentVO, String> districtColumn;
    @FXML
    private TableColumn<ApartmentVO, String> cityColumn;
    @FXML
    private TableColumn<ApartmentVO, Double> rentColumn;
    @FXML
    private TableColumn<ApartmentVO, String> aspectsColumn;
    @FXML
    private TableColumn<ApartmentVO, String> capacityColumn;
    @FXML
    private TableColumn<ApartmentVO, String> bedroomsQuantityColumn;
    @FXML
    private TableColumn<ApartmentVO, String> availableToDivideColumn;
    @FXML
    private TableColumn<ApartmentVO, String> allowedGenderColumn;

    @FXML
    void searchFiltred(ActionEvent event) {
        valorBox.getValue();
        bairroBox.getValue();
        cidadeBox.getValue();
        estadoBox.getValue();
        // availableToDivideState;
        // allowedGenderState;
        capacidadeField.getText();

        apartmentList = apartmentBo.findAll();
        for(ApartmentVO apartmentVo : apartmentList){
            searchTable.getItems().remove(apartmentVo);
        }

        FilterList<ApartmentVO> apartmentFiltredList;
        apartmentFiltredList = apartmentBo.getSortedApartmentsList(apartmentList, ApartmentDataToFilter.byCity);
        apartmentList = apartmentBo.filterByCity(apartmentFiltredList, cidadeBox.getValue());
        
        for(ApartmentVO apartmentVo : apartmentList){
            searchTable.getItems().add(apartmentVo);
        }
    }
    
    @FXML
    void searchData(ActionEvent event) {
        
    }
    @FXML
    void print(ActionEvent event) {
        
    }
        

    static FilterList<ApartmentVO> apartmentList;
    ApartmentBO apartmentBo = new ApartmentBO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.setText(user.getName());
        
        OwnerColumn.setCellValueFactory((owner -> 
        	new SimpleStringProperty(owner.getValue().getOwner().getName()))
        );
        descriptionColumn.setCellValueFactory((description -> 
        	new SimpleStringProperty(description.getValue().getAspects().getDescription()))
        );
        districtColumn.setCellValueFactory((district -> 
        	new SimpleStringProperty(district.getValue().getAddress().getDistrict()))
        );
        cityColumn.setCellValueFactory((city -> 
        	new SimpleStringProperty(city.getValue().getAddress().getCity()))
        );
        rentColumn.setCellValueFactory(new PropertyValueFactory<ApartmentVO, Double>("rent"));
        capacityColumn.setCellValueFactory(capacity -> 
            new SimpleStringProperty(capacity.getValue().getAspects().obtainCapacityString())
        );
        bedroomsQuantityColumn.setCellValueFactory(bedroomsQuantity -> 
            new SimpleStringProperty(bedroomsQuantity.getValue().getAspects().obtainBedroomsQuantityString())
        );
        availableToDivideColumn.setCellValueFactory(availableToDivide -> 
            new SimpleStringProperty(availableToDivide.getValue().getAspects().obtainAvailableToDivideText())
        );
        allowedGenderColumn.setCellValueFactory(allowedGender -> 
            new SimpleStringProperty(allowedGender.getValue().getAspects().getAllowedGender().toString())
        );

        apartmentList = apartmentBo.findAll();
        for(ApartmentVO apartmentVo : apartmentList){
            bairroBox.getItems().add(apartmentVo.getAddress().getDistrict());
            cidadeBox.getItems().add(apartmentVo.getAddress().getCity());
            estadoBox.getItems().add(apartmentVo.getAddress().getDistrict());
            valorBox.getItems().add(apartmentVo.getRent().toString());

            searchTable.getItems().add(apartmentVo);
        }
           
    }
}