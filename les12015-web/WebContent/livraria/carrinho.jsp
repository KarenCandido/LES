<%@page import="java.util.ArrayList"%>
<%@page import="les12015.dominio.ItemPedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.getSession();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
<script type="text/javascript"></script>
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
		<div class="carrinho">
			<p class="titulo">Carrinho</p>
			<div class="col1">
				<table width="100%;">
					<tr>
						<th><b class="vermelho">ITEM</b></th>
						<th><b class="vermelho">PRE�O</b></th>
						<th><b class="vermelho">QUANTIDADE</b></th>
						<th><b class="vermelho">SUBTOTAL</b></th>
					</tr>
					<c:if test="${itens != null}">
						<c:forEach items="${itens}" var="item">
							<tr>
								<td>${item.getLivro().getTitulo()}</td>
								<td>R$ <b class="vermelho">${item.getLivro().getPrecoVenda()}</b></td>
								<%-- 	                                <td><input type="number" id="qtde" name="qtde" min="1" max="${l.getQtde_venda()}"  --%>
								<%-- 	                                	value="${item.getQtdeLivro()}" style="width: 3em;" required></td> --%>
								<td>${item.getQtdeLivro()}</td>
								<td>R$ <b class="vermelho">${item.getSubTotal()}</b></td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${itens == null}">
						<center>
							<h2 style="color: red">N�o h� produtos adicionados!</h2>
						</center>
					</c:if>
				</table>
				<a href="ShowLivros?&operacao=EXIBIR"><input type="button"
					id="continuar_comprando" value="Continuar Comprando"
					style="width: 15em;"></a>
				<p class="total">
					Total: R$ <b class="vermelho">${total}</b>
				</p>

			</div>
			<div class="col2">
				<!-- coloque aqui as coisas -->
				SELECT e form!!!!!!<input type="text" id="end_cep" placeholder="CEP"> Cupom


			</div>
		</div>

	</div>
	<div class="rodape"></div>
</body>
</html>