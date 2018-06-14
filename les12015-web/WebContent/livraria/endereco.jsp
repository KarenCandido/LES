<%@page import="java.util.ArrayList"%>
<%@page import="les12015.dominio.ItemPedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.getSession(); %><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livraria Fatec - Endereços </title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
<link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
</head>

<body>
<jsp:include page="menu.jsp"/>

<div class="wrapper">
    <jsp:include page="perfil_lateral.jsp"/>
    <div class="centro">
    	<p class="titulo"> Endereços </p>
    	<div class="cad_endereco">
    	<form>
            <select id="tipo_endereco" name="tipo_endereco">
                <option value="Cobrança" ${endereco.getTipoEndereco().equalsIgnoreCase("Cobrança") ? 'selected' : ''}> Endereço de Cobrança</option>
                <option value="Entrega" ${endereco.getTipoEndereco().equalsIgnoreCase("Entrega") ? 'selected' : ''}> Endereço de Entrega</option>
            </select><br>

        	<input type="text" id="cep" name="cep" placeholder="CEP"
        			value="${endereco.getCep()}">
            <input type="text" id="tipo_residencia" name="tipo_residencia" placeholder="Tipo de Residência"
            		value="${endereco.getTipoResidencia()}">
            <input type="text" id="tipo_logradouro" name="tipo_logradouro" placeholder="Tipo de Logradouro"
            		value="${endereco.getTipoLogradouro()}">
            <input type="text" id="logradouro" name="logradouro" placeholder="Logradouro"
            		value="${endereco.getLogradouro()}">
            <input type="text" id="numero" name="numero" placeholder="Nº"
            		value="${endereco.getNumero()}">
            <input type="text" id="bairro" name="bairro" placeholder="Bairro"
            		value="${endereco.getBairro()}">

            <select id="idCidade" name="idCidade" placeholder="Cidade">
            		<c:forEach items="${cidades}" var="c">
	                    <option value="${c.getId()}" ${endereco.getCidade().getId() == c.getId() ? 'selected' : ''}>
	                        ${c.getNome()}
	                    </option>
	                </c:forEach>
	        </select>

            <select id="estado" name="estado">
                	<c:forEach items="${estados}" var="e">
	                    <option value="${e.getId()}" ${endereco.getCidade().getEstado().getId() == e.getId() ? 'selected' : ''}>
	                        ${e.getNome()}
	                    </option>
	            	</c:forEach>
            </select>
           
            <select id="pais" name="pais">
                <c:forEach items="${paises}" var="p">
	                   <option value="${p.getId()}" ${endereco.getCidade().getEstado().getPais().getId() == p.getId() ? 'selected' : ''}>
	                        ${p.getNome()}
	                   </option>
	            </c:forEach>
            </select>
            
            <input type="text" id="obs" name="obs" placeholder="Observação" value="${endereco.getObservacao()}">
            <br>
            
            <input type="button" id="bt_adicionar" value="Adicionar Outro" >
            
            <input type="button" id="bt_cancelar" value="Cancelar" >
            <input type="button" id="bt_excluir" value="Excluir" >
            <c:if test="${endereco.getId() != null}">
                   <input type='submit' id='bt_alterar' value='ALTERAR' id='operacao' name='operacao'>
            </c:if>
            <c:if test="${endereco.getId() == null}">
                   <input type='submit' id='bt_salvar' value='SALVAR' id='operacao' name='operacao'>
            </c:if>
        </form>
        </div>
    </div>
</div> 
<div class="rodape"></div>
</body>
</html>