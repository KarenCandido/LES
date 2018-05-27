<%@ page import="les12015.core.util.ConverteDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Livro</title>
</head>
<!--  Header import -->
<c:import url="../Template/Header.jsp"></c:import>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<c:if test="${livro != null }">
			<h1>Atualizar Livro</h1>
		</c:if>
		<c:if test="${livro == null }">
			<h1>Cadastro de Livro</h1>
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
					<form role="form" action="CRUDLivro" method="post"
						class="form-horizontal">

						<div class="box-body">
							<div class="form-group">
								<!-- <label for="txtId">Id:</label>   -->
								<input type="hidden" class="form-control" id="idLivro"
									name="idLivro" value="${livro.getId()}">
							</div>


							<div class="form-group">
								<label class="col-sm-2 control-label">Título do Livro</label>
								<div class="col-sm-10">
									<input required type="text" class="form-control" id="titulo"
										name="titulo" placeholder="Entre com nome do livro"
										value="${livro.getTitulo()}">
								</div>

							</div>

						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Sinopse</label>
							<div class="col-sm-10">
								<textarea required rows="5" class="form-control" id="sinopse"
									name="sinopse" placeholder="Entre com a sinopse"> ${livro.getSinopse()} </textarea>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">Editora</label>
							<div class="col-sm-2">
								<select required class="form-control select2" id="editora"
									name="editora">
									<c:forEach items="${editoras}" var="e">
										<option value="${e.getId()}"
											${livro.getEditora().getId() == e.getId() ? 'selected' : ''}>${e.getNomeEditora()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Páginas</label>
							<div class="col-sm-2">
								<input required type="number" class="form-control" id="paginas"
									name="paginas"
									placeholder="Entre com o número de páginas livro"
									value="${livro.getEdicao().getNumeroPagina()}">
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Autor</label>
								<div class="col-sm-4">
									<select multiple required class="form-control select2" id="autor" name="autor">
										<c:forEach items="${autores}" var="a">
											<option value="${a.getId()}"
												${livro.getAutor().getId() == a.getId() ? 'selected' : ''}>${a.getNomeAutor()}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">Edição</label>
								<div class="col-sm-2">
									<input required type="number" class="form-control" id="edicao"
										name="edicao" placeholder="Entre com a edição livro"
										value="${livro.getEdicao().getNumero()}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">Categoria</label>
								<div class="col-sm-4">
									<select required class="form-control select2" id="categoria"
										name="categoria">
										<c:forEach items="${categorias}" var="c">
											<option value="${c.getId()}"
												${livro.getCategoriaLivro().getId() == c.getId() ? 'selected' : ''}>${c.getNomeCategoria()}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Ano</label>
								<div class="col-sm-2">
									<input required type="number" class="form-control" id="ano"
										name="ano" placeholder="Entre com o ano do livro"
										value="${livro.getEdicao().getAno()}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">ISBN</label>
								<div class="col-sm-6">
									<input required type="text" class="form-control" id="isbn"
										name="isbn" placeholder="Entre com a ISBN do livro"
										value="${livro.getIsbn()}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">Código de barras</label>
								<div class="col-sm-6">
									<input required type="text" class="form-control"
										id="codigoBarras" name="codigoBarras"
										placeholder="Entre com o código de barras do livro"
										value="${livro.getCodigoBarras()}">
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label">Preço</label>
								<div class="col-sm-6">
									<input required type="text" class="form-control"
										id="precoVenda" name="precoVenda"
										placeholder="Entre com o código de barras do livro"
										value="${livro.getPrecoVenda()}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">Status</label>
								<div class="col-sm-10">
									<div class="radio">
										<label><input
											${livro.isStatus() == true ? 'checked' : '' } type="radio"
											name="status" value="true">Ativo</label>
									</div>
									<div class="radio">
										<label><input
											${livro.isStatus() == false ? 'checked' : '' } type="radio"
											name="status" value="false">Inativo</label>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">Altura</label>
								<div class="col-sm-2">
									<input required type="number" step=".01" class="form-control"
										id="altura" name="altura"
										placeholder="Entre com a altura livro"
										value="${livro.getEdicao().getDimensoes().getAltura()}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">Largura</label>
								<div class="col-sm-2">
									<input required type="number" step=".01" class="form-control"
										id="largura" name="largura"
										placeholder="Entre com a largura do livro"
										value="${livro.getEdicao().getDimensoes().getLargura()}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Peso</label>
								<div class="col-sm-2">
									<input required type="number" step=".01" class="form-control"
										id="peso" name="peso" placeholder="Entre com a peso do livro"
										value="${livro.getEdicao().getDimensoes().getPeso()}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Profundidade</label>
								<div class="col-sm-2">
									<input required type="number" step=".01" class="form-control"
										id="profundidade" name="profundidade"
										placeholder="Entre com a profunfidade do livro"
										value="${livro.getEdicao().getDimensoes().getProfundidade()}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Grupo de Precificação</label>
								<div class="col-sm-4">
									<select required class="form-control select2"
										id="grupoPrecificacao" name="grupoPrecificacao">
										<c:forEach items="${grupos}" var="g">
											<option value="${g.getId()}"
												${g.getId() == livro.getGrupoPrecificacao().getId() ? 'selected' : ''}>${g.getNomeGrupo()}
												- ${g.getPorcentagemLucro()}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="box-footer">
								<c:if test="${livro.getId() != null}">
									<button type='submit' class='btn btn-default' id='operacao'
										name='operacao' value='ALTERAR'>ALTERAR</button>

								</c:if>
								<c:if test="${livro.getId() == null}">
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