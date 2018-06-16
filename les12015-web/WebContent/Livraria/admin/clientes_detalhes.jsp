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
			<a href="CRUDCliente?&operacao=CONSULTAR"><li>Clientes</li></a>
			<a href="compras.jsp"><li>Compras</li></a>
			<a href="CRUDEstoque?&operacao=CONSULTAR"><li>Estoque</li></a>
			<a href="CRUDLivros?&operacao=CONSULTAR"><li>Livros</li></a>
			<li>Sair</li>
	    </ul>
	</div>
	<div class="centro">
		<div class="clientes_detalhes" id="wrapper">
	        <p class="titulo"> Clientes </p>
	    	<form>
	            <input type="text" id="cli_numero" placeholder="Cliente nº #000">
	            <input type="text" id="cli_pontuacao" placeholder="Pontuação"> <br>
	            <input type="text" id="cli_email" placeholder="Endereço de E-mail"><br>
	            <input type="text" id="cli_nome" placeholder="Nome"><br>	
	            <input type="text" id="cli_cpf" placeholder="CPF">
	            <input type="text" id="cli_dt_nasc" placeholder="Data de Nascimento">
	            <select id="cli_sexo">
	                <option value="Selecione"> Selecione...</option>
	                <option value="Masculino"> Masculino</option>
	                <option value="Feminino"> Feminina</option>
	            </select><br>
	            <input type="text" id="cli_telefone" placeholder="Telefone">
	            <input type="text" id="cli_celular" placeholder="Celular">
	            
	            <input type="button" id="bt_voltar" value="Voltar"  onclick="history.back()"  >
			</form>
	    </div>	
	</div>
	</div> 
	<div class="rodape"></div>
</body>
</html>