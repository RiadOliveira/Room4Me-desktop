package model.BO;

import model.DAO.UserDAO;
import model.VO.UserVO;

public class UserBO extends BaseBO<UserVO> {
    private static UserDAO<UserVO> userDAO = new UserDAO<UserVO>();

    public void insert(UserVO entity) throws Exception {
        
    }

    public void update(UserVO entity) throws Exception {
        
    }

    public void delete(UserVO entity) throws Exception {
        
    }

    public UserVO findById(UserVO entity) {
        return null;
    }
}
