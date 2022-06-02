package utils;

public enum AllowedGender {
    male("Masculino"), female("Feminino"), both("Indefinido");
    
    private String AllowedGender;

    AllowedGender(final String AllowedGender) {
        this.AllowedGender = AllowedGender;
    }

    @Override
    public String toString() {
        return AllowedGender;
    }
}
