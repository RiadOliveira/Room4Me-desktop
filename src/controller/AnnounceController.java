package controller;

import java.net.URL;
import java.util.ResourceBundle;

import filter.FilterList;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.ApartmentBO;
import model.VO.ApartmentVO;
import utils.ScreensName;
import view.CreateApartmentScreen;

public class AnnounceController extends BaseController implements Initializable{

    @FXML
    private Button announceButton;
    @FXML
    private Button deleteButton;

    @FXML
    private TableView<ApartmentVO> announceTable;
    @FXML
    private TableColumn<ApartmentVO, String> descriptionColumn;
    @FXML
    private TableColumn<ApartmentVO, String> districtColumn;
    @FXML
    private TableColumn<ApartmentVO, String> cityColumn;
    @FXML
    private TableColumn<ApartmentVO, Double> rentColumn;

    @FXML
    void announce(ActionEvent event) {
        CreateApartmentScreen.load(ScreensName.Address);
    }
    @FXML
    void delete(ActionEvent event) {
        ApartmentVO apartmentVO = announceTable.getSelectionModel().getSelectedItem();
        try {
            apartmentBo.delete(apartmentVO);            
            announceTable.getItems().remove(apartmentVO);
            CreateApartmentScreen.load(ScreensName.DeleteMesage);
        } catch (Exception e) {
            e.printStackTrace();
        } 

    }
    @FXML
    private Button concludeDeleteButton;
    @FXML
    void concludeDelete(ActionEvent event) {
        CreateApartmentScreen.fechar();
    }

    static FilterList<ApartmentVO> apartmentList;
    ApartmentBO apartmentBo = new ApartmentBO();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.setText(user.getName());

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
        
        apartmentList = apartmentBo.findAll();
        for(ApartmentVO apartmentVo : apartmentList){
            announceTable.getItems().add(apartmentVo);
            System.out.println(apartmentVo);
        }
    }
    
    @FXML
    public void loadAnnounceTable(){
        apartmentList = apartmentBo.findAll();
        for(ApartmentVO apartmentVo : apartmentList){
            announceTable.getItems().remove(apartmentVo);
            announceTable.getItems().add(apartmentVo);
            System.out.println(apartmentVo);
        }
    }

}
