package model.VO;

import errors.ValidationException;

public class Address extends Entity {
    private String city;
    private String district;
    private String street;
    private String complement;
    private String apartmentNumber;
    private int zipCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws ValidationException {
        verifyNull(city, "city");
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) throws ValidationException {
        verifyNull(district, "district");
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws ValidationException {
        verifyNull(street, "street");
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) throws ValidationException {
        verifyNull(complement, "complement");
        this.complement = complement;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) throws ValidationException {
        verifyNull(apartmentNumber, "apartmentNumber");
        this.apartmentNumber = apartmentNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
