package Authentication.AuthenticationServices;

import Database.DAO.UserCredDao;
import Database.Entities.User;
import Database.Mode;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Scanner;

public class Services implements AuthService {
    @Override
    public User SignIn(User user) {

        UserCredDao dao = new UserCredDao(Mode.TEST);
        User u = dao.getOneByUsername(user.getUsername());
        if(u != null){
            boolean sign = BCrypt.checkpw(user.getPassword(),u.getPassword());
            if (sign){
//                System.out.println(u.getSecurityQuestion());
                Scanner sc = new Scanner(System.in);
                String answer =  sc.nextLine();
                if( u.getSecurityAnswer().equals(answer)){
                    return u;
                }
                else {
                    System.out.println("Sign in not successful try again (Wrong answer)");
                }

            }else {
                System.out.println("Sign in not successful try again (Wrong password)");
            }

        }

        return null;
    }

    @Override
    public User SignUp(User user) {
          String password = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());

          UserCredDao dao = new UserCredDao(Mode.TEST);
        user.setPassword(password);
          dao.createOne(user);

        return user;
    }


}
