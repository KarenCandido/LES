
package les12015.core.impl.dao;

import les12015.dominio.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO extends AbstractJdbcDAO {

	public FornecedorDAO() {
		super("tb_fornecedor", "id_for");
	}

	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Fornecedor fornecedor = (Fornecedor) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_fornecedor(nome_fornecedor)");
			sql.append(" VALUES (?)");

			pst = connection.prepareStatement(sql.toString());
			pst.setString(1, fornecedor.getNome());

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
	 * @see fai.dao.IDAO#alterar(fai.domain.EntidadeDominio)
	 */
	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		Fornecedor fornecedor = (Fornecedor) entidade;

		if (fornecedor == null) {
			fornecedor = new Fornecedor();
		}

		String sql = "SELECT * FROM tb_fornecedor WHERE";

		if (fornecedor.getId() != null)
			sql += " id_fornecedor = ? AND";
		if (fornecedor.getNome() != null)
			sql += " nome_fornecedor = ? AND";

		////////////////////////////////////
		if (sql.endsWith(" AND"))
			sql = sql.substring(0, sql.length() - 4) + ";";

		else
			sql = "SELECT * FROM tb_fornecedor;";

		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			int i = 1;

			if (fornecedor.getId() != null) {
				pst.setInt(i, fornecedor.getId());
				i++;
			}

			if (fornecedor.getNome() != null) {
				pst.setString(i, fornecedor.getNome());
				i++;
			}


			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> fornecedores = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Fornecedor f = new Fornecedor();

				f.setId(rs.getInt("id_fornecedor"));
				f.setNome(rs.getString("nome_fornecedor"));

				fornecedores.add(f);
			}

			return fornecedores;
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
