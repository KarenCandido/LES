package les12015.core.impl.dao;

import les12015.dominio.EntidadeDominio;

import java.sql.SQLException;
import java.util.List;

public class PedidoDAO extends AbstractJdbcDAO {

    public PedidoDAO(String table, String idTable) {
        super("tb_pedido", "id_pedido");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {

    }

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {

    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        return null;
    }
}
