package pl.camp.it.Shop2.authenticators;


import pl.camp.it.Shop2.databases.UserDB;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;

import java.io.IOException;

public class Authenticator {

    private final GUI gui = GUI.getInstance();
    private static final Authenticator instance = new Authenticator();
    private Authenticator(){}

    public boolean tryAuthenticate() throws IOException {
        User newUser = gui.readLoginAndPassword();
        for (User userOnList : UserDB.getUsers()) {
            if (userOnList.equals(newUser)) {
                UserDB.setLoggedUser(userOnList);
                return true;
            }
        }
        gui.printWrongCredentials();
        return tryAuthenticate();
    }
    public static Authenticator getInstance(){
        return instance;
    }
}
