<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="views/html/head.jsp" %>
<body>
<div class="container text-center ">
<%@ include file="views/html/nav.jsp" %>
<h1 class="text-center">Bienvenido al sistema empresarial StartUp!</h1>
<h2 class="text-center">Elija una opcion para continuar</h2>
<div class="container m-5">
<a href="${pageContext.request.contextPath}/SingUpController" type="button" class="btn btn-primary">Registrarse</a>
<a href="${pageContext.request.contextPath}/LoginController" type="button" class="btn btn-secondary m-auto">Iniciar sesion</a>
</div>
<%@ include file="views/html/footer.jsp" %>
</div>
</body>
</html>