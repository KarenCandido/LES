
package les12015.controle.web.vh.impl;

import les12015.controle.web.vh.IViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.core.impl.dao.ClienteDAO;
import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ClienteViewHelper implements IViewHelper {

	/**
	 * TODO Descrição do Método
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @see les12015.controle.web.vh.IViewHelper#getEntidade(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		// String nome = request.getParameter("txtNome");
		// String cpf = request.getParameter("txtCpf");
		// String id = request.getParameter("txtId");
		//
		// Cliente c = new Cliente();
		// c.setNome(nome);
		//
		// if (id != null && !id.trim().equals("")) {
		// c.setId(Integer.parseInt(id));
		// }
		//
		// c.setCpf(cpf);
		// return c;

		String operacao = request.getParameter("operacao");

		Cliente cliente = null; // instancia livro
		if (!operacao.equals("VISUALIZAR")) {

			String id = request.getParameter("idCliente");
			String nome = request.getParameter("nome");
			String dtNasc = request.getParameter("dtNasc");
			String email = request.getParameter("email");
			String cpf = request.getParameter("cpf");
			String genero = request.getParameter("genero");
			String status = request.getParameter("status");

			cliente = new Cliente();
			// Edicao e = new Edicao();
			// Dimensoes d = new Dimensoes();

			if (id != null && !id.isEmpty()) {
				cliente.setId(Integer.parseInt(id));
			}
			if (nome != null && !nome.isEmpty()) {
				cliente.setNome(nome);
			}
			if (dtNasc != null && !dtNasc.isEmpty()) {
				cliente.setDataNascimento(Timestamp.valueOf(dtNasc));
			}
			if (email != null && !email.isEmpty()) {
				cliente.setEmail(email);
			}
			if (cpf != null && !cpf.isEmpty()) {
				cliente.setCpf(cpf);
			}
			if (genero != null && !genero.isEmpty()) {

				cliente.setGenero(genero);
			}
			if (status != null && !status.isEmpty()) {
				cliente.setStatus(Boolean.parseBoolean(status));
			}

		} else {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<Cliente> clientes = (List<Cliente>) session.getAttribute("clientes");
			String txtId = request.getParameter("idCliente");
			int id = 0;

			if (txtId != null && !txtId.trim().equals("")) {
				id = Integer.parseInt(txtId);
			}

			if (clientes != null) {
				for (Cliente l : clientes) {
					if (l.getId() == id) {
						cliente = l;
					}
				}
			} else {
				cliente = new Cliente();
			}
		}

		return cliente;
	}

	/**
	 * TODO Descrição do Método
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @see les12015.controle.web.vh.IViewHelper.setView(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher d = null;

		HttpSession session = request.getSession();
		String operacao = request.getParameter("operacao");

		// SALVAR CLIENTE
		if (resultado.getMsg() == null && operacao.equals("SALVAR")) {
			resultado.setMsg("Cliente cadastrado com sucesso!");

			ClienteDAO clienteDAO = new ClienteDAO();
			List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>(); // criando uma lista de cliente
			clientes = clienteDAO.consultar(null);

			request.getSession().setAttribute("clientes", clientes);
			d = request.getRequestDispatcher("index.jsp");
		}

		// ALTERAR CLIENTE
		if (resultado.getMsg() == null && operacao.equals("ALTERAR")) {
			resultado.setMsg("Cliente alterado com sucesso!");

			ClienteDAO clienteDAO = new ClienteDAO();
			List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>(); // criando uma lista de cliente
			clientes = clienteDAO.consultar(null);

			request.getSession().setAttribute("clientes", clientes);
			d = request.getRequestDispatcher("perfil.jsp");
		}

		// VISUALIZAR CLIENTE
		if (resultado.getMsg() == null && operacao.equals("VISUALIZAR")) {
			loadingForm(request);
			request.setAttribute("cliente", resultado.getEntidades().get(0));
			d = request.getRequestDispatcher("perfil.jsp");
		}

		// INATIVAR CLIENTE
		if (resultado.getMsg() == null && operacao.equals("INATIVAR")) {
			resultado.setMsg("Cliente inativado com sucesso!");

			ClienteDAO clienteDAO = new ClienteDAO();
			List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>(); // criando uma lista de cliente
			clientes = clienteDAO.consultar(null);

			request.getSession().setAttribute("clientes", clientes);
			d = request.getRequestDispatcher("index.jsp");
		}

		// MOSTRAR TODOS
		// if (operacao.equals("GETALLCLIENTS")) {

		// ClienteDAO clienteDAO = new ClienteDAO();
		// List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>(); // criando
		// uma lista de livro
		// clientes = clienteDAO.consultar(null);

		// request.getSession().setAttribute("clientes", clientes);
		// d = request.getRequestDispatcher("clientes.jsp");

		// }

		// ENVIAR PARA O FORM CLIENTE
		if (operacao.equals("NOVO")) {

			loadingForm(request);
			d = request.getRequestDispatcher("cadastro_dados.jsp");

		}

		// EXCLUIR CLIENTE
		if (resultado.getMsg() == null && operacao.equals("EXCLUIR")) {

			request.getSession().setAttribute("clientes", null);
			d = request.getRequestDispatcher("index.jsp");
		}

		d.forward(request, response);

	}

	public void loadingForm(HttpServletRequest request) {

		// AutorDAO autdao = new AutorDAO(null, null);
		// EditoraDAO edao = new EditoraDAO(null, null);
		// CategoriaDAO catdao = new CategoriaDAO(null, null);
		// GrupoDAO grudao = new GrupoDAO(null, null);
		//
		// Autor a = new Autor();
		// Editora e = new Editora();
		// Categoria c = new Categoria();
		// GrupoPrecificacao g = new GrupoPrecificacao();
		//
		// List<EntidadeDominio> autores = new ArrayList<EntidadeDominio>();
		// List<EntidadeDominio> editoras = new ArrayList<EntidadeDominio>();
		// List<EntidadeDominio> categorias = new ArrayList<EntidadeDominio>();
		// List<EntidadeDominio> grupos = new ArrayList<EntidadeDominio>();
		//
		// try {
		// grupos = grudao.consultar(g);
		// autores = autdao.consultar(a);
		// editoras = edao.consultar(e);
		// categorias = catdao.consultar(c);
		// } catch (SQLException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// request.getSession().setAttribute("autores", autores);
		// request.getSession().setAttribute("editoras", editoras);
		// request.getSession().setAttribute("categorias", categorias);
		// request.getSession().setAttribute("grupos", grupos);

	}
}
