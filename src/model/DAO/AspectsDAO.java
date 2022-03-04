package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import errors.ValidationException;
import model.VO.AspectsVO;

public class AspectsDAO<VO extends AspectsVO> extends BaseDAO<VO> {
    public void insert(VO aspects) throws SQLException, ValidationException {
    }

    public ResultSet findById(VO aspects) throws SQLException {
        return null;
    }

    public void update(VO aspects) throws SQLException {
    }

    public void delete(VO aspects) throws SQLException {
    }
}
