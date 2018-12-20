<%@ page import="ncu.dto.FindNewFriendExecution" %>
<%@ page import="ncu.dto.Result" %>
<%@ page import="ncu.dto.Friend" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Result<FindNewFriendExecution> result = (Result<FindNewFriendExecution>) session.getAttribute("result"); %>
<html>
<head>
    <title>搜索结果</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <table>
        <th>
            <td>邮箱号</td>
            <td>用户名</td>
            <td>操作</td>
        </th>
        <%for (Friend friend : result.getData().getNewFriendList()) {%>
        <tr>
                <td><%=friend.getEmail()%></td>
                <td><%=friend.getName()%></td>
                <td>
                    <form id="form" action="/webfinal/home/addNewFriendRequest" method="post">
                        <input type="text" value="<%=friend.getId()%>" name="newFriendId"/>
                        <input type="submit" value="添加"/>
                    </form>
                </td>
        </tr>
        <%}%>
    </table>
</div>

</body>
</html>
