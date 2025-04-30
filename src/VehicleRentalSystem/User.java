package VehicleRentalSystem;

public class User {

    int userId;
    String userName;
    String licenseNumber;

    public User(int userId, String userName, String licenseNumber) {
        this.userId = userId;
        this.userName = userName;
        this.licenseNumber = licenseNumber;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}
