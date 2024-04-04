package fr.univamu.iut.apiplateuser.entity;

/**
 * Represents credentials used for user login.
 */
public class LoginCredentials {

    /**
     * The username for login.
     */
    private String username;

    /**
     * The password for login.
     */
    private String password;

    /**
     * Constructs an empty LoginCredentials object.
     */
    public LoginCredentials() {}

    /**
     * Constructs a LoginCredentials object with the specified username and password.
     *
     * @param username The username for login.
     * @param password The password for login.
     */
    public LoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username for login.
     *
     * @return The username for login.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for login.
     *
     * @param username The username for login.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password for login.
     *
     * @return The password for login.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for login.
     *
     * @param password The password for login.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
