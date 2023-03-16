package view;

import controller.plannedtransaction.PlannedTransactionControllerImpl;
import manager.WalletManager;
import model.PlannedTransaction;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PlannedTransactionServlet", value = "/plannedtransaction")
public class PlannedTransactionServlet extends HttpServlet {
    PlannedTransactionControllerImpl plannedTransactionController=new PlannedTransactionControllerImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        WalletManager.setWalletList(request);
        String action=request.getParameter("action");
        if(action==null)action="";
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                deletePlannedTransaction(request,response);
            default:
                showPTransaction(request,response);
                break;
        }
    }

    private void deletePlannedTransaction(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        plannedTransactionController.delete(id);
    }

    private void showPTransaction(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        int userId = (int) session.getAttribute("id");
        long moneyStart = request.getParameter("money_start")==null?0:
                Long.parseLong(request.getParameter("money_start"));
        long moneyEnd = request.getParameter("money_end")==null?Long.MAX_VALUE:
                Long.parseLong(request.getParameter("money_end"));
        ArrayList<PlannedTransaction> plannedTransactions=plannedTransactionController.showPlannedTransactionOnDemand(userId, moneyStart, moneyEnd);
        request.setAttribute("list",plannedTransactions);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/userAction/showPlannedTransactions.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        PlannedTransaction plannedTransaction=plannedTransactionController.showByIndex(id);
        request.setAttribute("plannedTransaction",plannedTransaction);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("userAction/editPlannedTransaction");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/userAction/createPlannedTransaction");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action=request.getParameter("action");
        if(action==null)action="";
        switch (action){
            case "create":
                createNewPTransaction(request,response);
                break;
            case "edit":
                editPTransaction(request,response);
                break;
        }
    }

    private void editPTransaction(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        String action= request.getParameter("action");
        long money_Amount= Long.parseLong(request.getParameter("money_amount"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        User user_id=new User(userId);
        PlannedTransaction plannedTransaction=new PlannedTransaction(id,action,money_Amount,user_id);        plannedTransactionController.update(plannedTransaction);
        plannedTransactionController.update(plannedTransaction);
        showPTransaction(request,response);
    }

    private void createNewPTransaction(HttpServletRequest request, HttpServletResponse response) {
        String action= request.getParameter("action");
        long money_Amount= Long.parseLong(request.getParameter("money_amount"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        User user_id=new User(userId);
        PlannedTransaction plannedTransaction=new PlannedTransaction(action,money_Amount,user_id);
        plannedTransactionController.create(plannedTransaction);
        showPTransaction(request,response);
    }
}
