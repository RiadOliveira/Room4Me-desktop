package utils;

public enum AllowedGender {
    male("Masculino"), female("Feminino"), both("Ambos");

    private final String genderName;

    AllowedGender(final String genderName) {
        this.genderName = genderName;
    }

    public AllowedGender getReverse() {
        if(this == male) return female;
        if(this == female) return male;

        return null;
    }

    @Override
    public String toString() {
        return genderName;
    }
}
