<%@ page import="ncu.dto.ManagerFriendExecution" %>
<%@ page import="ncu.dto.Result" %>
<%@ page import="ncu.dto.Friend" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ncu.dto.FindNewFriendExecution" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Result<ManagerFriendExecution> result = (Result<ManagerFriendExecution>) session.getAttribute("result"); %>
<% List<Friend> friendList = result.getData().getFriendList(); %>
<% Result<FindNewFriendExecution> searchResult = (Result<FindNewFriendExecution>) session.getAttribute("searchResult");%>
<%
    List<Friend> searchList;
    if(searchResult == null) {
        searchList = new ArrayList<>();
    } else {
        searchList = searchResult.getData().getNewFriendList();
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
<div class="container">
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
        <div class="col-md-4">
            <table class="table">
                <thead>
                <tr>
                    <th colspan="2">删除好友</th>
                </tr>
                </thead>
                <tbody style="height:350px; overflow-y:auto;">
                <%
                    for(Friend f : friendList) {
                %>
                <form action="/webfinal/home/deleteFriend">
                <tr>
                    <td><%=f.getName()%><input name="friendId" value="<%=f.getId()%>" hidden/></td>
                    <td><input type="submit" value="删除"></td>
                </tr>
                </form>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
        <div class="col-md-8">
            <table id="userlist" class="table">
                <thead>
                    <tr>
                        <form action="/webfinal/home/findNewFriend">
                            <th>
                                <input name="key" type="text" placeholder="用户名或邮箱...">
                            </th>
                            <th>
                                <input type="submit" value="搜索新好友">
                            </th>
                        </form>
                    </tr>
                </thead>
                <tbody id="user" style="height:350px; overflow-y:auto;">
                <%
                    for (Friend f : searchList) {
                %>
                <form action="/webfinal/home/addNewFriendRequest" method="post">
                    <tr>
                        <td><%=f.getName()+" (" + f.getEmail() + ")"%><input hidden name="friendId" type="text" value="<%=f.getId()%>"></td>
                        <td><input type="submit" value="添加"></td>
                    </tr>
                </form>
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