package controller;

import view.MainScreen;
import view.screens.ScreensName;

public class changeScreen {

    public void logout(){
        MainScreen.load(ScreensName.Login);
    }

    public void singUp(){
        MainScreen.load(ScreensName.LoginBase);
    }
    
    public void search(){
        MainScreen.load(ScreensName.Search);
    }
    
    public void announce(){
        MainScreen.load(ScreensName.Announce);
    }
}
