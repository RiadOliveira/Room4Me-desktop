package model.DAO;

//import io.github.cdimascio.dotenv.Dotenv;
import model.VO.Entity;
import utils.CamelCaseToSnakeCaseConverter;
import utils.StatementFiller;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class BaseDAO<VO extends Entity> implements IBaseDAO<VO> {
	private static Connection connection = null;
	private final String entityName = this.getClass().getSimpleName().split("DAO")[0];
    private static final String url = "jdbc:postgresql://localhost:5432/Room4ME";
    private static final String user = "postgres";
    private static final String password = "tradelous";//Dotenv.load().get("DATABASE_PASSWORD");
	
	protected static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(url, user, password);				
		}

		return connection;
	}

	public static void closeConnection() throws SQLException {
		if(connection != null) connection.close();
	}

    public void insert(VO entity) throws SQLException, Exception {
        Connection connection = getConnection();

        List<String> fieldsNames = entity.getFieldsNames();
        int fieldsQuantity = fieldsNames.size();
        String query = "INSERT INTO Room4Me." + entityName + '(';

        for(int ind=0 ; ind<fieldsQuantity ; ind++) {
            query += CamelCaseToSnakeCaseConverter.execute(fieldsNames.get(ind));
            if(ind != fieldsQuantity - 1) query += ", ";
            else query += ") values (";
        }

        for(int ind=0 ; ind<fieldsQuantity ; ind++) {
            query += '?';
            if(ind != fieldsQuantity - 1) query += ", ";
            else query += ')';
        }

        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        StatementFiller statementFiller = new StatementFiller(entity, statement);
        statementFiller.execute(false);

        statement.execute();
        ResultSet generatedKeys = statement.getGeneratedKeys();

        if(generatedKeys.next()) entity.setId(UUID.fromString(generatedKeys.getString(1)));
        else throw new SQLException(entityName + " ID not found on database.");
    }

	public ResultSet findById(VO entity) throws SQLException, Exception {
        Connection connection = getConnection();

        String query = "SELECT * FROM Room4Me." + entityName + " WHERE id=?::uuid";
        PreparedStatement statement;
        ResultSet findedEntity;

        statement = connection.prepareStatement(query);
        statement.setString(1, entity.getId().toString());
        findedEntity = statement.executeQuery();

        if(!findedEntity.next()) throw new Exception(entityName + " not found.");
        return findedEntity;
    }

    public void update(VO entity) throws SQLException, Exception {
        Connection connection = getConnection();

        String query = "UPDATE Room4Me." + entityName + " SET ";
        List<String> fieldsNames = entity.getFieldsNames();

        for(int ind=0 ; ind<fieldsNames.size() ; ind++) {
            query += CamelCaseToSnakeCaseConverter.execute(fieldsNames.get(ind));
            query += "=?";

            if(ind != fieldsNames.size() - 1) query += ", ";
        }
        query += " WHERE id=?::uuid";

        PreparedStatement statement;
        statement = connection.prepareStatement(query);

        StatementFiller statementFiller = new StatementFiller(entity, statement);
        statementFiller.execute(true);

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