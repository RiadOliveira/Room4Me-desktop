package model.DAO;

import io.github.cdimascio.dotenv.Dotenv;
import model.VO.Entity;
import utils.ConvertCamelCaseToSnakeCase;
import utils.FillStatement;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class BaseDAO<VO extends Entity> implements IBaseDAO<VO> {
	private static Connection connection = null;
	private final String entityName = this.getClass().getSimpleName().split("DAO")[0];
    private static final String url = "jdbc:postgresql://localhost:5432/Room4ME";
    private static final String user = "postgres";
    private static final String password = Dotenv.load().get("DATABASE_PASSWORD");
	
	protected static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(url, user, password);				
		}

		return connection;
	}

	public static void closeConnection() throws SQLException {
		if(connection != null) connection.close();
	}

	public ResultSet findById(VO entity) throws SQLException {
        Connection connection = getConnection();

        String query = "SELECT * FROM Room4Me." + entityName + " WHERE id=?::uuid";
        PreparedStatement statement;
        ResultSet findedEntity;

        statement = connection.prepareStatement(query);
        statement.setString(1, entity.getId().toString());
        findedEntity = statement.executeQuery();

        if(!findedEntity.next()) return null;
        return findedEntity;
    }

    public void update(VO entity) throws SQLException, Exception {
        Connection connection = getConnection();

        String query = "UPDATE Room4Me." + entityName + " SET ";
        String fieldsNames[] = entity.getFieldsNames();

        for(int ind=0 ; ind<fieldsNames.length ; ind++) {
            query += ConvertCamelCaseToSnakeCase.execute(fieldsNames[ind]);
            query += "=?";

            if(ind != fieldsNames.length - 1) query += ", ";
        }
        query += " WHERE id=?::uuid";

        PreparedStatement statement;
        statement = connection.prepareStatement(query);

        FillStatement fillStatement = new FillStatement(entity, statement);
        fillStatement.execute();

        statement.execute();
    }

    public void delete(VO entity) throws SQLException {
        Connection connection = getConnection();

        String query = "DELETE FROM Room4Me." + entityName + " WHERE id=?::uuid";
        PreparedStatement statement;

        statement = connection.prepareStatement(query);
        statement.setString(1, entity.getId().toString());
        statement.execute();
    }
}