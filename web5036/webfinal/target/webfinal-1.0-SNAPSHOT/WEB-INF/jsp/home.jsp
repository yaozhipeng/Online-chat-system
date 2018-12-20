<%@ page import="ncu.dto.HomeExecution" %>
<%@ page import="ncu.dto.Result" %>
<%@ page import="ncu.dto.Friend" %>
<%@ page import="java.util.List" %>
<%@ page import="ncu.entity.Information" %>
<%@ page import="java.util.Map" %>
<%@ page import="ncu.entity.Impression" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Result<HomeExecution> result = (Result<HomeExecution>) session.getAttribute("result"); %>
<% List<Friend> friendList = result.getData().getFriendList(); %>
<% Map<String, Information> informationMap = result.getData().getInformationMap(); %>
<% Map<String, List<Impression>> impressionListMap = result.getData().getImpressionListMap(); %>
<% String currentId = (String) session.getAttribute("currentId");%>
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
    <script src="${pageContext.request.contextPath}/static/sockjs-0.3.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/stomp.min.js"></script>
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
        <div class="col-md-2">
            <table class="table">
                <thead>
                <tr>
                    <th>好友列表</th>
                </tr>
                </thead>
                <tbody style="height:350px; overflow-y:auto;">
                <%
                    for(Friend f : friendList) {
                        String id = f.getId();
                        Information information = informationMap.get(id);
                        List<Impression> impressionList = impressionListMap.get(id);
                        StringBuilder discription = new StringBuilder("");
                        for (Impression impression : impressionList) {
                            discription.append(impression.getDescription()).append("; ");
                        }
                        String gender = "未知";
                        if (information.getGender() != null) {
                            if (information.getGender() == 0) {
                                gender = "女";
                            } else if (information.getGender() == 1) {
                                gender = "男";
                            }
                        }
                        String content = "邮箱: " + f.getEmail() +
                                "<br>性别: " + gender +
                                "<br>爱好: " + information.getHabit()+
                                "<br>地址: " + information.getAddress() +
                                "<br>手机: " + information.getPhone() +
                                "<br>好友评价: " + discription.toString();
                %>
                <tr title="<%=f.getName()%>" data-toggle="popover" data-trigger="hover" data-html="true"   data-content="<%=content%>" class="<%=f.getId()%>">
                    <td onclick="choseFriend('<%=f.getId()%>')"><%=f.getName()%> <span id="<%="span"+f.getId()%>" class="badge badge-pill badge-danger" style="float: right; display: none">0</span></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
        <div name="main" class="col-md-8"></div>
        <%
            for(Friend f : friendList) {
        %>
        <div name="main" id="<%="main" + f.getId()%>" class="col-md-8" style="display:none;">
            <table class="table">
                <thead>
                <tr>
                    <th><%=f.getName()%></th>
                </tr>
                </thead>
                <tbody id="<%="tbody" + f.getId()%>" style="height:350px; overflow-y:auto; display:block; ">
                <%--<tr><td>00-00 00:00【用户B】对你说：欢迎你来到聊天室</td></tr>--%>
                </tbody>
            </table>
            <div class="input-group" style="height: 74px">
                <textarea id="<%="textarea" + f.getId()%>" class="form-control" rows="3" style="resize: none;" placeholder="请输入要发送的内容......" ></textarea>
                <span class="input-group-btn">
                    <button onclick="sendMessage('<%=f.getId()%>')" class="btn btn-default" type="submit" style="height: 100%">发送</button>
                </span>
            </div>
        </div>
        <%
            }
        %>
        
        
        <div class="col-md-2">
            <table class="table">
                <thead>
                <tr>
                    <th>功能列表</th>
                </tr>
                </thead>
                <tbody style="height:350px; overflow-y:auto;">
                <tr><td onclick="location.href = '/webfinal/view/managerFriend'">增删好友</td></tr>
                <tr><td onclick="location.href = '/webfinal/view/verification'">好友申请信息</td></tr>
                <tr><td onclick="location.href = '/webfinal/view/selfInformation'">修改个人信息</td></tr>
                <tr><td onclick="location.href = '/webfinal/view/labelFriend'">评价好友</td></tr>
                <tr><td onclick="location.href = '/webfinal/view/selfLabel'">查看对自己的评价</td></tr>
                <tr><td onclick="location.href = '/webfinal/view/downloadChat'">下载聊天记录</td></tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<br/>
</body>
<script type="text/javascript">
    $(document).ready(function(){
        $('[data-toggle="popover"]').popover();
    });

    var stompClient = null;
    var chosenId = null;

    function getChoseId() {
        return chosenId;
    }

    function connect() {
        var socket = new SockJS('/webfinal/chat'); // yes
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/chat/<%=session.getAttribute("currentId")%>',
                function(messageOutput) {
                showMessageOutput(JSON.parse(messageOutput.body));
            });
        });
    }

    function disconnect() {
        if(stompClient != null) {
            stompClient.disconnect();
        }
        console.log("Disconnected");
    }

    function sendMessage(toId) {
        var textarea = document.getElementById('textarea' + toId);
        text = textarea.value;
        stompClient.send("/app/chat/"+toId, {},
            JSON.stringify({'from':'<%=currentId%>', 'text':text}));
        stompClient.send("/app/chat/<%=currentId%>", {},
            JSON.stringify({'from':'<%=currentId%>', 'text':text}));
        textarea.value = "";
    }

    function showMessageOutput(messageOutput, chosenId) {
        var fromId = messageOutput.fromId;
        var fromName = messageOutput.fromName;
        var toId = messageOutput.toId;
        var text = messageOutput.text;
        var time = messageOutput.time;
        var trNode = document.createElement('tr');
        var tdNode = document.createElement('td');
        var textNode = document.createTextNode('[' + time + '] ' + fromName + ': ' + text);
        tdNode.appendChild(textNode);
        trNode.appendChild(tdNode);
        var tbody = document.getElementById('tbody'+fromId);
        if (tbody == undefined) {
            tbody = document.getElementById('tbody'+ getChoseId());
        }
        tbody.appendChild(trNode);
        // 红点提示
        if(fromId != getChoseId() && fromId != toId) {
            var span = document.getElementById('span'+fromId);
            var n = parseInt(span.innerText);
            n = n + 1;
            span.innerText = n;
            span.style.display = 'block';
        }
    }
    
    function choseFriend(id) {
        var mains = document.getElementsByName('main');
        for(var i = 0; i < mains.length; ++i) {
            mains[i].style.display = 'none';
        }
        chosenId = id;
        document.getElementById("main"+id).style.display = 'block';
        // 红点提示取消
        var span = document.getElementById("span"+id);
        span.style.display = "none";
        span.innerText = "0";
    }
    connect();
</script>
</html>