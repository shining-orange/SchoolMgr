<%--
  Created by IntelliJ IDEA.
  User: dengmi
  Date: 2022/12/9
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/js/jquery-3.6.0.js"></script>
    <title>Title</title>
</head>
<body>
<script>
    $(function () {//启用jquery方法
        //通过传统的js事件绑定实现p元素的异步请求
        document.getElementById("p").addEventListener("click", function () {
            // alert("hello");
            $.get("/testGetInfo?name=张三", function () {
                console.log("异步到服务器");
            });
        });
        $("#p").on('click', function () {
            alert("hello3333");
            $.get("/testGetInfo?name=张三&age=20", function (resp) {
                console.log("resp:" + resp);
                console.log(resp.id)
                console.log(resp.name)
                console.log(resp.age)
            })
        })
    })
</script>

</body>
</html>
