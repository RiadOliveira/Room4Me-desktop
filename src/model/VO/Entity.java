package model.VO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
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

    // Utils
    public String[] getFieldsNames() {
        Field[] fields = this.getClass().getDeclaredFields();
        String fieldsNames[] = new String[fields.length];

        for(int ind=0 ; ind<fields.length ; ind++) {
            fieldsNames[ind] = fields[ind].getName();
        }

        return fieldsNames;
    }

    public List<Method> getGetterMethods() {
        Method methods[] = this.getClass().getDeclaredMethods();
        List<Method> parsedMethods = new ArrayList<Method>();

        for(int ind=0 ; ind<methods.length ; ind++) {
            if(methods[ind].getName().contains("get")) {
                parsedMethods.add(methods[ind]);
            }
        }

        return parsedMethods;
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
