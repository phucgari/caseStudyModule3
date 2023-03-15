package controller.transaction;

import model.Transaction;
import model.Wallet;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TransactionControllerImpl implements TransactionController {
    private static final String GET_ALL_TRANSACTION =
            "select transaction.id,transaction.time,transaction.money_Amount,transaction.action,transaction.wallet_id" +
                    "from transaction" +
                    "join wallet on transaction.wallet_id=wallet.id";
    private static final String GET_ALL_TRANSACTION_BY_ID =
            "select transaction.id,transaction.time,transaction.money_Amount,transaction.action,transaction.wallet_id" +
                    "from transaction" +
                    "join wallet on transaction.wallet_id=wallet.id where" +
                    "join user on wallet.use_id=user.id";
    private static final String SHOW_TRANSACTION_ON_DEMAND =
            "select transaction.*" +
                    "from transaction" +
                    "join wallet on transaction.wallet_id=wallet.id " +
                    "where transaction.wallet_id=? and transaction.time between ? and ? and transaction.money_Amount";
    private static final String CREATE_A_TRANSACTION = "insert into transaction(time, money_Amount, action, wallet_id) values (?,?,?,?)";
    private static final String UPDATE_A_TRANSACTION = "update transaction set time = ?, money_Amount = ?, action = ?, wallet_id = ? where id = ?";
    private static final String DELETE_A_TRANSACTION = "update transaction set disable=1 WHERE id=?";

    @Override
    public ArrayList<Transaction> showAll() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TRANSACTION)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Transaction transaction = getTransaction(resultSet);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }

    public ArrayList<Transaction> showAllTransactionById(int id) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TRANSACTION_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Transaction transaction = getTransaction(resultSet);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }

    public ArrayList<Transaction> ShowTransactionOnDemand(int wallet_id, LocalDateTime timeStart, LocalDateTime timeEnd, long moneyStart, long moneyEnd) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SHOW_TRANSACTION_ON_DEMAND)) {
            preparedStatement.setInt(1,wallet_id);
            preparedStatement.setTimestamp(2,Timestamp.valueOf(timeStart));
            preparedStatement.setTimestamp(3,Timestamp.valueOf(timeEnd));
            preparedStatement.setLong(4,moneyStart);
            preparedStatement.setLong(5,moneyEnd);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Transaction transaction = getTransaction(resultSet);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }

    private Transaction getTransaction(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        LocalDateTime time = resultSet.getTimestamp("time").toLocalDateTime();
        Long money_Amount = resultSet.getLong(" money_amount");
        String action = resultSet.getString("action");
        Wallet wallet_id = new Wallet(resultSet.getInt("wallet_id"));
        Transaction transaction = new Transaction(id, time, money_Amount, action, wallet_id);
        return transaction;
    }

    @Override
    public void create(Transaction transaction) {
        //function 7
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_A_TRANSACTION)) {
            Timestamp timestamp = Timestamp.valueOf(transaction.getTime());
            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setLong(2, transaction.getMoney_Amount());
            preparedStatement.setString(3, transaction.getAction());
            preparedStatement.setInt(4, transaction.getWallet_id().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
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
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_A_TRANSACTION)) {
            Timestamp timestamp = Timestamp.valueOf(transaction.getTime());
            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setLong(2, transaction.getMoney_Amount());
            preparedStatement.setString(3, transaction.getAction());
            preparedStatement.setInt(4, transaction.getWallet_id().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int index) {
        //function 18
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_A_TRANSACTION)) {
            preparedStatement.setInt(1, index);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
