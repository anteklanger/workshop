<%--
  Created by IntelliJ IDEA.
  User: antek
  Date: 03.08.18
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/VehicleAddController">
    <label><h2>Brand: </h2>
        <input type="text" name="brand" placeholder="Vehicle brand...">
    </label>

    <label><h2>Model: </h2>
        <input type="text" name="model" placeholder="Model...">
    </label>

    <label><h2>Licence Plate:</h2>
        <input type="text" name="licencePlate" placeholder="Licence plate...">
    </label>

    <label><h2>Registration Year: </h2>
        <input type="number" name="registrationYear" placeholder="Registration year...">
    </label>

    <label><h2>Technical Review Date: </h2>
        <input type="date" name="techReview" placeholder="Technical review date...">
    </label>

    <label><h2>Client: </h2>
        <select>

        </select>
        <input type="submit" value="Add Vehicle">
    </label>



</form>
</body>
</html>
