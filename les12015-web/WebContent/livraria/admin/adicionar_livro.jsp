<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Administrador - Estoque </title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
<script type="text/javascript"></script>
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
    	<div class="add_produtos" id="wrapper">
            <p class="titulo"> Estoque </p>
        	<form>
<!--         	<input type="text" id="prod_titulo" placeholder="Título"><br> -->
            <select required id="idLivro" name="idLivro">
                <c:forEach items="${livros}" var="l">
                    <option value="${l.getId()}" ${livro.getId().contains(l.getId()) ? 'selected' : ''}>
                        ${l.getTitulo()}
                    </option>
                </c:forEach>
            </select><br>
               <label>Quantidade</label>
               	<input type="text" id="qtdeEntrada" name="qtdeEntrada" value="${estoque.getQtdeEntrada()}" />
               <button type="button" id="aumentaAcrescimo">+</button>
               <button type="button" id="diminuiAcrescimo">-</button>
              
              <input type="text" id="valorCusto" name="valorCusto" placeholder="Preço de Custo" 
               name="qtdeEntrada" value="${estoque.getValorCusto()}" />
               <br>
              
               <input type="text" id="fornecedor"  placeholder="Fornecedor"><br><br><br>
				<select required id="idFornecedor" name="idFornecedor">
	                <c:forEach items="${fornecedores}" var="f">
	                    <option value="${f.getId()}" ${fornecedor.getId().contains(f.getId()) ? 'selected' : ''}>
	                        ${f.getNome()}
	                    </option>
	                </c:forEach>
	            </select><br>
	            
               <input type="button" id="bt_voltar" value="Voltar" onclick="history.back()" >
               <input type="button" id="bt_cancelar" value="Cancelar" onclick="history.back()"  >
               <input type="button" id="bt_excluir" value="Excluir" >
               <input type="button" id="bt_salvar" value="Salvar" >

   		</form>
       
        
        </div>	
    </div>
</div> 
<div class="rodape"></div>
</body>
</html>
<script>
	$("#prod_quantidade").val(0);
	
	$("#aumentaAcrescimo").click(function () {
		var input = $("#prod_quantidade")[0];
		input.value = parseInt(input.value, 10) + 1;
	});
	
	$("#diminuiAcrescimo").click(function () {
		var input = $("#prod_quantidade")[0];
		var decrescimo = parseInt(input.value, 10) - 1;
		input.value = decrescimo < 1 ? 0 : decrescimo;
	});
</script>