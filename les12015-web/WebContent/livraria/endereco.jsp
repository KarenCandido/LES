<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Endere�os </title>
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
        	<a href="endereco.jsp"><li>Endere�os</li></a>
        	<a href="cartoes.jsp"><li>Cart�es</li></a>
        	<a href="pedidos.jsp"><li>Pedidos</li></a>
        	<a href="cupons.jsp"><li>Cupons</li></a>
        	<a href="trocas.jsp"><li>Trocas</li></a>
        	<li>Sair</li>
        
        </ul>
	</div>
    <div class="centro">
    	<p class="titulo"> Endere�os </p>
    	<div class="cad_endereco">
            <select id="end_endereco">
                <option value="Tipo de Endere�o"> Tipo de Endere�o</option>
                <option value="Endere�o de Cobran�a"> Endere�o de Cobran�a</option>
                <option value="Endere�o de Entrega"> Endere�o de Entrega</option>
            </select><br>

        	<input type="text" id="end_cep" placeholder="CEP"> Consultar CEP
            <input type="text" id="end_residencia" placeholder="Tipo de Resid�ncia">
            <input type="text" id="end_logradouro" placeholder="Logradouro">
            <input type="text" id="end_numero" placeholder="N�">
            <input type="text" id="end_bairro" placeholder="Bairro"><br>
            <input type="text" id="end_cidade" placeholder="Cidade">
            <select id="end_estado">
                <option value="Estado"> Estado...</option>
                <option value="S�o Paulo"> S�o Paulo</option>
            </select>
            <select id="end_pais">
                <option value="Pa�s"> Pa�s...</option>
                <option value="Brasil"> Brasil</option>
            </select>
            <input type="text" id="end_obs" placeholder="Observa��o">
            <input type="button" id="bt_adicionar" value="Adicionar Outro" >
            <input type="button" id="bt_cancelar" value="Cancelar" >
            <input type="button" id="bt_excluir" value="Excluir" >
            <input type="button" id="bt_salvar" value="Salvar" >
        </div>
    </div>
</div> 
<div class="rodape"></div>
</body>
</html>