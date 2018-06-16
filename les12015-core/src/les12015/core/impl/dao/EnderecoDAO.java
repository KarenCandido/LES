
package les12015.core.impl.dao;

import les12015.dominio.Cidade;
import les12015.dominio.Cliente;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO extends AbstractJdbcDAO {

	private CidadeDAO cidadeDao;
	
	protected EnderecoDAO(String table, String idTable) {
		super("tb_endereco", "id");
		cidadeDao = new CidadeDAO();
	}

	public EnderecoDAO(Connection cx) {
		super(cx, "tb_endereco", "id");
	}

	public EnderecoDAO() {
		super("tb_endereco", "id");
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

			pst.setInt(11, endereco.getId());

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
		Endereco endereco = (Endereco) entidade;

		if (endereco == null)
			endereco = new Endereco();

		if (endereco.getCliente() == null){
            Cliente cliente = new Cliente();
            endereco.setCliente(cliente);
        }
		//////////////////////////////////////////////
		String sql = "SELECT * FROM tb_endereco JOIN tb_cidade ON tb_cidade.id_cidade=tb_endereco.fk_cidade WHERE";
		//////////////////////////////////////////////
		if (endereco.getId() != null)
			sql += " id = ? AND";
		if (endereco.getLogradouro() != null)
			sql += " logradouro = ? AND";
		if (endereco.getCliente().getId() != null)
			sql += " fk_cliente = ? AND";
		////////////////////////////////////
		if (sql.endsWith(" AND"))
			sql = sql.substring(0, sql.length() - 4) + ";";

		else
			sql = "SELECT * FROM tb_endereco JOIN tb_cidade ON tb_cidade.id_cidade=tb_endereco.fk_cidade;";

		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			int i = 1;

			if (endereco.getId() != null) {
				pst.setInt(i, endereco.getId());
				i++;
			}

			if (endereco.getLogradouro() != null) {
				pst.setString(i, endereco.getLogradouro());
				i++;
			}
			if (endereco.getCliente().getId() != null) {
				pst.setInt(i, endereco.getCliente().getId());
				i++;
			}

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> enderecos = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Endereco e = new Endereco();
				Cliente cli = new Cliente();
				Cidade cid = new Cidade();

				e.setId(rs.getInt("id"));
				e.setTipoResidencia(rs.getString("tipo_residencia"));
				e.setTipoEndereco(rs.getString("tipo_endereco"));
				e.setTipoLogradouro(rs.getString("tipo_logradouro"));
				e.setLogradouro(rs.getString("logradouro"));
				e.setNumero(rs.getString("numero"));
				e.setBairro(rs.getString("bairro"));
				e.setCep(rs.getString("cep"));
				e.setObservacao(rs.getString("obs"));
				cli.setId(rs.getInt("fk_cliente"));
				cid.setId(rs.getInt("fk_cidade"));
		        
				
				cid = (Cidade) cidadeDao.consultar(cid).get(0);

				e.setCliente(cli);
				e.setCidade(cid);

				enderecos.add(e);
			}
			return enderecos;
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