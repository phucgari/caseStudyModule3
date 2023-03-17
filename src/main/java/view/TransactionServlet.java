package view;

import controller.transaction.TransactionControllerImpl;
import controller.wallet.WalletControllerImpl;
import manager.WalletManager;
import model.Transaction;
import model.Wallet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@WebServlet(name = "TransactionServlet", value = "/transaction")
public class TransactionServlet extends HttpServlet {
    private final TransactionControllerImpl transactionController = new TransactionControllerImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        WalletManager.setWalletList(request);
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                showTransaction(request, response);
        }
    }

    private void showTransaction(HttpServletRequest request, HttpServletResponse response) {
        int walletId = Integer.parseInt(request.getParameter("id"));
        LocalDateTime timeStart = request.getParameter("timeStart") == null ? LocalDateTime.parse("1900-06-07T00:00") :
                LocalDateTime.parse(request.getParameter("timeStart"));
        LocalDateTime timeEnd = request.getParameter("timeEnd") == null ? LocalDateTime.parse("2100-06-14T00:00") :
                LocalDateTime.parse(request.getParameter("timeEnd"));
        long moneyStart = request.getParameter("moneyStart") == null ? 0 :
                Long.parseLong(request.getParameter("moneyStart"));
        long moneyEnd = request.getParameter("moneyEnd") == null ? Long.MAX_VALUE :
                Long.parseLong(request.getParameter("moneyEnd"));
        ArrayList<Transaction> transactions = transactionController.ShowTransactionOnDemand(walletId, timeStart, timeEnd, moneyStart, moneyEnd);
        request.setAttribute("transactions", transactions);
        request.setAttribute("wallet_id",request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("userAction/showAllTransaction.jsp");
        long sum = 0;
        for (Transaction t: transactions) {
            sum+= t.getMoney_Amount();
        }
        request.setAttribute("sum", sum);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("wallet/createTransaction.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Transaction existingTransaction = transactionController.showByIndex(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("wallet/editTransaction.jsp");
        request.setAttribute("transaction", existingTransaction);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createTransaction(request, response);
                break;
            case "edit":
                updateTransaction(request, response);
                break;
        }
    }

    private void createTransaction(HttpServletRequest request, HttpServletResponse response) {
        LocalDateTime time = LocalDateTime.now();
        Long money_Amount = Long.valueOf(request.getParameter("money_amount"));
        String action = request.getParameter("t_action");
        int walletId = Integer.parseInt(request.getParameter("id"));
        WalletControllerImpl walletController = new WalletControllerImpl();
        Wallet wallet_id = walletController.showByIndex(walletId);
        Transaction transaction = new Transaction(time, money_Amount, action, wallet_id);
        if (wallet_id.getBalance() > money_Amount) {
            transactionController.create(transaction);
        }
        try {
            response.sendRedirect("/transaction?id="+walletId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateTransaction(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("T_id"));
        LocalDateTime time = LocalDateTime.parse(request.getParameter("T_time"));
        Long money_Amount = Long.valueOf(request.getParameter("money_amount"));
        String action = request.getParameter("t_action");
        Wallet wallet_id = new Wallet();
        Transaction transaction = new Transaction(id, time, money_Amount, action, wallet_id);
        transactionController.update(transaction);
        try {
            response.sendRedirect("/transaction?id="+request.getParameter("wallet_id"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
