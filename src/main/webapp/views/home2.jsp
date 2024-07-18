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
<h2 style=color:red>Seccion no autorizada!</h2>
<h2>No estas autorizado a ver la lista de proveedores</h2>
<h3>Ni la direccion de los trabajadores</h3>
<a  href="${pageContext.request.contextPath}" class="btn btn-primary mb-3">Regresar</a>
<%@ include file="html/footer.jsp" %>
</div>
</body>
</html>