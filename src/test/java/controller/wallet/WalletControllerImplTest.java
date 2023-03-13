package controller.wallet;

import controller.GenericController;
import model.User;
import model.Wallet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WalletControllerImplTest {
    GenericController<Wallet> walletController= new WalletControllerImpl();

    @AfterEach
    void afterFlush(){
        walletController.connector.flush();
    }
    @Test
    void testGetALl(){
        ArrayList<Wallet> wallets= (ArrayList<Wallet>) walletController.showAll();
        assertEquals("[Wallet{id=1, name='tieu dung', balance=130000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=2, name='vi', balance=190000, user_id=User{id=2, login_name='popin123', login_password='password123', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=3, name='tiet kiem', balance=1900000, user_id=User{id=2, login_name='popin123', login_password='password123', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=4, name='dau tu', balance=2200000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=5, name='tieu vat', balance=100000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",wallets.toString());
    }
    @Test
    void testCreate(){
        Wallet wallet=new Wallet("sdfafda",388888888,new User(3,"fsdf","fsdff"));
        walletController.create(wallet);
        ArrayList<Wallet> wallets=(ArrayList<Wallet>) walletController.showAll();
        assertEquals("[Wallet{id=1, name='tieu dung', balance=130000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=2, name='vi', balance=190000, user_id=User{id=2, login_name='popin123', login_password='password123', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=3, name='tiet kiem', balance=1900000, user_id=User{id=2, login_name='popin123', login_password='password123', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=4, name='dau tu', balance=2200000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=5, name='tieu vat', balance=100000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=6, name='sdfafda', balance=388888888, user_id=User{id=3, login_name='wowweee', login_password='helloworld', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",wallets.toString());
        wallet=new Wallet("ffffff",999999999,new User(1,"fdffff","errr333"));
        walletController.create(wallet);
        wallets=(ArrayList<Wallet>) walletController.showAll();
        assertEquals("[Wallet{id=1, name='tieu dung', balance=130000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=2, name='vi', balance=190000, user_id=User{id=2, login_name='popin123', login_password='password123', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=3, name='tiet kiem', balance=1900000, user_id=User{id=2, login_name='popin123', login_password='password123', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=4, name='dau tu', balance=2200000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=5, name='tieu vat', balance=100000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=6, name='sdfafda', balance=388888888, user_id=User{id=3, login_name='wowweee', login_password='helloworld', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}" +
                ", Wallet{id=7, name='ffffff', balance=999999999, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",wallets.toString());
    }
    @Test
    void testUpdate(){
        Wallet wallet=new Wallet(3,"fdsdfsdf",0,new User());
        walletController.update(wallet);
        ArrayList<Wallet> wallets= (ArrayList<Wallet>) walletController.showAll();
        assertEquals("[Wallet{id=1, name='tieu dung', balance=130000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=2, name='vi', balance=190000, user_id=User{id=2, login_name='popin123', login_password='password123', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=3, name='fdsdfsdf', balance=0, user_id=User{id=2, login_name='popin123', login_password='password123', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=4, name='dau tu', balance=2200000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=5, name='tieu vat', balance=100000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",wallets.toString());
        wallet=new Wallet(2,"pofpodsf",22222,new User());
        walletController.update(wallet);
        wallets= (ArrayList<Wallet>) walletController.showAll();
        assertEquals("[Wallet{id=1, name='tieu dung', balance=130000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=2, name='pofpodsf', balance=22222, user_id=User{id=2, login_name='popin123', login_password='password123', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=3, name='fdsdfsdf', balance=0, user_id=User{id=2, login_name='popin123', login_password='password123', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=4, name='dau tu', balance=2200000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}, " +
                "Wallet{id=5, name='tieu vat', balance=100000, user_id=User{id=1, login_name='phuc1', login_password='phuc1password', email='null', picture_url='null', gender=false, user_name='null', user_dob=null, card_id='null', phone='null', address='null'}}]",wallets.toString());
    }
}