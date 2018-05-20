<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<title>Livro</title>
</head>
<!--  Header import -->
<jsp:include page="../Template/Header.jsp"></jsp:include>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- coluna principal -->
			<div class="col-md-12">

				<div class="box">
					<div class="box-header">
						<h3 class="box-title">Consulta</h3>
						<div class="box-tools pull-right">
							<a href="CRUDLivro?&operacao=NEWBOOK"><button type="button"
									class="btn btn-block btn-default">
									<i class="fa fa-plus-circle"></i>
								</button></a>
						</div>
						<div class="form-group has-error">
							<label class="control-label"> ${mensagem} </label>
						</div>

					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<div class="row">
							<div class="col-md-12">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>ID</th>
											<th>Título</th>
											<th>Ações</th>
										</tr>
									</thead>

									<c:if test="${livros != null}">
										<c:forEach var="livro" items="${livros}">
											<TR ALIGN='CENTER'>
												<TD>${livro.getId()}</TD>
												<TD>${livro.getTitulo()}</TD>
												<td><a
													href="CRUDLivro?idLivro=${livro.getId()}&operacao=VISUALIZAR"><button
															type="button" class="btn btn-block btn-default">
															<i class="fa fa-eye"></i>
														</button></a> <a
													href="CRUDLivro?idLivro=${livro.getId()}&operacao=INATIVAR"><button
															type="button" class="btn btn-block btn-default">
															<i class="fa fa-trash"></i>
														</button></a></td>
											</TR>
										</c:forEach>
									</c:if>
								</table>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<!--  Footer import -->
<jsp:include page="../Template/Footer.jsp"></jsp:include>