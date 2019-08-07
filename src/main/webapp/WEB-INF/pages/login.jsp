<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>登录界面</h3>
<form id="zc" action="${pageContext.request.contextPath}/user/checkUser" method="post">
    <label for="username">用户名：</label> <input type="text" required id="username" name="username"><br>
    <label for="password">密码：</label> <input type="password" required id="password" name="password"><br>
    <input type="submit" value="登录">
    <input type="button" value="注册" onclick="location.href='${pageContext.request.contextPath}/user/register'">
</form>
<script>

    //对应后台返回的提示
    if ('${result}' != '') {
        if ('${result}' == 0)
            alert('该账户不存在！');
        if ('${result}' == 1)
            alert('密码错误！');
        if ('${result}' == 2) {
            alert('登录成功！');
            location.href = '${pageContext.request.contextPath}/user/success';
        }
        if ('${result}' == 3) {
            alert('未登录,请登录！');
        }
    }
</script>
</body>
</html>
