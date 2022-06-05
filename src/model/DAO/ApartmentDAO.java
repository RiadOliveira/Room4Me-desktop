package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.VO.AddressVO;
import model.VO.ApartmentVO;
import model.VO.AspectsVO;
import model.VO.Entity;
import utils.DataConverter;

public class ApartmentDAO extends BaseDAO<ApartmentVO> {
    private static String findApartmentsQuery = null;

    public ApartmentDAO() {
        if(findApartmentsQuery == null) {
            String query = "SELECT apartment.id, ";

            query += generateQueryPropsFromEntity(new ApartmentVO(), false);
            query += generateQueryPropsFromEntity(new AddressVO(), false);
            query += generateQueryPropsFromEntity(new AspectsVO(), true);

            query += " FROM Room4Me.Apartment as apartment ";
            query += "INNER JOIN Room4Me.Address as address on address.id = apartment.address ";
            query += "INNER JOIN Room4Me.Aspects as aspects on aspects.id = apartment.aspects";

            findApartmentsQuery = query;
        }
    }

    private <VO extends Entity>String generateQueryPropsFromEntity(
        VO entity, boolean isLastProps
    ) {
        List<String> entityFields = entity.getFieldsNames();
        String entityName = entity.getClass().getSimpleName().split("VO")[0];
        String queryPropsFromEntity = "";

        for(String entityField: entityFields) {
            String parsedField = DataConverter.convertCamelCaseToSnakeCase(entityField);
            queryPropsFromEntity += entityName + '.' + parsedField + ", ";
        }

        if(isLastProps) {
            queryPropsFromEntity = queryPropsFromEntity.substring(
                0, queryPropsFromEntity.length() - 2
            );
        }

        return queryPropsFromEntity;
    }

    public void insert(ApartmentVO apartment) throws SQLException, Exception {
        AddressDAO addressDAO = new AddressDAO();
        addressDAO.insert(apartment.getAddress());

        AspectsDAO aspectsDAO = new AspectsDAO();
        aspectsDAO.insert(apartment.getAspects());

        super.insert(apartment);
    }

    public ResultSet findAll() throws SQLException {
        Connection connection = getConnection();

        Statement statement = connection.createStatement();
        ResultSet findedApartments = statement.executeQuery(findApartmentsQuery);

        return findedApartments;
    }

    public ResultSet findById(ApartmentVO apartment) throws SQLException, Exception {
        Connection connection = getConnection();
        String query = findApartmentsQuery + " WHERE apartment.id=?::uuid";
        
        PreparedStatement statement;
        ResultSet findedEntity;

        statement = connection.prepareStatement(query);
        statement.setString(1, apartment.getId().toString());
        findedEntity = statement.executeQuery();

        if(!findedEntity.next()) throw new Exception("Apartment not found.");
        return findedEntity;

    }
  
    public void update(ApartmentVO apartment) throws SQLException, Exception {
        AddressDAO addressDAO = new AddressDAO();
        addressDAO.update(apartment.getAddress());

        AspectsDAO aspectsDAO = new AspectsDAO();
        aspectsDAO.update(apartment.getAspects());

        super.update(apartment);
    }
}
