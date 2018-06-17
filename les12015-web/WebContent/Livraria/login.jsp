<%@page import="java.util.ArrayList"%>
<%@page import="les12015.dominio.ItemPedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.getSession(); %><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Login</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
</head>

<body>
	<jsp:include page="menu.jsp"/>

	<div class="wrapper">
		<p class="titulo">Já sou cliente</p>
		<form>
			<div class="login">
				<input type="text" id="email" name="email" placeholder="Endereço de E-mail"><br>
				<input type="password" id="senha" name="senha" placeholder="Senha"><br>
				<input type='submit' id="operacao" name="operacao" formaction="Usuario?&operacao=login"
										value='login' style="width: 8em;">
				<p>
					Ainda não é cadastrado? <a href="cadastro_dados.jsp">Clique aqui!</a>
			</div>
		</form>
		<c:if test="${mensagem != null}">
			<c:out value="${mensagem}" />
		</c:if>
	</div>
	<div class="rodape"></div>
</body>
</html>