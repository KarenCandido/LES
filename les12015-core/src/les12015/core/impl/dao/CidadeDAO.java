package les12015.core.impl.dao;

import les12015.dominio.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO extends AbstractJdbcDAO {
	
	protected CidadeDAO(String table, String idTable) {
		super("tb_cidade", "id_cidade");
	}

	public CidadeDAO(Connection cx) {
		super(cx, "tb_cidade", "id_cidade");
	}

	public CidadeDAO() {
		super("tb_cidade", "id_cidade");
	}

	
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Cidade cidade = (Cidade) entidade;

		if (cidade == null) {
			cidade = new Cidade();
		}
		//////////////////////////////////////////////
		String sql = "SELECT * FROM tb_cidade "
				+ "JOIN tb_estado ON tb_estado.id_estado=tb_cidade.fk_estado JOIN tb_pais ON tb_pais.id=tb_estado.fk_pais WHERE";
		//////////////////////////////////////////////
		if (cidade.getId() != null)
			sql += " id_cidade = ? AND";
		if (cidade.getNome() != null)
			sql += " tb_cidade.nome = ? AND";
		////////////////////////////////////
		if (sql.endsWith(" AND"))
			sql = sql.substring(0, sql.length() - 4) + ";";

		else
			sql = "SELECT * FROM tb_cidade "
					+ "JOIN tb_estado ON tb_estado.id_estado=tb_cidade.fk_estado JOIN tb_pais ON tb_pais.id=tb_estado.fk_pais";

		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			int i = 1;

			if (cidade.getId() != null) {
				pst.setInt(i, cidade.getId());
				i++;
			}

			if (cidade.getNome() != null) {
				pst.setString(i, cidade.getNome());
				i++;
			}

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> cidades = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Cidade cid = new Cidade();
				Estado est = new Estado();
				Pais pais = new Pais();

				cid.setId(rs.getInt("id_cidade"));
				cid.setNome(rs.getString("nome_cidade"));
				est.setId(rs.getInt("id_estado"));
				est.setNome(rs.getString("nome_estado"));
				est.setUf(rs.getString("uf"));
				pais.setId(rs.getInt("id"));
				pais.setNome(rs.getString("nome_pais"));
				pais.setSigla(rs.getString("sigla"));

				est.setPais(pais);
				cid.setEstado(est);

				cidades.add(cid);
			}
			return cidades;
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

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
