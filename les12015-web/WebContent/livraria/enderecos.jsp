<%@page import="java.util.ArrayList"%>
<%@page import="les12015.dominio.ItemPedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    request.getSession();
%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Livraria Fatec - Endereços</title>
    <link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
    <link rel="stylesheet" type="text/css" href="css/fonte/fonte.css"></link>
</head>

<body>
<div class="wrapper">
    <jsp:include page="perfil_lateral.jsp"/>

    <div class="centro">
        <div class="enderecos">

            <p class="Endereco"> Endereços </p>
            <input type="text" id="busca_endereco" placeholder="Pesquisa"><br>
            <table>
                <tr>
                    <td style="width:65%;">Tipo de Endereço</td>
                    <td style="width:15%;">Logradouro</td>
                    <td style="border:none"></td>
                    <td style="border:none"></td>
                </tr>
                <c:forEach items="${enderecos}" var="e">
                    <tr>
                        <td>${e.getTipoEndereco()}</td>
                        <td>${e.getLogradouro()}</td>
                        <td style="border:none;width:15%;"><a
                                ///////////////href="CRUDLivros?&operacao=VISUALIZAR&idLivro=${l.getId()}"><input type="button"
                                                                                                                  id="bt_detalhes"
                                                                                                   value="DETALHES"></a>
                        </td>
                       ///////////////// <td style="border:none; width:15%;"><a href="CRUDLivros?&operacao=EXCLUIR&idLivro=${l.getId()}"
                                                               onclick="confirmAlert()"><input type="button"
                                                                                               id="bt_excluir"
                                                                                               onclick="confirmAlert()"
                                                                                               value="EXCLUIR"></a></td>
                    </tr>

                </c:forEach>
            </table>
           ////////// <a href="CRUDLivros?&operacao=NOVO"><input type="button" id="add_produto" value="Adicionar Outro"></a>
        </div>
    </div>
</div>
<div class="rodape"></div>
</body>
</html>