package controller;

import connector.Connector;

import java.util.Collection;

public interface GenericController<E> {
    String jdbcURL = null;
    String jdbcUsername = null;
    String jdbcPassword = null;
    Connector connector=new Connector(jdbcURL,jdbcUsername,jdbcPassword);
    Collection<E> showAll();
    void create();
    E showByIndex(int index);
    void update(E Object);
    void delete(int index);
}
