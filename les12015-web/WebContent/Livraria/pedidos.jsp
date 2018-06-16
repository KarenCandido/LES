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
<title>Livraria Fatec - Meus Pedidos</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
</head>

<body>
<jsp:include page="menu.jsp"/>
	<div class="wrapper">
		<jsp:include page="perfil_lateral.jsp"/>
		<div class="centro">
			<p class="titulo">Histórico de Pedidos</p>
			<div class="pedidos">
				<table>
					<tr>
						<td>Pedido nº #0000</td>
						<td>Data</td>
						<td>Produtos</td>
						<td>Valor</td>
						<td>Status</td>
						<td style="border: none"><input type="button" id="bt_detalhes" value="DETALHES"></td>
					</tr>
				</table>

			</div>
		</div>
	</div>
	<div class="rodape"></div>
</body>
</html>