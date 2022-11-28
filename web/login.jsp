<%--
  Created by IntelliJ IDEA.
  User: hua
  Date: 2022/11/28
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="rs" method="get">
    <table>
        <tr>
            <td> 姓名:</td>
            <td> <input type="text" name="name"></td>
        </tr>
        <tr>
            <td> 密码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <input type="hidden" name="i" value="2">
        <tr>
            <td colspan="2"> <input type="submit" value="登陆"></td>
        </tr>
    </table>
</form>
</body>
</html>
