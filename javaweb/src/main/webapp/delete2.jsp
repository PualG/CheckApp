<%@ page import="com.signin.beans.Record" %>
<%@ page import="com.signin.dao.RecordDAO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/my.css">
</head>
<body>

    <%
        String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8");
        String date_time = request.getParameter("date_time");
        RecordDAO recordDAO = new RecordDAO();
        Record record = new Record(date_time,name);
       int delete=recordDAO.delete(record);
       if (delete==0){out.print("你已经删除成功!");
        }
    %>

</body>
</html>
