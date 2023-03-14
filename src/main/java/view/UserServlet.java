package view;

import controller.user.UserControllerImpl;
import manager.WalletManager;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private UserControllerImpl userControllerImpl = new UserControllerImpl();
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
                case "editProfile":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:
                    showUserProfile(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void showUserProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int id= (int) session.getAttribute("id");
        User user=userControllerImpl.showByIndex(id);
        request.setAttribute("user",user);
        WalletManager.setWalletList(request);
        RequestDispatcher dispatcher=request.getRequestDispatcher("userAction/profile.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userControllerImpl.delete(id);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userControllerImpl.showByIndex(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userAction/editProfile.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("userAction/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    createUser(request, response);
                    break;
                case "editProfile":
                    updateUser(request, response);
                    break;

//                case "view":
//                    showUserForm(request, response);
//                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String login_name = request.getParameter("login_name");
        String login_password = request.getParameter("login_password");
        String email = request.getParameter("email");
        String picture_url = request.getParameter("picture_url");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String user_name = request.getParameter("user_name");
        String user_dob = request.getParameter("user_dob");
        String card_id = request.getParameter("card_id");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        User newUser = new User(id, login_name, login_password, email, picture_url, gender, user_name, user_dob,
                card_id, phone, address);
        userControllerImpl.update(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userAction/editProfile.jsp");
        dispatcher.forward(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login_name = request.getParameter("login_name");
        String login_password = request.getParameter("login_password");
        String email = request.getParameter("email");
        String picture_url = request.getParameter("picture_url");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String user_name = request.getParameter("user_name");
        String user_dob = request.getParameter("user_dob");
        String card_id = request.getParameter("card_id");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        User newUser = new User(login_name, login_password, email, picture_url, gender, user_name, user_dob,
                card_id, phone, address);
        userControllerImpl.create(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userAction/register.jsp");
        dispatcher.forward(request, response);

    }
}
