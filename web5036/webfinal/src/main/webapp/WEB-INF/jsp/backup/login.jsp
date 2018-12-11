<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>登陆</title>
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>

<form action="/webfinal/user/login" method="POST">
    <table>
        <tr>
            <td>注册邮箱: </td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>密码: </td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="确认"/></td>
        </tr>
    </table>
</form>

<a href="/webfinal/view/register">注册</a>

</body>
<%--<script language="JavaScript">--%>
    <%--$("#submit").click(function () {--%>
        <%--$.ajax({--%>
            <%--cache: false,--%>
            <%--type: "POST",--%>
            <%--url:"http://localhost:8080/webfinal/user/login",--%>
            <%--data:$('#login').serialize(),--%>
            <%--async: false,--%>
            <%--error: function() {--%>
                <%--alert("Connection error");--%>
            <%--},--%>
            <%--success: function(data) {--%>
                <%--if(data.success) {--%>
                    <%--redirection();--%>
                <%--} else {--%>
                    <%--alert(data.error);--%>
                <%--}--%>
            <%--}--%>
        <%--});--%>

    <%--})--%>

    <%--function redirection() {--%>
        <%--$("#form").submit();--%>
    <%--}--%>
<%--</script>--%>
</html>
