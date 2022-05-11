package model.BO;

import java.util.List;

import model.DAO.ApartmentDAO;
import model.VO.ApartmentVO;

public class ApartmentBO implements IBaseBO<ApartmentVO> {
    private static ApartmentDAO<ApartmentVO> apartmentDAO = new ApartmentDAO<ApartmentVO>();

    public void insert(ApartmentVO apartment) throws Exception {
        
    }

    public void update(ApartmentVO apartment) throws Exception {
        
    }

    public void delete(ApartmentVO apartment) throws Exception {
        
    }

    public List<ApartmentVO> findAll() {
        return null;
    }

    public ApartmentVO findById(ApartmentVO apartment) {
        return null;
    }
}
