<%@ page import="ncu.dto.Friend" %>
<%@ page import="java.util.List" %>
<%@ page import="ncu.dto.VerificationExecution" %>
<%@ page import="ncu.dto.Result" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Result<VerificationExecution> result = (Result<VerificationExecution>) session.getAttribute("result");%>
<% List<Friend> friendList = result.getData().getFriendList(); %>
<html>
<head>
    <title>好友验证</title>
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
    <div class="row">
        <div class="col-md-12">
            <table id="userlist" class="table">
                <thead>
                    <th colspan="3">验证好友申请: </th>
                </thead>
                <tbody>
                    <tr>
                        <th>用户名</th>
                        <th>邮箱</th>
                        <th>操作</th>
                    </tr>
                    <%
                        for (Friend f : friendList) {
                    %>
                    <tr>
                        <form action="/webfinal/home/agreeNewFriend" method="post">
                            <th><%=f.getName()%></th>
                            <th><%=f.getEmail()%></th>
                            <th><input type="text" name="friendId" value="<%=f.getId()%>" hidden><input type="submit" value="接收"></th>
                        </form>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<br/>
</body>
</html>
