<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="html/head.jsp" %>
<body>
<div class="container text-center ">
<%@ include file="html/nav.jsp" %>
<h1 class="text-center">El correo ingresado: ${usuarioSU.correo} ya esta asociado a una cuenta existente</h1>
<div class="container m-5">
<a href="${pageContext.request.contextPath}/LoginController" type="button" class="btn btn-secondary m-auto">Iniciar sesion</a>
<a  href="${pageContext.request.contextPath}" class="btn btn-primary">Regresar</a>
</div>
<%@ include file="html/footer.jsp" %>
</div>
</body>
</html>