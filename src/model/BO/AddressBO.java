package model.BO;

import model.DAO.AddressDAO;
import model.VO.AddressVO;

public class AddressBO implements IBaseBO<AddressVO> {
    private static AddressDAO<AddressVO> addressDAO = new AddressDAO<AddressVO>();

    public void insert(AddressVO address) throws Exception {
        
    }

    public void update(AddressVO address) throws Exception {
        
    }

    public void delete(AddressVO address) throws Exception {
        
    }

    public AddressVO findById(AddressVO address) {
        return null;
    }
}
