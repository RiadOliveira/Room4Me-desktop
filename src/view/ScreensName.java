package view;

public enum ScreensName {
    Base("Base"),
    
    Login("Login"), SignUp("SignUp"),
    Search("Search"), Announce("Announce"),
    
    CreateApartment("CreateApartment"),
    Address("Address"),Aspects("Aspects");

    private String ScreensName;

    ScreensName(final String ScreensName) {
        this.ScreensName = ScreensName;
    }

    @Override
    public String toString() {
        return ScreensName;
    }

}
