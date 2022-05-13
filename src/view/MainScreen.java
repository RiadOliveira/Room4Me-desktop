package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.screens.ScreensName;

public class MainScreen extends Application{

    private static Stage principal;

    public static Stage getPrincipal() {
        return principal;
    }

    public static void setPrincipal(Stage principal) {
        MainScreen.principal = principal;
    }
    
    public static void main(String args[]) {
        launch();
    }

    public static void load(ScreensName ScreensName) { 
        try {
            Parent root = FXMLLoader.load(MainScreen.class.getResource("./screens/" + ScreensName + ".fxml"));
            Scene scene = new Scene(root);
    
            principal.setScene(scene);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void start(Stage pricipal) throws Exception {
        setPrincipal(pricipal);

        Image icon = new Image("view/images/Icon.png");

        pricipal.getIcons().add(icon);

        pricipal.setTitle("Room4Me");
        load(ScreensName.Login); //Tela que irá aparecer quano programa iniciar
        pricipal.show();
    }

}
