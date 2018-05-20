package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Editora;
import les12015.dominio.EntidadeDominio;

public class EditoraDAO extends AbstractJdbcDAO {

	public EditoraDAO(String table, String idTable) {
		super(table, idTable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		PreparedStatement pst = null;
		String sql = null;

		sql = "SELECT * FROM tb_editora";
		try {
			openConnection();
			pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> editoras = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Editora a = new Editora();
				a.setId(rs.getInt("id_editora"));
				a.setNomeEditora(rs.getString("nome_editora"));

				editoras.add(a);
			}
			return editoras;
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
				connection.close(); // Fecha a conex�o com o BD
			} catch (SQLException e) // Ocorreu um erro no fechamento da conexao
			{
				e.printStackTrace(); // Exibe uma mensagem com a excecao
			}
		}
		return null;
	}

}
