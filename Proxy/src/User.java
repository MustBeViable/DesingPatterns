public class User {
    private static int userIndex = 1;
    private int userId;
    private String username;

    public User (String username) {
        this.username = username;
        this.userId = userIndex;
        userIndex++;
    }

    public int getUserId() {
        return userId;
    }
}
