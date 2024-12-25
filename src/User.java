public class User extends Entity {
    private String name;
    private String email;
    private String password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User(int id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public void login() {
        System.out.println(name + " logged in.");
    }
    public void logout() {
        System.out.println(name + " logged out.");
    }
    public String toString() {
        return "User{" +"id=" + super.getId() +", name='" + name + '\'' + ", email='" + email + '\'' +", password='" + password + '\'' + '}';
    }
}
