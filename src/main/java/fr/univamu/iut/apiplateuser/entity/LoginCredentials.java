package fr.univamu.iut.apiplateuser.entity;


public class LoginCredentials {
    private String username;
    private String password;

    public LoginCredentials() {}

    public LoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
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
}
