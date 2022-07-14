<%@ page import="com.signin.dao.RecordDAO" %>
<%@ page import="com.signin.beans.Record" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 有
  Date: 2022/6/10
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/my.css">
</head>
<body>
  查询到的数据为：
    <%
  String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8");
  String date_time = request.getParameter("date_time");
  RecordDAO recordDAO = new RecordDAO();
  Record record = new Record(date_time,name);
    Record record2 =recordDAO.select(record);

    %>

        <table>
            <tr>
                <td>时间</td><td>姓名</td><td>体温</td><td>症状</td><td>旅居史</td><td>其他情况</td><td>有无重点关注地区旅居史</td><td>重点关注地区旅居史</td><td>现在位置</td><td>位置</td><td>健康码，行程码</td><td>同住人员健康码，行程码</td><td>所在位置区域</td>
            </tr>
        <%

    out.print(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
            record2.getDate_time(), record2.getName(), record2.getTemp(), record2.getTemp1(), record2.getTemp2(), record2.getTemp3(), record2.getTemp4(), record2.getTemp8(), record2.getTemp5(), record2.getLocation(), record2.getTemp6(), record2.getTemp9(), record2.getTemp7()));

%>


  </table>
  <br>
  请输入需要更改的数据：<br>
  <form method="post" action="update2.jsp">
<span id="test1" style="display:none">
    <input type="text"  name="name1" value="<%=record2.getName()%>">
    <input type="text"  name="date_time1" value="<%=record2.getDate_time()%>"></span>
      <script>
          function changes(){
              document.getElementById("1").style.display="none"}
      </script>
 时间：<input type="text" name="date_time"><br>
  姓名：<input type="text" name="name"><br>
  体温：<input type="text" name="temp"><br>
  症状：<input type="text" name="temp1"><br>
  旅居史：<input type="text" name="temp2"><br>
  其他情况：<input type="text" name="temp3"><br>
  有无重点关注地区旅居史：<select size="1" name="temp4">
  <option value=" 无"> 无</option>
  <option value="有">有</option>
</select><br>
  重点关注地区旅居史：<input type="text" name="temp8"><br>
  现在位置：<input type="text" name="temp5"><br>
  位置：<input type="text" name="location"><br>
  本人健康码，行程码情况：<select size="1" name="temp6">
  <option value="绿码">绿码</option>
  <option value="绿码带星">绿码带星</option>
  <option value="黄码"> 黄码</option>
  <option value="红码">红码</option>
</select><br>
  同住人员健康码，行程码情况：<br>
  全部绿码<input type="checkbox" name="temp9" value="全部绿码" onclick="chkbox(this);"><br>
  出现绿码带星<input type="checkbox" name="temp9" value="出现绿码带星" onclick="chkbox(this);"><br>
  出现黄码<input type="checkbox" name="temp9" value="出现黄码" onclick="chkbox(this);"><br>
  出现红码<input type="checkbox" name="temp9" value="出现红码" onclick="chkbox(this);"><br>
  所在位置区域：<select size="1" name="temp7"><br>
  <option value="正常区域">正常区域</option>
  <option value="在封控区">在封控区</option>
  <option value="在管控区">在管控区</option>
  <option value="在防范区">在防范区</option></select><br>

  <script language="javascript">
    function chkbox(elm)
    {var obj=document.getElementsByName("temp9");
      var num=0;
      for (var i=0;i<obj.length ;i++ )
        if (obj[i].checked )
          num+=1;
      if (num>2)
      {alert("最多可以选择两个！");
        elm.checked=false;
      }
    }
  </script>
  <input type="submit" value="更新">
  <input type="reset" value="取消"></tr>
</form>
</body>
</html>
