<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>注册</title>
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<form id="register" action="/webfinal/user/register" method="post">
    <table>
        <tr>
            <td>邮箱: </td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>密码: </td>
            <td><input type="password" name="password1"/></td>
        </tr>
        <tr>
            <td>再次输入密码: </td>
            <td><input type="password" name="password2"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="确认"/></td>
        </tr>
    </table>
</form>
</body>
<%--<script language="JavaScript">--%>
        <%--$("#submit").click(function () {--%>
            <%--$.ajax({--%>
                <%--cache: false,--%>
                <%--type: "POST",--%>
                <%--url:"http://localhost:8080/webfinal/user/register",--%>
                <%--data:$('#register').serialize(),--%>
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
    <%----%>
        <%--})--%>
    <%----%>
        <%--function redirection() {--%>
            <%--$("#form").submit();--%>
        <%--}--%>
    <%--</script>--%>
</html>
