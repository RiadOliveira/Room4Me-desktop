package model.DAO;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class BaseDAO<VO> implements IBaseDAO<VO> {
    private static Connection connection = null;
    private static final String url = "jdbc:postgresql://localhost:5432/Room4ME";
    private static final String user = "postgres";
    private static final String password = Dotenv.load().get("DATABASE_PASSWORD");
	
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(url, user, password);				
		}

		return connection;
	}

	public static void closeConnection() throws SQLException {
		if(connection != null) {
			connection.close();
		}
	}
}