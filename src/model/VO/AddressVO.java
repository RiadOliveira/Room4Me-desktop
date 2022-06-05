package model.VO;

import errors.ValidationException;

public class AddressVO extends Entity {
    private String state;
    private String city;
    private String district;
    private String street;
    private String complement = null;
    private String apartmentNumber;
    private int zipCode;

    public String getState() {
        return state;
    }

    public void setState(String state) throws ValidationException {
        String propertyName = "state";
        verifyNull(state, propertyName);

        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws ValidationException {
        String propertyName = "city";
        verifyNull(city, propertyName);

        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) throws ValidationException {
        String propertyName = "district";
        verifyNull(district, propertyName);
        verifyStringLength(district, propertyName);

        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws ValidationException {
        String propertyName = "street";
        verifyNull(street, propertyName);
        verifyStringLength(street, propertyName);

        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) throws ValidationException {
        String propertyName = "complement";
        verifyNull(complement, propertyName);
        verifyStringLength(complement, propertyName);

        this.complement = complement;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) throws ValidationException {
        String propertyName = "apartmentNumber";
        verifyNull(apartmentNumber, propertyName);
        verifyStringLength(apartmentNumber, propertyName);

        this.apartmentNumber = apartmentNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) throws ValidationException {
        if(String.valueOf(zipCode).length() != 8) {
            throw new ValidationException(
                "Zip code must be equal to 8 in length."
            );
        }

        this.zipCode = zipCode;
    }
}
