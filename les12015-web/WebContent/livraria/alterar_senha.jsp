<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Alterar Senha</title>
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
		<div class="lateral">
			<ul>
				<a href="perfil.jsp"><li>Perfil</li></a>
				<a href="alterar_senha.jsp"><li>Alterar Senha</li></a>
				<a href="endereco.jsp"><li>Endereços</li></a>
				<a href="cartoes.jsp"><li>Cartões</li></a>
				<a href="pedidos.jsp"><li>Pedidos</li></a>
				<a href="cupons.jsp"><li>Cupons</li></a>
				<a href="trocas.jsp"><li>Trocas</li></a>
				<li>Sair</li>

			</ul>
		</div>
		<div class="centro">
			<p class="titulo">Alterar Senha</p>
			<div class="cadastro_dados">
				<form>
					<input type="text" id="cad_email" placeholder="Endereço de E-mail"><br>
					<input type="text" id="cad_senha" placeholder="Senha"> -
					minimo 8 caracteres<br> <input type="text"
						id="cad_confirma_senha" placeholder="Confirmar Senha"> -
					letras maiusculas e minusculas<br> <input type="button"
						id="bt_cancelar" value="Cancelar"> <input type="button"
						id="bt_salvar" value="Salvar">
				</form>
			</div>
		</div>
	</div>
	<div class="rodape"></div>
</body>
</html>