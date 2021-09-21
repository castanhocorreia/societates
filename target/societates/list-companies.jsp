<%@ page import="java.util.List, dev.castanhocorreia.societates.model.Company" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Companies List</title>
</head>
<body>
  <ul>
    <c:forEach items="${companiesList}" var="company">
      <li>${company.name}</li>
    </c:forEach>
  </ul>
</body>
</html>
