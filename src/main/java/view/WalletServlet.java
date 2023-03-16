package view;

import controller.wallet.WalletControllerImpl;
import manager.WalletManager;
import model.User;
import model.Wallet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "WalletServlet", value = "/wallet")
public class WalletServlet extends HttpServlet {
    WalletControllerImpl walletController = new WalletControllerImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        WalletManager.setWalletList(request);
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                showCreateNewWallet(request, response);
                break;
            case "edit":
                showEditWallet(request, response);
                break;
            default:
                showALlWallet(request, response);
        }
    }

    private void showEditWallet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Wallet wallet = walletController.showByIndex(id);
        request.setAttribute("wallet", wallet);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wallet/editWallet.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateNewWallet(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wallet/createNewWallet.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showALlWallet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("wallet/showAllWallets.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createNewWallet(request, response);
                break;
            case "edit":
                editWallet(request, response);
        }
    }

    private void editWallet(HttpServletRequest request, HttpServletResponse response) {
        Wallet wallet = getWallet(request);
        walletController.update(wallet);
        showALlWallet(request, response);
    }

    private static Wallet getWallet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        String name = request.getParameter("name");
        long balance = Long.parseLong(request.getParameter("balance"));
        Wallet wallet = new Wallet(name, balance, new User(id));
        return wallet;
    }

    private void createNewWallet(HttpServletRequest request, HttpServletResponse response) {
        Wallet wallet = getWallet(request);
        walletController.create(wallet);
        showALlWallet(request, response);
    }
}
