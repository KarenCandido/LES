<%@page import="java.util.ArrayList"%>
<%@page import="les12015.dominio.ItemPedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.getSession();
%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Cartões</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
</head>
</head>
<body>
	<div class="topo">
		<div class="logo">
			<img src="imagens/logo.png" width="100%">
		</div>
		<div class="menu">
			<div id="menu">
				<ul>
					<a href="ShowLivros?&operacao=EXIBIR"><li>Home</li></a>
					<a href="quem_somos.jsp"><li>Quem Somos</li></a>
					<a href="ShowLivros?&operacao=EXIBIR"><li>Livros</li></a>
					<!-- 					<a href="contato.jsp"><li>Contato</li></a> -->
					<a href="login.jsp"><li>Login</li></a>
					<a href="CRUDCompra?&operacao=GETITENS"><li>Carrinho</li></a>
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

			<p class="titulo">Cartões</p>
			
			<div class="cadastro_cartao">
			<form>
				<input type="checkbox" value="principal">
				<b class="vermelho">Cartão Principal</b><br>
				
				<input type="text" id="numero" name="numero" placeholder="Número do Cartão"
						value="${cartao.getNumero()}">${cartao.getNumero()}>
				
				<select id="bandeira" name="bandeira">
					<option value="mastercad">MasterCard</option>
					<option value="visa">Visa</option>	
				</select><br>
				
				<input type="text" id="nome_impresso" name="nome_impresso" placeholder="Nome Impresso no Cartão" 
						value="${cartao.getNomeImpresso()}">${cartao.getNomeImpresso()}>
				<input type="text" id="codigo_seguranca" name="codigo_seguranca" placeholder="Código de Segurança"
						value="${cartao.getCodigoSeguranca()}">${cartao.getCodigoSeguranca()}><br>
				<br>
				
				<input type="checkbox" value="secundario">
					<b class="vermelho">Cartão Secundário</b><br>
					
				<input type="text" id="numero" name="numero" placeholder="Número do Cartão"
						value="${cartao.getNumero()}">${cartao.getNumero()}>
				
				<select id="bandeira" name="bandeira">
					<option value="Selecione">Selecione</option>
					<option value="mastercad">MasterCard</option>
					<option value="visa">Visa</option>
				</select><br>
				
				<input type="text" id="nome_impresso" name="nome_impresso" placeholder="Nome Impresso no Cartão"
						value="${cartao.getNomeImpresso()}">${cartao.getNomeImpresso()}>
				<input type="text" id="codigo_seguranca" name="codigo_seguranca" placeholder="Código de Segurança"
						value="${cartao.getCodigoSeguranca()}">${cartao.getCodigoSeguranca()}><br>


				<input type="button" id="bt_adicionar" value="Adicionar Outro">
				<input type="button" id="bt_cancelar" value="Cancelar">
				<input type="button" id="bt_excluir" value="Excluir">
				<c:if test="${cartao.getId() != null}">
                    <input type='submit' id='bt_alterar' value='ALTERAR' id='operacao' name='operacao'>
                </c:if>
                <c:if test="${cartao.getId() == null}">
                    <input type='submit' id='bt_salvar' value='SALVAR' id='operacao' name='operacao'>
                </c:if>
			</form>
			</div>
		</div>
		<div class="rodape"></div>
</body>
</html>