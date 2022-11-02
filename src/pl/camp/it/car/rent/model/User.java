package pl.camp.it.car.rent.model;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.car.rent.Authenticator;

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
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        User temp = (User) obj;
        return this.login.equals(temp.login) &&
                this.password.equals(DigestUtils
                        .md5Hex(temp.password + Authenticator.seed));
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