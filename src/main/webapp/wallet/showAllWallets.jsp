<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/13/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Wallets of ${requestScope["login_name"]}</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Balance</th>
        <th>Show Transactions</th>
    </tr>
    <form method="post">
        <c:forEach items='${requestScope["wallets"]}' var="wallet">
            <tr>
                <td>${wallet.getName()}</td>
                <td>${wallet.getBalance()}</td>
                <td><button type="submit" value="${wallet.getId()}" name="wallet_id">Transactions</button></td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
</html>
