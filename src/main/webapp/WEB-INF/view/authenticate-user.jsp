<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
</head>
<body>
  <form action="authenticate-user" method="POST">
    <span>Login:</span>
    <input type="text" name="login">
    <span>Password:</span>
    <input type="password" name="password">
    <input type="submit">
  </form>
  <c:if test="${incorrectCredentials eq true}">
    <spans style="color: red">The login or password is incorrect.</spans>
  </c:if>
</body>
</html>
