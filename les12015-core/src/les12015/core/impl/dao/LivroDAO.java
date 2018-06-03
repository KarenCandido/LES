package les12015.core.impl.dao;

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
import les12015.dominio.EntidadeDominio;
import les12015.dominio.GrupoPrecificacao;
import les12015.dominio.Livro;
import les12015.dominio.StatusLivro;

public class LivroDAO extends AbstractJdbcDAO {

	public LivroDAO() {
		super("tb_livro", "id_livro");
	}

	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Livro livro = (Livro) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_livro(titulo, ano, edicao, isbn, numero_pagina, sinopse, altura, largura, peso,"
					+ "profundidade, codigo_barras, preco_venda, qtde_estoque, qtde_venda, fk_grupo, fk_editora, fk_status)");
			sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); // campo a ser inserido

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

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
			pst.setInt(17, livro.getStatusLivro().getId());
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int id = 0;
			if (rs.next())
				id = rs.getInt(1);
			livro.setId(id);

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
	 * @see fai.dao.IDAO#alterar(fai.domain.EntidadeDominio)
	 */
	@Override
	public void alterar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Livro livro = (Livro) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_livro SET (titulo, ano, edicao, isbn, numero_pagina, sinopse, altura, largura, peso,"
					+ "profundidade, codigo_barras, preco_venda, qtde_estoque, qtde_venda, fk_grupo, fk_editora)");
			sql.append(" = (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			sql.append(" WHERE id_livro = ?");

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
			pst.setInt(17, livro.getId());


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
	
	public void excluir(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst=null;
		StringBuilder sb = new StringBuilder();
		try {
			connection.setAutoCommit(false);
			// Excluir dado da tabela tb_livro_cat
			sb = new StringBuilder();
			sb.append("DELETE FROM tb_livro_cat WHERE fk_livro = ?");
			pst = connection.prepareStatement(sb.toString());
			pst.setInt(1, entidade.getId());
			pst.executeUpdate();
			connection.commit();

			// Excluir dado da tabela tb_livro_autor
			sb = new StringBuilder();
			sb.append("DELETE FROM tb_livro_autor WHERE fk_livro = ?");
			pst = connection.prepareStatement(sb.toString());
			pst.setInt(1, entidade.getId());
			pst.executeUpdate();
			connection.commit();
			
			// Excluir dado da tabela tb_livro
			sb = new StringBuilder();
			sb.append("DELETE FROM tb_livro WHERE id_livro = ?");
			pst = connection.prepareStatement(sb.toString());
			pst.setInt(1, entidade.getId());
			pst.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			
			try {
				pst.close();
				if(ctrlTransaction)
					connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
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
		Livro livro = (Livro) entidade;

		if (livro == null) {
			livro = new Livro();
		}

		String sql = "SELECT * FROM Livro WHERE";

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
			//SELECT autor.id_autor, autor.nome_autor "
//			+ "FROM tb_livro_autor as livro_autor "
//			+ "JOIN tb_autor as autor ON autor.id_autor = livro_autor.fk_autor " + "WHERE fk_livro=?;
			sql = "SELECT * "
					+ "FROM tb_livro "
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
				s.setStatus(rs.getBoolean("status"));
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

}