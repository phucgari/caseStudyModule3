package controller.transaction;

import model.Transaction;
import model.Wallet;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class TransactionControllerImpl implements TransactionController {
    private static final String GET_ALL_TRANSACTION =
            "select transaction.id,transaction.name,transaction.time,transaction.money_Amount,transaction.action,transaction.wallet_id" +
                    "from transaction" +
                    "left join wallet on transaction.wallet_id=wallet.id where transaction.disable=0 ";
    private static final String GET_ALL_TRANSACTION_BY_ID =
            "\"select transaction.id,transaction.name,transaction.time,transaction.money_Amount,transaction.action,transaction.wallet_id\" +\n" +
                    "                    \"from transaction\" +\n" +
                    "                    \"left join wallet on transaction.wallet_id=wallet.id where transaction.disable=0 and transaction.wallet_id = ?\";";
    private static final String CREATE_A_TRANSACTION = "insert into transaction(time, money_Amount, action, wallet_id) values (?,?,?,?)";
    private static final String UPDATE_A_TRANSACTION = "update transaction set time = ?, money_Amount = ?, action = ?, wallet_id = ? where id = ?";
    private static final String DELETE_A_TRANSACTION = "update transaction set disable=1 WHERE id=?";
    @Override
    public ArrayList<Transaction> showAll() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try(Connection connection=connector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_ALL_TRANSACTION)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Transaction transaction = getTransaction(resultSet);
                transactions.add(transaction);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return transactions;
    }
    public ArrayList<Transaction> showAllTransactionById(int id){
        ArrayList<Transaction> transactions = new ArrayList<>();
        try(Connection connection=connector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_ALL_TRANSACTION)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Transaction transaction = getTransaction(resultSet);
                transactions.add(transaction);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return transactions;
        }
    private Transaction getTransaction(ResultSet resultSet) throws SQLException{
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        LocalDate time = resultSet.getDate("time").toLocalDate();
        int money_Amount = resultSet.getInt(" money_Amount");
        String action = resultSet.getString("action");
        Wallet wallet_id = (Wallet) resultSet.getObject("wallet_id");
        Transaction transaction = new Transaction(id,name,time,money_Amount,action,wallet_id);
        return transaction;
    }

    @Override
    public void create(Transaction transaction) {
        //function 7
        try(Connection connection=connector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(CREATE_A_TRANSACTION)) {
            preparedStatement.setString(1,transaction.getName());
            preparedStatement.setDate(2, Date.valueOf(transaction.getTime()));
            preparedStatement.setInt(3,transaction.getMoney_Amount());
            preparedStatement.setString(4,transaction.getAction());
            preparedStatement.setInt(5,transaction.getWallet_id().getId());
            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transaction showByIndex(int index) {
        return null;
    }

    @Override
    public void update(Transaction transaction) {
        //function 8
        try(Connection connection=connector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_A_TRANSACTION)) {
            preparedStatement.setString(1,transaction.getName());
            preparedStatement.setDate(2, Date.valueOf(transaction.getTime()));
            preparedStatement.setInt(3,transaction.getMoney_Amount());
            preparedStatement.setString(4,transaction.getAction());
            preparedStatement.setInt(5,transaction.getWallet_id().getId());
            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int index) {
        //function 18
        try(Connection connection=connector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_A_TRANSACTION)){
            preparedStatement.setInt(1,index);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
