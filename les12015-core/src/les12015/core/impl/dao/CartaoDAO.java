package les12015.core.impl.dao;

import les12015.dominio.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartaoDAO extends AbstractJdbcDAO {

	protected CartaoDAO(String table, String idTable) {
		super("tb_cartao", "id_cartao");
	}

	public CartaoDAO(Connection cx) {
		super(cx, "tb_cartao", "id_cartao");
	}

	public CartaoDAO() {
		super("tb_cartao", "id_cartao");
	}

	// SALVAR CARTÃO
	public void salvar(EntidadeDominio entidade) {
		if (connection == null) {
			openConnection();
		}
		PreparedStatement pst = null;
		Cartao cartao = (Cartao) entidade;
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO tb_cartao(numero, nome_impresso, codigo_seguranca, dt_vencimento, fk_cliente, fk_bandeira)");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?)");
		try {
			connection.setAutoCommit(false);

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, cartao.getNumero());
			pst.setString(2, cartao.getNomeImpresso());
			pst.setString(3, cartao.getCodigoSeguranca());
			pst.setTimestamp(4, cartao.getDataVencimento());
			pst.setInt(5, cartao.getCliente().getId());
			pst.setInt(6, cartao.getBandeiraCartao().getId());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idCartao = 0;
			if (rs.next())
				idCartao = rs.getInt(1);
			cartao.setId(idCartao);

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

	// ALTERAR CARTÃO
	@Override
	public void alterar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Cartao cartao = (Cartao) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_cartao(numero, nome_impresso, codigo_seguranca, dt_vencimento, fk_cliente, fk_bandeira)");
			sql.append(" = (?, ?, ?, ?, ?, ?)"); // campo a ser inserido
			sql.append(" WHERE id_cartao = ?");

            pst.setString(1, cartao.getNumero());
            pst.setString(2, cartao.getNomeImpresso());
            pst.setString(3, cartao.getCodigoSeguranca());
            pst.setTimestamp(4, cartao.getDataVencimento());
            pst.setInt(5, cartao.getCliente().getId());
            pst.setInt(6, cartao.getBandeiraCartao().getId());

			pst.setInt(7, cartao.getId());

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

	// CONSULTAR CARTAO
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Cartao cartao = (Cartao) entidade;

		if (cartao == null) {
			cartao = new Cartao();
		}
		//////////////////////////////////////////////
		String sql = "SELECT * FROM tb_cartao " +
                "JOIN tb_cliente ON tb_cliente.id_cliente=tb_cartao.fk_cliente " +
                "JOIN tb_bandeiras_aceitas ON tb.bandeiras_aceitas.id_bandeiras=tb_cartao.fk_bandeira" +
                "WHERE";
		//////////////////////////////////////////////
		if (cartao.getId() != null)
			sql += " id = ? AND";
		if (cartao.getNumero() != null)
			sql += " numero = ? AND";
        if (cartao.getNomeImpresso() != null)
            sql += " nome_impresso = ? AND";
		if (cartao.getCliente().getId() != null)
			sql += " fk_cliente = ? AND";
        if (cartao.getBandeiraCartao().getId() != null)
            sql += " fk_bandeira = ? AND";
		////////////////////////////////////
		if (sql.endsWith(" AND"))
			sql = sql.substring(0, sql.length() - 4) + ";";

		else
            sql = "SELECT * FROM tb_cartao " +
                    "JOIN tb_cliente ON tb_cliente.id_cliente=tb_cartao.fk_cliente " +
                    "JOIN tb_bandeiras_aceitas ON tb.bandeiras_aceitas.id_bandeiras=tb_cartao.fk_bandeira";

		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			int i = 1;

			if (cartao.getId() != null) {
				pst.setInt(i, cartao.getId());
				i++;
			}

			if (cartao.getNumero() != null) {
				pst.setString(i, cartao.getNumero());
				i++;
			}

            if (cartao.getNomeImpresso() != null) {
                pst.setString(i, cartao.getNomeImpresso());
                i++;
            }

			if (cartao.getCliente().getId() != null) {
				pst.setInt(i, cartao.getCliente().getId());
				i++;
			}

            if (cartao.getBandeiraCartao().getId() != null) {
                pst.setInt(i, cartao.getBandeiraCartao().getId());
                i++;
            }

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> cartoes = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Cartao car = new Cartao();
				Cliente cli = new Cliente();
                BandeiraCartao bandeira = new BandeiraCartao();

				car.setId(rs.getInt("id_cartao"));
                car.setNumero(rs.getString("numero"));
                car.setNomeImpresso(rs.getString("nome_impresso"));
                car.setCodigoSeguranca(rs.getString("codigo_seguranca"));
                car.setDataVencimento(rs.getTimestamp("dt_vencimento"));
				cli.setId(rs.getInt("fk_cliente"));
				cli.setNome(rs.getString("nome"));
				cli.setDataNascimento(rs.getTimestamp("dt_nasc"));
				cli.setCpf(rs.getString("cpf"));
				cli.setGenero(rs.getString("genero"));
				cli.setStatus(rs.getBoolean("status"));
                bandeira.setId(rs.getInt("fk_bandeira"));
                bandeira.setBandeira(rs.getString("bandeira"));

				car.setCliente(cli);
                car.setBandeiraCartao(bandeira);

				cartoes.add(car);
			}
			return cartoes;
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
