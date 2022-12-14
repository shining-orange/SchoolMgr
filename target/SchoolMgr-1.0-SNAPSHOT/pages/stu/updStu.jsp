<%@ page import="com.softeem.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/7
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table
        {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
            margin-top: 5%;
        }
        table td, table th
        {
            border: 1px solid #cad9ea;
            color: #666;
            height: 30px;
        }
        table thead th
        {
            background-color: #CCE8EB;
            width: 100px;
        }
        table tr:nth-child(odd)
        {
            background: #fff;
        }
        table tr:nth-child(even)
        {
            background: #F5FAFA;
        }
        input{
            background-color: transparent;
            text-align: center;
            outline:none;
            border: none;
        }
        input:focus{
            border:none;
        }
    </style>
</head>
<body>

<%
    Student student = (Student) request.getAttribute("user");
%>
修改用户页面 <br>
<form action="/updStu">
<table align="center" border="1">
    <caption>修改学生信息</caption>
    <tr>
        <td>编号:</td>
        <td>
            <input type="text" name="sno" value="${student.sno}" readonly="readonly">
        </td>
    </tr>

    <tr>
        <td>姓名:</td>
        <td>
            <input type="text" value="${student.sname}" name="sname">
        </td>
    </tr>
    <tr>
        <td>密码:</td>
        <td>
            <input type="text" value="${student.password}" name="password">
        </td>
    </tr>

    <tr>
        <td>性别:</td>
        <td>
            <c:choose >
                <c:when test="${student.sex=='男' }">
                    <input type="radio" name="sex" value="男" checked="checked" >男
                    <input type="radio" name="sex" value="女">女
                </c:when>
                <c:otherwise>
                    <input type="radio" name="sex" value="男">男
                    <input type="radio" name="sex" value="女" checked="checked" >女
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
    <tr>
        <td>成绩:</td>
        <td>
            <input type="text"	 name="score" value="${student.score}"/>
        </td>
    </tr>

    <tr>
        <td>电话:</td>
        <td>
            <input type="text" name="phone" value="${student.phone}">
        </td>
    </tr>

    <tr>
        <td>生日:</td>
        <td>
            <input type="text" name="birthday" value="${student.birthday}">
        </td>
    </tr>

    <tr>
        <td>状态:</td>
        <td>
            <input type="radio" name="status" value="${student.status}" checked="checked">在读
            <input type="radio" name="status" value="${student.status}">毕业
        </td>
    </tr>

    <tr>
        <td>班级:</td>
        <td>
<%--       <input type="text" name="cid" value="${student.cid}">--%>
        <select name="cid" required>
            <%--    required约束，需要设置请选择的值为空字符串value=''  --%>
            <option value="${student.cid}">${student.cid}班</option>
            <c:forEach items="${requestScope.dataClazz}" var="cls">
                <option value="${cls.cid}">${cls.cname}</option>
            </c:forEach>
        </select>

        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input  type="submit" value="修改">
        </td>
    </tr>
</table>
</form>
</body>
</html>
