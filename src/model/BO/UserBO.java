package model.BO;

import java.sql.ResultSet;

import model.DAO.UserDAO;
import model.VO.UserVO;

public class UserBO extends BaseBO<UserVO> {
    private static UserDAO<UserVO> userDAO = new UserDAO<UserVO>();

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

    public UserVO findById(UserVO user) {
    	 try {
    		 verifyIsNull(user);

             ResultSet findedUserDB = userDAO.findById(apartment);
             UserVO findUser = new UserVO();
             
             findUser.setId(UUID.fromString(findedUserDB.getString("id")));
             findUser.setName(findedUserDB.getString("name"))
             findUser.setEmail(findedUserDB.getString("email"))
             findUser.setPassword(findedUserDB.getString("password"))
             findUser.setPhoneNumber(findedUserDB.getString("phoneNumber"))
             
             int genderValue = findedUserDB.getInt("gender");
             findUser.setGender(Gender.values()[genderValue]);
             
             findUser.setAvatar(findedUserDB.getString("avatar"))
             
             return findUser;
    	 }catch(Exception exception) {
    		 return null;
    	 }    
    }
}
