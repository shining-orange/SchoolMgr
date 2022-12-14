<%--
  Created by IntelliJ IDEA.
  User: yj2022
  Date: 2022/12/9
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/pages/js/jquery-3.6.0.js"></script>
    <style>
        body{
            background-image: url("/pages/bg/2e8v5x.png");
            background-size: 100%;
            background-size: cover;
        }
        .box{
            width: 600px;
            height: 500px;
            border: 1px solid gray;
            margin: 0 auto;
            /*    当前父盒子定位*/
            position: relative;
            background-image: linear-gradient(135deg,#3b2667,#bc78ec);
            background-size: 100%;
            background-size: cover;
        }
        .box #head{
            width: 100px;
            height: 100px;
            border-radius: 50%;
            /*相对于父盒子居中*/
            position: absolute;
            left: 50%;
            /*水平偏移：相对自身左移，左移自己一半的尺寸*/
            transform: translate(-50%,-50%);
            box-shadow: 0 0 5px gray;
            background-color: #ffffff;


        }
        .top{
            width: 100%;
            height: 40%;
            background: url("/pages/bg/2.jpg") no-repeat;
            /*background-size: 100% 140px;*/
            background-size: 100%;
            background-size: cover;
        }
        form{
            position: absolute;
            left: 50%;
            top: 52%;
            transform: translateX(-50%);
        }
        form input {
            margin-bottom: 20px;
            width: 220px;
            height: 30px;
            border: 1px solid gray;
            border-radius: 7px;
        }
        .logBtn{
            text-align: center;
        }
        .logBtn button{
            width: 100px;
            height: 42px;
            background-color: dodgerblue;
            color: white;
            border: none;
        }
        .logBtn a{
            background-color: #dbaeae;
            display: inline-block;
            /*line-height: 30px;*/
            text-decoration: none;
            padding: 10px;
        }
        form #code{
            width: 100px;
        }
        form #codeImg{
            vertical-align: middle;

        }
    </style>
</head>
<body>
<%--${sessionScope.adminData}--%>
<div class="box">
    <div class="top"></div>
    <img src="" id="head" alt="头像">
    <form>
        账号：<input type="text" name="name" id="name"> <br>
        密码：<input type="text" name="password" id="password"> <br>
        输入验证码：<input type="text" id="code" name="code"> <img id="codeImg" src="/showCode" alt=""> <br>
        <div class="logBtn">
            <button type="button" id="logBtn">登录</button>
            <a href="/pages/admin/reg.jsp">新用户注册</a>
        </div>
    </form>
</div>
<script>
    var head = `${sessionScope.adminData.headimg}` ;
    // 使用el表达式获取数据，$在js脚本中默认为jq对象，需要使用``转义为el表达式特征符
    console.log(head);
    if (head){ // 非null，非0，非false 都为true
        // alert("非空");
        document.getElementById("head").src = "/pages/images/"+head;
    }else {
        // alert("没有数据");  设置默认图片
        document.getElementById("head").src = "/pages/bg/添加客户.png";
    }
    //异步登录实现
    $(function () {
        // alert(111)
        var respData = null;
        $("#logBtn").on('click',function () {
            // alert(222)
            var name = $("#name").val();
            var pwd = $("#password").val();
            var code = $("#code").val();
            $.ajax({
                url:"/adminLog",
                type:"post",
                data:{"name":name,"password":pwd,"code":code},
                dataType:'json',
                success:function (resp) {
                    console.log(resp);
                    respData = resp;
                    alert(resp.msg);
                    url = "/pages/admin/log.jsp";
                    if (resp.code==1){ //登录失败
                        return;
                    }
                    url = "/getAllStuPageCon";//登录成功，跳转到管理界面
                    location.href = url;
                }
            })
        })
        //图片点击更新
        $("#codeImg").click(function () {
            // alert(333)
            $(this).prop("src","/showCode?"+new Date().getTime())
        })

        $("#name").val('admin')

    })
</script>

<%@include file="showInfo.jsp"%>
</body>
</html>
