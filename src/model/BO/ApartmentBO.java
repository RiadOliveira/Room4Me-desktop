package model.BO;

import java.util.List;

import model.DAO.ApartmentDAO;
import model.VO.ApartmentVO;

public class ApartmentBO extends BaseBO<ApartmentVO> {
    private static ApartmentDAO apartmentDAO = new ApartmentDAO();

    public void insert(ApartmentVO apartment) throws Exception {
    	  verifyIsNull(apartment);
    	  apartmentDAO.insert(apartment);
    }

    public void update(ApartmentVO apartment) throws Exception {
    	 verifyIsNull(apartment);
         if(findById(apartment) == null) {
             throw new Exception("Requested apartment do not exist.");
         }

         apartmentDAO.update(apartment);
    }

    public void delete(ApartmentVO apartment) throws Exception {
    	 verifyIsNull(apartment);
         if(findById(apartment) == null) {
             throw new Exception("Requested apartment do not exist.");
         }

         AddressBO addressBO = new AddressBO();
         addressBO.delete(apartment.getAddress());

         AspectsBO aspectsBO = new AspectsBO();
         aspectsBO.delete(apartment.getAspects());

         apartmentDAO.delete(apartment);
    }

    public List<ApartmentVO> findAll() {
        return null;
    }

    public ApartmentVO findById(ApartmentVO apartment) {
        return null;
    }
}
