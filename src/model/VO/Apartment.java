package model.VO;

import java.util.UUID;

public class Apartment {
    private UUID id;
    private User owner;
    private Address address;
    private Aspects aspects;
    private double rent;
    private String image;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Aspects getAspects() {
        return aspects;
    }

    public void setAspects(Aspects aspects) {
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

    public void setImage(String image) {
        this.image = image;
    }
}
