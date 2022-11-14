package pl.camp.it.Shop2;


import pl.camp.it.Shop2.database.UserDB;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;

import java.io.IOException;

public class Authenticator {

    private final GUI gui = new GUI();
  // UserDB userDB = new UserDB();

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
}
