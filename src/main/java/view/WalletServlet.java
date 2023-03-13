package view;

import controller.wallet.WalletControllerImpl;
import manager.WalletManager;
import model.Wallet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "WalletServlet", value = "/wallet")
public class WalletServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null)action="";
        switch(action){
            default:
                showALlWallet(request,response);
        }
    }

    private void showALlWallet(HttpServletRequest request, HttpServletResponse response) {
        WalletManager.setWalletList(request);
        try {
            request.getRequestDispatcher("wallet/showAllWallets.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
