<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Livraria Fatec - Administrador - Livros </title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css">
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
        	<a href="estatisticas.html"><li>Estatísticas</li></a>
        	<a href="clientes.html"><li>Clientes</li></a>
        	<a href="compras.html"><li>Compras</li></a>
        	<a href="estoque.html"><li>Estoque</li></a>
        	<a href="livros.html"><li>Livros</li></a>
        	<li>Sair</li>
        
        </ul>
	</div>
    <div class="centro">
    	<div class="add_livros" id="wrapper">
            <p class="titulo"> Livros </p>
        	<form>
                <input type="text" id="livro_titulo" placeholder="Título"><br>
                <input type="text" id="livro_autor" placeholder="Autor" /> 
                <input type="button" name="add" id="adicionar" value="+" />
                <fieldset id="inputs_adicionais"></fieldset><br>

                <input type="text" id="livro_editora" placeholder="Editora">
                <div style="width:100%; display:table; margin:20px 0;">
                    <input id="livro_cat1" type="checkbox"><label> Categoria 1</label>
                    <input id="livro_cat2" type="checkbox"><label> Categoria 2</label>
                    <input id="livro_cat3" type="checkbox"><label> Categoria 3</label>
                    <input id="livro_cat4" type="checkbox"><label> Categoria 4</label>
                    <input id="livro_cat5" type="checkbox"><label> Categoria 5</label><br>
                    <input id="livro_cat6" type="checkbox"><label> Categoria 6</label>
                    <input id="livro_cat7" type="checkbox"><label> Categoria 7</label>
                    <input id="livro_cat8" type="checkbox"><label> Categoria 8</label>
                    <input id="livro_cat9" type="checkbox"><label> Categoria 9</label>
                    <input id="livro_cat10" type="checkbox"><label> Categoria 10</label>
                </div>
                <input type="text" id="livro_ano" placeholder="Ano">
                <input type="text" id="livro_edicao" placeholder="Edição">
                <input type="text" id="livro_isbn" placeholder="ISBN">
                <input type="text" id="livro_codigo" placeholder="Código de Barras">
                <input type="text" id="livro_preco_custo" placeholder="Preço de Custo">
                <input type="text" id="livro_altura" placeholder="Altura">
                <input type="text" id="livro_largura" placeholder="Largura">
                <input type="text" id="livro_peso" placeholder="Peso">
                <input type="text" id="livro_profundidade" placeholder="Profundidade">
                <select>
                	<option>Grupo de Precificação</option>
                	<option></option>
                	<option></option>
                </select>
                <input type="button" id="bt_voltar" value="Voltar" onclick="history.back()" >
                <input type="button" id="bt_cancelar" value="cancelar" onclick="history.back()"  >
                <input type="button" id="bt_excluir" value="Excluir" >
                <input type="button" id="bt_salvar" value="Salvar" >

    		</form>
        
        
        </div>	
    </div>
</div> 
<div class="rodape"></div>
</body>
</html>

