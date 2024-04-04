package fr.univamu.iut.apiplateuser.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name= "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "delivery_address")
    private String deliveryAddress;

    public User(int id, String username, String password, String email, String deliveryAddress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    public User() {}

    public User(String username, String hashedPassword, String email, String deliveryAddress) {
        this.username = username;
        this.password = hashedPassword;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String pseudo) {
        this.username = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
