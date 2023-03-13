package controller.user;

import model.User;

import java.util.Collection;

public interface UserController  {
    Collection<User> showAll();
    void create(User user);
    User showByIndex(int index);
    void update(User user);
    void delete(int index);
}
