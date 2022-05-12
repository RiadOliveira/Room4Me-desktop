package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.VO.ApartmentVO;

public class ApartmentDAO extends BaseDAO<ApartmentVO> {
    public void insert(ApartmentVO apartment) throws SQLException, Exception {
        AddressDAO addressDAO = new AddressDAO();
        addressDAO.insert(apartment.getAddress());

        AspectsDAO aspectsDAO = new AspectsDAO();
        aspectsDAO.insert(apartment.getAspects());

        super.insert(apartment);
    }

    public ResultSet findAll() throws SQLException {
        Connection connection = getConnection();

        String query = "SELECT * FROM Room4Me.Apartment";

        Statement statement = connection.createStatement();
        ResultSet findedApartments = statement.executeQuery(query);

        return findedApartments;
    }

    public void update(ApartmentVO apartment) throws SQLException, Exception {
        AddressDAO addressDAO = new AddressDAO();
        addressDAO.update(apartment.getAddress());

        AspectsDAO aspectsDAO = new AspectsDAO();
        aspectsDAO.update(apartment.getAspects());

        super.update(apartment);
    }
}
