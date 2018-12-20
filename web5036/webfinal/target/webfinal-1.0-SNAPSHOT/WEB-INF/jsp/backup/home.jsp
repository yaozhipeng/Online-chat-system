<%@ page import="ncu.dto.HomeExecution" %>
<%@ page import="ncu.dto.Result" %>
<%@ page import="ncu.dto.Friend" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Result<HomeExecution> result = (Result<HomeExecution>) session.getAttribute("result"); %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>主页面</title>
</head>
<body>
<div>
    <ul>
        <li>
            <button onclick="location.href = '/webfinal/view/systemMessage'">系统消息</button>
        </li>
        <li>
        </li>
    </ul>
</div>

<div>
    <div>
        <ul>
            <%for(Friend friend : result.getData().getFriendList()) {%>
            <li><%=friend.getName()%></li>
            <%}%>
        </ul>
    </div>
</div>
<div>
    <form action="/webfinal/home/findNewFriend" method="post">
        <input type="text" placeholder="输入邮箱或用户名" name="key"/>
        <input type="submit" value="搜索"/>
    </form>
</div>
<form action="/webfinal/view/selfInformation">
    <input type="submit" value="修改个人资料">
</form>

</body>
</html>