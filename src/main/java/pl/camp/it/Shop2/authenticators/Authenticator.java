package pl.camp.it.Shop2.authenticators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.Shop2.databases.UserDB;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;

import java.io.IOException;

@Component
public class Authenticator {
    @Autowired
    private GUI gui;
    @Autowired
    private UserDB userDB;

    public boolean tryAuthenticate() throws IOException {
        User newUser = gui.readLoginAndPassword();
        for (User userOnList : userDB.getUsers()) {
            if (userOnList.equals(newUser)) {
                userDB.setLoggedUser(userOnList);
                return true;
            }
        }
        gui.printWrongCredentials();
        return tryAuthenticate();
    }

}
