package les12015.controle.web.vh.impl;

import les12015.controle.web.vh.IViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.core.impl.dao.*;
import les12015.dominio.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroViewHelper implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String operacao = request.getParameter("operacao");

		Livro livro = null; // instancia livro
		if (!operacao.equals("VISUALIZAR")) {

			String id = request.getParameter("idLivro");
			String idStatus = request.getParameter("idStatus");
			String titulo = request.getParameter("titulo");
			String ano = request.getParameter("ano");
			String edicao = request.getParameter("edicao");
			String isbn = request.getParameter("isbn");
			String numero_pagina = request.getParameter("paginas");
			String sinopse = request.getParameter("sinopse");
			String altura = request.getParameter("altura");
			String largura = request.getParameter("largura");
			String profundidade = request.getParameter("profundidade");
			String peso = request.getParameter("peso");
			String codigo_barras = request.getParameter("codigoBarras");
			String preco_venda = request.getParameter("precoVenda");
			String id_grupoPrecificacao = request.getParameter("grupoPrecificacao");
			String id_editora = request.getParameter("editora");
			String[] id_categoria = request.getParameterValues("categoria");
			String status = request.getParameter("status");
			String statusJustificativa = request.getParameter("statusJustificativa");
			String[] id_autor = request.getParameterValues("autor");

			livro = new Livro();
			Edicao e = new Edicao();
			Dimensoes d = new Dimensoes();
            StatusLivro statusLivro = new StatusLivro();

			if (id != null && !id.isEmpty()) {
				livro.setId(Integer.parseInt(id));
			}
			if (idStatus != null && !idStatus.isEmpty()) {
                statusLivro.setId(Integer.parseInt(idStatus));
			}
			if (titulo != null && !titulo.isEmpty()) {
				livro.setTitulo(titulo);
			}
			if (ano != null && !ano.isEmpty()) {
				e.setAno(Integer.parseInt(ano));
			}

			if (edicao != null && !edicao.isEmpty()) {
				e.setNumero(Integer.parseInt(edicao));
			}

			if (isbn != null && !isbn.isEmpty()) {
				livro.setIsbn(isbn);
			}
			if (numero_pagina != null && !numero_pagina.isEmpty()) {

				e.setNumeroPagina(Integer.parseInt(numero_pagina));
			}
			if (sinopse != null && !sinopse.isEmpty()) {
				livro.setSinopse(sinopse);
			}
			if (altura != null && !altura.isEmpty()) {
				d.setAltura(Double.parseDouble(altura));

			}
			if (largura != null && !largura.isEmpty()) {
				d.setLargura(Double.parseDouble(largura));
			}
			if (profundidade != null && !profundidade.isEmpty()) {
				d.setProfundidade(Double.parseDouble(profundidade));
			}
			if (peso != null && !peso.isEmpty()) {
				d.setPeso(Double.parseDouble(peso));
			}
			if (codigo_barras != null && !codigo_barras.isEmpty()) {
				livro.setCodigoBarras(codigo_barras);
			}
			if (preco_venda != null && !preco_venda.isEmpty()) {
				livro.setPrecoVenda(Double.parseDouble(preco_venda));
			}
			if (status != null && !status.isEmpty()) {
                statusLivro.setStatus(Boolean.parseBoolean(status));
			}
			if (statusJustificativa != null && !statusJustificativa.isEmpty()) {
                statusLivro.setJustificativa(statusJustificativa);
			}

            livro.setStatusLivro(statusLivro);
			e.setDimensoes(d);
			livro.setEdicao(e);

			GrupoPrecificacao grupoPrecificacao = new GrupoPrecificacao();
			if (id_grupoPrecificacao != null && !id_grupoPrecificacao.isEmpty()) {
				grupoPrecificacao.setId(Integer.parseInt(id_grupoPrecificacao));
				livro.setGrupoPrecificacao(grupoPrecificacao);
			}

			Editora editora = new Editora();
			if (id_editora != null && !id_editora.isEmpty()) {
				editora.setId(Integer.parseInt(id_editora));
				livro.setEditora(editora);
			}

			ArrayList<Categoria> categorias = new ArrayList<Categoria>();
			if (id_categoria != null) {
				for(String a: id_categoria) {
					Categoria categoria = new Categoria();
					categoria.setId(Integer.parseInt(a));
					categorias.add(categoria);
				}
			}
			livro.setCategorias(categorias);
			
			ArrayList<Autor> autores = new ArrayList<Autor>();
			if (id_autor != null) {
				for(String a: id_autor) {
					Autor autor = new Autor();
					autor.setId(Integer.parseInt(a));
					autores.add(autor);
				}
			}
			livro.setAutores(autores);
		} else {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<Livro> livros = (List<Livro>) session.getAttribute("livros");
			String txtId = request.getParameter("idLivro");
			int id = 0;

			if (txtId != null && !txtId.trim().equals("")) {
				id = Integer.parseInt(txtId);
			}

			if (livros != null) {
				for (Livro l : livros) {
					if (l.getId() == id) {
						livro = l;
					}
				}
			} else {
				livro = new Livro();
			}
		}

		return livro;
	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher d = null;

		HttpSession session = request.getSession();
		String operacao = request.getParameter("operacao");

		
		// SALVAR LIVRO
		if (resultado.getMsg() == null && operacao.equals("SALVAR")) {
			resultado.setMsg("Livro cadastrado com sucesso!");

			LivroDAO livroDAO = new LivroDAO();
			List<EntidadeDominio> livros = new ArrayList<EntidadeDominio>(); // criando uma lista de livro
			livros = livroDAO.consultar(null);

			request.getSession().setAttribute("livros", livros);
			d = request.getRequestDispatcher("livros.jsp");
		}

		// ALTERAR LIVRO
		if (resultado.getMsg() == null && operacao.equals("ALTERAR")) {
			resultado.setMsg("Livro alterado com sucesso!");

			LivroDAO livroDAO = new LivroDAO();
			List<EntidadeDominio> livros = new ArrayList<EntidadeDominio>(); // criando uma lista de livro
			livros = livroDAO.consultar(null);

			request.getSession().setAttribute("livros", livros);
			d = request.getRequestDispatcher("livros.jsp");
		}

		// INATIVAR LIVRO
		if (resultado.getMsg() == null && operacao.equals("INATIVAR")) {
			resultado.setMsg("Livro alterado com sucesso!");

			LivroDAO livroDAO = new LivroDAO();
			List<EntidadeDominio> livros = new ArrayList<EntidadeDominio>(); // criando uma lista de livro
			livros = livroDAO.consultar(null);

			request.getSession().setAttribute("livros", livros);
			d = request.getRequestDispatcher("livros.jsp");
		}
		
		// PEGAR TODOS OS LIVROS
		if (operacao.equals("GETALLBOOKS")) {

			LivroDAO livroDAO = new LivroDAO();
			List<EntidadeDominio> livros = new ArrayList<EntidadeDominio>(); // criando uma lista de livro
			livros = livroDAO.consultar(null);

			request.getSession().setAttribute("livros", livros);
			d = request.getRequestDispatcher("livros.jsp");

		}
		
		// CONSULTAR LIVRO
		if (operacao.equals("CONSULTAR")) {
			request.getSession().setAttribute("livros", resultado.getEntidades());
			d = request.getRequestDispatcher("livros.jsp");

		}

		// EXIBIR LIVROS PARA O USUARIO
		if (operacao.equals("EXIBIR")) {
			request.getSession().setAttribute("livros", resultado.getEntidades());
			d = request.getRequestDispatcher("index.jsp");

		}

		// NOVO LIVRO
		if (operacao.equals("NOVO")) {
			loadingForm(request);
			d = request.getRequestDispatcher("detalhes_livros.jsp");

		}

		// VISUALIZAR LIVRO
		if (resultado.getMsg() == null && operacao.equals("VISUALIZAR")) {
			loadingForm(request);
			request.setAttribute("livro", resultado.getEntidades().get(0));
			d = request.getRequestDispatcher("detalhes_livros.jsp");
		}

		// EXCLUIR LIVRO
		if (resultado.getMsg() == null && operacao.equals("EXCLUIR")) {
			request.getSession().setAttribute("livros", null);
			d = request.getRequestDispatcher("CRUDLivros?&operacao=GETALLBOOKS");
		}

		d.forward(request, response);

	}

	public void loadingForm(HttpServletRequest request) {

		AutorDAO autdao = new AutorDAO(null, null);
		EditoraDAO edao = new EditoraDAO(null, null);
		CategoriaDAO catdao = new CategoriaDAO(null, null);
		GrupoDAO grudao = new GrupoDAO(null, null);

		Autor a = new Autor();
		Editora e = new Editora();
		Categoria c = new Categoria();
		GrupoPrecificacao g = new GrupoPrecificacao();

		List<EntidadeDominio> autores = new ArrayList<EntidadeDominio>();
		List<EntidadeDominio> editoras = new ArrayList<EntidadeDominio>();
		List<EntidadeDominio> categorias = new ArrayList<EntidadeDominio>();
		List<EntidadeDominio> grupos = new ArrayList<EntidadeDominio>();

		try {
			grupos = grudao.consultar(g);
			autores = autdao.consultar(a);
			editoras = edao.consultar(e);
			categorias = catdao.consultar(c);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		request.getSession().setAttribute("autores", autores);
		request.getSession().setAttribute("editoras", editoras);
		request.getSession().setAttribute("categorias", categorias);
		request.getSession().setAttribute("grupos", grupos);
	}
}