package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import errors.ValidationException;
import model.VO.UserVO;

public class UserDAO<VO extends UserVO> extends BaseDAO<VO> {
    public void insert(VO user) throws SQLException, ValidationException {
    }

    public ResultSet findById(VO user) throws SQLException {
        return null;
    }

    public void update(VO user) throws SQLException {
    }

    public void delete(VO user) throws SQLException {
    }
}
