<%--<%@ page import="com.softeem.pojo.Student" %>--%>
<%--<%@ page import="java.util.List" %>&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Administrator--%>
<%--  Date: 2022/12/7--%>
<%--  Time: 16:16--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <style>--%>
<%--        table--%>
<%--        {--%>
<%--            border-collapse: collapse;--%>
<%--            margin: 0 auto;--%>
<%--            text-align: center;--%>
<%--            margin-top: 5%;--%>
<%--        }--%>
<%--        table td, table th--%>
<%--        {--%>
<%--            border: 1px solid #cad9ea;--%>
<%--            color: #666;--%>
<%--            height: 30px;--%>
<%--        }--%>
<%--        table thead th--%>
<%--        {--%>
<%--            background-color: #CCE8EB;--%>
<%--            width: 100px;--%>
<%--        }--%>
<%--        table tr:nth-child(odd)--%>
<%--        {--%>
<%--            background: #fff;--%>
<%--        }--%>
<%--        table tr:nth-child(even)--%>
<%--        {--%>
<%--            background: #F5FAFA;--%>
<%--        }--%>
<%--        input{--%>
<%--            background-color: transparent;--%>
<%--            text-align: center;--%>
<%--            outline:none;--%>
<%--            border: none;--%>
<%--        }--%>
<%--        input:focus{--%>
<%--            border:none;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<%--%>
<%--    List<Student> data = (List<Student>) request.getAttribute("data");--%>
<%--%>--%>
<%--<table border="1" align="center">--%>
<%--    <caption>学生信息表</caption>--%>
<%--    <tr>--%>
<%--        <td>编号</td>--%>
<%--        <td>姓名</td>--%>
<%--        <td>密码</td>--%>
<%--        <td>性别</td>--%>
<%--        <td>成绩</td>--%>
<%--        <td>电话</td>--%>
<%--        <td>生日</td>--%>
<%--        <td>状态</td>--%>
<%--        <td>班级</td>--%>
<%--        <td>操作</td>--%>
<%--    </tr>--%>
<%--    <c:if test="${not empty data}">--%>
<%--        <c:forEach items="${data}" var="s">--%>
<%--            <tr>--%>
<%--                <td> ${s.sno} </td>--%>
<%--                <td> ${s.sname} </td>--%>
<%--                <td> ${s.password} </td>--%>
<%--                <td> ${s.sex} </td>--%>
<%--                <td> ${s.score} </td>--%>
<%--                <td> ${s.phone} </td>--%>
<%--                <td> ${s.birthday} </td>--%>
<%--                <td> ${s.status} </td>--%>
<%--                <td> ${s.cid} </td>--%>
<%--                <td>--%>
<%--                    <a href="/delStu?sno=${s.sno}">删除</a>--%>
<%--                    <a href="/getStu?sno=${s.sno}">修改</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </c:if>--%>

<%--    <tr>--%>
<%--        <td colspan="10" align="center">--%>
<%--            <a href="pages/addStu.jsp" style="width: 100%">新增</a>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td colspan="10" align="center">--%>
<%--            <a href="/getAllStuPage?pageNum=1">首页</a>--%>
<%--            <a href="/getAllStuPage?pageNum=${pageBean.pageNum-1 > 0? pageBean.pageNum-1:1}">上一页</a>--%>
<%--            <a href="/getAllStuPage?pageNum=${pageBean.pageNum+1 < pageBean.totalPage ? pageBean.pageNum+1 : pageBean.totalPage}">下一页</a>--%>
<%--            <a href="/getAllStuPage?pageNum=${pageBean.totalPage}">尾页</a>--%>
<%--            第 ${pageBean.pageNum}页  / 共 ${pageBean.totalPage}页--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--</table>--%>

<%--</body>--%>
<%--</html>--%>

<%@ page import="java.util.List" %>
<%@ page import="com.softeem.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: yj2022
  Date: 2022/12/7
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background-image: url("/pages/bg/o.jpg");
            background-size: 100%;
            background-size: cover;
        }
        table
        {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
            margin-top: 0;

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
            /*border: none;*/
        }
        input:focus{
            /*border:none;*/
        }
        #head{
            width: 50px;
            height: 50px;
            border-radius: 50%;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<%--<iframe src="beijing.html" frameborder="0" width="100%" height="100%"; style="z-index: -1;width: 100%;position: fixed"></iframe>--%>
    <%--    ${data}--%>
    <div align="center">
