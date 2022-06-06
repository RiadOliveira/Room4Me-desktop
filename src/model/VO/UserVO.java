package model.VO;

import errors.ValidationException;
import utils.DataConverter;
import utils.Gender;

public class UserVO extends Entity {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Gender gender;
    private String avatar = null;

    public void Copy(UserVO user) {
        this.name = user.name;
        this.email = user.email;
        this.password = user.password;
        this.phoneNumber = user.phoneNumber;
        this.gender = user.gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidationException {
        String propertyName = "name";
        verifyNull(name, propertyName);
        verifyStringLength(name, propertyName);

        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ValidationException {
        String propertyName = "email";
        verifyNull(email, propertyName);
        verifyStringLength(email, propertyName);

        String splittedEmail[] = email.split("@");
        if(email.equals(splittedEmail[0]) || !splittedEmail[1].contains(".")) {
            throw new ValidationException("Invalid e-mail format.");
        }

        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws ValidationException {
        verifyNull(password, "password");
        if(password.length() < 8) {
            throw new ValidationException(
                "Password must be greater than or equal to 8 in length."
            );
        }

        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws ValidationException {
        verifyNull(phoneNumber, "phoneNumber");

        // To get only variable numbers.
        String parsedPhoneNumber = phoneNumber.replaceAll("\\D+","");
        if(parsedPhoneNumber.length() != 13) {
            throw new ValidationException(
                "Phone number must be equal to 13 in length."
            );
        }

        this.phoneNumber = parsedPhoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) throws ValidationException {
        if(avatar == null) {
            this.avatar = null;
            return;
        }

        String propertyName = "avatar";
        verifyStringLength(avatar, propertyName);

        this.avatar = avatar;
    }

    public String dataToText() {
        String textData = "";
        String parsedPhoneNumber = DataConverter.getParsedPhoneNumber(
            phoneNumber
        );

		textData += "- Nome: " + name + '\n';
		textData += "- Email: " + email + '\n';
		textData += "- Telefone: " + parsedPhoneNumber + '\n';

        return textData;
    }
}