package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.ApartmentBO;
import model.VO.AddressVO;
import model.VO.ApartmentVO;
import model.VO.AspectsVO;
import model.VO.UserVO;
import utils.AllowedGender;
import utils.Gender;

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
    
    ApartmentBO apartmentBo = new ApartmentBO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bairroBox.getItems().addAll(bairros);
        cidadeBox.getItems().addAll(cidades);
        valorBox.getItems().addAll(valores);
        
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
            new SimpleStringProperty(capacity.getValue().getAspects().getCapacityString())
        );
        bedroomsQuantityColumn.setCellValueFactory(bedroomsQuantity -> 
            new SimpleStringProperty(bedroomsQuantity.getValue().getAspects().getBedroomsQuantityString())
        );
        availableToDivideColumn.setCellValueFactory(availableToDivide -> 
            new SimpleStringProperty(availableToDivide.getValue().getAspects().getAvailableToDivideString())
        );
        allowedGenderColumn.setCellValueFactory(allowedGender -> 
            new SimpleStringProperty(allowedGender.getValue().getAspects().getAllowedGender().toString())
            );
            
            
            searchTable.getItems().setAll(apartmentBo.findAll());
        }
}

// UserVO userTeste = new UserVO();
// AddressVO addressTeste = new AddressVO();
// AspectsVO aspectsTeste = new AspectsVO();
// ApartmentVO apartmentTeste = new ApartmentVO();
    
// try {
//     userTeste.setName("Nome teste");
//     userTeste.setAvatar(null);
//     userTeste.setEmail("teste@example.com");
//     userTeste.setGender(Gender.female);
//     userTeste.setPassword("senha123");
//     userTeste.setPhoneNumber("+55(99)9.9999-9999");

//     aspectsTeste.setAllowedGender(AllowedGender.both);
//     aspectsTeste.setAvailableToDivide(true);
//     aspectsTeste.setBedroomsQuantity(2);
//     aspectsTeste.setCapacity(4);
//     aspectsTeste.setDescription("Muito dahora");

//     addressTeste.setApartmentNumber("135A");
//     addressTeste.setState("Rio Grande do Norte");
//     addressTeste.setCity("Areia Branca");
//     addressTeste.setComplement("Sim");
//     addressTeste.setDistrict("District");
//     addressTeste.setZipCode(59655000);
//     addressTeste.setStreet("Alguma rua aí");

//     apartmentTeste.setRent(10);
//     apartmentTeste.setImage(null);
//     apartmentTeste.setAddress(addressTeste);
//     apartmentTeste.setAspects(aspectsTeste);
//     apartmentTeste.setOwner(userTeste);
// } catch (Exception e) {
//     System.out.println(e.getMessage());
// }

// ObservableList<ApartmentVO> index = FXCollections.observableArrayList();
// index.add(apartmentTeste);