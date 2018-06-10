<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.getSession(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
<script type="text/javascript"></script>
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
			<input type="text" name="pesquisa" id="pesquisa"
				placeholder="Pesquisa">
			<p>Pesquisa Avançada:</p>
			<input type="text" name="titulo" id="titulo" placeholder="Título"><br>
			<input type="text" name="autor" id="autor" placeholder="Autor"><br>
			<input type="text" name="categoria" id="categoria"
				placeholder="Categoria"><br> <input type="text"
				name="editora" id="editora" placeholder="Editora"><br>
			<input type="text" name="ano" id="ano" placeholder="ano"><br>
			<input type="text" name="edicao" id="edicao" placeholder="Edição"><br>
			<input type="text" name="isbn" id="isbn" placeholder="ISBN"><br>
			<input type="button" id="pesquisa" value="pesquisar">
		</div>

		<div class="centro" id="home">
            <c:forEach items="${livros}" var="l">
				<form>
                    <div class="bloco">
                        <div id="bloco">
                        	<input type="hidden" id="idLivro" name="idLivro" value="${l.getId()}">
                            <center><img src="imagens/livro.png"></center><br>
                            <p class="descricao" >
                        	<input type="hidden" id="tituloLivro" name="tituloLivro" value="${l.getTitulo()}">
                            ${l.getTitulo()}
                            </p>
                            <p class="preco">
                        	<input type="hidden" id="precoVenda" name="precoVenda" value="${l.getPrecoVenda()}">
                             R$ <b class="vermelho">${l.getPrecoVenda()}</b>
                            </p>
                        </div>
                        <div class="add_carrinho">
                        	<input type="number" id="qtde" name="qtde" min="1" max="${l.getQtde_venda()}" value="1" style="width: 3em;" required>
                            <input type='submit' id="operacao" name="operacao" 
                            	formaction="CRUDCompra?&operacao=ADICIONAR" value='ADICIONAR' style="width: 8em;">
                        </div>
                    </div>
				</form>
            </c:forEach>
		</div>
	</div>
	<div class="rodape"></div>
</body>
</html>