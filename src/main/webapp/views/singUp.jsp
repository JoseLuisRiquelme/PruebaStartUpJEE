<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="html/head.jsp" %>
<html>
<body>
<div class="container">
<%@ include file="html/nav.jsp" %>
<h1>Ingresa tus datos para registrarte:</h1>
<form action="SingUpController" method="post">
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">@</span>
  <input type="text" class="form-control" placeholder="Ingresa tu nick-name" aria-label="Username" aria-describedby="basic-addon1"
  id="nick" name="nick" required>
</div>
<div class="input-group mb-3">
  <input type="email" class="form-control" placeholder="Ingresa tu correo" aria-label="Recipient's username" aria-describedby="basic-addon2"
  id="email" name="email" required>
  <span class="input-group-text" id="basic-addon2">@example.com</span>
</div>

<div class="mb-3">
  <!-- <label for="basic-url" class="form-label">Your vanity URL</label> -->
  <div class="input-group">
    <!--<span class="input-group-text" id="basic-addon3">https://example.com/users/</span>-->
    <input type="text" class="form-control" id="basic-url" placeholder="ingresa tu nombre" aria-describedby="basic-addon3 basic-addon4"
    id="name" name="name" required>
  </div>
  <!-- <div class="form-text" id="basic-addon4">Example help text goes outside the input group.</div> -->
</div>

<div class="input-group mb-3">
  <input type="password" class="form-control" aria-label="Amount (to the nearest dollar)" placeholder="ingresa tu password"
  id="password" name="password" required>
  <span class="input-group-text">***</span>
</div>

<div class="input-group mb-3">
  <input type="number" class="form-control" placeholder="Ingresa tu peso" aria-label="Username" id="weight"
  name="weight" required>
  <span class="input-group-text">Kg</span>
</div>
<label for="calle">Ingresa tu direccion:</label>
<div class="input-group mb-3">
  <input type="text" class="form-control" placeholder="Ingresa tu calle" aria-label="Username" id="calle"
  name="calle" required>
</div>
<div class="input-group mb-3">
<span class="input-group-text">#</span>
  <input type="text" class="form-control" placeholder="Ingresa la numeracion" aria-label="Username" id="numeracion"
  name="numeracion" required>
</div>
<label for="rolId">Selecciona un rol:</label>
<select class="form-select" aria-label="Default select example" name="rolId" id="rolId">
  <option value="1">Administrador</option>
  <option value="2">Operador</option>
</select>
<button class="btn btn-primary mb-3 mt-3" type="submit">Registrarme</button>
</form>

<%@ include file="html/footer.jsp" %>
</div>
</body>
</html>