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
	<div class="topo">
		<div class="logo">
			<img src="imagens/logo.png" width="100%">
		</div>
		<div class="menu">
			<div id="menu">
				<ul>
					<a href="ShowLivros?&operacao=EXIBIR"><li>Home</li></a>
					<a href="quem_somos.jsp"><li>Quem Somos</li></a>
					<a href="ShowLivros?&operacao=EXIBIR"><li>Livros</li></a>
					<!-- 					<a href="contato.jsp"><li>Contato</li></a> -->
					<a href="login.jsp"><li>Login</li></a>
					<a href="CRUDCompra?&operacao=GETITENS"><li>Carrinho</li></a>
				</ul>
			</div>
		</div>
	</div>

	<div class="wrapper">
		<p class="titulo">Cadastro de dados</p>
		<div class="cadastro_dados">
		<form>
			<input type="text" id="cad_email" placeholder="Endereço de E-mail"><br>
			<input type="text" id="cad_senha" placeholder="Senha"> - mínimo de 8 caracteres<br>
					
			<input type="text" id="cad_confirma_senha" name="cad_confirma_senha" placeholder="Confirmar Senha"> -
					letras maiúsculas e minúsculas<br>
			<input type="text" id="Nome" name="Nome" placeholder="Nome" value="${cliente.getNome()}">${cliente.getNome()}>
			<input type="text" id="CPF" name="CPF" placeholder="CPF" value="${cliente.getCpf()}">${cliente.getCpf()}>
			<input type="text" id="DtNasc" name="DtNasc" placeholder="Data de nascimento"
					value="${cliente.getDataNascimento()}">${cliente.getDataNascimento()}>
			
			<select id="Genero" name="Genero">
				<option value="Masculino">Masculino</option>
				<option value="Feminino">Feminino</option>
			</select><br>
			
			<input type="text" id="DDD" name="DDD" placeholder="DDD" value="${telefone.getDdd()}">${telefone.getDdd()}>
			<input type="text" id="Telefone" name="Telefone" placeholder="Telefone" value="${telefone.getNumero()}">${telefone.getNumero()}><br>
			
			<input type="button" id="bt_cancelar" value="Cancelar">
			<c:if test="${cliente.getId() != null}">
                   <input type='submit' id='bt_alterar' value='ALTERAR' id='operacao' name='operacao'>
            </c:if>
            <c:if test="${cliente.getId() == null}">
                   <input type='submit' id='bt_salvar' value='SALVAR' id='operacao' name='operacao'>
            </c:if>
		</form>
		</div>
	</div>
	<div class="rodape"></div>
</body>
</html>