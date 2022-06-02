package utils;

public enum AllowedGender {
    male("Masculino"), 
    female("Feminino"), 
    both("Indefinido");

    private String AllowedGender;

    AllowedGender(String AllowedGender) {
        this.AllowedGender = AllowedGender;
    }

    public String toString() {
        return AllowedGender;
    }
}
