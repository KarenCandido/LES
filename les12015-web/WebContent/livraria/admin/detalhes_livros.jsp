<%@ page import="les12015.core.util.ConverteDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Livraria Fatec - Administrador - Livros </title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	var input = '<label><input type="text" id="livro_autor" placeholder="Autor" /> <a href="#" class="remove">X</a></label>';

	$("input[name='add']").click(function( e ){
		$('#inputs_adicionais').append( input );
	});

	$('#inputs_adicionais').delegate('a','click',function( e ){
		e.preventDefault();
		$( this ).parent('label').remove();
	});

});

window.onmousedown = function (e) {
    var el = e.target;
    if (el.tagName.toLowerCase() == 'option' && el.parentNode.hasAttribute('multiple')) {
        e.preventDefault();

        // toggle selection
        if (el.hasAttribute('selected')) el.removeAttribute('selected');
        else el.setAttribute('selected', '');

        // hack to correct buggy behavior
        var select = el.parentNode.cloneNode(true);
        el.parentNode.parentNode.replaceChild(select, el.parentNode);
    }
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
	        	<a href="livros.jsp"><li>Livros</li></a>
	        	<li>Sair</li>
	        
	        </ul>
		</div>
	    <div class="centro">
	    	<div class="add_livros" id="wrapper">
	            <p class="titulo"> Livros </p>
	        	<form action="CRUDLivros" method="post">
	                <input type="text" id="titulo" name="titulo" placeholder="Titulo" value="${livro.getTitulo()}"><br>
					
					<textarea id="sinopse" name="sinopse" placeholder="Sinopse" 
	                		value="${livro.getSinopse()}"></textarea>
					
					<c:set var="autorIds" value='${livro.getAutores().stream().map(Autor::getId).collect(Collectors.toList())}'/>
					<select multiple required id="autor" name="autor" placeholder="Autor">
						<c:forEach items="${autores}" var="a">
							<option value="${a.getId()}"
								${autorIds.contains(a.getId()) ? 'selected' : ''}>${a.getNomeAutor()}
							</option>
						</c:forEach>
					</select>
					
<!-- 	                <select required id="editora"name="editora"> -->
<%-- 						<c:forEach items="${editoras}" var="e"> --%>
<%-- 							<option value="${e.getId()}">${livro.getEditora().getNome()}</option> --%>
<%-- 								${livro.getEditora().getId() == e.getId() ? 'selected' : ''}>${e.getNomeEditora()} --%>
<!-- 							</option> -->
<%-- 						</c:forEach> --%>
<!-- 					</select> -->
	                
<!-- 	                <select multiple required id="categoria" name="categoria"> -->
<%-- 						<c:forEach items="${categorias}" var="c"> --%>
<%-- 							<option value="${c.getId()}">${livro.getCategoriaLivro().getNome()}</option> --%>
<%-- 								${livro.getCategoriaLivro().contains(c.getId()) ? 'selected' : ''}>${c.getNomeCategoria()} --%>
<!-- 							</option> -->
<%-- 						</c:forEach> --%>
<!-- 					</select> -->
	                <input type="text" id="ano" name="ano" placeholder="Ano"
	                		value="${livro.getEdicao().getAno()}">
	                
	                <input type="text" id="edicao" name="edicao" placeholder="Edição"
	                		value="${livro.getEdicao().getNumero()}">
	                
	                <input type="text" id="paginas" name="paginas" placeholder="Páginas"
	                		value="${livro.getEdicao().getNumeroPagina()}">
	                		
	                <input type="text" id="isbn" name="isbn" placeholder="ISBN"
	                		value="${livro.getIsbn()}">
	                
	                <input type="text" id="codigoBarras" name="codigoBarras" placeholder="Código de Barras"
	                		value="${livro.getCodigoBarras()}">
	                <br>
	                <input type="text" id="precoVenda" name="precoVenda" placeholder="Preço de Venda"
	                		value="${livro.getPrecoVenda()}">
	                <br>
	                <input type="text" id="altura" name="altura" placeholder="Altura"
	                		value="${livro.getEdicao().getDimensoes().getAltura()}">
	                
	                <input type="text" id="largura" name="largura" placeholder="Largura"
	                		value="${livro.getEdicao().getDimensoes().getLargura()}">
	                
	                <input type="text" id="peso" name="peso" placeholder="Peso"
	                		value="${livro.getEdicao().getDimensoes().getPeso()}">
	                
	                <input type="text" id="profundidade" name="profundidade" placeholder="Profundidade" 
	                		value="${livro.getEdicao().getDimensoes().getProfundidade()}">
	                		
	                <select required id="grupoPrecificacao" name="grupoPrecificacao">
						<c:forEach items="${grupos}" var="g">
							<option value="${g.getId()}"
								${g.getId() == livro.getGrupoPrecificacao().getId() ? 'selected' : ''}>${g.getNomeGrupo()}
								- ${g.getPorcentagemLucro()}</option>
						</c:forEach>
					</select>
	                <input type="button" id="bt_voltar" value="VOLTAR" onclick="history.back()" >
	                <input type="button" id="bt_cancelar" value="CANCELAR" onclick="history.back()"  >
	                <input type="button" id="bt_excluir" value="EXCLUIR" >
	                <c:if test="${livro.getId() != null}">
						<input type='submit' id='bt_alterar' value='ALTERAR' id='operacao' name='operacao'>
					</c:if>
					<c:if test="${livro.getId() == null}">
						<input type='submit' id='bt_salvar' value='SALVAR' id='operacao' name='operacao'>
					</c:if>
	
	    		</form>
	        
	        
	        </div>	
	    </div>
	</div> 
	<div class="rodape"></div>
</body>
</html>

