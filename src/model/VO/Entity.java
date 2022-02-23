package model.VO;

import java.util.UUID;
import errors.ValidationException;

public abstract class Entity {
    private UUID id;

    public UUID getId() {
        return id;
    }

    protected void verifyNull(Object property, String propertyName) throws ValidationException {
        if(property == null) {
            throw new ValidationException(
                this.getClass().getSimpleName() + ' ' +
                propertyName + " can't be null."
            );
        }
    }
    
    public void setId(UUID id) throws ValidationException {
        verifyNull(id, "id");
        this.id = id;
    }
}
