package user;

public abstract class User {
    private String status = "status1";
    private static int prevID = 1000;
    private int ID;

    public User() {
        this.ID = prevID++;
    }

    public void update(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
