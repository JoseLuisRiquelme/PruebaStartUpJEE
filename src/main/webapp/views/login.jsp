<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="html/head.jsp" %>
<html>
<body>
<div class="container">
<%@ include file="html/nav.jsp" %>
<h1>Ingresa tus datos para iniciar sesion:</h1>
<form action="LoginController" method="post">
<div class="input-group mb-3">
  <input type="email" class="form-control" placeholder="Ingresa tu correo" aria-label="Recipient's username" aria-describedby="basic-addon2"
  id="email" name="email" required>
  <span class="input-group-text" id="basic-addon2">@example.com</span>
</div>

<div class="input-group mb-3">
  <input type="password" class="form-control" aria-label="Amount (to the nearest dollar)" placeholder="ingresa tu password"
  id="password" name="password" required>
  <span class="input-group-text">***</span>
</div>

<button class="btn btn-success mb-3" type="submit">Iniciar Sesion</button>
</form>

<%@ include file="html/footer.jsp" %>
</div>
</body>
</html>