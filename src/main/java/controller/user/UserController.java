package controller.user;

import controller.GenericController;
import model.User;

import java.util.Collection;
import java.util.List;

public interface UserController extends GenericController<User> {
    Collection<User> showAll();
    void create(User user);
    User showByIndex(int index);
    void update(User user);
    void delete(int index);
}
