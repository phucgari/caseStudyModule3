package view;

import controller.transaction.TransactionControllerImpl;
import controller.wallet.WalletControllerImpl;
import model.Transaction;
import model.Wallet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@WebServlet(name = "TransactionServlet", value = "/transaction")
public class TransactionServlet extends HttpServlet {
    private final TransactionControllerImpl transactionController = new TransactionControllerImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
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
                showAllTransaction(request, response);
        }
    }

    private void showAllTransaction(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        LocalDateTime time = LocalDateTime.parse(request.getParameter("time"));
        Long money_Amount = Long.valueOf(request.getParameter("money_amount"));
        String action = request.getParameter("action");
        int walletId = Integer.parseInt(request.getParameter("wallet_id"));
        Wallet wallet_id = new Wallet(walletId);
        Transaction transaction = new Transaction(id, time, money_Amount, action, wallet_id);
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
        request.setAttribute("wallet", existingTransaction);
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

        RequestDispatcher dispatcher = request.getRequestDispatcher("wallet/createTransaction.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateTransaction(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        LocalDateTime time = LocalDateTime.parse(request.getParameter("time"));
        Long money_Amount = Long.valueOf(request.getParameter("money_amount"));
        String action = request.getParameter("t_action");
        Wallet wallet_id = new Wallet();
        Transaction transaction = new Transaction(id, time, money_Amount, action, wallet_id);
        transactionController.update(transaction);
        RequestDispatcher dispatcher = request.getRequestDispatcher("wallet/editTransaction.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
