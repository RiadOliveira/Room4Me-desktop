package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.VO.AddressVO;
import model.VO.ApartmentVO;
import model.VO.AspectsVO;

public class ApartmentDAO<VO extends ApartmentVO> extends BaseDAO<VO> {
    public void insert(VO apartment) throws SQLException, Exception {
        AddressDAO<AddressVO> addressDAO = new AddressDAO<AddressVO>();
        addressDAO.insert(apartment.getAddress());

        AspectsDAO<AspectsVO> aspectsDAO = new AspectsDAO<AspectsVO>();
        aspectsDAO.insert(apartment.getAspects());

        super.insert(apartment);
    }

    public ResultSet findAll() throws SQLException {
        return null;
    }
}
