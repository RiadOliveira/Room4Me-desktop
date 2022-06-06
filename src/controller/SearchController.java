package controller;

import java.net.URL;
import java.util.ResourceBundle;

import errors.ValidationException;
import filter.FilterList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.BO.ApartmentBO;
import model.VO.AddressVO;
import model.VO.ApartmentVO;
import model.VO.AspectsVO;
import utils.ApartmentDataToFilter;
import utils.DataConverter;
import utils.SearchApartmentData;

public class SearchController extends BaseController implements Initializable{
    static FilterList<ApartmentVO> apartmentsList;
    static FilterList<ApartmentVO> filteredApartments;
    ApartmentBO apartmentBo = new ApartmentBO();

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
    private Button searchWithFiltersButton;
    @FXML
    private Button resetButton;
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
    private TableColumn<ApartmentVO, String> rentColumn;
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
    void searchWithFilters(ActionEvent event) {
        AddressVO searchedAddress = new AddressVO();
        AspectsVO searchedAspects = new AspectsVO();
        String capacityText = capacidadeField.getText();
        String parsedCapacity = capacityText.length() == 0 ? "0" : capacityText;

        String districtValue = bairroBox.getValue();
        String cityValue = cidadeBox.getValue();
        String stateValue = estadoBox.getValue();

        try {
            searchedAspects.setAllowedGender(user.getGender().convertToAllowedGender());
            searchedAspects.setAvailableToDivide(availableToDivideState);
            searchedAspects.setCapacity(Integer.valueOf(parsedCapacity));
            searchedAspects.setBedroomsQuantity(0);

            if(districtValue != null) searchedAddress.setDistrict(districtValue);
            if(cityValue != null) searchedAddress.setCity(cityValue);
            if(stateValue != null) searchedAddress.setState(stateValue);
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        String rentText = valorBox.getValue();
        String parsedRent = rentText == null ? "0" : rentText;

        SearchApartmentData searchData = new SearchApartmentData(
            searchedAddress, searchedAspects, 
            Double.valueOf(parsedRent), allowedGenderState
        );

        filteredApartments = apartmentBo.getFilteredApartmentsByRequirements(
            apartmentsList, searchData
        );

        filteredApartments = apartmentBo.getSortedApartmentsList(
            filteredApartments, ApartmentDataToFilter.byCity
        );
        
        ObservableList<ApartmentVO> parsedApartments = FXCollections.observableArrayList();
        for(ApartmentVO apartment : filteredApartments) {
            parsedApartments.add(apartment);
        }

        searchTable.setItems(parsedApartments);
    }
    
    @FXML
    void resetData(ActionEvent event) {
        ObservableList<ApartmentVO> parsedApartments = FXCollections.observableArrayList();
        for(ApartmentVO apartment : apartmentsList) {
            parsedApartments.add(apartment);
        }

        searchTable.setItems(parsedApartments);

        bairroBox.setValue(null);
        cidadeBox.setValue(null);
        estadoBox.setValue(null);
        valorBox.setValue(null);
        capacidadeField.setText("");
        availableToDivideCheck.setSelected(false);
        allowedGenderCheck.setSelected(false);
    }

    @FXML
    void print(ActionEvent event) {
        apartmentBo.generateFileWithApartmentsList(filteredApartments);
    }

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
        rentColumn.setCellValueFactory(rent -> 
            new SimpleStringProperty(DataConverter.convertNumberToCurrencyValue(rent.getValue().getRent()))
        );
        capacityColumn.setCellValueFactory(capacity -> 
            new SimpleStringProperty(capacity.getValue().getAspects().obtainCapacityString())
        );
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

        apartmentsList = apartmentBo.findAll();
        AspectsVO searchedAspects = new AspectsVO();
        searchedAspects.setAllowedGender(user.getGender().convertToAllowedGender());

        SearchApartmentData searchData = new SearchApartmentData(
            new AddressVO(), searchedAspects, 0, false
        );

        FilterList<ApartmentVO> apartmentsFilteredList = apartmentBo.getFilteredApartmentsByRequirements(
            apartmentsList, searchData
        );

        apartmentsFilteredList = apartmentBo.getSortedApartmentsList(
            apartmentsFilteredList, ApartmentDataToFilter.byCity
        );

        for(ApartmentVO apartment : apartmentsFilteredList) {
            searchTable.getItems().add(apartment);
        }

        for(ApartmentVO apartment : apartmentsList) {
            if(!bairroBox.getItems().contains(apartment.getAddress().getDistrict())) {
                bairroBox.getItems().add(apartment.getAddress().getDistrict());
            }

            if(!cidadeBox.getItems().contains(apartment.getAddress().getCity())) {
                cidadeBox.getItems().add(apartment.getAddress().getCity());
            }

            if(!estadoBox.getItems().contains(apartment.getAddress().getState())) {
                estadoBox.getItems().add(apartment.getAddress().getState());
            }

            if(!valorBox.getItems().contains(apartment.getRent().toString())) {
                valorBox.getItems().add(apartment.getRent().toString());
            }
        } 
    }
}