<%--        <span style="float: right">登录信息：<img id="head" src="/pages/images/${sessionScope.logData.headimg}" alt="头像待更新">  ${sessionScope.logData.name}</span> <br>--%>
    <div style="width: 100%;height: 60px;overflow: auto;background-color:rgba(255,255,255,0.5)"><span style=" float: right; margin-right: 22px;margin-top: 5px;">欢迎回来: <img id="head" src="/pages/images/${sessionScope.logData.headimg}" alt="头像待更新">  ${sessionScope.logData.name}</span></div> <br>
    <span style="font-size: 25px;font-weight: bolder">学生信息管理平台</span> <br> <br>
        <form action="/getAllStuPageCon" id="myForm">
            姓名：<input type="text" name="sname" value="${pageBean.sname}">
            成绩：<input type="number" min="0" max="100" name="scoreFrom" value="${pageBean.scoreFrom}">
            -<input type="number" min="0" max="100"   name="scoreTo" value="${pageBean.scoreTo}" >
            班级：<%--<input type="text" name="cid" value="${pageBean.cid}"> <br><br>--%>
            <%-- <select name="cid">
                 <option value="">请选择</option>
                 <option value="1">计科1班</option>
                 <option value="2">软件工程</option>
                 <option value="3">网络工程</option>
                 <option value="4">计算机信息管理1班</option>
                 <option value="5">大数据</option>
             </select>  <br> <br>--%>
            <%--  动态获取班级名称           --%>
            <select name="cid">
                <option value="">请选择</option>
                <c:forEach items="${requestScope.dataClazz}" var="cls">
                <c:if test="${cls.cid==pageBean.cid}">
                <option value="${cls.cid}" selected>${cls.cname}</option>
                </c:if>

                <c:if test="${cls.cid!=pageBean.cid}">
                <option value="${cls.cid}">${cls.cname}</option>
                </c:if>

                </c:forEach>
            </select>  <br> <br>

            生日：<input type="date" name="birthFrom" value="${pageBean.birthFrom}">
            - <input type="date" name="birthTo" value="${pageBean.birthTo}">
            <input hidden="hidden" name="pageNum" id="pageNum">
            <button>查询</button>
        </form>
    </div>


    <table border="1" cellspacing="0" align="center">
        <tr>
            <td>序号</td>
            <td>姓名</td>
            <td>密码</td>
            <td>性别</td>
            <td>成绩</td>
            <td>电话</td>
            <td>生日</td>
            <td>状态</td>
            <td>班级</td>
            <td>课程</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${data}" var="s" varStatus="stas">
            <tr>
                    <%--                <td> ${s.sno} </td>--%>
                <td> ${stas.count+(requestScope.pageBean.pageNum-1)*requestScope.pageBean.pageSize} </td>
                <td> ${s.sname} </td>
                <td> ${s.password}</td>
                <td> ${s.sex}</td>
                    <%--                <td> ${s.score}</td>--%>
                <td>
                    <fmt:formatNumber value="${s.score}" pattern="0.00"/>
                </td>
                <td> ${s.phone}</td>
                    <%--                <td> ${s.birthday}</td>--%>
                <td>
                    <fmt:formatDate value="${s.birthday}" pattern="yyyy/MM/dd"/>
                </td>
                <td> ${s.status==1?"在读":"毕业"}</td>
                <td> ${s.cid}班</td>
                <td> ${s.cname}</td>
                <td>
                    <a href="/delStu?sno=${s.sno}">删除 </a>
<%--                    <a href="/getStu?sno=${s.sno}">修改</a>--%>
                    <a href="/updStuWithClazz?sno=${s.sno}">修改</a>
