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
<title>Livraria Fatec - Cartões</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
</head>
</head>
<body>
<jsp:include page="menu.jsp"/>

	<div class="wrapper">
        <jsp:include page="perfil_lateral.jsp"/>
		<div class="centro">

			<p class="titulo">Cartões</p>
			
			<div class="cadastro_cartao">
			<form>
				<input type="text" id="idCartao" name="idCartao" value="${cartao.getId()}" hidden>

				<input type="checkbox" value="principal">
				<b class="vermelho">Cartão Principal</b><br>
				
				<input type="text" id="numero" name="numero" placeholder="Número do Cartão"
						value="${cartao.getNumero()}">
				
				<select id="bandeira" name="bandeira">
					<option value="2">MasterCard</option>
					<option value="1">Visa</option>
				</select><br>
				
				<input type="text" id="nome_impresso" name="nome_impresso" placeholder="Nome Impresso no Cartão" 
						value="${cartao.getNomeImpresso()}">
				<input type="text" id="codigo_seguranca" name="codigo_seguranca" placeholder="Código de Segurança"
						value="${cartao.getCodigoSeguranca()}"><br>
				<br>
				<input type="text" id="dt_vencimento" name="dt_vencimento" placeholder="Data de Vencimento"
						value="${cartao.getDataVencimento()}"><br>
				<br>
				
				<%--<input type="checkbox" value="secundario">--%>
					<%--<b class="vermelho">Cartão Secundário</b><br>--%>
					
				<%--<input type="text" id="numero" name="numero" placeholder="Número do Cartão"--%>
						<%--value="${cartao.getNumero()}">--%>
				<%----%>
				<%--<select id="bandeira" name="bandeira">--%>
					<%--<option value="Selecione">Selecione</option>--%>
					<%--<option value="mastercad">MasterCard</option>--%>
					<%--<option value="visa">Visa</option>--%>
				<%--</select><br>--%>
				<%----%>
				<%--<input type="text" id="nome_impresso" name="nome_impresso" placeholder="Nome Impresso no Cartão"--%>
						<%--value="${cartao.getNomeImpresso()}">--%>
				<%--<input type="text" id="codigo_seguranca" name="codigo_seguranca" placeholder="Código de Segurança"--%>
						<%--value="${cartao.getCodigoSeguranca()}"><br>--%>


				<input type="button" id="bt_adicionar" value="Adicionar Outro">
				<input type="button" id="bt_cancelar" value="Cancelar">
				<input type="button" id="bt_excluir" value="Excluir">
				<c:if test="${cartao.getId() != null}">
                    <input type='submit' id='bt_alterar' value='ALTERAR' id='operacao' name='operacao'>
                </c:if>
                <c:if test="${cartao.getId() == null}">
                    <input type='submit' id='bt_salvar' value='SALVAR' id='operacao' name='operacao'>
                </c:if>
			</form>
			</div>
		</div>
		<div class="rodape"></div>
</body>
</html>