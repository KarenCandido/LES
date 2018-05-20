<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Livraria Fatec - Administrador - Clientes </title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css">
<script src="https://code.jquery.com/jquery-2.1.3.js"></script>

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
    	<div class="add_produtos" id="wrapper">
            <p class="titulo"> Estoque </p>
        	<form>
                <input type="text" id="prod_titulo" placeholder="Título"><br>
                <label>Quantidade</label> <input type="text" id="prod_quantidade"  />
                <button type="button" id="aumentaAcrescimo">+</button>
                <button type="button" id="diminuiAcrescimo">-</button>
                <input type="text" id="prod_preco" placeholder="Preço de Venda"> <br>
                <input type="radio" id="prod_ativo"><label>Ativado</label><input type="radio" id="prod_desativado"><label>Desativado</label>
                
                <input type="text" id="prod_justificativa" placeholder="Justificativa"><br><br><br>
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


