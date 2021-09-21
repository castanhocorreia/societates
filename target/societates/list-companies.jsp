<%@ page import="java.util.List, dev.castanhocorreia.societates.model.Company" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Companies List</title>
</head>
<body>
  <table>
    <thead>
      <tr>
        <th>Id</th>
        <th>Registration Date</th>
        <th>Name</th>
        <th>Founded In</th>
      <tr>
    </thead>
    <tbody>
      <c:forEach items="${companiesList}" var="company">
        <tr>
          <td>${company.id}</td>
          <td><fmt:formatDate value="${company.registrationDate}" pattern="dd/MM/yyyy"/></td>
          <td>${company.name}</td>
          <td><fmt:formatDate value="${company.foundedIn}" pattern="dd/MM/yyyy"/></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
