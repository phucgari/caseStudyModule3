package view;

import controller.user.UserControllerImpl;
import manager.WalletManager;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private UserControllerImpl userControllerImpl = new UserControllerImpl();
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
            case "editProfile":
                showEditForm(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "login":
                showFormLogin(request, response);
                break;
            default:
                showUserProfile(request, response);
                break;
        }
    }

    private void showUserProfile(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        int id= (int) session.getAttribute("id");
        String login_name= (String) session.getAttribute("login_name");
        request.setAttribute("login_name",login_name);
        User user=userControllerImpl.showByIndex(id);
        request.setAttribute("user",user);
        WalletManager.setWalletList(request);
        RequestDispatcher dispatcher=request.getRequestDispatcher("userAction/profile.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("userAction/login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) request.getSession().getAttribute("id");
        userControllerImpl.delete(id);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response){
        int id = (int) request.getSession().getAttribute("id");
        User existingUser = userControllerImpl.showByIndex(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userAction/editProfile.jsp");
        request.setAttribute("user", existingUser);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("userAction/register.jsp");
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
                createUser(request, response);
                break;
            case "editProfile":
                updateUser(request, response);
                break;
            case "login":
                loginProfile(request, response);
                break;
        }
    }
    private void loginProfile(HttpServletRequest request, HttpServletResponse response){
        String login_name = request.getParameter("login_name");
        String login_password = request.getParameter("login_password");
        User user = userControllerImpl.login(login_name, login_password);

        HttpSession session = request.getSession();
        session.setAttribute("login_name", login_name);

        if(user == null){
            try {
                response.sendRedirect("user?action=login");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                response.sendRedirect("userAction/profile.jsp");
                session.setAttribute("id", user.getId());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) request.getSession().getAttribute("id");

        String login_name = request.getParameter("login_name");
        String login_password = request.getParameter("login_password");
        String email = request.getParameter("email");
        String picture_url = request.getParameter("picture_url");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String user_name = request.getParameter("user_name");
        LocalDate user_dob = LocalDate.parse(request.getParameter("user_dob"));
        String card_id = request.getParameter("card_id");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        User newUser = new User(id, login_name, login_password, email, picture_url, gender, user_name, user_dob,
                card_id, phone, address);
        userControllerImpl.update(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userAction/editProfile.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String login_name = request.getParameter("login_name");
        String login_password = request.getParameter("login_password");
        String email = request.getParameter("email");
        String picture_url = request.getParameter("picture_url");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String user_name = request.getParameter("user_name");
        LocalDate user_dob = LocalDate.parse(request.getParameter("user_dob"));
        String card_id = request.getParameter("card_id");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        User newUser = new User(login_name, login_password, email, picture_url, gender, user_name, user_dob,
                card_id, phone, address);
        userControllerImpl.create(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userAction/register.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}