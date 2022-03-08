package model.DAO;

import java.sql.SQLException;

import errors.ValidationException;
import model.VO.UserVO;

public class UserDAO<VO extends UserVO> extends BaseDAO<VO> {
    public void insert(VO user) throws SQLException, ValidationException {
    }
}
