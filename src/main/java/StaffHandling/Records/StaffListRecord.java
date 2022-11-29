package StaffHandling.Records;

public record StaffListRecord(String id, String name, String address, String contact, String email, String role) {
    public StaffListRecord(String id, String name, String address, String contact, String email, String role) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.role = role;
    }
}
