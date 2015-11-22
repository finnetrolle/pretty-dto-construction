package ru.finnetrolle.examples.prettydtoconstruction.dto;

import java.util.Set;

/**
 * Created by finnetrolle on 22.11.2015.
 */
public class UserDto {

    private Long id;
    private String login;
    private String name;
    private Set<String> accessRights;

    public UserDto() {
    }

    public UserDto(Long id, String login, String name, Set<String> accessRights) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.accessRights = accessRights;
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

    public Set<String> getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(Set<String> accessRights) {
        this.accessRights = accessRights;
    }
}
