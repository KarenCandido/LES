<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec</title>
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
		<input type="text" name="pesquisa" id="pesquisa" placeholder="Pesquisa">
        <p> Pesquisa Avan�ada:</p>
		<input type="text" name="titulo" id="titulo" placeholder="T�tulo"><br>
		<input type="text" name="autor" id="autor" placeholder="Autor"><br>
		<input type="text" name="categoria" id="categoria" placeholder="Categoria"><br>
		<input type="text" name="editora" id="editora" placeholder="Editora"><br>
		<input type="text" name="ano" id="ano" placeholder="ano"><br>
		<input type="text" name="edicao" id="edicao" placeholder="Edi��o"><br>
		<input type="text" name="isbn" id="isbn" placeholder="ISBN"><br>
        <input type="button" id="pesquisa" value="pesquisar" >
	</div>
    <div class="centro">
    	<p class="titulo"> Destaques </p>
    
    </div>
</div>
<div class="rodape"></div>
</body>
</html>