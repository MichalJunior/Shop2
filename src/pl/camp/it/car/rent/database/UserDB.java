package pl.camp.it.car.rent.database;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.car.rent.Authenticator;
import pl.camp.it.car.rent.model.User;

public class UserDB {
    private User[] users = new User[2];

    public UserDB() {
        this.users[0] = new User("mateusz",
                "fff2f9619b803349d3d2a269306c0002", "USER");
        this.users[1] = new User("admin",
                "34fabc41d484eb1563a1c188e0b30718", "ADMIN");
    }

    public User[] getUsers() {
        return users;
    }

    public User findUserByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;
    }
}
