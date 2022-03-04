package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import errors.ValidationException;
import model.VO.ApartmentVO;

public class ApartmentDAO<VO extends ApartmentVO> extends BaseDAO<VO> {
    public void insert(VO apartment) throws SQLException, ValidationException {
    }

    public ResultSet findById(VO apartment) throws SQLException {
        return null;
    }

    public ResultSet findAll() throws SQLException {
        return null;
    }

    public void update(VO apartment) throws SQLException {
    }

    public void delete(VO apartment) throws SQLException {
    }
}
