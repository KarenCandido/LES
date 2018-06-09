<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Administrador - Compras </title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
<script type="text/javascript"></script>
</head>

<body>
	<div class="wrapper">
	<div class="lateral">
		<div class="logo">
	        <img src="imagens/logo.png" width="100%"><br>
	        <br><center><p>Bem-vindo, Administrador</p></center>
	    </div>
	
		<ul>
	    	<a href="estatisticas.jsp"><li>Estatísticas</li></a>
        	<a href="clientes.jsp"><li>Clientes</li></a>
        	<a href="compras.jsp"><li>Compras</li></a>
        	<a href="CRUDEstoque?&operacao=CONSULTAR"><li>Estoque</li></a>
        	<a href="CRUDLivros?&operacao=CONSULTAR"><li>Livros</li></a>
	    	<li>Sair</li>
	    </ul>
	</div>
	<div class="centro">
		<div class="compras">
	        <p class="titulo"> Compras </p>
	    	<input type="text" id="busca_clientes" placeholder="Pesquisa"><br>
	    	<table>
	    		<tr>
	    			<td>Pedido nº #0000</td>
	    			<td>Cliente nº #0000</td>
	    			<td>Status</td>
	                <td style="border:none"><a href="compra_detalhes.html"><input type="button" id="bt_detalhes" value="DETALHES"></a></td>
	                <td style="border:none"><input type="button" id="bt_cancelar" value="Cancelar"></td>
	    		</tr>
	    	</table>
	    </div>	
	</div>
	</div> 
	<div class="rodape"></div>
</body>
</html>