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
<title>Livraria Fatec - Meus Cupons</title>
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
		<div class="lateral">
			<ul>
				<a href="perfil.jsp"><li>Perfil</li></a>
				<a href="alterar_senha.jsp"><li>Alterar Senha</li></a>
				<a href="endereco.jsp"><li>Endereços</li></a>
				<a href="cartoes.jsp"><li>Cartões</li></a>
				<a href="pedidos.jsp"><li>Pedidos</li></a>
				<a href="cupons.jsp"><li>Cupons</li></a>
				<a href="trocas.jsp"><li>Trocas</li></a>
				<li>Sair</li>

			</ul>
		</div>
		<div class="centro">
			<p class="titulo">Cupons</p>
			<div class="cupons">
				<table>
					<tr>
						<td>Cupom nº #0000</td>
						<td>Data</td>
						<td>Tipo</td>
						<td>Valor</td>
						<td>Status</td>
						<td style="border: none"><input type="button"
							id="bt_detalhes" value="DETALHES"></td>
					</tr>
				</table>

			</div>
		</div>
	</div>
	<div class="rodape"></div>
</body>
</html>