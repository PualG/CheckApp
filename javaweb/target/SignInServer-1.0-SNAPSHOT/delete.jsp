<%--
  Created by IntelliJ IDEA.
  User: 有
  Date: 2022/6/8
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>Delete</title>
</head>
<body >
请输入删除数据条件：
<form action="delete2.jsp" method="post">
    姓名： <input type="text" name="name"><br>
    日期： <input type="text" name="date_time"><br>
    <input type="submit" value="删除">
    <input type="reset" value="取消">
</form>
</body>
</html>
