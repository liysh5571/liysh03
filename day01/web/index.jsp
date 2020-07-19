<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
  <head>
    <title>Javaweb项目</title>
  </head>
  <body>
       这是我的第一个Javaweb项目<br>
       <%
         int a=10;   //局部变量
       %>
       <%
         out.print(a++);//11
       %>
       <br>
       <%=a%>
       <%!
           int a=100;   //成员变量
           public void fun1(){
               System.out.println(a);
           }
       %>
       <%
           out.print(a++);  //输出局部变量11
       %>
       <%
           out.print(this.a++);  //101  每刷新一次数据会加1
           fun1();
       %>
  </body>
</html>