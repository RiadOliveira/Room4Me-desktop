package model.DAO;

import java.sql.SQLException;
import errors.ValidationException;
import model.VO.AddressVO;

public class AddressDAO<VO extends AddressVO> extends BaseDAO<VO> {
    public void insert(VO address) throws SQLException, ValidationException {
    }

    public void update(VO address) throws SQLException {
    }
}
