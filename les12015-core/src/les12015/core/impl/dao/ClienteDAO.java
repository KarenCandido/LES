
package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;

public class ClienteDAO extends AbstractJdbcDAO {

	public ClienteDAO() {
		super("tb_cliente", "id");
	}

	public void salvar(EntidadeDominio entidade) {

		openConnection();
		PreparedStatement pst = null;
		Cliente cliente = (Cliente) entidade;

		try {

			connection.setAutoCommit(false);

			//
			// Faz inserção do usuario
			//

			StringBuilder sql_insert_usuario = new StringBuilder();
			sql_insert_usuario.append(
					"INSERT INTO tb_usuario(nome, dt_nasc, email, cpf, genero, status)" + "VALUES (?,?,?,?,?,?);");

			pst = connection.prepareStatement(sql_insert_usuario.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, cliente.getNome());
			pst.setTimestamp(2, cliente.getDataNascimento());
			pst.setString(3, cliente.getEmail());
			pst.setString(4, cliente.getCpf());
			pst.setString(5, cliente.getGenero());
			pst.setBoolean(6, cliente.isStatus());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int id = 0;
			if (rs.next())
				id = rs.getInt(1);
			cliente.setId(id);

			//
			// Faz inserção do cliente
			//

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_cliente(fk_usuario) VALUES (?)");

			pst = connection.prepareStatement(sql.toString());
			pst.setInt(1, cliente.getId());
			pst.executeUpdate();

			rs = pst.getGeneratedKeys();
			int idCliente = 0;
			if (rs.next())
				idCliente = rs.getInt(1);
			cliente.setId(idCliente);

			//
			// Salva transação
			//

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
	 * @see fai.dao.IDAO#alterar(fai.domain.EntidadeDominio)
	 */
	@Override
	public void alterar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Cliente cliente = (Cliente) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_cliente SET (nome, dt_nasc, email, cpf, genero, status)");
			sql.append(" = (?, ?, ?, ?, ?, ?)");
			sql.append(" WHERE id_cliente = ?");

			pst = connection.prepareStatement(sql.toString());

			pst.setString(1, cliente.getNome());
			pst.setTimestamp(2, cliente.getDataNascimento());
			pst.setString(3, cliente.getEmail());
			pst.setString(4, cliente.getCpf());
			pst.setString(5, cliente.getGenero());
			pst.setBoolean(6, cliente.isStatus());

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
	 * @see fai.dao.IDAO#inativa(fai.domain.EntidadeDominio)
	 */
	public void inativar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Cliente cliente = (Cliente) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_livro SET (status)");
			sql.append(" = (?)");
			sql.append(" WHERE id_livro = ?");

			pst = connection.prepareStatement(sql.toString());

			pst.setBoolean(1, cliente.isStatus());
			pst.setInt(2, cliente.getId());

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
		Cliente cliente = (Cliente) entidade;

		if (cliente == null) {
			cliente = new Cliente();
		}

		String sql = null;

		if (cliente.getNome() == null) {
			cliente.setNome("");
		}

		if (cliente.getId() == null && cliente.getNome().equals("")) {
			sql = "SELECT * FROM tb_usuario WHERE status = ?";
		} else if (cliente.getId() != null && cliente.getNome().equals("")) {
			sql = "SELECT * FROM tb_usuario WHERE id=? and status = ?";
		} else if (cliente.getId() == null && !cliente.getNome().equals("")) {
			sql = "SELECT * FROM tb_usuario WHERE nome ilike ? and status = ?";
		}

		try {
			openConnection();
			pst = connection.prepareStatement(sql);

			if (cliente.getId() == null && cliente.getNome().equals("")) {
				pst.setBoolean(1, true);
			} else if (cliente.getId() != null && cliente.getNome().equals("")) {
				pst.setInt(1, cliente.getId());
				pst.setBoolean(2, true);
			} else if (cliente.getId() == null && !cliente.getNome().equals("")) {
				pst.setString(1, "%" + cliente.getNome() + "%");
				pst.setBoolean(2, true);
			}

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Cliente c = new Cliente();

				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setDataNascimento(rs.getTimestamp("dt_nasc"));
				c.setEmail(rs.getString("email"));
				c.setCpf(rs.getString("cpf"));
				c.setGenero(rs.getString("genero"));
				c.setStatus(rs.getBoolean("status"));

				clientes.add(c);
			}

			return clientes;
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
