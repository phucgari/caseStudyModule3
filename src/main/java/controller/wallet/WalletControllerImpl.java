package controller.wallet;


import model.User;
import model.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WalletControllerImpl implements WalletController{
    private static final String GET_ALL_WALLET="select * from wallet left join user on wallet.user_id=user.id";
    @Override
    public ArrayList<Wallet> showAll() {
        // function 10+11
        ArrayList<Wallet> result=new ArrayList<>();
        try(Connection connection=connector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_ALL_WALLET)) {
            ResultSet resultset=preparedStatement.executeQuery();
            while (resultset.next()){
                int id=resultset.getInt(1);
                String name =resultset.getString(2);
                long balance=resultset.getLong(3);
                User user=generateUser(resultset);
                Wallet wallet=new Wallet(id,name,balance,user);
                result.add(wallet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private User generateUser(ResultSet resultset) {
        try {
            int id=resultset.getInt(5);
            String login_name=resultset.getString(6);
            String login_password=resultset.getString(7);
            return new User(id,login_name,login_password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void create(Wallet object) {
        // function 24
    }

    @Override
    public Wallet showByIndex(int index) {
        return null;
    }

    @Override
    public void update(Wallet Object) {
        //function 22
    }

    @Override
    public void delete(int index) {
        //function 23
    }
}
