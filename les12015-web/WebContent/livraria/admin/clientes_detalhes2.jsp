<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Livraria Fatec - Administrador - Clientes </title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
<script type="text/javascript">
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
    	<div class="clientes_detalhes" id="wrapper">
            <p class="titulo"> Clientes </p>
        	<form>
                <input type="text" id="cli_numero" placeholder="Cliente n� #000">
                <input type="text" id="cli_pontuacao" placeholder="Pontua��o"> <br>
                <input type="text" id="cli_email" placeholder="Endere�o de E-mail"><br>
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
 