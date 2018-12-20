<%@ page import="ncu.dto.SelfInformationExecution" %>
<%@ page import="ncu.dto.Result" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Result<SelfInformationExecution> result = (Result<SelfInformationExecution>) session.getAttribute("result"); %>
<% SelfInformationExecution execution = result.getData(); %>
<html>
<head>
    <title>修改信息</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
</head>
<body>
<form action="/webfinal/home/updateSelfInformation" method="post">
    <table>
        <%--<tr>--%>
            <%--<td>ID</td>--%>
            <%--<td></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>邮箱</td>--%>
            <%--<td></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>密码</td>--%>
            <%--<td></td>--%>
        <%--</tr>--%>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name" value="<%=execution.getName()%>"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="gender" value="<%
                if (execution.getGender() == null) {
                    response.getWriter().write("未知");
                }else if (execution.getGender() == 0) {
                    response.getWriter().write("女");
                } else if (execution.getGender() == 1) {
                    response.getWriter().write("男");
                } else {
                    response.getWriter().write("未知");
                }
            %>"></td>
        </tr>
        <tr>
            <td>个性签名</td>
            <td><input type="text" name="motto" value="<%=execution.getMotto()%>"></td>
        </tr>
        <tr>
            <td>学校</td>
            <td><input type="text" name="school" value="<%=execution.getSchool()%>"></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="phone" value="<%=execution.getPhone()%>"></td>
        </tr>
        <tr>
            <input type="submit" value="确认修改"/>
        </tr>
    </table>
</form>
</body>
</html>
