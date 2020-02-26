<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<c:url value="/entradaLogin?class=LoginController" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<form action="${linkServletNovaEmpresa }" method="post">
		
		Login : <input type="text" name="login"/>
		Senha : <input type="password" name="senha"/>
		
		<input type="hidden" name="acao" value="login"/>
		<input type="submit" value="logar"/>
		
	</form>

</body>
</html>