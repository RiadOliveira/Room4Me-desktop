package view.screens;

public enum ScreensName {
    LoginBase("LoginBase"), Base("Base"), TESTE("TESTE"),
    Login("Login"), SignUp("SignUp"),
    Search("Search"), Announce("Announce");

    private String ScreensName;

    ScreensName(final String ScreensName) {
        this.ScreensName = ScreensName;
    }

    @Override
    public String toString() {
        return ScreensName;
    }

}
