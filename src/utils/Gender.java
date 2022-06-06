package utils;

public enum Gender {
    male("Masculino"), 
    female("Feminino"), 
    other("Não se identificar");
    
    private String Gender;

    Gender(final String Gender) {
        this.Gender = Gender;
    }

    public AllowedGender convertToAllowedGender() {
        switch(this) {
            case male: return AllowedGender.male;
            case female: return AllowedGender.female;
            case other: return AllowedGender.both;
            default: return AllowedGender.both;
        }
    }

    @Override
    public String toString() {
        return Gender;
    }
}
