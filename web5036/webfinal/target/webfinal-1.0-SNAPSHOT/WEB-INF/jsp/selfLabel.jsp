<%@ page import="ncu.dto.SelfLabelExecution" %>
<%@ page import="ncu.dto.Result" %>
<%@ page import="ncu.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ncu.entity.Information" %>
<%@ page import="java.util.Map" %>
<%@ page import="javax.sound.sampled.Line" %>
<%@ page import="ncu.entity.Impression" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Result<SelfLabelExecution> result = (Result<SelfLabelExecution>) session.getAttribute("result"); %>
<%
    SelfLabelExecution execution = result.getData();
    List<User> userList = execution.getFromUserList();
    Map<String, Information> informationMap = execution.getFromInformationMap();
    Map<String, String> impressionMap = execution.getImpressionMap();
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
                <thead>
                    <th colspan="2">好友对自己的评价: </th>
                </thead>
                <tbody>
                <%
                    for(User user : userList) {
                        Information information = informationMap.get(user.getId());
                        String description = impressionMap.get(user.getId());
                %>
                    <tr>
                        <td><%=information.getName()%></td>
                        <td><%=description%></td>
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
<script language="JavaScript">

</script>
</html>