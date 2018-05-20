<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Livraria Fatec - Cadastro de Dados </title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css">

</head>

<body>

<div class="topo">
	<div class="logo">
    	<img src="imagens/logo.png" width="100%">
	</div>
	<div class="menu">
		<div id="menu">
        	<ul>
        		<a href="index.html"><li>Home</li></a>
        		<a href="quem_somos.html"><li>Quem Somos</li></a>
        		<a href="livros.html"><li>Livros</li></a>
        		<a href="contato.html"><li>Contato</li></a>
        		<a href="login.html"><li>Login</li></a>
            </ul>
        </div>
	</div>
</div>

<div class="wrapper">
    <p class="titulo"> Cadastro de dados </p>
	<div class="cadastro_dados">
        <input type="text" id="cad_email" placeholder="Endereço de E-mail"><br>
        <input type="text" id="cad_senha" placeholder="Senha"> - minimo 8 caracteres<br>
        <input type="text" id="cad_confirma_senha" placeholder="Confirmar Senha"> - letras maiusculas e minusculas<br>
        <input type="text" id="cad_nome" placeholder="Nome">
        <input type="text" id="cad_cpf" placeholder="CPF">
        <input type="text" id="cad_dt_nasc" placeholder="Data de nascimento">
        <select id="cad_sexo">
        	<option value="Selecione"> Selecione...</option>
        	<option value="Masculino"> Masculino</option>
        	<option value="Feminino"> Feminina</option>
        </select><br>
        <input type="text" id="cad_telefone" placeholder="Telefone">
        <input type="text" id="cad_celular" placeholder="Celular"><br>
        <input type="button" id="bt_cancelar" value="Cancelar" >
        <input type="button" id="bt_salvar" value="Salvar" >

	</div>
</div> 
<div class="rodape"></div>
</body>
</html>
