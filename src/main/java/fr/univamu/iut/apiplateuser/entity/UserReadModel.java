package fr.univamu.iut.apiplateuser.entity;

/**
 * Represents a read-only model of a user entity.
 */
public class UserReadModel {

    /**
     * The unique identifier of the user.
     */
    private int id;

    /**
     * The username of the user.
     */
    private String username;

    /**
     * The email address of the user.
     */
    private String email;

    /**
     * The delivery address of the user.
     */
    private String deliveryAddress;

    /**
     * Constructs a new UserReadModel with the given parameters.
     *
     * @param id              The unique identifier of the user.
     * @param username        The username of the user.
     * @param email           The email address of the user.
     * @param deliveryAddress The delivery address of the user.
     */
    public UserReadModel(int id, String username, String email, String deliveryAddress) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Gets the unique identifier of the user.
     *
     * @return The unique identifier of the user.
     */
    public int getId() {
        return id;
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
     * Gets the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the delivery address of the user.
     *
     * @return The delivery address of the user.
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
