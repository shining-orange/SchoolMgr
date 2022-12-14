<%--
  Created by IntelliJ IDEA.
  User:
  Date: 2022/12/9
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/pages/js/jquery-3.6.0.js"></script>
    <style>
    html,
    body {
        margin: 0;
        font-family: "PingFang SC", "Microsoft Yahei", sans-serif;
    }
    .container {
        width: 100vw;
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        background: url("/pages/bg/2e8v5x.png") fixed no-repeat;
        background-size: cover;
    }

    .login-form {
        width: 240px;
        height: 220px;
        display: flex;
        flex-direction: column;
        padding: 40px;
        text-align: center;
        position: relative;
        z-index: 100;
        background: inherit;
        border-radius: 18px;
        overflow: hidden; /* 隐藏多余的模糊效果*/
    }

    .login-form::before {
        content: "";
        width: calc(100% + 20px);
        height: calc(100% + 20px);
        position: absolute;
        top: -10px;
        left: -10px;
        overflow: hidden;
        background: inherit;
        box-shadow: inset 0 0 0 200px rgba(255, 255, 255, 0.25);
        filter: blur(6px);
        z-index: -1;
    }

    .login-form h2 {
        font-size: 18px;
        font-weight: 400;
        color: #3d5245;
    }

    .login-form input,
    .login-form button {
        margin: 6px 0;
        height: 36px;
        border: none;
        background-color: rgba(255, 255, 255, 0.3);
        border-radius: 4px;
        padding: 0 14px;
        color: #3d5245;
    }

    .login-form input::placeholder {
        color: #3d5245;
    }
    .login-form button:focus,
    .login-form input:focus {
        outline: 0;
    }

    .login-form button {
        margin-top: 24px;
        background-color: rgba(57, 88, 69, 0.4);
        color: white;
        position: relative;
        overflow: hidden;
        cursor: pointer;
        transition: 0.4s;
    }

    .login-form button:hover {
        background-color: rgba(12, 80, 38, 0.67);
    }
    .filee button{
        opacity:0;
    }
 </style>
</head>
<body>
<%--    <form action="/adminReg">
        账号：<input type="text" name="name"> <br>
        密码：<input type="text" name="password"> <br>
        <button>注册</button>
    </form>--%>
<div class="container">
<form id="myForm" action="/adminReg" method="post" enctype="multipart/form-data" class="login-form">
    <input type="text" name="name" id="name" placeholder="用户名">  <span id="content"></span> <br>
    <input type="text" name="password" id="pwd" placeholder="密码"> <br>
    <input type="file" name="head" id="head" placeholder="头像" class="filee"> <br>
    <button type="button" id="btn">注册</button>
</form>
</div>
<script>
    $(function () {
        // alert(111)
        var respData = null;
        $("#name").focusout(function () { //用户控件失焦事件
            $.ajax({
                url:"/checkAcc",
                type:"get",
                data:{"name":$("#name").val()},
                dataType:'json',
                success:function (resp) {
                    console.log(resp);
                    respData = resp;
                    if (resp.code==0){  //可用  ，文本显示绿色
                        $("#content").css('color','green')
                    }else {   //不可用，文本显示红色
                        $("#content").css('color','red')
                    }
                    $("#content").text(resp.msg)
                }

            })
        })
        //注册按钮提交执行
        $("#btn").on("click",function () {
            if (respData.code!=0){
                alert("请求完善注册信息")
            }else {
                //表单提交
                form = document.getElementById("myForm");
                form.submit();
            }
        })

        /* $("#btn").on("click",function () {
             // alert(2222)

             if (respData.code==0){
                 alert("准备提交注册")

                 //第一种请求：异步调用注册的servlet（post方式参数传递方便）
                 //第二种请求：location.href
                 //location.href = "/adminReg?name=值";
                 $.ajax({
                     url: "/adminReg",
                     type: "post",
                     data: {"name":$("#name").val(),"password":$("#pwd").val()},
                     dataType: "json",
                     success:function (resp) {
                         //根据注册是否成功跳转到响应的页面
                         console.log(resp);
                         url = "/pages/admin/reg.jsp";
                         if (resp.code==0){ //注册成功，跳转到登录页面
                             url = "/pages/admin/log.jsp";
                         }
                         alert(resp.msg)
                         location.href = url;//执行请求
                     }
                 })
             }else {
                 alert("请求完善注册信息")
             }
         })*/


    })
</script>

</body>
</html>
