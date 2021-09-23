<%@ page import="dev.castanhocorreia.societates.model.Company" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles.css">
  <title>Edit ${companyToBeUpdated.name}</title>
</head>
<body>
  <form action="update-company?id=${companyToBeUpdated.id}" method="POST">
    <span>Name:</span>
    <input type="text" name="newCompanyName" value="${companyToBeUpdated.name}">
    <span>Founded In:</span>
    <input type="text" name="newCompanyFoundingDate" value="<fmt:formatDate value="${companyToBeUpdated.registrationDate}" pattern="dd/MM/yyyy"/>">
    <input type="submit">
  </form>
</body>
</html>
