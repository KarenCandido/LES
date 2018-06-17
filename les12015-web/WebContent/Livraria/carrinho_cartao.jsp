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
	    <div class="carrinho_cartao" >
	    	<p class="titulo"> Carrinho </p>
	        <div class="col1">
	            <div class="cadastro_cartao">
	                <input type="checkbox" value="principal"> <b class="vermelho">Cartão Principal</b><br>
	                <input type="text" id="num_cartao" placeholder="Número do Cartão"> 
	                <select id="bandeira">
	                    <option value="Selecione"> Selecione</option>
	                    <option value="mastercad"> MasterCard</option>
	                    <option value="visa"> Visa</option>
	                    <option value="cielo"> Cielo</option>
	                    <option value="elo"> Elo</option>
	                    <option value="amex"> Amex</option>
	                </select><br>
	        
	                <input type="text" id="nome_cartao" placeholder="Nome Impresso no Cartão">
	                <input type="text" id="cod_seguranca" placeholder="Código de Segurança"><br><br>
	        
	        
	                <input type="checkbox" value="secundario"> <b class="vermelho">Cartão Secundário</b><br>
	                <input type="text" id="num_cartao" placeholder="Número do Cartão"> 
	                <select id="bandeira">
	                    <option value="Selecione"> Selecione</option>
	                    <option value="mastercad"> MasterCard</option>
	                    <option value="visa"> Visa</option>
	                    <option value="cielo"> Cielo</option>
	                    <option value="elo"> Elo</option>
	                    <option value="amex"> Amex</option>
	                </select><br>
	        
	                <input type="text" id="nome_cartao" placeholder="Nome Impresso no Cartão">
	                <input type="text" id="cod_seguranca" placeholder="Código de Segurança"><br>
	        
	        
	                <input type="button" id="bt_adicionar" value="Adicionar Outro" >
	                <input type="button" id="bt_voltar" value="Voltar" >
	        
	            </div>
	        </div>
	        
	        <div class="col2">
	    		<span class="valores">
	                <p>Total do Pedido <span class="titulo">R$139,90</span></p>
	                <p>Frete <span class="titulo">R$20,00</span></p>
	            </span>
	                <p>Total <span class="titulo">R$159,90</span></p>
	            <input type="button" id="bt_finalizar" value="Finalizar Compra" >
	        </div>        
	     </div>   
	</div>
	<div class="rodape"></div>
</body>
</html>