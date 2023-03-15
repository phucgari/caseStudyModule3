<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2023
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Transaction</title>
</head>
<body>
<center>
    <h1>Edit Transaction</h1>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Transaction
                </h2>
            </caption>
            <c:if test ="${transaction != null}">
                <input type="hidden" name="id" value="<c:out value ='${transaction.id}'/>" />
            </c:if>
            <tr>
                <th>time</th>
                <td>
                    <input type="text" name="time" size="60"
                    value = "<c:out value='${transaction.time}'/>">
                </td>
            </tr>
            <tr>
                <th>money_amount</th>
                <td>
                    <input type="text" name="money_Amount" size="60"
                    value="<c:out value='${transaction.money_Amount}'/>">
                </td>
            </tr>
            <tr>
                <th>action</th>
                <td>
                    <input type="text" name="action" size="60"
                    value="<c:out value='${transaction.action}'/>">
                </td>
            </tr>
            <tr>
                <th>wallet_id</th>
                <td>
                    <input type="text" name="wallet_id" size="60"
                    value="<c:out value='${transaction.wallet_id}'/>">
                </td>
            </tr>
            <tr>
                <td colspan="1" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
