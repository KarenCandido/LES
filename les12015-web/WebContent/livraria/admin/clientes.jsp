<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	        	<a href="estatisticas.html"><li>Estatísticas</li></a>
	        	<a href="clientes.html"><li>Clientes</li></a>
	        	<a href="compras.html"><li>Compras</li></a>
	        	<a href="estoque.html"><li>Estoque</li></a>
	        	<a href="livros.html"><li>Livros</li></a>
	        	<li>Sair</li>
	        
	        </ul>
		</div>
	    <div class="centro">
	    	<div class="clientes" id="wrapper">
	            <p class="titulo"> Clientes </p>
	        	<input type="text" id="busca_clientes" placeholder="Pesquisa"><br>
	        	<table>
	        		<tr>
	        			<td>Cliente nº #0000</td>
	        			<td>Classificação</td>
	                    <td style="border:none"><a href="clientes_detalhes.html"><input type="button" id="bt_detalhes" value="DETALHES"></a></td>
	                    <td style="border:none"><input type="button" id="bt_excluir" value="EXCLUIR"></td>
	        		</tr>
	        	</table>
	        </div>	
	    </div>
	</div> 
	<div class="rodape"></div>
</body>
</html>