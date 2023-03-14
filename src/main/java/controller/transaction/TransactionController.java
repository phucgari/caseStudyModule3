package controller.transaction;

import controller.GenericController;
import model.Transaction;

import java.util.Collection;

public interface TransactionController extends GenericController<Transaction> {
    Collection<Transaction> showAll();
    void create(Transaction transaction);
    Transaction showByIndex(int index);
    void update(Transaction transaction);
    void delete(int index);
}
