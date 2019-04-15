package constructors;

public class newUser {

    protected String username;
    protected String password;
    protected byte age;
    protected String name;

    public newUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public newUser(String username, String password, byte age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public newUser(String username, String password, byte age, String name) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.name = name;
    }
}
