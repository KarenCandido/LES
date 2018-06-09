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
		 * opera��o garantimos que esta servelt atender� qualquer opera��o
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
		 * Utilizando o ViewHelper para tratar especifica��es de qualquer tela e
		 * indexando cada viewhelper pela url em que esta servlet � chamada no form
		 * garantimos que esta servelt atender� qualquer entidade
		 */

		vhs = new HashMap<String, IViewHelper>();
		/*
		 * A chave do mapa � o mapeamento da servlet para cada form que est� configurado
		 * no web.xml e sendo utilizada no action do html
		 */

		vhs.put("/les12015-web/Livraria/admin/CRUDLivros", new LivroViewHelper());
        vhs.put("/les12015-web/Livraria/admin/CRUDEstoque", new EstoqueViewHelper());
        vhs.put("/les12015-web/Livraria/CRUDCliente", new ClienteViewHelper());
		vhs.put("/les12015-web/Livraria/CRUDCompra", new PedidoViewHelper());
		vhs.put("/les12015-web/Livraria/ShowLivros", new LivroViewHelper());

	}

	/**
	 * TODO Descri��o do M�todo
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

		// Obt�m a uri que invocou esta servlet (O que foi definido no methdo do form
		// html)
		String uri = request.getRequestURI();

		// Obt�m um viewhelper indexado pela uri que invocou esta servlet
		IViewHelper vh = vhs.get(uri);

		// O viewhelper retorna a entidade especifica para a tela que chamou esta
		// servlet
		EntidadeDominio entidade = vh.getEntidade(request);

		// Obt�m a opera��o executada
		String operacao = request.getParameter("operacao");

		// Obt�m o command para executar a respectiva opera��o
		ICommand command = commands.get(operacao);

		/*
		 * Executa o command que chamar� a fachada para executar a opera��o requisitada
		 * o retorno � uma inst�ncia da classe resultado que pode conter mensagens derro
		 * ou entidades de retorno
		 */
		Resultado resultado = command.execute(entidade);

		/*
		 * Executa o m�todo setView do view helper espec�fico para definir como dever�
		 * ser apresentado o resultado para o usu�rio
		 */
		try {
			vh.setView(resultado, request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
