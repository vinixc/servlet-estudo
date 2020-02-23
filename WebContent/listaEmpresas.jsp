<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.vini.gerenciador.entities.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	<ul>
		<c:forEach items="${empresas }" var="empresa" >
			<li>${empresa.id} - ${empresa.nome}</li>
		</c:forEach>
	</ul>
</body>
</html>