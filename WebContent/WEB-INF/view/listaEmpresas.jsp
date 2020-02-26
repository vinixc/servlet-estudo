<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.vini.gerenciador.entities.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	
	<c:import url="logout-parcial.jsp"/>
	<br>
	
	Usuario logado : ${usuarioLogado.login }
	<br>
	<br>
	
	Lista de Empresas : 
		<c:if test="${not empty empresa }" >
			Empresa ${ empresa } cadastrada com sucesso!
		</c:if>

	<ul>
		<c:forEach items="${empresas }" var="empresa" >
			
			<li>${empresa.id} - ${empresa.nome} -- Data abertura: 
			<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
			<a href="<c:url value="/entrada?acao=deleteEmpresa&class=EmpresaController&id=${empresa.id }"/>">Remover</a> 
			<a href="<c:url value="/entrada?acao=atualizaEmpresa&class=EmpresaController&id=${empresa.id }"/>">Atualizar</a>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>