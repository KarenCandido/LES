package les12015.controle.web;

import les12015.controle.web.command.ICommand;
import les12015.controle.web.command.impl.*;
import les12015.controle.web.vh.IViewHelper;
import les12015.controle.web.vh.impl.ClienteViewHelper;
import les12015.controle.web.vh.impl.EstoqueViewHelper;
import les12015.controle.web.vh.impl.LivroViewHelper;
import les12015.controle.web.vh.impl.PedidoViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.dominio.EntidadeDominio;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> vhs;

	/**
	 * Default constructor.
	 */
	public Servlet() {

		/*
		 * Utilizando o command para chamar a fachada e indexando cada command pela
		 * operação garantimos que esta servelt atenderá qualquer operação
		 */
		commands = new HashMap<String, ICommand>();

		commands.put("SALVAR", new SalvarCommand());
		commands.put("EXCLUIR", new ExcluirCommand());
		commands.put("CONSULTAR", new ConsultarCommand());
		commands.put("EXIBIR", new ConsultarCommand());
		commands.put("VISUALIZAR", new VisualizarCommand());
		commands.put("ALTERAR", new AlterarCommand());
		commands.put("GETALLBOOKS", new ConsultarCommand());
		commands.put("NOVO", new NovoCommand());
		commands.put("INATIVAR", new InativarCommand());
		commands.put("ADICIONAR_ITEM", new AdicionarItemCommand());

		/*
		 * Utilizando o ViewHelper para tratar especificações de qualquer tela e
		 * indexando cada viewhelper pela url em que esta servlet é chamada no form
		 * garantimos que esta servelt atenderá qualquer entidade
		 */

		vhs = new HashMap<String, IViewHelper>();
		/*
		 * A chave do mapa é o mapeamento da servlet para cada form que está configurado
		 * no web.xml e sendo utilizada no action do html
		 */

		vhs.put("/les12015-web/Livraria/admin/CRUDLivros", new LivroViewHelper());
        vhs.put("/les12015-web/Livraria/admin/CRUDEstoque", new EstoqueViewHelper());
        vhs.put("/les12015-web/Livraria/CRUDCliente", new ClienteViewHelper());
		vhs.put("/les12015-web/Livraria/CRUDCompra", new PedidoViewHelper());
		vhs.put("/les12015-web/Livraria/ShowLivros", new LivroViewHelper());

	}

	/**
	 * TODO Descrição do Método
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcessRequest(request, response);
	}

	protected void doProcessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtêm a uri que invocou esta servlet (O que foi definido no methdo do form
		// html)
		String uri = request.getRequestURI();

		// Obtêm um viewhelper indexado pela uri que invocou esta servlet
		IViewHelper vh = vhs.get(uri);

		// O viewhelper retorna a entidade especifica para a tela que chamou esta
		// servlet
		EntidadeDominio entidade = vh.getEntidade(request);

		// Obtêm a operação executada
		String operacao = request.getParameter("operacao");

		// Obtêm o command para executar a respectiva operação
		ICommand command = commands.get(operacao);

		/*
		 * Executa o command que chamará a fachada para executar a operação requisitada
		 * o retorno é uma instância da classe resultado que pode conter mensagens derro
		 * ou entidades de retorno
		 */
		Resultado resultado = command.execute(entidade);

		/*
		 * Executa o método setView do view helper específico para definir como deverá
		 * ser apresentado o resultado para o usuário
		 */
		try {
			vh.setView(resultado, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
