package controller.wallet;


import model.User;
import model.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WalletControllerImpl implements WalletController{
    private static final String GET_ALL_WALLET=
            "select wallet.id,wallet.name,wallet.balance,wallet.user_id,user.login_name,user.login_password " +
            "from wallet " +
            "left join user on wallet.user_id=user.id";
    private static final String CREATE_A_WALLET="insert into wallet(name,balance,user_id) values (?,?,?)";
    private static final String UPDATE_A_WALLET="update wallet set name=?,balance=? where id=?";

    @Override
    public ArrayList<Wallet> showAll() {
        // function 10+11
        ArrayList<Wallet> result=new ArrayList<>();
        try(Connection connection=connector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_ALL_WALLET)) {
            ResultSet resultset=preparedStatement.executeQuery();
            while (resultset.next()){
                int id=resultset.getInt("id");
                String name =resultset.getString("name");
                long balance=resultset.getLong("balance");
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
            int id=resultset.getInt("user_id");
            String login_name=resultset.getString("login_name");
            String login_password=resultset.getString("login_password");
            return new User(id,login_name,login_password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void create(Wallet object) {
        // function 24
        try(Connection connection=connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(CREATE_A_WALLET)) {
            preparedStatement.setString(1,object.getName());
            preparedStatement.setLong(2,object.getBalance());
            preparedStatement.setInt(3,object.getUser_id().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Wallet showByIndex(int index) {
        return null;
    }

    @Override
    public void update(Wallet object) {
        //function 22
        try(Connection connection=connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_A_WALLET)){
            preparedStatement.setString(1,object.getName());
            preparedStatement.setLong(2,object.getBalance());
            preparedStatement.setInt(3,object.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int index) {
        //function 23
    }
}
