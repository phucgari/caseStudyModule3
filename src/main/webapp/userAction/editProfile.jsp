<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/3/2023
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<center>
    <h1>Edit User</h1>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
            </c:if>
            <tr>
                <th>Login name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${user.login_name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Login password:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${user.login_password}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${user.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Picture url:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${user.picture_url}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <select name="gender" id="gender" value='${user.gender}'>*
                    <option value="1">Male</option>
                    <option value="0">Female</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${user.user_name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>User dob:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${user.user_dob}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Card id:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${user.card_id}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${user.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${user.address}' />"
                    />
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
