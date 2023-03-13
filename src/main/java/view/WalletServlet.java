package view;

import controller.wallet.WalletControllerImpl;
import model.Wallet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "WalletServlet", value = "/wallet")
public class WalletServlet extends HttpServlet {
    WalletControllerImpl walletController= new WalletControllerImpl();
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
        HttpSession session=request.getSession();
        int id= (int) session.getAttribute("id");
        String login_name=(String)session.getAttribute("login_name");
        ArrayList<Wallet> wallets=walletController.showAllWalletById(id);
        request.setAttribute("wallets",wallets);
        request.setAttribute("login_name",login_name);
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
