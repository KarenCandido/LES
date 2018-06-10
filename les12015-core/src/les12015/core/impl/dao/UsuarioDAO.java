
package les12015.core.impl.dao;

import les12015.dominio.EntidadeDominio;
import les12015.dominio.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends AbstractJdbcDAO {

	public UsuarioDAO() {
		super("tb_usuario", "id_usuario");
	}

	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Usuario usuario = (Usuario) entidade;
		try {
			connection.setAutoCommit(false);
			// Faz inserção do usuario
			StringBuilder sql_insert_usuario = new StringBuilder();
			sql_insert_usuario.append("INSERT INTO tb_usuario(email, senha, is_admin) VALUES (?, MD5(?),?);");
			pst = connection.prepareStatement(sql_insert_usuario.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getSenha());
			pst.setBoolean(3, false);

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int id = 0;
			if (rs.next())
				id = rs.getInt(1);
			usuario.setId(id);

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
		Usuario usuario = (Usuario) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_usuario SET (email, senha, is_admin)");
			sql.append(" = (?, MD5(?),?)");
			sql.append(" WHERE id_usuario = ?");

			pst = connection.prepareStatement(sql.toString());
            pst.setString(1, usuario.getEmail());
            pst.setString(2, usuario.getSenha());
            pst.setBoolean(3, false);
            pst.setInt(4, usuario.getId());

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
		Usuario usuario = (Usuario) entidade;

		if (usuario == null) {
			usuario = new Usuario();
		}

		String sql = null;

		if (usuario.getEmail() == null) {
			usuario.setEmail("");
		}

		if (usuario.getId() == null && usuario.getEmail().equals("")) {
			sql = "SELECT * FROM tb_usuario";
		} else if (usuario.getId() != null) {
			sql = "SELECT * FROM tb_usuario WHERE id_usuario=?";
		} else if (!usuario.getEmail().equals("")) {
			sql = "SELECT * FROM tb_usuario WHERE email ilike ?";
		} else if (usuario.getId() != null && !usuario.getEmail().equals("")) {
            sql = "SELECT * FROM tb_usuario WHERE id_usuario=? and email ilike ?";
        }

		try {
			openConnection();
			pst = connection.prepareStatement(sql);

			if (usuario.getId() != null && usuario.getEmail().equals("")) {
				pst.setInt(1, usuario.getId());
			} else if (!usuario.getEmail().equals("")) {
				pst.setString(1, "%" + usuario.getEmail() + "%");
			} else if (usuario.getId() != null && !usuario.getEmail().equals("")) {
				pst.setInt(1, usuario.getId());
				pst.setString(2, "%" + usuario.getEmail() + "%");
	        }

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> usuarios = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Usuario u = new Usuario();

                u.setId(rs.getInt("id_usuario"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setAdmin(rs.getBoolean("is_admin"));

				usuarios.add(u);
			}

			return usuarios;
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
