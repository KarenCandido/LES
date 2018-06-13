package les12015.core.impl.dao;

import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Telefone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO extends AbstractJdbcDAO {

	protected TelefoneDAO(String table, String idTable) {
		super("tb_telefone", "id_telefone");
	}

	public TelefoneDAO(Connection cx) {
		super(cx, "tb_telefone", "id_telefone");
	}

	public TelefoneDAO() {
		super("tb_telefone", "id_telefone");
	}

	// SALVAR TELEFONE
	public void salvar(EntidadeDominio entidade) {
		if (connection == null) {
			openConnection();
		}
		PreparedStatement pst = null;
		Telefone tel = (Telefone) entidade;
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO tb_telefone(ddd, numero, tipo, fk_cliente)");
		sql.append(" VALUES (?, ?, ?, ?)");
		try {
			connection.setAutoCommit(false);

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, tel.getDdd());
			pst.setString(2, tel.getNumero());
			pst.setString(3, tel.getTipoTelefone());
			pst.setInt(4, tel.getCliente().getId());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idTel = 0;
			if (rs.next())
				idTel = rs.getInt(1);
			tel.setId(idTel);

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

	// ALTERAR TELEFONE
	@Override
	public void alterar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Telefone tel = (Telefone) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_telefone(ddd, numero, tipo, fk_cliente");
			sql.append(" = (?, ?, ?, ?)"); // campo a ser inserido
			sql.append(" WHERE id_telefone = ?");

			pst.setString(1, tel.getDdd());
			pst.setString(2, tel.getNumero());
			pst.setString(3, tel.getTipoTelefone());
			pst.setInt(4, tel.getCliente().getId());

			pst.setInt(5, tel.getId());

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

	// CONSULTAR TELEFONE
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Telefone telefone = (Telefone) entidade;

		if (telefone == null) {
			telefone = new Telefone();
		}
		//////////////////////////////////////////////
		String sql = "SELECT * FROM tb_telefone JOIN tb_cliente ON tb_cliente.id_cliente=tb_telefone.fk_cliente WHERE";
		//////////////////////////////////////////////
		if (telefone.getId() != null)
			sql += " id = ? AND";
		if (telefone.getDdd() != null && telefone.getNumero() != null)
			sql += " ddd = ? AND numero = ? AND";
		if (telefone.getCliente().getId() != null)
			sql += " fk_cliente = ? AND";
		////////////////////////////////////
		if (sql.endsWith(" AND"))
			sql = sql.substring(0, sql.length() - 4) + ";";

		else
			sql = "SELECT * FROM tb_telefone JOIN tb_cliente ON tb_cliente.id_cliente=tb_telefone.fk_cliente;";

		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			int i = 1;

			if (telefone.getId() != null) {
				pst.setInt(i, telefone.getId());
				i++;
			}

			if (telefone.getDdd() != null && telefone.getNumero() != null) {
				pst.setString(i, telefone.getDdd());
				i++;
				pst.setString(i, telefone.getNumero());
				i++;
			}
			if (telefone.getCliente().getId() != null) {
				pst.setInt(i, telefone.getCliente().getId());
				i++;
			}

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> telefones = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Telefone t = new Telefone();
				Cliente cli = new Cliente();

				t.setId(rs.getInt("id_telefone"));
				t.setDdd(rs.getString("ddd"));
				t.setNumero(rs.getString("numero"));
				t.setTipoTelefone(rs.getString("tipo"));
				cli.setId(rs.getInt("fk_cliente"));
				cli.setNome(rs.getString("nome"));
				cli.setDataNascimento(rs.getTimestamp("dt_nasc"));
				cli.setCpf(rs.getString("cpf"));
				cli.setGenero(rs.getString("genero"));
				cli.setStatus(rs.getBoolean("status"));

				t.setCliente(cli);

				telefones.add(t);
			}
			return telefones;
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
