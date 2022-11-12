package pl.camp.it.Shop2;


import pl.camp.it.Shop2.database.UserDB;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;

public class Authenticator {


    public static final String seed = "GdySieNieMaCoSieLubiToSieLubiCoSieMa";


    public static boolean tryAuthenticate() {
        User newUser = GUI.readLoginAndPassword();
        for (User userOnList : UserDB.getUsers()) {
            if (userOnList.equals(newUser)) {
                UserDB.setLoggedUser(userOnList);
                return true;
            }
        }
        GUI.printWrongCredentials();
        return tryAuthenticate();
    }
}
