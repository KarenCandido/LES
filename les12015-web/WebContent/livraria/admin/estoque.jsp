<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Administrador - Estoque </title>
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
	    	<a href="estatisticas.html"><li>Estat�sticas</li></a>
	    	<a href="clientes.html"><li>Clientes</li></a>
	    	<a href="compras.html"><li>Compras</li></a>
	    	<a href="estoque.html"><li>Estoque</li></a>
	    	<a href="livros.html"><li>Livros</li></a>
	    	<li>Sair</li>
	    
	    </ul>
	</div>
	<div class="centro">
		<div class="estoque">
	        <p class="titulo"> ESTOQUE </p>
	
	    	<input type="text" id="busca_clientes" placeholder="Pesquisa"><br>
	    	<table>
	    		<tr>
	    			<td>Produto n� #0000</td>
	    			<td>Quantidade</td>
	    			<td>Status</td>
	                <td style="border:none"><a href="detalhes_livros.html"><input type="button" id="bt_detalhes" value="DETALHES"></a></td>
	                <td style="border:none"><input type="button" id="bt_excluir" value="EXCLUIR"></td>
	               
	    		</tr>
	    	</table>
	         <a href="adicionar_livro.html"><input type="button" id="add_produto" value="Adicionar Outro"></a>
	    </div>	
	</div>
	</div> 
	<div class="rodape"></div>
</body>
</html>