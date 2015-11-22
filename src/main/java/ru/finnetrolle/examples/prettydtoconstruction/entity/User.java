package ru.finnetrolle.examples.prettydtoconstruction.entity;

/**
 * Created by finnetrolle on 22.11.2015.
 */
public class User {

    private Long id;
    private String login;
    private String name;
    private String hashedPassword;
    private Role role;

    public User(Long id, String login, String name, String hashedPassword, Role role) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.hashedPassword = hashedPassword;
        this.role = role;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
