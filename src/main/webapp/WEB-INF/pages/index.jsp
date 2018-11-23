<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 25.06.2018
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello</h1>
<form action="/save" method="post">
    <input type="text" name="name" placeholder="name"/>
    <input type="password" name="password" placeholder="password"/>
    <input type="submit" value="save"/>
</form>

<br>
<a href="/next"> go to spring form</a>
</body>
</html>
