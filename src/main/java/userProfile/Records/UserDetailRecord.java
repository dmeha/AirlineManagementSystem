package userProfile.Records;

public record UserDetailRecord(String userId, String email, String name, String address, String contact) {
    public UserDetailRecord(String userId, String email, String name, String address, String contact) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.address = address;
        this.contact = contact;

    }


}
