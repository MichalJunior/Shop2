package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> users = new ArrayList<>();
    public UserDB(){
        users.add(new User("admin","34fabc41d484eb1563a1c188e0b30718", User.Role.isAdmin));
        users.add(new User("user","user", User.Role.isUser));
    }
    public User findUserByLogin(String login) {
        for(User user : users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;
    }

}
