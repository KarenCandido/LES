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
<title>Livraria Fatec - Cadastro de Dados</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
</head>

<body>
<jsp:include page="menu.jsp"/>

	<div class="wrapper">
		<p class="titulo">Cadastro de dados</p>
		<div class="cadastro_dados">
		<form action="CRUDCliente" method="post" >
			<input type="text" id="email" name="email" placeholder="Endereço de E-mail" value="${cliente.getEmail()}"><br>
			<input type="text" id="senha" name="senha" placeholder="Senha" value="${cliente.getSenha()}"><br>
			<input type="text" id="Nome" name="Nome" placeholder="Nome" value="${cliente.getNome()}">
			<input type="text" id="CPF" name="CPF" placeholder="CPF" value="${cliente.getCpf()}">
			<input type="text" id="DtNasc" name="DtNasc" placeholder="Data de nascimento"
					value="${cliente.getDataNascimento()}">
			
							
			<select id="genero" name="genero">
				<option value="Masculino" ${cliente.getGenero().equalsIgnoreCase("Masculino") ? 'selected' : ''}>Masculino</option>
				<option value="Feminino" ${cliente.getGenero().equalsIgnoreCase("Feminino") ? 'selected' : ''}>Feminino</option>
			</select><br>
			
			<input type="text" id="DDD" name="DDD" placeholder="DDD" value="${telefone.getDdd()}">
			<input type="text" id="Telefone" name="Telefone" placeholder="Telefone" value="${telefone.getNumero()}"><br>
			
			<input type="button" id="bt_cancelar" value="Cancelar">
			<input type='submit' value='SALVAR' id='operacao' name='operacao' value= "${cliente.getId() == null}" >
		
		</form>
		</div>
	</div>
	<div class="rodape"></div>
</body>
</html>