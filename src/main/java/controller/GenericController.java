package controller;

import connector.Connector;

import java.util.Collection;

public interface GenericController<E> {
    String jdbcURL = "jdbc:mysql://localhost:3306/casestudy_demo?";
    String jdbcUsername = "root";
    String jdbcPassword = "0398878422suti?";
    Connector connector=new Connector(jdbcURL,jdbcUsername,jdbcPassword);
    Collection<E> showAll();
    void create(E object);
    E showByIndex(int index);
    void update(E Object);
    void delete(int index);
}
