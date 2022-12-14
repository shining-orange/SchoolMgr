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
       // alert("post异步")
        $("#").on('click',function () {
            $.post("/testGetInfo",{"name":"张三","age":20},function (resp) {
                // alert("123123123")
                resp=JSON.parse(resp);
                console.log(resp);
            });
        })
        $("p2").click(function (){
                $.ajax({
                url:"/testGetInfo",
                type:"get",
                dataType:JSON,
                    success:function (resp) {//服务器执行完毕以后,异步操作
                        // resp=JSON.parse(resp);
                        console.log(resp);
                    }
            })
        })
    })
</script>

</body>
</html>
