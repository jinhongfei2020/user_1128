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
<form action="emp" method="get">
    <c:forEach items="${sessionScope.emp}" var="e">
        员工编号:<input type="text" name="empno"  readonly style="" value="${e.empno}"><br>
        员工姓名:<input type="text" name="ename"    value="${e.ename}"><br>
        岗位名称:<input type="text" name="job"      value="${e.job}"><br>
        经理编号:<input type="text" name="mgr"      value="${e.mgr}"><br>
        入职时间:<input type="date" name="hiredate" value="${e.hiredate}"><br>
        员工工资:<input type="text" name="sal"      value="${e.sal}"><br>
        员工奖金:<input type="text" name="comm"     value="${e.comm}"><br>
        部门编号:<input type="text" name="depyno"   value="${e.depyno}"><br>
        <input type="hidden" name="num" value="4">
        <input type="submit" onclick="return show1()" value="提交"/>
    </c:forEach>
</form>
</body>
</html>
