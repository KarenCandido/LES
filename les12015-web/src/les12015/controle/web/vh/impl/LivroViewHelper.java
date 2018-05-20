package les12015.controle.web.vh.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import les12015.controle.web.vh.IViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.core.impl.dao.AutorDAO;
import les12015.core.impl.dao.CategoriaDAO;
import les12015.core.impl.dao.EditoraDAO;
import les12015.core.impl.dao.GrupoDAO;
import les12015.core.impl.dao.LivroDAO;
import les12015.dominio.Autor;
import les12015.dominio.Categoria;
import les12015.dominio.Dimensoes;
import les12015.dominio.Edicao;
import les12015.dominio.Editora;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.GrupoPrecificacao;
import les12015.dominio.Livro;

public class LivroViewHelper implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String operacao = request.getParameter("operacao");

		Livro livro = null; // instancia livro
		if (!operacao.equals("VISUALIZAR")) {

			String id = request.getParameter("idLivro");
			String titulo = request.getParameter("titulo");
			String ano = request.getParameter("ano");
			String edicao = request.getParameter("edicao");
			String isbn = request.getParameter("isbn");
			String numero_pagina = request.getParameter("paginas");
			String sinopse = request.getParameter("sinopse");
			String altura = request.getParameter("altura");
			String largura = request.getParameter("largura");
			String profundidade = request.getParameter("profundidade");
			String peso = request.getParameter("peso"); // falta na jsp
			String codigo_barras = request.getParameter("codigoBarras");
			String preco_custo = request.getParameter("precoCusto");// falta na jsp
			String id_grupoPrecificacao = request.getParameter("grupoPrecificacao");
			String id_editora = request.getParameter("editora");
			String id_categoria = request.getParameter("categoria");
			String status = request.getParameter("status");
			String id_autor = request.getParameter("autor");

			livro = new Livro();
			Edicao e = new Edicao();
			Dimensoes d = new Dimensoes();

			if (id != null && !id.isEmpty()) {
				livro.setId(Integer.parseInt(id));
			}
			if (titulo != null && !titulo.isEmpty()) {
				livro.setTitulo(titulo);
			}
			if (ano != null && !ano.isEmpty()) {
				e.setAno(ano);
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
			if (preco_custo != null && !preco_custo.isEmpty()) {
				livro.setPrecoCusto(Double.parseDouble(preco_custo));
			}
			if (status != null && !status.isEmpty()) {
				livro.setStatus(Boolean.parseBoolean(status));
			}

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

			Categoria categoria = new Categoria();
			if (id_categoria != null && !id_categoria.isEmpty()) {
				categoria.setId(Integer.parseInt(id_categoria));
				livro.setCategoriaLivro(categoria);
			}

			Autor autor = new Autor();
			if (id_autor != null && !id_autor.isEmpty()) {
				autor.setId(Integer.parseInt(id_autor));
				livro.setAutor(autor);
			}
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

		if (resultado.getMsg() == null && operacao.equals("SALVAR")) {
			resultado.setMsg("Livro cadastrado com sucesso!");

			LivroDAO livroDAO = new LivroDAO();
			List<EntidadeDominio> livros = new ArrayList<EntidadeDominio>(); // criando uma lista de livro
			livros = livroDAO.consultar(null);

			request.getSession().setAttribute("livros", livros);
			d = request.getRequestDispatcher("../Livro/ListaLivro.jsp");
		}

		if (resultado.getMsg() == null && operacao.equals("ALTERAR")) {
			resultado.setMsg("Livro alterado com sucesso!");

			LivroDAO livroDAO = new LivroDAO();
			List<EntidadeDominio> livros = new ArrayList<EntidadeDominio>(); // criando uma lista de livro
			livros = livroDAO.consultar(null);

			request.getSession().setAttribute("livros", livros);
			d = request.getRequestDispatcher("../Livro/ListaLivro.jsp");
		}

		if (resultado.getMsg() == null && operacao.equals("INATIVAR")) {
			resultado.setMsg("Livro alterado com sucesso!");

			LivroDAO livroDAO = new LivroDAO();
			List<EntidadeDominio> livros = new ArrayList<EntidadeDominio>(); // criando uma lista de livro
			livros = livroDAO.consultar(null);

			request.getSession().setAttribute("livros", livros);
			d = request.getRequestDispatcher("../Livro/ListaLivro.jsp");
		}
		if (operacao.equals("GETALLBOOKS")) {

			LivroDAO livroDAO = new LivroDAO();
			List<EntidadeDominio> livros = new ArrayList<EntidadeDominio>(); // criando uma lista de livro
			livros = livroDAO.consultar(null);

			request.getSession().setAttribute("livros", livros);
			d = request.getRequestDispatcher("../Livro/ListaLivro.jsp");

		}
		if (operacao.equals("CONSULTAR")) {
			request.getSession().setAttribute("livros", resultado.getEntidades());
			d = request.getRequestDispatcher("../Livro/ListaLivro2.jsp");

		}

		if (operacao.equals("NEWBOOK")) {

			loadingForm(request);

			d = request.getRequestDispatcher("FormLivro.jsp");

		}

		if (resultado.getMsg() == null && operacao.equals("VISUALIZAR")) {
			loadingForm(request);
			request.setAttribute("livro", resultado.getEntidades().get(0));
			d = request.getRequestDispatcher("FormLivro.jsp");
		}

		if (resultado.getMsg() == null && operacao.equals("EXCLUIR")) {

			request.getSession().setAttribute("livros", null);
			d = request.getRequestDispatcher("ListaLivro.jsp");
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