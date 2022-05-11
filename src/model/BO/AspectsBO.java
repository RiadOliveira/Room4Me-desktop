package model.BO;

import model.DAO.AspectsDAO;
import model.VO.AspectsVO;

public class AspectsBO implements IBaseBO<AspectsVO> {
    private static AspectsDAO<AspectsVO> aspectsDAO = new AspectsDAO<AspectsVO>();

    public void insert(AspectsVO aspects) throws Exception {
        
    }

    public void update(AspectsVO aspects) throws Exception {
        
    }

    public void delete(AspectsVO aspects) throws Exception {
        
    }

    public AspectsVO findById(AspectsVO aspects) {
        return null;
    }
}
