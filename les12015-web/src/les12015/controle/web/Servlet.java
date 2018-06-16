package les12015.controle.web;

import les12015.controle.web.command.ICommand;
import les12015.controle.web.command.impl.*;
import les12015.controle.web.vh.IViewHelper;
import les12015.controle.web.vh.impl.*;
import les12015.core.aplicacao.Resultado;
import les12015.dominio.EntidadeDominio;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		commands.put("ADICIONAR", new AdicionarItemCommand());
		commands.put("GETITENS", null);
		commands.put("login", null);
		commands.put("logout", null);

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

		vhs.put("/LES/Livraria/admin/CRUDLivros", new LivroViewHelper());
        vhs.put("/LES/Livraria/admin/CRUDEstoque", new EstoqueViewHelper());
        vhs.put("/LES/Livraria/admin/CRUDCliente", new ClienteAdminViewHelper());
        vhs.put("/LES/Livraria/CRUDCliente", new ClienteViewHelper());
		vhs.put("/LES/Livraria/CRUDCompra", new PedidoViewHelper());
		vhs.put("/LES/Livraria/ShowLivros", new LivroViewHelper());
		vhs.put("/LES/Livraria/Usuario", new UsuarioViewHelper());
		vhs.put("/LES/Livraria/CRUDEndereco", new EnderecoViewHelper());
		vhs.put("/LES/Livraria/CRUDCartao", new CartaoViewHelper());
		vhs.put("/LES/Livraria", new LivroViewHelper());

		
		/*vhs.put("/Livraria/admin/CRUDLivros", new LivroViewHelper());
        vhs.put("/Livraria/admin/CRUDEstoque", new EstoqueViewHelper());
        vhs.put("/Livraria/CRUDCliente", new ClienteViewHelper());
		vhs.put("/Livraria/CRUDCompra", new PedidoViewHelper());
		vhs.put("/Livraria/ShowLivros", new LivroViewHelper());
		vhs.put("/Livraria/Usuario", new UsuarioViewHelper());
		vhs.put("/Livraria/CRUDEndereco", new EnderecoViewHelper());
		vhs.put("/Livraria/CRUDCartao", new CartaoViewHelper());
*/
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
        HttpSession session = request.getSession();

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
		if (operacao == null) {
			operacao = "EXIBIR";
		}

		// Obt�m o command para executar a respectiva opera��o
		ICommand command = commands.get(operacao);

		/*
		 * Executa o command que chamar� a fachada para executar a opera��o requisitada
		 * o retorno � uma inst�ncia da classe resultado que pode conter mensagens derro
		 * ou entidades de retorno
		 */
		Resultado resultado = new Resultado();
		if(command == null){
        }else if(command.getClass().equals(AdicionarItemCommand.class)){
            List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
            entidades = (List)session.getAttribute("itens");
            resultado.setEntidades(entidades);
        }else
            resultado = command.execute(entidade);

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