<%--
  Created by IntelliJ IDEA.
  User: dengmi
  Date: 2022/12/7
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //模拟从后端在域中存放数据
    pageContext.setAttribute("page","page的数据");
    request.setAttribute("req","req的数据");
    session.setAttribute("ses","ses的数据");
    application.setAttribute("app","app的数据");
%>
    ${pageScope.page}<br>
    ${requestScope.req}<br>
    ${sessionScope.ses}<br>
    ${pplicationScope.app}
<br>
    ${page}<br>
    ${req}<br>
    ${ses}<br>
    ${app}
</body>
</html>
