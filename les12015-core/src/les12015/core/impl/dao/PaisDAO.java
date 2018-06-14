package les12015.core.impl.dao;


import les12015.dominio.EntidadeDominio;
import les12015.dominio.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO  extends AbstractJdbcDAO {

    protected PaisDAO(String table, String idTable) {
        super("tb_pais", "id");
    }

    public PaisDAO(Connection cx) {
        super(cx, "tb_pais", "id");
    }

    public PaisDAO() {
        super("tb_pais", "id");
    }


    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        PreparedStatement pst = null;
        Pais pais = (Pais) entidade;

        if (pais == null) {
            pais = new Pais();
        }
        //////////////////////////////////////////////
        String sql = "SELECT * FROM tb_pais WHERE";
        //////////////////////////////////////////////
        if (pais.getId() != null)
            sql += " id = ? AND";
        if (pais.getNome() != null)
            sql += " tb_pais.nome = ? AND";
        ////////////////////////////////////
        if (sql.endsWith(" AND"))
            sql = sql.substring(0, sql.length() - 4) + ";";

        else
            sql = "SELECT * FROM tb_pais";

        try {
            openConnection();
            pst = connection.prepareStatement(sql);
            int i = 1;

            if (pais.getId() != null) {
                pst.setInt(i, pais.getId());
                i++;
            }

            if (pais.getNome() != null) {
                pst.setString(i, pais.getNome());
                i++;
            }

            ResultSet rs = pst.executeQuery();
            List<EntidadeDominio> paises = new ArrayList<EntidadeDominio>();
            while (rs.next()) {
                Pais p = new Pais();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome_pais"));
                p.setSigla(rs.getString("sigla"));

                paises.add(p);
            }
            return paises;
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