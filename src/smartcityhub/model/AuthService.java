package smartcityhub.model;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<User> users;

    public AuthService() {
        users = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("Account registered: " + user.getName() + " (" + user.getEmail() + ")");
    }

    public User login(String email, String password) {
        for (User user : users) {
            if (user.login(email, password)) {
                System.out.println("Login successful: " + user.getName());
                return user;
            }
        }
        System.out.println("Login failed for " + email);
        return null;
    }

    public int getUserCount() {
        return users.size();
    }
}
