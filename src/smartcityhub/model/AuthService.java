package smartcityhub.model;

import java.util.ArrayList;
import java.util.List;

/**
 * NEW: AuthService implements the Phase I "Login" and "Register Account" use cases.
 * It keeps a registry of users and validates credentials through User.login(),
 * which previously existed but was never exercised.
 */
public class AuthService {

    private List<User> users;

    public AuthService() {
        users = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("Account registered: " + user.getName()
                + " (" + user.getEmail() + ")");
    }

    public User login(String email, String password) {
        for (User u : users) {
            if (u.login(email, password)) {
                System.out.println("Login successful: " + u.getName());
                return u;
            }
        }
        System.out.println("Login failed for " + email);
        return null;
    }

    public int getUserCount() {
        return users.size();
    }
}
