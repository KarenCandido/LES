<%@page import="java.util.ArrayList"%>
<%@page import="les12015.dominio.ItemPedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.getSession();
%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Alterar Senha</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
</head>

<body>
<jsp:include page="menu.jsp"/>

	<div class="wrapper">
		<jsp:include page="perfil_lateral.jsp"/>
		<div class="centro">
			<p class="titulo">Alterar Senha</p>
			<div class="cadastro_dados">
				<form>
					<input type="text" id="cad_email" placeholder="Endereço de E-mail"><br>
					<input type="text" id="cad_senha" placeholder="Senha"> -
					minimo 8 caracteres<br> <input type="text"
						id="cad_confirma_senha" placeholder="Confirmar Senha"> -
					letras maiusculas e minusculas<br> <input type="button"
						id="bt_cancelar" value="Cancelar"> <input type="button"
						id="bt_salvar" value="Salvar">
				</form>
			</div>
		</div>
	</div>
	<div class="rodape"></div>
</body>
</html>