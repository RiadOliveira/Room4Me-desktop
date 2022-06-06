package utils;

public enum AllowedGender {
    male("Masculino"), female("Feminino"), both("Ambos");

    private final String genderName;

    AllowedGender(final String genderName) {
        this.genderName = genderName;
    }

    @Override
    public String toString() {
        return genderName;
    }
}
