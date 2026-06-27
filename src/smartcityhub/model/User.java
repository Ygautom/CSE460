package smartcityhub.model;

/**
 * User base class from the Phase II class diagram.
 * Attributes: userId, name, email, password.
 * Citizen, Administrator, and DepartmentManager inherit from User.
 */
public class User {
    protected String userId;
    protected String name;
    protected String email;
    protected String password;

    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void logout() {
        System.out.println(name + " logged out.");
    }

    public static void registerUser(String name, String email, String password) {
        System.out.println("Registered new user: " + name + " (" + email + ")");
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
