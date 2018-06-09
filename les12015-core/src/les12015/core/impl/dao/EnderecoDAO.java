
package les12015.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Autor;
import les12015.dominio.Categoria;
import les12015.dominio.Dimensoes;
import les12015.dominio.Edicao;
import les12015.dominio.Editora;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Estoque;
import les12015.dominio.Fornecedor;
import les12015.dominio.GrupoPrecificacao;
import les12015.dominio.Livro;
import les12015.dominio.StatusLivro;

public class EnderecoDAO extends AbstractJdbcDAO {

	protected EnderecoDAO(String table, String idTable) {
		super("tb_endereco", "id_end");
	}

	public EnderecoDAO(Connection cx) {
		super(cx, "tb_endereco", "id_end");
	}

	public EnderecoDAO() {
		super("tb_endereco", "id_end");
	}

	public void salvar(EntidadeDominio entidade) {
		if (connection == null) {
			openConnection();
		}
		PreparedStatement pst = null;
		Endereco end = (Endereco) entidade;
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO tb_endereco(tipo_residencia, tipo_endereco, tipo_logradouro, logradouro, ");
		sql.append("numero, bairro, cep, obs, fk_cliente, fk_cidade");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		try {
			connection.setAutoCommit(false);

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, end.getTipoResidencia());
			pst.setString(2, end.getTipoEndereco());
			pst.setString(3, end.getTipoLogradouro());
			pst.setString(4, end.getLogradouro());
			pst.setString(5, end.getNumero());
			pst.setString(6, end.getBairro());
			pst.setString(7, end.getCep());
			pst.setString(8, end.getObservacao());
			pst.setInt(9, end.getCliente().getId());
			pst.setInt(10, end.getCidade().getId());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idEnd = 0;
			if (rs.next())
				idEnd = rs.getInt(1);
			end.setId(idEnd);

			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (ctrlTransaction) {
				try {
					pst.close();
					if (ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Endereco endereco = (Endereco) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_endereco(tipo_residencia, tipo_endereco, tipo_logradouro, logradouro, ");
			sql.append("numero, bairro, cep, obs, fk_cliente, fk_cidade");
			sql.append(" = (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); // campo a ser inserido
			sql.append(" WHERE id = ?");

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, endereco.getTipoResidencia());
			pst.setString(2, endereco.getTipoEndereco());
			pst.setString(3, endereco.getTipoLogradouro());
			pst.setString(4, endereco.getLogradouro());
			pst.setString(5, endereco.getNumero());
			pst.setString(6, endereco.getBairro());
			pst.setString(7, endereco.getCep());
			pst.setString(8, endereco.getObservacao());
			pst.setInt(9, endereco.getCliente().getId());
			pst.setInt(10, endereco.getCidade().getId());

			pst.executeUpdate();
			connection.commit();

			sql = new StringBuilder();
			sql.append("UPDATE tb_endereco(tipo_residencia, tipo_endereco, tipo_logradouro, logradouro, ");
			sql.append("numero, bairro, cep, obs, fk_cliente, fk_cidade");
			sql.append(" = (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			sql.append(" WHERE id = ?");

			pst = connection.prepareStatement(sql.toString());

			pst.setString(1, livro.getTitulo());
			pst.setInt(2, livro.getEdicao().getAno());
			pst.setInt(3, livro.getEdicao().getNumero());
			pst.setString(4, livro.getIsbn());
			pst.setInt(5, livro.getEdicao().getNumeroPagina());
			pst.setString(6, livro.getSinopse());
			pst.setDouble(7, livro.getEdicao().getDimensoes().getAltura());
			pst.setDouble(8, livro.getEdicao().getDimensoes().getLargura());
			pst.setDouble(9, livro.getEdicao().getDimensoes().getPeso());
			pst.setDouble(10, livro.getEdicao().getDimensoes().getProfundidade());
			pst.setString(11, livro.getCodigoBarras());
			pst.setDouble(12, livro.getPrecoVenda());
			pst.setDouble(13, livro.getQtde_estoque());
			pst.setDouble(14, livro.getQtde_venda());
			pst.setInt(15, livro.getGrupoPrecificacao().getId());
			pst.setInt(16, livro.getEditora().getId());
			pst.setInt(17, statusLivro.getId());
			pst.setInt(18, livro.getId());

			pst.executeUpdate();

			connection.commit();

			sql = new StringBuilder();
			sql.append("DELETE FROM tb_livro_cat WHERE fk_livro = ?");
			pst = connection.prepareStatement(sql.toString());

			pst.setInt(1, livro.getId());
			pst.executeUpdate();
			connection.commit();

			for (Categoria c : livro.getCategorias()) {

				sql = new StringBuilder();
				sql.append("INSERT INTO tb_livro_cat(fk_livro, fk_categoria)");
				sql.append(" VALUES (?,?)");

				pst = connection.prepareStatement(sql.toString());

				pst.setInt(1, livro.getId());
				pst.setInt(2, c.getId());
				pst.executeUpdate();
				connection.commit();
			}

			sql = new StringBuilder();
			sql.append("DELETE FROM tb_livro_autor WHERE fk_livro = ?");
			pst = connection.prepareStatement(sql.toString());

			pst.setInt(1, livro.getId());
			pst.executeUpdate();
			connection.commit();
			for (Autor a : livro.getAutores()) {

				sql = new StringBuilder();
				sql.append("INSERT INTO tb_livro_autor(fk_livro, fk_autor)");
				sql.append(" VALUES (?,?)");

				pst = connection.prepareStatement(sql.toString());

				pst.setInt(1, livro.getId());
				pst.setInt(2, a.getId());
				pst.executeUpdate();
				connection.commit();
			}

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * TODO Descrição do Método
	 *
	 * @param entidade
	 * @return
	 * @see fai.dao.IDAO#consulta(fai.domain.EntidadeDominio)
	 */
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Endereco endereco = (Endereco) entidade;

		if (endereco == null) {
			endereco = new Endereco();
		}
		//////////////////////////////////////////////
		String sql = "SELECT * " + "FROM tb_endereco "
				+ "JOIN tb_status_livro ON tb_status_livro.id_status = tb_livro.fk_status WHERE";
		//////////////////////////////////////////////
		if (livro.getId() != null)
			sql += " id_livro = ? AND";
		if (livro.getTitulo() != null)
			sql += " titulo = ? AND";
		if (livro.getEditora() != null && livro.getEditora().getNomeEditora() != null)
			sql += " id_editora = ? AND";
		if (livro.getAutores() != null && !livro.getAutores().isEmpty())
			sql += " id_autor = ? AND";
		if (livro.getCategorias() != null && !livro.getCategorias().isEmpty())
			sql += " id_categoria = ? AND";
		if (livro.getEditora() != null && livro.getEditora().getNomeEditora() != null)
			sql += " id_editora = ? AND";
		if (livro.getEdicao() != null && livro.getEdicao().getAno() != 0)
			sql += " ano = ? AND";
		if (livro.getEdicao() != null && livro.getEdicao().getNumero() != 0)
			sql += " id_edicao = ? AND";
		if (livro.getIsbn() != null)
			sql += " isbn = ? AND";
		////////////////////////////////////
		if (sql.endsWith(" AND"))
			sql = sql.substring(0, sql.length() - 4) + ";";

		else
			sql = "SELECT * " + "FROM tb_livro "
					+ "JOIN tb_status_livro ON tb_status_livro.id_status = tb_livro.fk_status;";

		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			int i = 1;

			if (livro.getId() != null) {
				pst.setInt(i, livro.getId());
				i++;
			}

			if (livro.getTitulo() != null) {
				pst.setString(i, livro.getTitulo());
				i++;
			}

			if (livro.getAutores() != null && !livro.getAutores().isEmpty()) {
				pst.setInt(i, livro.getAutores().get(0).getId());
				i++;
			}

			if (livro.getCategorias() != null && !livro.getCategorias().isEmpty()) {
				pst.setInt(i, livro.getCategorias().get(0).getId());
				i++;
			}

			if (livro.getEditora() != null && livro.getEditora().getNomeEditora() != null) {
				pst.setString(i, livro.getEditora().getNomeEditora());
				i++;
			}

			if (livro.getEdicao() != null && livro.getEdicao().getAno() != 0) {
				pst.setInt(i, livro.getEdicao().getAno());
				i++;
			}

			if (livro.getEdicao() != null && livro.getEdicao().getNumero() != 0) {
				pst.setInt(i, livro.getEdicao().getNumero());
				i++;
			}

			if (livro.getIsbn() != null) {
				pst.setString(i, livro.getIsbn());
				i++;
			}

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> livros = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Livro l = new Livro();
				Edicao e = new Edicao();
				Dimensoes d = new Dimensoes();
				StatusLivro s = new StatusLivro();

				l.setId(rs.getInt("id_livro"));
				l.setTitulo(rs.getString("titulo"));
				e.setAno(rs.getInt("ano"));
				e.setNumero(rs.getInt("edicao"));
				l.setIsbn(rs.getString("isbn"));
				e.setNumeroPagina(rs.getInt("numero_pagina"));
				l.setSinopse(rs.getString("sinopse"));
				d.setAltura(rs.getDouble("altura"));
				d.setLargura(rs.getDouble("largura"));
				d.setPeso(rs.getDouble("peso"));
				d.setProfundidade(rs.getDouble("profundidade"));
				l.setCodigoBarras(rs.getString("codigo_barras"));
				s.setId(rs.getInt("id_status"));
				s.setStatus(rs.getBoolean("status"));
				s.setJustificativa(rs.getString("justificativa"));
				l.setPrecoVenda(rs.getDouble("preco_venda"));
				l.setQtde_estoque(rs.getInt("qtde_estoque"));
				l.setQtde_venda(rs.getInt("qtde_venda"));

				GrupoPrecificacao grupo = new GrupoPrecificacao();
				grupo.setId(rs.getInt("fk_grupo"));
				l.setGrupoPrecificacao(grupo);

				Editora editora = new Editora();
				editora.setId(rs.getInt("fk_editora"));
				l.setEditora(editora);

				e.setDimensoes(d);
				l.setEdicao(e);
				l.setStatusLivro(s);

				// Consultar autores do livro
				l.setAutores(new ArrayList<Autor>());
				pst = connection.prepareStatement(("SELECT autor.id_autor, autor.nome_autor "
						+ "FROM tb_livro_autor as livro_autor "
						+ "JOIN tb_autor as autor ON autor.id_autor = livro_autor.fk_autor " + "WHERE fk_livro=?;"));
				pst.setInt(1, l.getId());
				ResultSet rs2 = pst.executeQuery();
				while (rs2.next()) {
					Autor a = new Autor(rs2.getInt("id_autor"), rs2.getString("nome_autor"));
					l.getAutores().add(a);
				}

				// Consultar categorias do livro
				l.setCategorias(new ArrayList<Categoria>());
				pst = connection.prepareStatement("SELECT categoria.id_categoria, categoria.nome_categoria "
						+ "FROM tb_livro_cat as livro_cat "
						+ "JOIN tb_categoria_livro as categoria ON categoria.id_categoria = livro_cat.fk_categoria "
						+ "WHERE fk_livro=?;");
				pst.setInt(1, l.getId());
				rs2 = pst.executeQuery();
				while (rs2.next()) {
					Categoria c = new Categoria(rs2.getInt("id_categoria"), rs2.getString("nome_categoria"));
					l.getCategorias().add(c);
				}
				livros.add(l);
			}

			return livros;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally // Executa o bloco abaixo independente do que ocorreu
		{
			try // Ocorreu um erro de SQLException
			{
				pst.close(); // Nao sera mais utilizado. Fecha o
				connection.close(); // Fecha a conexão com o BD
			} catch (SQLException e) // Ocorreu um erro no fechamento da conexao
			{
				e.printStackTrace(); // Exibe uma mensagem com a excecao
			}
		}
		return null;
	}

	public void inativar(EntidadeDominio entidade) {
        openConnection();
        PreparedStatement pst = null;
        Livro livro = (Livro) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE tb_livro SET (status)");
            sql.append(" = (?)");
            sql.append(" WHERE id_livro = ?");

            pst = connection.prepareStatement(sql.toString());

            pst.setInt(1, livro.getStatusLivro().getId());
            pst.setInt(2, livro.getId());

            pst.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void consultarFornecedor (ResultSet rs, Estoque e, ResultSet rs2) throws SQLException {
            while (rs2.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id_fornecedor"));
                fornecedor.setId(rs.getInt("nome_fornecedor"));
                e.setFornecedor(fornecedor);
            }
        }
    }

	/**
	 * TODO Descrição do Método
	 *
	 * @param entidade
	 * @return
	 * @see fai.dao.IDAO#consulta(fai.domain.EntidadeDominio)
	 */
	public Endereco findById(Integer enderecoId) {

		PreparedStatement pst = null;

		String sql = null;

		sql = "SELECT * FROM tb_endereco WHERE id_endereco = ?";

		try {
			openConnection();
			pst = connection.prepareStatement(sql);

			if (enderecoId != null) {
				pst.setInt(1, enderecoId);
			}

			ResultSet rs = pst.executeQuery();
			Endereco endereco = null;

			while (rs.next()) {
				endereco = new Endereco();
				Cidade c = new Cidade();
				Estado estado = new Estado();

				endereco.setId(rs.getInt("id_endereco"));
				c.setNome(rs.getString("cidade"));
				estado.setNome(rs.getString("estado"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setCep(rs.getString("cep"));
				endereco.setRua(rs.getString("rua"));
				endereco.setTiporesidencia(rs.getString("tiporesidencia"));
				endereco.setTipoendereco(rs.getString("tipoendereco"));
				endereco.setPais(rs.getString("pais"));

				c.setEstado(estado);
				endereco.setCidade(c);

			}

			return endereco;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Executa o bloco abaixo idependente do que ocorreu
		{
			try // Ocorreu um erro de SQLException
			{
				pst.close(); // Nao sera mais utilizado. Fecha o
				connection.close(); // Fecha a conexão com o BD
			} catch (SQLException e) // Ocorreu um erro no fechamento da conexao
			{
				e.printStackTrace(); // Exibe uma mensagem com a excecao
			}
		}
		return null;

	}

	public List<Endereco> findByCliente(Integer clienteId) {

		PreparedStatement pst = null;

		String sql = null;

		sql = "SELECT * FROM tb_endereco WHERE id_cliente = ?";

		try {
			openConnection();
			pst = connection.prepareStatement(sql);

			if (clienteId != null) {
				pst.setInt(1, clienteId);
			}

			ResultSet rs = pst.executeQuery();
			List<Endereco> enderecos = new ArrayList<Endereco>();
			while (rs.next()) {
				Endereco e = new Endereco();
				Cidade c = new Cidade();
				Estado estado = new Estado();

				e.setId(rs.getInt("id_endereco"));
				c.setNome(rs.getString("cidade"));
				estado.setNome(rs.getString("estado"));
				e.setBairro(rs.getString("bairro"));
				e.setNumero(rs.getString("numero"));
				e.setCep(rs.getString("cep"));
				e.setRua(rs.getString("rua"));
				e.setTiporesidencia(rs.getString("tiporesidencia"));
				e.setTipoendereco(rs.getString("tipoendereco"));
				e.setPais(rs.getString("pais"));

				c.setEstado(estado);
				e.setCidade(c);

				enderecos.add(e);
			}

			return enderecos;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Executa o bloco abaixo idependente do que ocorreu
		{
			try // Ocorreu um erro de SQLException
			{
				pst.close(); // Nao sera mais utilizado. Fecha o
				connection.close(); // Fecha a conexão com o BD
			} catch (SQLException e) // Ocorreu um erro no fechamento da conexao
			{
				e.printStackTrace(); // Exibe uma mensagem com a excecao
			}
		}
		return null;

	}
}
