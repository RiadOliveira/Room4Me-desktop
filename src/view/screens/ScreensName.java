package view.screens;

public enum ScreensName {
    Login("Login"), LoginBase("LoginBase"), Search("Search");

    private String ScreensName;

    ScreensName(final String ScreensName) {
        this.ScreensName = ScreensName;
    }

    @Override
    public String toString() {
        return ScreensName;
    }

}
