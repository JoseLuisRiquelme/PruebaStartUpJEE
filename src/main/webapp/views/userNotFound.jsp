<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="html/head.jsp" %>
<body>
<div class="container">
<%@ include file="html/nav.jsp" %>
<h1>Correo o contrasenha errones o usuario no existe!</h1>
<h2>Intente nuevamente </h2>
<a  href="${pageContext.request.contextPath}/LoginController" class="btn btn-primary mb-3">Regresar</a>
<%@ include file="html/footer.jsp" %>
</div>
</body>
</html>