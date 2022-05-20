package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.screens.ScreensName;

public class CreateApartmentScreen {
    private static Stage createApartment;

    public static Stage getCreateApartment() {
        return createApartment;
    }

    public static void setCreateApartment(Stage CreateApartment) {
        createApartment = CreateApartment;
    }

    public static void load(ScreensName ScreensName) {
        try {
            if(createApartment == null) {
                Stage createApartment = new Stage();
                setCreateApartment(createApartment);
            }

            Parent root = FXMLLoader.load(MainScreen.class.getResource("./screens/" + ScreensName + ".fxml"));
            Scene scene = new Scene(root);

            Image icon = new Image("view/images/Icon.png");

            createApartment.getIcons().add(icon);
            createApartment.setTitle("Room4Me - Create Apartment");
            createApartment.setScene(scene);
            createApartment.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fechar() {
        createApartment.hide();
    } 
}
