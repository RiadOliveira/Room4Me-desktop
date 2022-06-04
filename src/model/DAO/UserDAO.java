package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.VO.UserVO;

public class UserDAO extends BaseDAO<UserVO> {
	public ResultSet Auth(UserVO user) throws SQLException, Exception {
        Connection connection = getConnection();

        String query = "SELECT * FROM Room4Me.user WHERE email=? AND password=?";
        PreparedStatement statement;
        ResultSet findedEntity;

        statement = connection.prepareStatement(query);
        statement.setString(1, user.getEmail().toString());
        statement.setString(2, user.getPassword().toString());
        findedEntity = statement.executeQuery();

        if(!findedEntity.next()) throw new Exception("user not found.");
        return findedEntity;
    }

}