<%--                    <a href="/addStuWithClazz?sno=${s.sno}">修改</a>--%>
                </td>

            </tr>

        </c:forEach>

        <tr>
            <td colspan="11" align="center">
<%--                <a href="/pages/addStu.jsp">添加</a>--%>
                    <a href=/addStuWithClazz>添加</a>
            </td>
        </tr>

        <tr>
            <td colspan="11" align="center">
                <%--            <a href="/getAllStuPage?pageNum=1">首页</a>--%>
                <%--            <a href="/getAllStuPage?pageNum=${pageBean.pageNum-1 > 0? pageBean.pageNum-1:1}">上一页</a>--%>
                <%--            <a href="/getAllStuPage?pageNum=${pageBean.pageNum+1 < pageBean.totalPage ? pageBean.pageNum+1 : pageBean.totalPage}">下一页</a>--%>
                <%--            <a href="/getAllStuPage?pageNum=${pageBean.totalPage}">尾页</a>--%>
                <%--            第 ${pageBean.pageNum}页  / 共 ${pageBean.totalPage}页--%>

                <a href="javascript:homePage()">首页</a>
                <a href="javascript:upPage()">上一页</a>
                <a href="javascript:downPage()">下一页</a>
                <a href="javascript:endPage()">尾页</a>
                第 ${pageBean.pageNum}页  / 共 ${pageBean.totalPage}页
                <%--   表单中 每天条数隐藏域  --%>
                <input type="hidden" id="sizeNew" name="pageSize" value="${pageBean.pageSize}">
                <%--  下拉列表 选择设置页大小  --%>
                每页
                <select id="page" onchange="javascript:changeSize()">
                    <c:forEach items="2,3,5,10" var="page">
                        <c:if test="${pageBean.pageSize==page}">
                            <option selected value="${page}">${page}</option>
                        </c:if>
                        <c:if test="${pageBean.pageSize!=page}">
                            <option value="${page}">${page}</option>
                        </c:if>
                    </c:forEach>
                </select>
                条
            </td>
        </tr>
    </table>
    <%--   js负责提交请求 --%>

<script>
    //动态更新每页条数
    function changeSize() {
        //获取下拉列表选中的数据
        let pageSize = document.getElementById("pageSize").value;
        // alert(pageSize);
        //获取表单对象，与下拉列表的值一致
        let sizeNew = document.getElementById("sizeNew");
        sizeNew.value = pageSize;
        alert(sizeNew.value);
        //当前页恢复为初始值1
        let pageNum = document.getElementById("pageNum");
        pageNum.value = "1";
        //location.href = "/allStsPageCondition?pageSize="+pageSize;
        let myForm = document.getElementById("myForm");
        myForm.submit();

    }
</script>
<script>
    // 首页
    function homePage() { // 发送请求 查询所有学生信息（表单提交）
        //1，更新传递当前页数据
        document.getElementById("pageNum").value = 1;
        //2 表单提交
        document.getElementById("myForm").submit();

    }
    // 上一页
    function upPage() { // 发送请求 查询所有学生信息（表单提交）
        //1，更新传递当前页数据
        document.getElementById("pageNum").value = ${pageBean.pageNum-1 > 0? pageBean.pageNum-1:1};
        //2 表单提交
        document.getElementById("myForm").submit();

    }
    // 下一页
    function downPage() { // 发送请求 查询所有学生信息（表单提交）
        //1，更新传递当前页数据
        document.getElementById("pageNum").value = ${pageBean.pageNum+1 < pageBean.totalPage ? pageBean.pageNum+1 : pageBean.totalPage};
        //2 表单提交
        document.getElementById("myForm").submit();

    }

    // 尾页
    function endPage() { // 发送请求 查询所有学生信息（表单提交）
        //1，更新传递当前页数据
        document.getElementById("pageNum").value = ${pageBean.totalPage};
        //2 表单提交
        document.getElementById("myForm").submit();

    }
</script>


</body>
</html>
