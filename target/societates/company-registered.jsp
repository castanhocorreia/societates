<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Company Registered</title>
</head>
<body>
  <c:if test="${ not empty name }">
    <h1>The company ${name} was succesfully registered.</h1>
  </c:if>
</body>
</html>
