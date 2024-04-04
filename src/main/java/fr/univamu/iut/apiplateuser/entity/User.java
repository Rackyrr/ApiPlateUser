package fr.univamu.iut.apiplateuser.entity;

import jakarta.persistence.*;

/**
 * Represents a user entity.
 */
@Entity
@Table(name = "User")
public class User {

    /**
     * The unique identifier of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * The username of the user.
     */
    @Column(name = "username")
    private String username;

    /**
     * The password of the user.
     */
    @Column(name= "password")
    private String password;

    /**
     * The email address of the user.
     */
    @Column(name = "email")
    private String email;

    /**
     * The delivery address of the user.
     */
    @Column(name = "delivery_address")
    private String deliveryAddress;

    /**
     * Constructs a new User with the given parameters.
     *
     * @param id              The unique identifier of the user.
     * @param username        The username of the user.
     * @param password        The password of the user.
     * @param email           The email address of the user.
     * @param deliveryAddress The delivery address of the user.
     */
    public User(int id, String username, String password, String email, String deliveryAddress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Constructs a new User with default values.
     */
    public User() {}

    /**
     * Constructs a new User with the given parameters, including the hashed password.
     *
     * @param username        The username of the user.
     * @param hashedPassword The hashed password of the user.
     * @param email           The email address of the user.
     * @param deliveryAddress The delivery address of the user.
     */
    public User(String username, String hashedPassword, String email, String deliveryAddress) {
        this.username = username;
        this.password = hashedPassword;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Returns a read-only representation of the user.
     *
     * @return A read-only representation of the user.
     */
    public UserReadModel readModel() {
        return new UserReadModel(
                this.id,
                this.username,
                this.email,
                this.deliveryAddress);
    }

    // Getters and setters

    /**
     * Gets the unique identifier of the user.
     *
     * @return The unique identifier of the user.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id The unique identifier of the user.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the delivery address of the user.
     *
     * @return The delivery address of the user.
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Sets the delivery address of the user.
     *
     * @param deliveryAddress The delivery address of the user.
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
