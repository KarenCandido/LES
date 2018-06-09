<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Perfil de Usuário</title>
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
			<center>
				<img src="imagens/premium.png">
			</center>
			<div class="cadastro_dados">
				<input type="text" id="cad_email" placeholder="Endereço de E-mail"><br>
				<input type="text" id="cad_nome" placeholder="Nome"> <input
					type="text" id="cad_cpf" placeholder="CPF"> <input
					type="text" id="cad_dt_nasc" placeholder="Data de nascimento">
				<select id="cad_sexo">
					<option value="Selecione">Selecione...</option>
					<option value="Masculino">Masculino</option>
					<option value="Feminino">Feminina</option>
				</select><br> <input type="text" id="cad_telefone"
					placeholder="Telefone"> <input type="text" id="cad_celular"
					placeholder="Celular"><br> <input type="button"
					id="bt_cancelar" value="Cancelar"> <input type="button"
					id="bt_excluir" value="Excluir"> <input type="button"
					id="bt_salvar" value="Salvar">

			</div>
		</div>
	</div>
	<div class="rodape"></div>
</body>
</html>