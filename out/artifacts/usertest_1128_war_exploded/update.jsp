<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2022/11/28
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>修改界面</h1>
    <table>
        <tr>
            <td>员工编号</td>
            <td>员工姓名</td>
            <td>员工密码</td>
            <td>员工年龄</td>
        </tr>
        <tr>
            <td>${requestScope.user.uid}</td>
            <td>${requestScope.user.name}</td>
            <td>${requestScope.user.password}</td>
            <td>${requestScope.user.age}</td>
        </tr>
    </table>

<form action="user" method="get">
        员工编号:<input type="text" name="uid" readonly value="${requestScope.user.uid}"><br>
        员工姓名:<input type="text" name="name" value="${requestScope.user.name}"><br>
        员工密码:<input type="password" name="password" value="${requestScope.user.password}"><br>
        员工年龄:<input type="text" name="age" value="${requestScope.user.age}"><br>
        <input type="hidden" name="i" value="4">
        <input type="submit" value="提交"/>
</form>
</body>
</html>
