<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Livraria Fatec - Endereços </title>
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
        		<a href="index.html"><li>Home</li></a>
        		<a href="quem_somos.html"><li>Quem Somos</li></a>
        		<a href="livros.html"><li>Livros</li></a>
        		<a href="contato.html"><li>Contato</li></a>
        		<a href="login.html"><li>Login</li></a>
            </ul>
        </div>
	</div>
</div>

<div class="wrapper">
	<div class="lateral">
		<ul>
        	<a href="perfil.html"><li>Perfil</li></a>
        	<a href="alterar_senha.html"><li>Alterar Senha</li></a>
        	<a href="endereco.html"><li>Endereços</li></a>
        	<a href="cartoes.html"><li>Cartões</li></a>
        	<a href="pedidos.html"><li>Pedidos</li></a>
        	<a href="cupons.html"><li>Cupons</li></a>
        	<a href="trocas.html"><li>Trocas</li></a>
        	<li>Sair</li>
        
        </ul>
	</div>
    <div class="centro">
    	<p class="titulo"> Endereços </p>
    	<div class="cad_endereco">
            <select id="end_endereco">
                <option value="Tipo de Endereço"> Tipo de Endereço</option>
                <option value="Endereço de Cobrança"> Endereço de Cobrança</option>
                <option value="Endereço de Entrega"> Endereço de Entrega</option>
            </select><br>

        	<input type="text" id="end_cep" placeholder="CEP"> Consultar CEP
            <input type="text" id="end_residencia" placeholder="Tipo de Residência">
            <input type="text" id="end_logradouro" placeholder="Logradouro">
            <input type="text" id="end_numero" placeholder="Nº">
            <input type="text" id="end_bairro" placeholder="Bairro"><br>
            <input type="text" id="end_cidade" placeholder="Cidade">
            <select id="end_estado">
                <option value="Estado"> Estado...</option>
                <option value="São Paulo"> São Paulo</option>
            </select>
            <select id="end_pais">
                <option value="País"> País...</option>
                <option value="Brasil"> Brasil</option>
            </select>
            <input type="text" id="end_obs" placeholder="Observação">
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
