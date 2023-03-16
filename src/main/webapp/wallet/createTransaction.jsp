<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2023
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transaction</title>
</head>
<body>
<center>
    <h1>Create Transaction</h1>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>time</th>
                <td>
                    <input type="text" name="time" id="time" size="60"/> *
                </td>
            </tr>
            <tr>
                <th>money_amount</th>
                <td>
                    <input type="text" name="money_Amount" id="money_Amount" size="60"/> *
                </td>
            </tr>
            <tr>
                <th>action</th>
                <td>
                    <input type="text" name="action" id="action" size="60"/> *
                </td>
            </tr>
            <tr>
                <th>wallet_id</th>
                <td>
                    <input type="text" name="wallet_id" id="wallet_id" size="60"/> *
                </td>
            </tr>
            <tr>
                <td colspan="5" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
