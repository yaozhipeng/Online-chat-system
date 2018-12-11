<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <title>登陆</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>  
        body{  
        margin-left:auto;  
        margin-right:auto; 
        margin-TOP:150PX; 
        width:20em;  
        }
    </style>
</head>
<body>

<div class="input-group">
    <table>
        <form action="/webfinal/user/login" method="POST">
            <tr>
                <td><span class="input-group-addon">注册邮箱：</span></td>
                <td><input name="email" type="email" class="form-control" placeholder="邮箱名" aria-describedby="basic-addon1"></td>
            </tr>
            <tr>
                <td><span class="input-group-addon" id="basic-addon1">密码：</span></td>
                <td><input name="password" type="password" class="form-control" placeholder="密码" aria-describedby="basic-addon1"></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit" style="width:320px;" class="btn btn-default">登 录</button></td>
            </tr>
        </form>
        <tr>
            <td colspan="2"><button onclick="location.href='/webfinal/view/register'" type="button" style="width:320px;" class="btn btn-default">注册</button></td>
        </tr>
    </table>
</div>

</body>
</html>
