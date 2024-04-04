package fr.univamu.iut.apiplateuser.entity;

public class UserReadModel {
    private int id;
    private String username;
    private String email;
    private String deliveryAddress;

    public UserReadModel() {
    }

    public UserReadModel(int id, String username, String email, String deliveryAddress) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
