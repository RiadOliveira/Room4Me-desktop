package model.VO;

import java.util.UUID;

public class Aspects {
    private UUID id;
    private int bedroomsQuantity;
    private boolean availableToDivide;
    private String description;
    private int capacity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
