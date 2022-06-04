/*package controller;

import model.BO.ApartmentBO;

public class teste {
    public static void main(String args[]) {
        ApartmentBO apartment = new ApartmentBO();
        System.out.println(apartment.findAll());
        UserBO userBO = new UserBO();
        UserVO user = new UserVO();

        ApartmentVO apartment = new ApartmentVO();
        ApartmentBO apartmentBO = new ApartmentBO();

        AspectsVO aspects = new AspectsVO();
        AddressVO address = new AddressVO();
        
        try {
            user.setName("Nome teste");
            user.setAvatar(null);
            user.setEmail("teste@example.com");
            user.setGender(Gender.female);
            user.setPassword("senha123");
            user.setPhoneNumber("+55(99)9.9999-9999");

            userBO.insert(user);
    
            aspects.setAllowedGender(AllowedGender.both);
            aspects.setAvailableToDivide(true);
            aspects.setBedroomsQuantity(2);
            aspects.setCapacity(4);
            aspects.setDescription("Muito dahora");

            address.setApartmentNumber("135A");
            address.setState("Rio Grande do Norte");
            address.setCity("Areia Branca");
            address.setComplement("Sim");
            address.setDistrict("District");
            address.setZipCode(59655000);
            address.setStreet("Alguma rua aí");

            apartment.setRent(10);
            apartment.setImage(null);
            apartment.setAddress(address);
            apartment.setAspects(aspects);
            apartment.setOwner(user);

            apartmentBO.insert(apartment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
FuncionarioVO authfunvo = new FuncionarioVO();

	public void auth(ActionEvent event) throws Exception {

		FuncionarioBO bo = new FuncionarioBO();
		FuncionarioVO funvo = new FuncionarioVO();

		funvo.setNickName(usu.getText());
		funvo.setSenha(senha.getText());

		this.authfunvo = bo.autenticar(funvo);

		if (authfunvo == null) {
			usu.setStyle(usu.getStyle() + "-fx-border-color: #F40779;");
			senha.setStyle(senha.getStyle() + "-fx-border-color: #F40779;");
		} else {
			TelasPrincipal.load(telasNome.venda);
		}

	}

	public FuncionarioVO returnFuncionario(FuncionarioVO vo) {
		return (vo);
	}
}
*/
/* 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class CheckboxWhileKeyPressedNotWorking extends Application {

    private final CheckBox checkbox = new CheckBox();
    private boolean isControlKeyDown = false;

    @Override
    public void start(Stage primaryStage) {

        checkbox.setText("Click me while pressing <CNTRL> key");
        checkbox.setOnMouseClicked(e->{
            if(isControlKeyDown){
                checkbox.fire(); //change check box state
            }
        });

        Scene scene = new Scene(checkbox, 300, 50);
        scene.setOnKeyPressed(keyEvent -> {
            isControlKeyDown = keyEvent.isControlDown();
        });

        scene.setOnKeyReleased(keyEvent -> {
            isControlKeyDown = keyEvent.isControlDown();
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/