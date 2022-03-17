package model.VO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import errors.ValidationException;

public abstract class Entity {
    private final String entityName = this.getClass().getSimpleName().split("VO")[0];
    private UUID id;

    // Validation functions.
    protected void verifyStringLength(String value, String propertyName) throws ValidationException {
        if(value.length() == 0) {
            throw new ValidationException(
                entityName + ' ' + propertyName + " must be greater than 0 in length."
            );
        }
    }

    protected void verifyNull(Object property, String propertyName) throws ValidationException {
        if(property == null) {
            throw new ValidationException(
                entityName + ' ' + propertyName + " can't be null."
            );
        }
    }

    // Utils
    public List<String> getFieldsNames() {
        Field[] fields = this.getClass().getDeclaredFields();
        List<String> fieldsNames = new ArrayList<String>();

        for(int ind=0 ; ind<fields.length ; ind++) {
            fieldsNames.add(fields[ind].getName());
        }

        Collections.sort(fieldsNames, new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                return left.compareTo(right);
            }
        });

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

        Collections.sort(parsedMethods, new Comparator<Method>() {
            @Override
            public int compare(Method left, Method right) {
                return left.getName().compareTo(right.getName());
            }
        });

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
