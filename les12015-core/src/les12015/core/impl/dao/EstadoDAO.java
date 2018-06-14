package les12015.core.impl.dao;

import les12015.dominio.EntidadeDominio;
import les12015.dominio.Estado;
import les12015.dominio.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO extends AbstractJdbcDAO {

    protected EstadoDAO(String table, String idTable) {
        super("tb_estado", "id_estado");
    }

    public EstadoDAO(Connection cx) {
        super(cx, "tb_estado", "id_estado");
    }

    public EstadoDAO() {
        super("tb_estado", "id_estado");
    }


    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        PreparedStatement pst = null;
        Estado estado = (Estado) entidade;

        if (estado == null) {
            estado = new Estado();
        }
        //////////////////////////////////////////////
        String sql = "SELECT * FROM tb_estado "
                + "JOIN tb_pais ON tb_pais.id=tb_estado.fk_pais WHERE";
        //////////////////////////////////////////////
        if (estado.getId() != null)
            sql += " id_estado = ? AND";
        if (estado.getNome() != null)
            sql += " tb_estado.nome = ? AND";
        ////////////////////////////////////
        if (sql.endsWith(" AND"))
            sql = sql.substring(0, sql.length() - 4) + ";";

        else
            sql = "SELECT * FROM tb_estado "
                    + "JOIN tb_pais ON tb_pais.id=tb_estado.fk_pais";

        try {
            openConnection();
            pst = connection.prepareStatement(sql);
            int i = 1;

            if (estado.getId() != null) {
                pst.setInt(i, estado.getId());
                i++;
            }

            if (estado.getNome() != null) {
                pst.setString(i, estado.getNome());
                i++;
            }

            ResultSet rs = pst.executeQuery();
            List<EntidadeDominio> estados = new ArrayList<EntidadeDominio>();
            while (rs.next()) {
                Estado est = new Estado();
                Pais pais = new Pais();

                est.setId(rs.getInt("id_estado"));
                est.setNome(rs.getString("nome_estado"));
                est.setUf(rs.getString("uf"));
                pais.setId(rs.getInt("id"));
                pais.setNome(rs.getString("nome_pais"));
                pais.setSigla(rs.getString("sigla"));

                est.setPais(pais);

                estados.add(est);
            }
            return estados;
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