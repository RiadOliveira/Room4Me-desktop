package utils;

public enum Gender {
    male("Masculino"), female("Feminino"), other("Não se identificar");
    
    private String Gender;

    Gender(final String Gender) {
        this.Gender = Gender;
    }

    @Override
    public String toString() {
        return Gender;
    }
}
