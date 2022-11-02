package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> users = new ArrayList<>();
    public UserDB(){
        users.add(new User("admin","c8d76e034ae1dbf3548d6eca3f1a08bd", User.Role.isAdmin));

        users.add(new User("michal","ece2c66cf415af02fcf4f6449ca2ad1c", User.Role.isUser));
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
