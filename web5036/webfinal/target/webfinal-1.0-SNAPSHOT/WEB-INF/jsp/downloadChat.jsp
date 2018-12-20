<%@ page import="ncu.dto.DownloadChatExecution" %>
<%@ page import="ncu.dto.Result" %>
<%@ page import="ncu.dto.Friend" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Result<DownloadChatExecution> result = (Result<DownloadChatExecution>) session.getAttribute("result"); %>
<% DownloadChatExecution execution = result.getData(); %>
<% List<Friend> friendList = execution.getFriendList(); %>
<!DOCTYPE html>
<html>
<head>
    <title>聊天系统</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<div id="main-content" class="container">
    <br/>
    <div class="row">
        <div class="col-md-9">
            <label>当前用户: <%=session.getAttribute("currentName")%></label>
        </div>
        <div class="col-md-3">
            <label onclick="location.href='/webfinal/view/home'" style="float:right">主页</label>
        </div>
    </div>
    <br/>
    <form action="/webfinal/home/chatHistory" method="get">
        <div class="row">
            <div class="col-md-12">
                <table id="userlist" class="table">
                    <thead onclick='javascript:hidetuser()'>
                    <tr>
                        <th colspan="2">请选择好友，下载聊天记录：</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for(Friend f : friendList) {
                    %>
                    <tr>
                        <td><%=f.getName()%></td>
                        <td><input type="radio" value="<%=f.getId()%>" name="friendId"/></td>
                    </tr>
                    <%
                        }
                    %>
                    <tr>
                        <td colspan="2"><input type="submit" value="下载聊天记录"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </form>
</div>
<br/>
</body>
<script language="JavaScript">

</script>
</html>