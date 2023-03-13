package controller.plannedtransaction;

import controller.GenericController;
import model.PlannedTransaction;

import java.util.Collection;

public interface PlannedTransactionController extends GenericController<PlannedTransaction> {
    Collection<PlannedTransaction> showAll();
    void create(PlannedTransaction object);
    PlannedTransaction showByIndex(int index);
    void update(PlannedTransaction Object);
    void delete(int index);
}
