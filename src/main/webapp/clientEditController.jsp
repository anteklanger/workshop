<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 02.08.2018
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

You are editing client : ${actual.id}

<form action="/ClientEditController" method="get">
    <input hidden type="number" name="id" value="${actual.id}">

    <label><h2>${actual.id}</h2>
        <input type="text" name="firstname" placeholder="new first name" value="${actual.firstName}">
    </label>

    <label><h2>${actual.lastName}</h2>
        <input type="text" name="lastname" placeholder="new last name" value="${actual.lastName}">
    </label>

    <label><h2>${actual.birthDate}:</h2>
        <input type="date" name="birthdate" placeholder="new birth date" value="${actual.birthDate}">
        <input type="submit">
    </label>
</form>

</body>
</html>
