
package les12015.controle.web.vh.impl;

import les12015.controle.web.command.impl.ConsultarCommand;
import les12015.controle.web.vh.IViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.core.impl.dao.ClienteDAO;
import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Telefone;
import les12015.dominio.Usuario;

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

		String operacao = request.getParameter("operacao");

		Cliente cliente = null; // instancia livro
		Usuario usuario = null;
		Telefone telefone = null;
		if (!operacao.equals("VISUALIZAR")) {

			String id = request.getParameter("idCliente");
			String nome = request.getParameter("Nome");
			String dtNasc = request.getParameter("DtNasc");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String cpf = request.getParameter("CPF");
			String genero = request.getParameter("genero");
			String status = request.getParameter("status");
			String idTelefone = request.getParameter("idTelefone");
			String ddd = request.getParameter("DDD");
			String numero = request.getParameter("Telefone");
			String tipo = request.getParameter("tipo");

			cliente = new Cliente();
			telefone = new Telefone();

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
			if (senha != null && !senha.isEmpty()) {
				cliente.setSenha(senha);
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
			if (idTelefone != null && !idTelefone.isEmpty()) {
				telefone.setId(Integer.parseInt(idTelefone));
			}
			if (ddd != null && !ddd.isEmpty()) {
				telefone.setDdd(ddd);
			}
			if (numero != null && !numero.isEmpty()) {
				telefone.setNumero(numero);
			}
			if (tipo != null && !tipo.isEmpty()) {
				telefone.setTipoTelefone(tipo);
			}
			if (cliente != null && cliente.getId() != null) {
				telefone.setCliente(cliente);
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
			@SuppressWarnings("unchecked")
			List<Telefone> telefones = (List<Telefone>) session.getAttribute("telefones");
			txtId = request.getParameter("idTelefone");
			id = 0;

			if (txtId != null && !txtId.trim().equals("")) {
				id = Integer.parseInt(txtId);
			}

			if (telefone != null) {
				for (Telefone t : telefones) {
					if (t.getId() == id) {
						telefone = t;
					}
				}
			} else {
				telefone = new Telefone();
			}
		}

		cliente.setTelefone(telefone);
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
			Cliente cli = (Cliente) session.getAttribute("login");
			request.setAttribute("cliente", cli);
			loadingForm(request);
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
		HttpSession session = request.getSession();
		Telefone telefone = new Telefone();
		telefone.setCliente((Cliente) session.getAttribute("login"));

		ConsultarCommand consultarCommand = new ConsultarCommand();
		List<EntidadeDominio> entidades = consultarCommand.execute(telefone).getEntidades();
		if( ! entidades.isEmpty()) {
			telefone = (Telefone) entidades.get(0);
			request.getSession().setAttribute("telefone", telefone);
		}
	}
}
