package model.VO;

import errors.ValidationException;
import utils.UserType;

public class User extends Entity {
    private String name;
    private String email;
    private String phoneNumber;
    private String avatar;
    private UserType type;

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidationException {
        verifyNull(name, "name");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ValidationException {
        verifyNull(email, "email");
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws ValidationException {
        verifyNull(phoneNumber, "phoneNumber");
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) throws ValidationException {
        verifyNull(avatar, "avatar");
        this.avatar = avatar;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) throws ValidationException {
        verifyNull(type, "type");
        this.type = type;
    }
}