package les12015.dominio;

import java.sql.Timestamp;

public class Estoque extends EntidadeDominio{
    private int qtdeEntrada;
    private float valorCusto;
    private Timestamp dataEntrada;
    private Fornecedor fornecedor;
    private Livro livro;

    public Estoque() {
    }

    public Estoque(Integer id, Livro livro) {
        super(id);
        this.livro = livro;
    }

    public int getQtdeEntrada() {
        return qtdeEntrada;
    }

    public void setQtdeEntrada(int qtdeEntrada) {
        this.qtdeEntrada = qtdeEntrada;
    }

    public float getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Timestamp getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Timestamp dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
