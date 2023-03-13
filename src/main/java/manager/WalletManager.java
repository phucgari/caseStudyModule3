package manager;

import controller.wallet.WalletControllerImpl;
import model.Wallet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class WalletManager {
    public static void setWalletList(HttpServletRequest request) {
        HttpSession session= request.getSession();
        if(session.getAttribute("id")==null)return;
        int id= (int) session.getAttribute("id");
        String login_name=(String)session.getAttribute("login_name");
        ArrayList<Wallet> wallets=new WalletControllerImpl().showAllWalletById(id);
        request.setAttribute("wallets",wallets);
        request.setAttribute("login_name",login_name);
    }
}
