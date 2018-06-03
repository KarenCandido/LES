package les12015.core.impl.dao;

import les12015.dominio.EntidadeDominio;
import les12015.dominio.Estoque;
import les12015.dominio.Fornecedor;
import les12015.dominio.Livro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO extends AbstractJdbcDAO {

    public EstoqueDAO() {
        super("tb_estoque", "id_estoque");
    }

    @Override
    public void salvar(EntidadeDominio entidade) {
        openConnection();
        PreparedStatement pst = null;
        Estoque estoque = (Estoque) entidade;
        Estoque estoqueBD = findByLivroId(estoque.getLivro().getId());

        if (estoqueBD == null) {
            try {
                connection.setAutoCommit(false);

                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO tb_estoque(qtde_entrada, valor_custo, dt_entrada, fk_fornecedor, fk_livro)");
                sql.append(" VALUES (?, ?, ?, ?, ?)"); // campo a ser inserido

                // Constroi o pst com o SQL
                pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

                pst.setInt(1, estoque.getQtdeEntrada()); // substitui os ? pelos dados inseridos
                pst.setFloat(2, estoque.getValorCusto());
                pst.setTimestamp(3, estoque.getDataEntrada());
                pst.setInt(4, estoque.getFornecedor().getId());
                pst.setInt(5, estoque.getLivro().getId());

                pst.executeUpdate();

                ResultSet rs = pst.getGeneratedKeys();
                int id = 0;
                if (rs.next())
                    id = rs.getInt(1);
                estoque.setId(id);

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

        } else {
            alterar(estoque, estoqueBD);
        }
    }

    private void alterarGenerico(Estoque estoqueAtual, Estoque estoqueBD, PreparedStatement pst) {
        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE tb_estoque SET(qtde_entrada, valor_custo, dt_entrada, fk_fornecedor, fk_livro)");
            sql.append(" = (?, ?, ?, ?, ?)");
            sql.append(" WHERE id_estoque=?"); // utualiza somente naquele registro

            // Constroi o pst com o SQL
            pst = connection.prepareStatement(sql.toString());

            pst.setInt(1, estoqueAtual.getQtdeEntrada()); // substitui os ? pelos dados inseridos
            pst.setFloat(2, estoqueAtual.getValorCusto());
            pst.setTimestamp(3, estoqueAtual.getDataEntrada());
            pst.setInt(4, estoqueAtual.getFornecedor().getId());
            pst.setInt(5, estoqueAtual.getLivro().getId());
            pst.setInt(6, estoqueBD.getId());

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if (rs.next())
                id = rs.getInt(1);
            estoqueAtual.setId(id);

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

    public void alterar(Estoque estoqueAtual, Estoque estoqueBD) {
        openConnection();
        PreparedStatement pst = null;

        if (estoqueAtual.getValorCusto() < estoqueBD.getValorCusto()) {
            estoqueAtual.setValorCusto(estoqueBD.getValorCusto());
        }

        estoqueAtual.setQtdeEntrada(estoqueAtual.getQtdeEntrada() + estoqueBD.getQtdeEntrada());

        alterarGenerico(estoqueAtual, estoqueBD, pst);

    }

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {
        openConnection();
        PreparedStatement pst = null;

        Estoque estoque = (Estoque) entidade;

        alterarGenerico(estoque, estoque, pst);
    }

    private void consultarFornecedor(ResultSet rs, Estoque e, ResultSet rs2) throws SQLException {
        while (rs2.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id_fornecedor"));
            fornecedor.setId(rs.getInt("nome_fornecedor"));
            e.setFornecedor(fornecedor);
        }
    }

    private void consultarLivro(Estoque e, ResultSet rs2) throws SQLException {
        while (rs2.next()) {
            Livro livro = new Livro();
            livro.setId(rs2.getInt("id_livro"));
            livro.setId(rs2.getInt("nome_livro"));
            e.setLivro(livro);
        }
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement pst = null;
        Estoque estoque = (Estoque) entidade;

        String sql = "SELECT * FROM tb_estoque";

        try {
            openConnection();
            pst = connection.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            List<EntidadeDominio> estoques = new ArrayList<EntidadeDominio>();
            while (rs.next()) {
                Estoque e = new Estoque();

                e.setId(rs.getInt("id_estoque"));
                e.setValorCusto(rs.getFloat("valor_custo"));
                e.setDataEntrada(rs.getTimestamp("dt_entrada"));
                e.setQtdeEntrada(rs.getInt("qtde_entrada"));

                pst = connection.prepareStatement("SELECT * FROM tb_livro WHERE id_livro=?;");
                pst.setInt(1, rs.getInt("fk_livro"));
                ResultSet rs2 = pst.executeQuery();
                consultarLivro(e, rs2);

                pst = connection.prepareStatement("SELECT * FROM tb_fornecedor WHERE id_fornecedor=?;");
                pst.setInt(1, rs.getInt("fk_fornecedor"));
                rs2 = pst.executeQuery();
                consultarFornecedor(rs, e, rs2);
                estoques.add(e);
            }
            return estoques;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Estoque findById(Integer estoqueId) {
        PreparedStatement pst = null;

        String sql = "SELECT * FROM tb_estoque WHERE id_estoque = ?";

        try {
            openConnection();
            pst = connection.prepareStatement(sql);

            pst.setInt(1, estoqueId);
            ResultSet rs = pst.executeQuery();
            Estoque e = null;
            while (rs.next()) {
                e = new Estoque();
                e.setId(rs.getInt("id_estoque"));
                e.setValorCusto(rs.getFloat("valor_custo"));
                e.setDataEntrada(rs.getTimestamp("dt_entrada"));
                e.setQtdeEntrada(rs.getInt("qtde_entrada"));

                pst = connection.prepareStatement("SELECT * FROM tb_livro WHERE id_livro=?;");
                pst.setInt(1, rs.getInt("fk_livro"));
                ResultSet rs2 = pst.executeQuery();
                consultarLivro(e, rs2);

                pst = connection.prepareStatement("SELECT * FROM tb_fornecedor WHERE id_fornecedor=?;");
                pst.setInt(1, rs.getInt("fk_fornecedor"));
                rs2 = pst.executeQuery();
                consultarFornecedor(rs, e, rs2);
            }
            return e;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Estoque findByLivroId(Integer livroId) {
        PreparedStatement pst = null;

        String sql = "SELECT * FROM tb_estoque WHERE fk_livro = ?";

        try {
            openConnection();
            pst = connection.prepareStatement(sql);

            pst.setInt(1, livroId);
            ResultSet rs = pst.executeQuery();
            Estoque e = null;
            while (rs.next()) {
                e = new Estoque();
                e.setId(rs.getInt("id_estoque"));
                e.setValorCusto(rs.getFloat("valor_custo"));
                e.setDataEntrada(rs.getTimestamp("dt_entrada"));
                e.setQtdeEntrada(rs.getInt("qtde_entrada"));

                pst = connection.prepareStatement("SELECT * FROM tb_livro WHERE id_livro=?;");
                pst.setInt(1, rs.getInt("fk_livro"));
                ResultSet rs2 = pst.executeQuery();
                consultarLivro(e, rs2);

                pst = connection.prepareStatement("SELECT * FROM tb_fornecedor WHERE id_fornecedor=?;");
                pst.setInt(1, rs.getInt("fk_fornecedor"));
                rs2 = pst.executeQuery();
                consultarFornecedor(rs, e, rs2);
            }
            return e;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}