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
<center>
    <%String name = request.getParameter("name");
            String temp = new String(request.getParameter("temp").getBytes("iso-8859-1"),"UTF-8");
        String temp1 = new String(request.getParameter("temp1").getBytes("iso-8859-1"),"UTF-8");
        String temp6 = new String(request.getParameter("temp6").getBytes("iso-8859-1"),"UTF-8");
        RecordDAO recordDAO = new RecordDAO();
        Record record = new Record(name,temp,temp1,temp6);
        List<Record> recordList =recordDAO.select1(record);
        int count = recordList.size();
        System.out.println(recordList);
        out.print("所有的打卡记录条数为：" + count);
    %>
    <table>
        <tr>
            <td>记录条数</td><td>时间</td><td>姓名</td><td>体温</td><td>症状</td><td>旅居史</td><td>其他情况</td><td>有无重点关注地区旅居史</td><td>重点关注地区旅居史</td><td>现在位置</td><td>位置</td><td>健康码，行程码</td><td>同住人员健康码，行程码</td><td>所在位置区域</td>
        </tr>
        <%
            for (int i = 0; i < count; i++) {
                out.print(String.format("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", i, recordList.get(i).getDate_time(), recordList.get(i).getName(), recordList.get(i).getTemp(), recordList.get(i).getTemp1(), recordList.get(i).getTemp2(), recordList.get(i).getTemp3(), recordList.get(i).getTemp4(), recordList.get(i).getTemp8(), recordList.get(i).getTemp5(), recordList.get(i).getLocation(), recordList.get(i).getTemp6(), recordList.get(i).getTemp9(), recordList.get(i).getTemp7()));
            }
        %>
    </table>
</center>
</body>
</html>
