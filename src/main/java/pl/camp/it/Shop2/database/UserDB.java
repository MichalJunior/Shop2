package pl.camp.it.Shop2.database;

import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDB {


    private static final List<User> users = new ArrayList<>();


    private static User loggedUser;

    public UserDB() {
        users.add(new User("admin", "c8d76e034ae1dbf3548d6eca3f1a08bd", User.Role.isAdmin));

        users.add(new User("michal", "ece2c66cf415af02fcf4f6449ca2ad1c", User.Role.isUser));
    }

    public static List<User> getUsers() {
        return users;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User loggedUser) {
        UserDB.loggedUser = loggedUser;
    }

    public static void addUserToDB() {
        User newUser = GUI.readLoginAndPassword();
        for (User userOnList : getUsers()) {
            if (userOnList.equals(newUser)) {
                System.out.println("  !!!!  this User exists in DataBase  !!!!");
                addUserToDB();
            }
        }
        System.out.println("----Successfully registered----");
        newUser.setRole(User.Role.isUser);
        getUsers().add(newUser);
    }

}
