<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Administrador - Detalhes de Compra </title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
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
		<div class="compras_detalhes" id="wrapper">
	        <p class="titulo"> Compras </p>
	    	<form>
	            <input type="text" id="com_num_ped" placeholder="Pedido nº #000">
	            <input type="text" id="com_cliente" placeholder="Cliente nº #000">
	            <input type="button" id="bt_ver_cliente" value="Ver Cliente" > <br>
	            <textarea id="com_produtos" placeholder="Produtos"></textarea><br>
	            <select id="com_status">
	                <option value="Selecione"> Selecione...</option>
	                <option value="Masculino"> Masculino</option>
	                <option value="Feminino"> Feminina</option>
	            </select>
	            <input type="text" id="com_valor" placeholder="Valor"><br>
	            <select id="com_cartao">
	                <option value="Selecione"> Selecione...</option>
	                <option value="Masculino"> Masculino</option>
	                <option value="Feminino"> Feminina</option>
	            </select>
	            <select id="com_cupom">
	                <option value="Selecione"> Selecione...</option>
	                <option value="Masculino"> Masculino</option>
	                <option value="Feminino"> Feminina</option>
	            </select><br>
	            <input type="text" id="com_endereco" placeholder="Endereço de Entrega">
	            	
	            <input type="button" id="bt_voltar" value="Voltar"  onclick="history.back()" >
	            <input type="button" id="bt_salvar" value="Salvar" >
			</form>
	    </div>	
	</div>
	</div> 
	<div class="rodape"></div>
</body>
</html>