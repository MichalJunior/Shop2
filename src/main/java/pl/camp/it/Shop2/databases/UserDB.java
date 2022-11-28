package pl.camp.it.Shop2.databases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.interfaces.IUserDB;
import pl.camp.it.Shop2.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component

public class UserDB implements IUserDB {

@Autowired
    private  GUI gui;

    private static User loggedUser;
    private static final List<User> users = new ArrayList<>();



    public void addUserToDB() throws IOException {
        User newUser = gui.readLoginAndPassword();
        for (User userOnList : getUsers()) {
            if (userOnList.equals(newUser)) {
                System.out.println("  !!!! a user with this Login already exists  !!!!");
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
        for (User userOnList : getUsers()) {
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

    public  List<User> getUsers() {
        return users;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        UserDB.loggedUser = loggedUser;
    }
}


