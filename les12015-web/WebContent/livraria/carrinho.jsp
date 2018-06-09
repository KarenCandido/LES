<%@page import="java.util.ArrayList"%>
<%@page import="les12015.dominio.ItemPedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.getSession(); %>
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
 <%
     List<ItemPedido> listItem = new ArrayList<ItemPedido>();
     listItem = (List<ItemPedido>) session.getAttribute("item");
     double total=0;
 %>
<body>
	<div class="topo">
		<div class="logo">
			<img src="imagens/logo.png" width="100%">
		</div>
		<div class="menu">
			<div id="menu">
				<ul>
					<a href="index.jsp"><li>Home</li></a>
					<a href="quem_somos.jsp"><li>Quem Somos</li></a>
					<a href="livros.jsp"><li>Livros</li></a>
					<a href="contato.jsp"><li>Contato</li></a>
					<a href="login.jsp"><li>Login</li></a>
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
						<th><b class="vermelho">PREÇO</b></th>
						<th><b class="vermelho">QUANTIDADE</b></th>
						<th><b class="vermelho">SUBTOTAL</b></th>
					</tr>
		              <%if(session.getAttribute("item") != null){%>
                        <c:forEach items="${livros}" var="livro">
                            <tr>
                                <td></td>
                                <td>${item.getLivro().getTitulo()}</td>
                                <td>${item.getLivro().getPrecoVenda()}</td>
                                <td>${item.getQtdeLivro()}</td>
                                <td>R$: ${item.getQtdeLivro()*item.getLivro().getPrecoVenda()} </td>
                            </tr>
                        </c:forEach>
		              </tr>
		                  <%}else{%>
		                    <center><h2 style="color: red">Não há produtos adicionados!!</h2></center>
		                  <%}%>
		            </tr>
				</table>
			</div>

			<div class="col2"></div>
		</div>
	</div>
	<div class="rodape"></div>
</body>
</html>