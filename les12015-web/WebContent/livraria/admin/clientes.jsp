<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Administrador - Clientes </title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
<script type="text/javascript"> </script>
</head>

<body>
	<div class="wrapper">
		<div class="lateral">
	    	<div class="logo">
	            <img src="imagens/logo.png" width="100%"><br>
	            <br><center><p>Bem-vindo, Administrador</p></center>
	        </div>
	
			<ul>
				<a href="estatisticas.jsp"><li>Estat�sticas</li></a>
				<a href="CRUDCliente?&operacao=CONSULTAR"><li>Clientes</li></a>
				<a href="compras.jsp"><li>Compras</li></a>
				<a href="CRUDEstoque?&operacao=CONSULTAR"><li>Estoque</li></a>
				<a href="CRUDLivros?&operacao=CONSULTAR"><li>Livros</li></a>
				<li>Sair</li>
	        </ul>
		</div>
	    <div class="centro">
	    	<div class="clientes" id="wrapper">
	            <p class="titulo"> Clientes </p>
	        	<input type="text" id="busca_clientes" placeholder="Pesquisa"><br>
	        	<table>
	        		<tr>
	        			<td>Cliente n� #0000</td>
	        			<td>CPF</td>
	                    <td style="border:none"><a href="clientes_detalhes.html"><input type="button" id="bt_detalhes" value="DETALHES"></a></td>
	                    <td style="border:none"><input type="button" id="bt_excluir" value="EXCLUIR"></td>
	        		</tr>
					<c:forEach items="${clientes}" var="c">
						<tr>
							<td>${c.getNome()}</td>
							<td>${c.getCpf()}</td>
							<td style="border:none;width:15%;"><a href="CRUDCliente?&operacao=VISUALIZAR&idCliente=${c.getId()}"><input type="button" id="bt_detalhes" value="DETALHES"></a></td>
							<td style="border:none; width:15%;"><a href="CRUDCliente?&operacao=EXCLUIR&idCliente=${c.getId()}" onclick="confirmAlert()">
									<input type="button" id="bt_excluir" onclick="confirmAlert()" value="EXCLUIR"></a></td>
						</tr>

					</c:forEach>
	        	</table>
	        </div>	
	    </div>
	</div> 
	<div class="rodape"></div>
</body>
</html>