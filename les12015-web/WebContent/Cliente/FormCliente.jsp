<%@ page import="les12015.core.util.ConverteDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Cliente</title>
</head>
<!--  Header import -->
<c:import url="../Template/Header.jsp"></c:import>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<c:if test="${cliente != null }">
			<h1>Atualizar Cliente</h1>
		</c:if>
		<c:if test="${cliente == null }">
			<h1>Cadastro de Cliente</h1>
		</c:if>

	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="box box-defaul">
					<!-- form start -->
					<form role="form" action="CRUDCliente" method="post"
						class="form-horizontal">

						<div class="box-body">
							<div class="form-group">
								<!-- <label for="txtId">Id:</label>   -->
								<input type="hidden" class="form-control" id="idCliente"
									name="idCliente" value="${cliente.getId()}">
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">Nome do Cliente</label>
								<div class="col-sm-10">
									<input required type="text" class="form-control" id="nome"
										name="nome" placeholder="Entre com o nome"
										value="${cliente.getNome()}">
								</div>
							</div>

						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Data de Nascimento</label>
							<div class="col-sm-4">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input required type="text" id="dtNasc" name="dtNasc"
										class="form-control" data-inputmask="'alias': 'dd/mm/yyyy'"
										data-mask value="${cliente.getDtNasc()}">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">E-mail</label>
							<div class="col-sm-8">
								<input required type="text" class="form-control" id="email"
									name="email" placeholder="Entre com o e-mail"
									value="${cliente.getEmail()}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">CPF</label>
							<div class="col-sm-6">
								<input required type="text" class="form-control" id="paginas"
									name="paginas" placeholder="Entre com o CPF"
									value="${cliente.getCpf()}">
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Genero</label>
								<div class="col-sm-4">
									<div class="radio">
										<label><input
											${cliente.getGenero() == true ? 'checked' : '' } type="radio"
											name="status" value="true">Feminino</label>
									</div>
									<div class="radio">
										<label><input
											${cliente.getGenero() == false ? 'checked' : '' }
											type="radio" name="status" value="false">Masculino</label>
									</div>
								</div>
							</div>
							<div class="box-footer">
								<c:if test="${cliente.getId() != null}">
									<button type='submit' class='btn btn-default' id='operacao'
										name='operacao' value='ALTERAR'>ALTERAR</button>

								</c:if>
								<c:if test="${cliente.getId() == null}">
									<button type='submit' class='btn btn-default' id='operacao'
										name='operacao' value='SALVAR'>SALVAR</button>
								</c:if>
							</div>
						</div>
					</form>
				</div>
				<!-- /.box -->
			</div>
			<!--/.col (right) -->
		</div>
		<!-- /.row -->
	</section>
	<!-- /.content section -->
</div>
<!-- /.content-wrapper -->
<!--  Footer import -->
<c:import url="../Template/Footer.jsp"></c:import>