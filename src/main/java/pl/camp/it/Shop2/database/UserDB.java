package pl.camp.it.Shop2.database;

import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDB {


    private static final List<User> users = new ArrayList<>();
    private final GUI gui = new GUI();


    private static User loggedUser;


    public UserDB() {
        users.add(new User("admin", "c8d76e034ae1dbf3548d6eca3f1a08bd", User.Role.isAdmin));

        users.add(new User("michal", "ece2c66cf415af02fcf4f6449ca2ad1c", User.Role.isUser));
    }

    public void addUserToDB() throws IOException {
        User newUser = gui.readLoginAndPassword();
        for (User userOnList : getUsers()) {
            if (userOnList.equals(newUser)) {
                System.out.println("  !!!!  this User exists in DataBase  !!!!");
                addUserToDB();
            }
        }
        System.out.println("+++Successfully registered+++");
        newUser.setRole(User.Role.isUser);
        getUsers().add(newUser);
    }

    public void makeUserAdmin() throws IOException {
        User newUser = gui.readLoginAndPassword();
        boolean flag = false;
        for (User userOnList : UserDB.getUsers()) {
            if (userOnList.equals(newUser)) {
                newUser = userOnList;
                flag = true;
            }
        }
        if (flag) {
            newUser.setRole(User.Role.isAdmin);
            System.out.println("*** Successfully set User Admin ***");

        } else {
            System.out.println("---That used does not exist in Data Base,try again---");
            makeUserAdmin();
        }


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
}


