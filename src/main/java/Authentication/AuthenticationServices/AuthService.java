package Authentication.AuthenticationServices;

import Database.Entities.User;

public interface AuthService {
    User SignIn(User user);
    User SignUp(User user);

}
