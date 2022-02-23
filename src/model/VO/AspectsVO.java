package model.VO;

import errors.ValidationException;

public class AspectsVO extends Entity {
    private int bedroomsQuantity;
    private boolean availableToDivide;
    private String description;
    private int capacity;

    public int getBedroomsQuantity() {
        return bedroomsQuantity;
    }

    public void setBedroomsQuantity(int bedroomsQuantity) throws ValidationException {
        int parsedQuantity = Math.abs(bedroomsQuantity);
        if(parsedQuantity == 0) {
            throw new ValidationException(
                "Bedrooms quantity of an apartment must be greater than 0."
            );
        }

        this.bedroomsQuantity = parsedQuantity;
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
        String propertyName = "description";
        verifyNull(description, propertyName);
        verifyStringLength(description, propertyName);

        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws ValidationException {
        int parsedCapacity = Math.abs(capacity);
        if(parsedCapacity == 0) {
            throw new ValidationException(
                "Apartment capacity must be greater than 0."
            );
        }

        this.capacity = parsedCapacity;
    }
}
