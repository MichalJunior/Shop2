package pl.camp.it.Shop2.interfaces;

import pl.camp.it.Shop2.databases.UserDB;
import pl.camp.it.Shop2.model.User;

import java.io.IOException;
import java.util.List;

public interface IUserDB {
    void  addUserToDB() throws IOException;
    void makeUserAdmin() throws IOException;
    List<User> getUsers();
    User getLoggedUser();
    void setLoggedUser(User loggedUser);

}
