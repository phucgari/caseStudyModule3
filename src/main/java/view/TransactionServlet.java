package view;

import controller.transaction.TransactionControllerImpl;
import model.Transaction;
import model.Wallet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TransactionServlet", value = "/transaction")
public class TransactionServlet extends HttpServlet {
    private TransactionControllerImpl transactionController = new TransactionControllerImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "editTransaction":
                    showEditForm(request, response);
                    break;
            }
        }catch (Exception e){
            throw new ServletException(e);
        }
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("wallet/createTransaction.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Transaction> existingWallet = transactionController.showAllTransactionById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("wallet/editTransaction.jsp");
        request.setAttribute("wallet",existingWallet);
        dispatcher.forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
