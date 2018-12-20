<%@ page import="ncu.dto.LabelFriendExecution" %>
<%@ page import="ncu.dto.Result" %>
<%@ page import="ncu.dto.Friend" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Result<LabelFriendExecution> result = (Result<LabelFriendExecution>) session.getAttribute("result"); %>
<% List<Friend> friendList = result.getData().getFriendList();%>
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
    <!-- <script src="https://cdn.bootcss.com/sockjs-client/1.1.4/sockjs.min.js"></script>
    <script src="https://cdn.bootcss.com/stomp.js/2.3.3/stomp.min.js"></script> -->
    <!-- <script src="/app.js"></script> -->
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
    <form id="label" action="/webfinal/home/label" method="post">
        <div class="row">
            <div class="col-md-4">
                <table class="table">
                    <thead>
                    <tr>
                        <th colspan="2">选择好友</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for(Friend f : friendList) {
                    %>
                    <tr>
                        <td><%=f.getName()%> </td>
                        <td><input type="radio" value="<%=f.getId()%>" name="friendId"/></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
            <div class="col-md-8">
                <table class="table">
                    <thead>
                    <tr>
                        <th>填写评价</th>
                    </tr>
                    </thead>
                    <tbody style="height:350px; overflow-y:auto;">
                    <tr>
                        <td><textarea name="content" form="label" cols="30px" rows="10px"></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="评价"/></td>
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