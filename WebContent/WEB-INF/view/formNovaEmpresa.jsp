<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<c:url value="/entrada?acao=criarEmpresa&class=EmpresaController" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
					
	<c:import url="logout-parcial.jsp"/>
	<br>
	
	<form action="${linkServletNovaEmpresa }" method="post">
		
		<c:if test="${not empty empresa.id}">
			<input name="id" value="${empresa.id }" type="hidden"/>
		</c:if>
		
		Nome : <input type="text" name="nome" value="${empresa.nome}"/>
		Data Abertura : <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>"/>
		<input type="submit" value="cadastrar"/>
		
	</form>

</body>
</html>