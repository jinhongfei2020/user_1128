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
<h1>员工表</h1>
<table>
    <tr>
        <td>员工编号</td>&nbsp;
        <td>员工姓名</td>&nbsp;
        <td>员工岗位</td>&nbsp;
        <td>经理编号</td>&nbsp;
        <td>入职时间</td>&nbsp;
        <td>员工薪资</td>&nbsp;
        <td>员工奖金</td>&nbsp;
        <td>部门编号</td>&nbsp;
        <td>操作</td>&nbsp;
    </tr>
    <c:forEach items="${list1}" var="e">
        <tr>
            <td>${e.empno}</td>
            <td>${e.ename}</td>
            <td>${e.job}</td>
            <td>${e.mgr}</td>
            <td>${e.hiredate}</td>
            <td>${e.sal}</td>
            <td>${e.comm}</td>
            <td>${e.depyno}</td>
            <td><a href="user?num=2&empno=${e.empno}" onclick="return show()">删除</a></td>
            <td><a href="user?num=3&empno=${e.empno}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
