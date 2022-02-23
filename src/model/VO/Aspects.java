package model.VO;

import errors.ValidationException;

public class Aspects extends Entity {
    private int bedroomsQuantity;
    private boolean availableToDivide;
    private String description;
    private int capacity;

    public int getBedroomsQuantity() {
        return bedroomsQuantity;
    }

    public void setBedroomsQuantity(int bedroomsQuantity) {
        this.bedroomsQuantity = bedroomsQuantity;
    }

    public boolean getAvailableToDivide() {
        return availableToDivide;
    }

    public void setAvailableToDivide(boolean availableToDivide) {
        this.availableToDivide = availableToDivide;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws ValidationException {
        verifyNull(description, "description");
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
