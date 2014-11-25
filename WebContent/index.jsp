<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="shortcut icon" href="img/head.ico" type="image/x-icon"/>
    <script type="text/javascript">
    </script>
</head>
<body>
<h1>自贡市城乡管理执法信息系统</h1>

<div class="loginContainer">
    <form action="user!login" method="post">
        <div class="inputArea">
            <label>账号：</label><input class="input" type="text" name="user.userName" placeholder="请在此输入账号">
            <label>密码：</label><input class="input" type="password" name="user.userPw" placeholder="请在此输入密码">
            <input class="input sub" type="submit"  value="登录">
            <span class="error" id="error"><s:property value="errorString"/></span>
        </div>
    </form>
</div>
</body>
</html>