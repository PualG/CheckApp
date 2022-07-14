<%@ page import="com.signin.beans.Record" %>
<%@ page import="com.signin.dao.RecordDAO" %>
<%@ page import="com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer" %><%--
  Created by IntelliJ IDEA.
  User: 有
  Date: 2022/6/10
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  String date_time= new String(request.getParameter("date_time").getBytes("iso-8859-1"),"UTF-8");
  String name= new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8");
  String temp= new String(request.getParameter("temp").getBytes("iso-8859-1"),"UTF-8");
  String temp1=new String( request.getParameter("temp1").getBytes("iso-8859-1"),"UTF-8");
  String temp2=new String( request.getParameter("temp2").getBytes("iso-8859-1"),"UTF-8");
  String temp3=new String( request.getParameter("temp3").getBytes("iso-8859-1"),"UTF-8");
  String temp4=new String( request.getParameter("temp4").getBytes("iso-8859-1"),"UTF-8");
  String temp8=new String( request.getParameter("temp8").getBytes("iso-8859-1"),"UTF-8");
  String temp5=new String( request.getParameter("temp5").getBytes("iso-8859-1"),"UTF-8");
  String location= new String(request.getParameter("location").getBytes("iso-8859-1"),"UTF-8");
  String temp6= new String(request.getParameter("temp6").getBytes("iso-8859-1"),"UTF-8");
  String temp9= new String(request.getParameter("temp9").getBytes("iso-8859-1"),"UTF-8");
  String temp7= new String(request.getParameter("temp7").getBytes("iso-8859-1"),"UTF-8");
  String name1= new String(request.getParameter("name1").getBytes("iso-8859-1"),"UTF-8");
  String date_time1= new String(request.getParameter("date_time1").getBytes("iso-8859-1"),"UTF-8");
  System.out.println(name1);
  RecordDAO recordDAO = new RecordDAO();
  Record record = new Record(date_time,name,temp,temp1,temp2,temp3,temp4,temp8,temp5,location,temp6,temp9,temp7,name1,date_time1);
  int update=recordDAO.update(record);
  if (update>=1){out.print("你已经插入成功!");
  }
%>
</body>
</html>
