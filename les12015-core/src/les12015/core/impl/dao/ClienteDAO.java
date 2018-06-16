
package les12015.core.impl.dao;

import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Telefone;
import les12015.dominio.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends AbstractJdbcDAO {

	private TelefoneDAO telefoneDao;
	
	public ClienteDAO() {
		super("tb_cliente", "id");
		telefoneDao = new TelefoneDAO();
	}

	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Cliente cliente = (Cliente) entidade;
		try {
			connection.setAutoCommit(false);
			// Faz inserção do usuario
			StringBuilder sql_insert_usuario = new StringBuilder();
			sql_insert_usuario.append("INSERT INTO tb_usuario(email, senha, is_admin) VALUES (?, MD5(?),?);");
			pst = connection.prepareStatement(sql_insert_usuario.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, cliente.getEmail());
			pst.setString(2, cliente.getSenha());
			pst.setBoolean(3, false);

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
			sql.append("INSERT INTO tb_cliente(nome, dt_nasc, cpf, genero, status, fk_usuario)" +
					" VALUES (?, ?, ?, ?, ?, ?)");

			pst = connection.prepareStatement(sql.toString());
			pst.setString(1, cliente.getNome());
			pst.setTimestamp(2, cliente.getDataNascimento());
			pst.setString(3, cliente.getCpf());
			pst.setString(4, cliente.getGenero());
			pst.setBoolean(5, cliente.isStatus());

			pst.setInt(6, cliente.getId());
			pst.executeUpdate();

			rs = pst.getGeneratedKeys();
			int idCliente = 0;
			if (rs.next())
				idCliente = rs.getInt(1);
			cliente.setId(idCliente);

			cliente.getTelefone().setCliente(cliente);
           
			telefoneDao.salvar(cliente.getTelefone());

			// Salva transação
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
			sql.append("UPDATE tb_cliente SET (nome, dt_nasc, cpf, genero, status)");
			sql.append(" = (?, ?, ?, ?, ?)");
			sql.append(" WHERE id_cliente = ?");

			pst = connection.prepareStatement(sql.toString());

			pst.setString(1, cliente.getNome());
			pst.setTimestamp(2, cliente.getDataNascimento());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getGenero());
			pst.setBoolean(5, cliente.isStatus());
			pst.setInt(6, cliente.getId());
			pst.executeUpdate();
			connection.commit();

            cliente.getTelefone().setCliente(cliente);
            
            if(cliente.getTelefone().getId() == null) {
            	telefoneDao.salvar(cliente.getTelefone());
            } else {
            	telefoneDao.alterar(cliente.getTelefone());
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
	 * @see fai.dao.IDAO#inativa(fai.domain.EntidadeDominio)
	 */
	public void inativar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Cliente cliente = (Cliente) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_cliente SET (status)");
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
		
        String sql = "SELECT * FROM tb_cliente JOIN tb_usuario ON tb_usuario.id_usuario=tb_cliente.fk_usuario WHERE";

        if (cliente.getId() != null)
			sql += " id=? AND";
		else if (cliente.getNome() != null)
			sql += " nome ilike ? AND";
		else if (cliente.getId() != null)
            sql += " tb_cliente.fk_usuario=? AND";
        if (sql.endsWith(" AND"))
            sql = sql.substring(0, sql.length() - 4) + ";";
        else
            sql = "SELECT * FROM tb_cliente JOIN tb_usuario ON tb_usuario.id_usuario=tb_cliente.fk_usuario";

		try {
			openConnection();
			pst = connection.prepareStatement(sql);
            int i = 1;

			if (cliente.getId() != null) {
				pst.setInt(i, cliente.getId());
				i++;
			} else if (cliente.getNome() != null) {
				pst.setString(i, "%" + cliente.getNome() + "%");
                i++;
			} else if (cliente.getId() != null){
                pst.setInt(i, cliente.getId());
                i++;
			}

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Cliente c = new Cliente();

				c.setId(rs.getInt("id_cliente"));
				c.setNome(rs.getString("nome"));
				c.setDataNascimento(rs.getTimestamp("dt_nasc"));
                c.setId(rs.getInt("id_usuario"));
                c.setEmail(rs.getString("email"));
                c.setSenha(rs.getString("senha"));
                c.setAdmin(rs.getBoolean("is_admin"));
				c.setCpf(rs.getString("cpf"));
				c.setGenero(rs.getString("genero"));
				c.setStatus(rs.getBoolean("status"));
				
				// consulta o telefone do cliente
				Telefone telefone = new Telefone();
				telefone.setCliente(c);
				List<EntidadeDominio> telefones = telefoneDao.consultar(telefone);
				if( ! telefones.isEmpty()) {
					c.setTelefone( ( Telefone ) telefones.get(0));
				}
				
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
