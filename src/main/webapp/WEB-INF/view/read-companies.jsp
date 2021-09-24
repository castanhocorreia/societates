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
  <a href="logout-user">Logout</a>
  <c:if test="${not empty accreditedUser}">
    <span>User: ${accreditedUser.login}.</span>
  </c:if>
  <table>
    <thead>
      <tr>
        <th>Id</th>
        <th>Registration Date</th>
        <th>Name</th>
        <th>Founded In</th>
        <th>Update</th>
        <th>Delete</th>
      <tr>
    </thead>
    <tbody>
      <c:forEach items="${companiesList}" var="company">
        <tr>
          <td>${company.id}</td>
          <td><fmt:formatDate value="${company.registrationDate}" pattern="dd/MM/yyyy"/></td>
          <td>${company.name}</td>
          <td><fmt:formatDate value="${company.foundedIn}" pattern="dd/MM/yyyy"/></td>
          <td><a href="update-company?id=${company.id}">edit</a></td>
          <td><a href="delete-company?id=${company.id}">delete</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="create-company">CREATE NEW COMPANY</a>
</body>
</html>
