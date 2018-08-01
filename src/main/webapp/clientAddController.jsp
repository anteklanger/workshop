<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 01.08.2018
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ClientAddController">
    <label><h2>first name:</h2>
        <input type="text" name="firstname" placeholder="first name">
    </label>

    <label><h2>last name:</h2>
        <input type="text" name="lastname" placeholder="last name">
    </label>

    <label><h2>birth date:</h2>
        <input type="date" name="birthdate" placeholder="birth date">
        <input type="submit">
    </label>
</form>
</body>
</html>
