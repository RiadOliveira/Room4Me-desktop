package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        Connection connection = getConnection();

        String query = "SELECT * FROM Room4Me.Apartment";

        Statement statement = connection.createStatement();
        ResultSet findedCustomers = statement.executeQuery(query);

        return findedCustomers;
    }

    public void update(VO apartment) throws SQLException, Exception {
        AddressDAO<AddressVO> addressDAO = new AddressDAO<AddressVO>();
        addressDAO.update(apartment.getAddress());

        AspectsDAO<AspectsVO> aspectsDAO = new AspectsDAO<AspectsVO>();
        aspectsDAO.update(apartment.getAspects());

        super.update(apartment);
    }
}
