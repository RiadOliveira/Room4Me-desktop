package model.VO;

import errors.ValidationException;

public class Apartment extends Entity {
    private User owner;
    private Address address;
    private Aspects aspects;
    private double rent;
    private String image;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) throws ValidationException {
        verifyNull(owner, "owner");
        this.owner = owner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) throws ValidationException {
        verifyNull(address, "address");
        this.address = address;
    }

    public Aspects getAspects() {
        return aspects;
    }

    public void setAspects(Aspects aspects) throws ValidationException {
        verifyNull(aspects, "aspects");
        this.aspects = aspects;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) throws ValidationException {
        verifyNull(image, "image");
        this.image = image;
    }
}
