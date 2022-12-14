<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/7
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
添加学生信息： <br>
<form action="/insStu">
    <table align="center" border="1">
        <caption>新增员工信息</caption>
        <tr>
            <td>姓名:</td>
            <td>
                <input type="text" name="sname">
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td>
                <input type="text" name="password">
            </td>
        </tr>

        <tr>
            <td>性别:</td>
            <td>
                <input type="radio" name="sex" value="男" checked="checked">男
                <input type="radio" name="sex" value="女">女
            </td>
        </tr>

        <tr>
            <td>成绩:</td>
            <td>
                <input type="number" min="0" max="100"  name="score">
            </td>
        </tr>

        <tr>
            <td>电话:</td>
            <td>
                <input type="text" pattern="^(?:(?:\+|00)86)?1[3-9]\d{9}$" name="phone">
            </td>
        </tr>

        <tr>
            <td>生日:</td>
            <td>
                <input type="date" name="birthday">
            </td>
        </tr>

        <tr>
            <td>状态:</td>
            <td>
                <input type="radio" name="status" value="1" checked="checked">在读
                <input type="radio" name="status" value="0">毕业
            </td>
        </tr>

        <tr>
            <td>班级:</td>
            <td>
<%--                <input type="text" name="cid">--%>
                    <select name="cid" required>
                        <%--    required约束，需要设置请选择的值为空字符串value=''  --%>
                        <option value="">请选择</option>
                        <c:forEach items="${requestScope.dataClazz}" var="cls">
                            <option value="${cls.cid}">${cls.cname}</option>
                        </c:forEach>
                    </select>

            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="新增">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
