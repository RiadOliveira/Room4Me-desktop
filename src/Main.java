import errors.ValidationException;
import model.VO.User;

public class Main {
    public static void main(String args[]) {
        User user = new User();
        try {
            user.setEmail("riad.oliveira@hotmailcom");
            System.out.println(user.getEmail());
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }
}
