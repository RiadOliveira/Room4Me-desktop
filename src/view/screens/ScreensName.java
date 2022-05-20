package view.screens;

public enum ScreensName {
    Base("Base"), CreateApartment("CreateApartment"),
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
