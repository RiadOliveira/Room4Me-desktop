package model.BO;

import java.sql.ResultSet;
import java.util.UUID;

import model.DAO.UserDAO;
import model.VO.UserVO;
import utils.Gender;

public class UserBO extends BaseBO<UserVO> {
    private static UserDAO userDAO = new UserDAO();

    public void insert(UserVO user) throws Exception {
    	 verifyIsNull(user);
    	 userDAO.insert(user);
    }

    public void update(UserVO user) throws Exception {
    	 verifyIsNull(user);
         if(findById(user) == null) {
             throw new Exception("Requested user do not exist.");
         }

         userDAO.update(user);
    }

    public void delete(UserVO user) throws Exception {
    	 verifyIsNull(user);
         if(findById(user) == null) {
             throw new Exception("Requested user do not exist.");
         }

         userDAO.delete(user);
    }

    public UserVO getEntityFromResultSet(ResultSet findedUserDB) throws Exception {
        UserVO findedUser = new UserVO();
             
        findedUser.setId(UUID.fromString(findedUserDB.getString("id")));
        findedUser.setName(findedUserDB.getString("name"));
        findedUser.setEmail(findedUserDB.getString("email"));
        findedUser.setPassword(findedUserDB.getString("password"));
        findedUser.setPhoneNumber(findedUserDB.getString("phone_number"));
        
        int genderValue = findedUserDB.getInt("gender");
        findedUser.setGender(Gender.values()[genderValue]);             
        findedUser.setAvatar(findedUserDB.getString("avatar"));

        return findedUser;
    }

    public UserVO findById(UserVO user) {
    	 try {
    		 verifyIsNull(user);

             ResultSet findedUserDB = userDAO.findById(user);
             return getEntityFromResultSet(findedUserDB);
    	 } catch(Exception exception) {
    		 return null;
    	 }    
    }
}
