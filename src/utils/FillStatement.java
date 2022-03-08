package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.VO.Entity;

public class FillStatement {
    private Entity entity;
    private PreparedStatement statement;
    private List<Method> getterMethods;

    public FillStatement(Entity entity, PreparedStatement statement) {
        this.entity = entity;
        this.statement = statement;
        this.getterMethods = entity.getGetterMethods();
    }

    private void typeSwitch(
        String type, int index, Object property
    ) throws SQLException {
        switch(type) {
            case "String": statement.setString(index, (String)property);
            break;

            case "int": statement.setInt(index, (int)property);
            break;

            case "double": statement.setDouble(index, (double)property);
            break;

            case "boolean": statement.setBoolean(index, (boolean) property);
            break;

            case "AllowedGender": {
                statement.setShort(index, (short)((AllowedGender) property).ordinal());
                break;
            }

            case "Gender": {
                statement.setBoolean(index, ((Gender) property).ordinal() == 1);
                break;
            }

            default: {
                if(type.contains("VO")) {
                    String entityId = ((Entity) property).getId().toString();
                    statement.setString(index, entityId);
                }
            }
        }
    }

    public void execute() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {
        for(int ind=0 ; ind<getterMethods.size() ; ind++) {
            Method method = getterMethods.get(ind);
            String type = method.getReturnType().getSimpleName();
            Object property = method.invoke(entity);

            typeSwitch(type, ind+1, property);
        }

        statement.setString(getterMethods.size()+1, entity.getId().toString());
    }
}
