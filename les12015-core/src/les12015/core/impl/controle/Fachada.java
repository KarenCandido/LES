package les12015.core.impl.controle;

import les12015.core.IDAO;
import les12015.core.IFachada;
import les12015.core.IStrategy;
import les12015.core.aplicacao.Resultado;
import les12015.core.impl.dao.ClienteDAO;
import les12015.core.impl.dao.EstoqueDAO;
import les12015.core.impl.dao.FornecedorDAO;
import les12015.core.impl.dao.LivroDAO;
import les12015.core.impl.negocio.ComplementarDtCadastro;
import les12015.core.impl.negocio.ValidadorCnpj;
import les12015.core.impl.negocio.ValidadorCpf;
import les12015.core.impl.negocio.ValidadorDadosObrigatoriosFornecedor;
import les12015.dominio.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import les12015.core.impl.negocio.ValidadorQtdLivro;

public class Fachada implements IFachada {

    /**
     * Mapa de DAOS, ser� indexado pelo nome da entidade O valor � uma inst�ncia do
     * DAO para uma dada entidade;
     */
    private Map<String, IDAO> daos;

    /**
     * Mapa para conter as regras de neg�cio de todas opera��es por entidade; O
     * valor � um mapa que de regras de neg�cio indexado pela opera��o
     */
    private Map<String, Map<String, List<IStrategy>>> rns;

    private Resultado resultado;

    public Fachada() {
        /* Int�nciando o Map de DAOS */
        daos = new HashMap<String, IDAO>();
        /* Int�nciando o Map de Regras de Neg�cio */
        rns = new HashMap<String, Map<String, List<IStrategy>>>();

        /* Criando inst�ncias dos DAOs a serem utilizados */
        FornecedorDAO forDAO = new FornecedorDAO();
        ClienteDAO cliDAO = new ClienteDAO();
        LivroDAO livroDAO = new LivroDAO();
        EstoqueDAO estoqueDAO = new EstoqueDAO();

        /* Adicionando cada dao no MAP indexando pelo nome da classe */
        daos.put(Fornecedor.class.getName(), forDAO);
        daos.put(Cliente.class.getName(), cliDAO);
        daos.put(Livro.class.getName(), livroDAO);
        daos.put(Estoque.class.getName(), estoqueDAO);

        /* Criando inst�ncias de regras de neg�cio a serem utilizados */
        ValidadorDadosObrigatoriosFornecedor vrDadosObrigatoriosFornecedor = new ValidadorDadosObrigatoriosFornecedor();
        ValidadorCnpj vCnpj = new ValidadorCnpj();
        ComplementarDtCadastro cDtCadastro = new ComplementarDtCadastro();
        ValidadorCpf vCpf = new ValidadorCpf();
        // ValidadorQtdLivro vQtd = new ValidadorQtdLivro();

        /*
         * Criando uma lista para conter as regras de neg�cio de fornencedor quando a
         * opera��o for salvar
         */
        List<IStrategy> rnsSalvarFornecedor = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na opera��o salvar do fornecedor */
        rnsSalvarFornecedor.add(vrDadosObrigatoriosFornecedor);
        rnsSalvarFornecedor.add(vCnpj);
        rnsSalvarFornecedor.add(cDtCadastro);

        /*
         * Cria o mapa que poder� conter todas as listas de regras de neg�cio espec�fica
         * por opera��o do fornecedor
         */
        Map<String, List<IStrategy>> rnsFornecedor = new HashMap<String, List<IStrategy>>();
        /*
         * Adiciona a listra de regras na opera��o salvar no mapa do fornecedor (lista
         * criada na linha 70)
         */
        rnsFornecedor.put("SALVAR", rnsSalvarFornecedor);

        /*
         * Adiciona o mapa(criado na linha 79) com as regras indexadas pelas opera��es
         * no mapa geral indexado pelo nome da entidade
         */
        rns.put(Fornecedor.class.getName(), rnsFornecedor);

        /*
         * Criando uma lista para conter as regras de neg�cio de cliente quando a
         * opera��o for salvar
         */
        List<IStrategy> rnsSalvarCliente = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na opera��o salvar do cliente */
        //rnsSalvarCliente.add(cDtCadastro);
        //rnsSalvarCliente.add(vCpf);

        /*
         * Cria o mapa que poder� conter todas as listas de regras de neg�cio espec�fica
         * por opera��o do cliente
         */
        Map<String, List<IStrategy>> rnsCliente = new HashMap<String, List<IStrategy>>();
        /*
         * Adiciona a listra de regras na opera��o salvar no mapa do cliente (lista
         * criada na linha 93)
         */
        rnsCliente.put("SALVAR", rnsSalvarCliente);
        /*
         * Adiciona o mapa(criado na linha 101) com as regras indexadas pelas opera��es
         * no mapa geral indexado pelo nome da entidade. Observe que este mapa (rns) � o
         * mesmo utilizado na linha 88.
         */
        rns.put(Cliente.class.getName(), rnsCliente);

        /*
         * Criando uma lista para conter as regras de neg�cio de livro quando a opera��o
         * for salvar
         */
        List<IStrategy> rnsSalvarLivro = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na opera��o salvar do livro */
        rnsSalvarLivro.add(cDtCadastro);
        // rnsSalvarLivro.add(vQtd);

        /*
         * Criando uma lista para conter as regras de neg�cio de livro quando a opera��o
         * for alterar
         */
        List<IStrategy> rnsAlterarLivro = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na opera��o alterar do livro */
        // rnsAlterarLivro.add(vQtd);

        /*
         * Cria o mapa que poder� conter todas as listas de regras de neg�cio espec�fica
         * por opera��o do livro
         */
        Map<String, List<IStrategy>> rnsLivro = new HashMap<String, List<IStrategy>>();
        /*
         * Adiciona a listra de regras na opera��o salvar no mapa do livro (lista criada
         * na linha 114)
         */
        rnsLivro.put("SALVAR", rnsSalvarLivro);
        /*
         * Adiciona a listra de regras na opera��o alterar no mapa do livro (lista
         * criada na linha 122)
         */
        rnsLivro.put("ALTERAR", rnsAlterarLivro);

        /*
         * Adiciona o mapa(criado na linha 129) com as regras indexadas pelas opera��es
         * no mapa geral indexado pelo nome da entidade. Observe que este mapa (rns) � o
         * mesmo utilizado na linha 88.
         */
        rns.put(Livro.class.getName(), rnsLivro);

    }

