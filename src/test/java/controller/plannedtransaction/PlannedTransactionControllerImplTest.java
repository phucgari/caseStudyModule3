package controller.plannedtransaction;

import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;
import model.PlannedTransaction;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlannedTransactionControllerImplTest {
    PlannedTransactionControllerImpl plannedTransactionController=new PlannedTransactionControllerImpl();

    @AfterEach
    void after(){
        plannedTransactionController.connector.flush();
    }
    @Test
    void testShowPlannedTransactionOnDemand(){
        ArrayList<PlannedTransaction> list=plannedTransactionController.showPlannedTransactionOnDemand(1,0,70000);
        assertEquals("[PlannedTransaction{id=1, action='mua cay dao', money_Amount=70000, user_id=User{id=1, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",list.toString());
        list=plannedTransactionController.showPlannedTransactionOnDemand(1,75000,500000);
        assertEquals("[PlannedTransaction{id=3, action='Tra no anh Hung', money_Amount=122000, user_id=User{id=1, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",list.toString());
        list=plannedTransactionController.showPlannedTransactionOnDemand(3,0,9000000);
        assertEquals("[PlannedTransaction{id=4, action='mua tai nghe', money_Amount=80000, user_id=User{id=3, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",list.toString());
    }
    @Test
    void testCreateTransaction(){
        plannedTransactionController.create(new PlannedTransaction("fdsafasd",43424234,new User(3)));
        ArrayList<PlannedTransaction> list=plannedTransactionController.showPlannedTransactionOnDemand(3,0,99999999);
        assertEquals("[PlannedTransaction{id=4, action='mua tai nghe', money_Amount=80000, user_id=User{id=3, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "PlannedTransaction{id=5, action='fdsafasd', money_Amount=43424234, user_id=User{id=3, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",list.toString());
        plannedTransactionController.create(new PlannedTransaction("222231321",433432222,new User(2)));
        list=plannedTransactionController.showPlannedTransactionOnDemand(2,0,999999999);
        assertEquals("[PlannedTransaction{id=2, action='mua TV', money_Amount=200000, user_id=User{id=2, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "PlannedTransaction{id=6, action='222231321', money_Amount=433432222, user_id=User{id=2, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]", list.toString());
    }
    @Test
    void testUpdateTransaction(){
        plannedTransactionController.update(new PlannedTransaction(1,"4444421trtr",222223123,new User(1)));
        ArrayList<PlannedTransaction> list=plannedTransactionController.showPlannedTransactionOnDemand(1,0,9999999999L);
        assertEquals("[PlannedTransaction{id=1, action='4444421trtr', money_Amount=222223123, user_id=User{id=1, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "PlannedTransaction{id=3, action='Tra no anh Hung', money_Amount=122000, user_id=User{id=1, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",list.toString());
        plannedTransactionController.update(new PlannedTransaction(2,"lldlflflflfl",333333333,new User(99999)));
        list=plannedTransactionController.showPlannedTransactionOnDemand(2,0,99999999999999L);
        assertEquals("[PlannedTransaction{id=2, action='lldlflflflfl', money_Amount=333333333, user_id=User{id=2, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",list.toString());
    }
    @Test
    void testDeleteTransaction(){
        plannedTransactionController.delete(1);
        ArrayList<PlannedTransaction> list=plannedTransactionController.showPlannedTransactionOnDemand(1,0,9999999999999L);
        assertEquals("[PlannedTransaction{id=3, action='Tra no anh Hung', money_Amount=122000, user_id=User{id=1, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",list.toString());
        plannedTransactionController.delete(2);
        list=plannedTransactionController.showPlannedTransactionOnDemand(2,0,999999999999L);
        assertEquals("[]",list.toString());
    }
    @Test
    void testFindPlannedTransactionByID(){
        PlannedTransaction plannedTransaction=plannedTransactionController.showByIndex(1);
        assertEquals("PlannedTransaction{id=1, action='mua cay dao', money_Amount=70000, user_id=User{id=1, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}",plannedTransaction.toString());
        plannedTransaction=plannedTransactionController.showByIndex(2);
        assertEquals("PlannedTransaction{id=2, action='mua TV', money_Amount=200000, user_id=User{id=2, login_name='null', login_password='null', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}",plannedTransaction.toString());
    }
}