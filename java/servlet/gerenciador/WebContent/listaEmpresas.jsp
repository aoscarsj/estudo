<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List, br.com.alura.gerenciador.Empresa" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- //forma de usar expressoes no jsp. ${4 + 4  } ${empresa} -->
	<p>Lista de empresas:</p>
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li> ${ empresa.nome } </li>
		</c:forEach>
	</ul>
	 <!-- equivalentes bib jstl.
	<ul>
		 < %
				List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");
				for(Empresa empresa : lista) {
			%>
					<li> < %= empresa.getNome() %> </li>
			< % } %>		
	</ul>
	-->
</body>
</html>