<%@ page import="les12015.core.util.ConverteDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Administrador - Livros </title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
<script type="text/javascript"><script>
function confirmAlert() {
    confirm("Confirmar Exclusão");
}
</script>
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
        	<a href="clientes.jsp"><li>Clientes</li></a>
        	<a href="compras.jsp"><li>Compras</li></a>
        	<a href="estoque.jsp"><li>Estoque</li></a>
        	<a href="CRUDLivros?&operacao=GETALLBOOKS"><li>Livros</li></a>
        	<li>Sair</li>
        </ul>
	</div>
    <div class="centro">
    	<div class="livros">
            <p class="titulo"> Livros </p>
        	<input type="text" id="busca_clientes" placeholder="Pesquisa"><br>
        	<table>
        		<tr>
        			<td style="width:65%;">Título</td>
        			<td style="width:15%;">Quantidade</td>
                    <td style="border:none"></td>
                    <td style="border:none"></td>
        		</tr>
        		<c:forEach items="${livros}" var="l">
        		<tr>
        			<td>${l.getTitulo()}</td>
        			<td></td>
        			<td style="border:none;width:15%;"><a href="CRUDLivros?&operacao=VISUALIZAR&idLivro=${l.getId()}"><input type="button" id="bt_detalhes" value="DETALHES"></a></td>
                    <td style="border:none; width:15%;"><a href="CRUDLivros?&operacao=EXCLUIR&idLivro=${l.getId()}" onclick="confirmAlert()"><input type="button" id="bt_excluir" onclick="confirmAlert()" value="EXCLUIR"></a></td>
        		</tr>
        		
        		</c:forEach>
        	</table>
             <a href="CRUDLivros?&operacao=NEWBOOK"><input type="button" id="add_produto" value="Adicionar Outro"></a>
        </div>	
    </div>
</div> 
<div class="rodape"></div>
</body>
</html>