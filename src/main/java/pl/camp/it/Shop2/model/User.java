package pl.camp.it.Shop2.model;


import pl.camp.it.Shop2.Authenticator;

import java.util.Objects;

public class User {
    String login;
    String password;
    Role role;

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    public Role getRole() {
        return role;
    }

    public enum Role {
        isAdmin,
        isUser;
    }

    public String getLogin() {
        return login;
    }
}