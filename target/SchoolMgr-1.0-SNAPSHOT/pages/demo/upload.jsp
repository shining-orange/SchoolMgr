<%--
  Created by IntelliJ IDEA.
  User: dengmi
  Date: 2022/12/12
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/testUpload" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"> <br>
    头像：<input type="file" name="myHead"> <br>
    <button>提交</button>
</form>
</body>
</html>
