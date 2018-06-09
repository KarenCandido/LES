<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Login</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
</head>

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
		<p class="titulo">Já sou cliente</p>
		<div class="login">
			<input type="text" id="login" placeholder="Endereço de E-mail"><br>
			<input type="text" id="senha" placeholder="Senha"><br> <input
				type="button" id="bt_login" value="Entrar">
			<p>
				Ainda não é cadastrado? <a href="cadastro_dados.jsp">Clique
					aqui!</a>
		</div>
	</div>
	<div class="rodape"></div>
</body>
</html>