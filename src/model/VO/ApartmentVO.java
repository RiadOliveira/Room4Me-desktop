package model.VO;

import errors.ValidationException;

public class ApartmentVO extends Entity {
    private UserVO owner;
    private AddressVO address;
    private AspectsVO aspects;
    private Double rent = 0.0;
    private String image = null;

    public UserVO getOwner() {
        return owner;
    }

    public void setOwner(UserVO owner) throws ValidationException {
        verifyNull(owner, "owner");
        this.owner = owner;
    }

    public AddressVO getAddress() {
        return address;
    }

    public void setAddress(AddressVO address) throws ValidationException {
        verifyNull(address, "address");
        this.address = address;
    }

    public AspectsVO getAspects() {
        return aspects;
    }

    public void setAspects(AspectsVO aspects) throws ValidationException {
        verifyNull(aspects, "aspects");
        this.aspects = aspects;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(double rent) throws ValidationException {
        double parsedRent = Math.abs(rent);
        if(parsedRent == 0) {
            throw new ValidationException(
                "Apartment rent must be greater than 0."
            );
        }

        this.rent = parsedRent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) throws ValidationException {
        if(image == null) {
            this.image = null;
            return;
        }

        String propertyName = "image";
        verifyStringLength(image, propertyName);

        this.image = image;
    }
}
