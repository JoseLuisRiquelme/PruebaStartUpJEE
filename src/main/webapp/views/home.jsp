<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@ include file="html/head.jsp" %>
<body>
<div class="container">
<%@ include file="html/nav.jsp" %>
<h1>HOME</h1>
<h2>Bienvenido <strong>${usuario.nombre}!</strong></h2>
<h3>Tu correo es: ${usuario.correo}</h3>
<h2>Esta es la lista de proveedores</h2>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Rubro</th>
      <th scope="col">Telefono</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="p" items="${proveedores}">
    <tr>
      <th scope="row">1</th>
      <td><c:out value="${p.getNombre()}"></c:out></td>
      <td><c:out value="${p.getRubro()}"></c:out></td>
      <td><c:out value="${p.getTelefono()}"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<h2>Esta es la lista de direcciones</h2>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nombre Trabajador</th>
      <th scope="col">Nombre Calle</th>
      <th scope="col">Numeracion Calle</th>
      <th scope="col">Id</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="d" items="${direcciones}" >
    <tr>
      <th scope="row">1</th>
      <td><c:out value="${d.getNombreUsuario()}"></c:out></td>
      <td><c:out value="${d.getNombre()}"></c:out></td>
      <td><c:out value="${d.getNumeracion()}"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<a  href="${pageContext.request.contextPath}" class="btn btn-primary mb-3">Regresar</a>
<%@ include file="html/footer.jsp" %>
</div>
</body>
</html>