<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>注册界面</h3>
<form id="register" action="${pageContext.request.contextPath}/user/registerCheck" method="post">
    <label for="username">
        用户名：
    </label>
    <input type="text" required id="username" name="username"><br>
    <label for="password">
        密码：
    </label>
    <input type="text" required id="password" name="password"><br>
    <input type="submit" value="注册">
    <input type="reset" value="重置"/>
</form>

<script>
    //对应后台返回的提示
    if ('${result}' != '') {
        if ('${result}' == 1) {
            alert('注册成功，将跳转到登录页面！')
            location.href = '${pageContext.request.contextPath}/user/login'
        }
        if ('${result}' == 0) {
            alert('未知错误，注册失败！')
        }
        if ('${result}' == 2) {
            alert('该账号已有人注册！')
        }

    }
</script>
</body>
</html>
