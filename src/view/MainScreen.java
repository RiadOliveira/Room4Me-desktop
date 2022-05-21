package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainScreen extends Application{

    private static Stage mainScreen;

    public static Stage getMainScreen() {
        return mainScreen;
    }

    public static void setMainScreen(Stage mainScreen) {
        MainScreen.mainScreen = mainScreen;
    }
    
    public static void main(String args[]) {
        launch();
    }

    public static void load(ScreensName ScreensName) { 
        try {
            Parent root = FXMLLoader.load(MainScreen.class.getResource("./screens/" + ScreensName + ".fxml"));
            Scene scene = new Scene(root);
    
            mainScreen.setScene(scene);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void start(Stage pricipal) throws Exception {
        setMainScreen(pricipal);

        Image icon = new Image("view/images/Icon.png");

        pricipal.getIcons().add(icon);

        pricipal.setTitle("Room4Me");
        load(ScreensName.Login);
        pricipal.show();
    }

}
