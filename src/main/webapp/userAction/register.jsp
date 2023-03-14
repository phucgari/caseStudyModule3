<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2023
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<center>
    <h1>Register</h1>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="login_name" id="login_name" size="45"/> *
                </td>
            </tr>
            <tr>
                <th>Password:</th>
                <td>
                    <input type="text" name="login_password" id="login_password" size="45"/> *
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Picture:</th>
                <td>
                    <input type="text" name="picture_url" id="picture_url" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <select name="gender" id="gender"/>*
                    <option value="1">Male</option>
                    <option value="0">Female</option>
                    </select>
                </td>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="user_name" id="user_name" size="45"/> *
                </td>
            </tr>
            <tr>
                <th>user_dob:</th>
                <td>
                    <input type="text" name="user_dob" id="user_dob" size="45"/> *
                </td>
            </tr>
            <tr>
                <th>Card id:</th>
                <td>
                    <input type="text" name="card_id" id="card_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"/> *
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
