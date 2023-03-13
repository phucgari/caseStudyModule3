package view;

import controller.user.UserController;
import controller.user.UserControllerImpl;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private UserControllerImpl userControllerImpl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "create":
//                    createUser(request, response);
//                    break;
//                case "edit":
//                    updateUser(request, response);
//                case "view":
//                    find(request, response);
//                    break;
//            }
//        } catch (Exception ex) {
//            throw new ServletException(ex);
//        }
        createUser(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("userAction/login.jsp");
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
                    showNewForm(request, response);
                    break;
//                case "edit":
//                    showEditForm(request, response);
//                    break;
//                case "delete":
//                    deleteUser(request, response);
//                    break;
//                case "view":
//                    showUserForm(request, response);
//                    break;
                default:
                    showNewForm(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("userAction/login.jsp");
        dispatcher.forward(request, response);
    }
}
