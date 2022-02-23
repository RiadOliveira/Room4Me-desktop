package model.VO;

import java.util.UUID;
import errors.ValidationException;

public abstract class Entity {
    private UUID id;

    // Validation functions.
    protected void verifyStringLength(String value, String propertyName) throws ValidationException {
        if(value.length() == 0) {
            throw new ValidationException(
                this.getClass().getSimpleName() + ' ' +
                propertyName + " must be greater than 0 in length."
            );
        }
    }

    protected void verifyNull(Object property, String propertyName) throws ValidationException {
        if(property == null) {
            throw new ValidationException(
                this.getClass().getSimpleName() + ' ' +
                propertyName + " can't be null."
            );
        }
    }

    // Getter and Setter.
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) throws ValidationException {
        verifyNull(id, "id");
        this.id = id;
    }
}
