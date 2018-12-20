<%@ page import="ncu.dto.SelfInformationExecution" %>
<%@ page import="ncu.dto.Result" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Result<SelfInformationExecution> result = (Result<SelfInformationExecution>) session.getAttribute("result"); %>
<% SelfInformationExecution execution = result.getData(); %>
<%
    String gender = "未知";
    if (execution.getGender() != null) {
        if (execution.getGender() == 0) {
            gender = "女";
        } else if (execution.getGender() == 1) {
            gender = "男";
        }
    }
%>
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
    <div class="row">
        <div class="col-md-12">
            <table id="userlist" class="table">
                <form action="/webfinal/home/updateSelfInformation" method="post">
                    <thead>
                        <th colspan="2">修改个人信息: </th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>用户名</td>
                            <td><input type="text" name="name" value="<%=execution.getName()%>"></td>
                        </tr>
                        <tr>
                            <td>性别</td>
                            <td><input type="text" name="gender" value="<%=gender%>"></td>
                        </tr>
                        <tr>
                            <td>爱好</td>
                            <td><input type="text" name="motto" value="<%=execution.getHabit()%>"></td>
                        </tr>
                        <tr>
                            <td>地址</td>
                            <td><input type="text" name="school" value="<%=execution.getAddress()%>"></td>
                        </tr>
                        <tr>
                            <td>电话</td>
                            <td><input type="text" name="phone" value="<%=execution.getPhone()%>"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input style="float: right;" type="submit" value="确认修改"/></td>
                        </tr>
                    </tbody>
                </form>
            </table>
        </div>
    </div>
</div>
<br/>
</body>
<script language="JavaScript">

</script>
</html>