    @Override
    public Resultado salvar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();

        String msg = executarRegras(entidade, "SALVAR");

        if (msg == null) {
            IDAO dao = daos.get(nmClasse);
            try {
                dao.salvar(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("N�o foi poss�vel realizar o registro!");

            }
        } else {
            resultado.setMsg(msg);

        }

        return resultado;
    }

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();

        String msg = executarRegras(entidade, "ALTERAR");

        if (msg == null) {
            IDAO dao = daos.get(nmClasse);
            try {
                dao.alterar(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("N�o foi poss�vel realizar o registro!");

            }
        } else {
            resultado.setMsg(msg);

        }

        return resultado;

    }

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();

        String msg = executarRegras(entidade, "EXCLUIR");

        if (msg == null) {
            IDAO dao = daos.get(nmClasse);
            try {
                dao.excluir(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("N�o foi poss�vel realizar o registro!");
            }
        } else {
            resultado.setMsg(msg);
        }

        return resultado;

    }

    @Override
    public Resultado consultar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();

        String msg = executarRegras(entidade, "EXCLUIR");

        if (msg == null) {
            IDAO dao = daos.get(nmClasse);
            try {

                resultado.setEntidades(dao.consultar(entidade));
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("N�o foi poss�vel realizar a consulta!");

            }
        } else {
            resultado.setMsg(msg);

        }

        return resultado;

    }

    @Override
    public Resultado visualizar(EntidadeDominio entidade) {
        resultado = new Resultado();
        resultado.setEntidades(new ArrayList<EntidadeDominio>(1));
        resultado.getEntidades().add(entidade);
        return resultado;

    }

    private String executarRegras(EntidadeDominio entidade, String operacao) {
        String nmClasse = entidade.getClass().getName();
        StringBuilder msg = new StringBuilder();

        Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);

        if (regrasOperacao != null) {
            List<IStrategy> regras = regrasOperacao.get(operacao);

            if (regras != null) {
                for (IStrategy s : regras) {
                    String m = s.processar(entidade);

                    if (m != null) {
                        msg.append(m);
                        msg.append("\n");
                    }
                }
            }

        }

        if (msg.length() > 0)
            return msg.toString();
        else
            return null;
    }

    @Override
    public Resultado novo(EntidadeDominio entidade) {
        resultado = new Resultado();
        return resultado;
    }

    public Resultado inativar(EntidadeDominio entidade) {
        resultado = new Resultado();

        String msg = executarRegras(entidade, "INATIVAR");

        if (msg == null) {
            LivroDAO dao = new LivroDAO();

            dao.inativar(entidade);
            List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
            entidades.add(entidade);
            resultado.setEntidades(entidades);
        } else {
            resultado.setMsg(msg);

        }

        return resultado;
    }
}
