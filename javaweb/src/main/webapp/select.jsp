<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.signin.beans.Record" %>
<%@ page import="java.util.List" %>
<%@ page import="com.signin.dao.RecordDAO" %><%--
  Created by IntelliJ IDEA.
  User: undercover
  Date: 2022/5/15
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/my.css">
</head>
<body>
<form action="select2.jsp" method="post">
    请输入需要查询的条件：<br>
    名字：<input type="text" name="name"><br>
体温是否正常：<select size="1" name="temp">
   <option value="正常">正常</option>
    <option value="有发热">有发热</option>
</select> <br>
症状：<select size="1" name="temp1">
    <option value="有">有</option>
    <option value="无">无</option>
</select> <br>
健康码行程码情况：<select size="1" name="temp6">
    <option value="绿码">绿码</option>
<option value="绿码带星">绿码带星</option>
<option value="黄码">黄码</option>
<option value="红码">红码</option></select> <br>
    <input type="submit" value="查询">&nbsp&nbsp
<input type="reset" value="取消">
</form>
</body>
</html>
