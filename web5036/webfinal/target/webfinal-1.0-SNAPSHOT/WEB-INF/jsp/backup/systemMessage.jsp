<%@ page import="ncu.dto.SystemMessageExecution" %>
<%@ page import="ncu.dto.Result" %>
<%@ page import="ncu.dto.Friend" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Result<SystemMessageExecution> result = (Result<SystemMessageExecution>) session.getAttribute("result");%>
<html>
<head>
    <title>系统消息</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <ul>
        <%for(Friend friend : result.getData().getFriendList()) {%>
        <li>
            <%=friend.getName()%> <br/>
            <%=friend.getEmail()%> <br/>
            提交了好友请求
            <form action="/webfinal/home/agreeNewFriend">
                <input type="text" name="friendId" value="<%=friend.getId()%>" hidden="hidden"/>
                <input type="submit" value="同意">
            </form>
        </li>
        <%}%>
    </ul>
</div>
</body>
</html>
