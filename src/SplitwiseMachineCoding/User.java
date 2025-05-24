package SplitwiseMachineCoding;

public class User {
    private final String userId;
    private final String name;
    private final String email;
    private final String mobileNumber;

    public User(String userId, String name, String email, String mobileNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
