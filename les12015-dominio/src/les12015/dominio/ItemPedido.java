package les12015.dominio;

public class ItemPedido extends EntidadeDominio{
    private Livro livro;
    private Pedido pedido;
    private int qtdeLivro;
    private float precoVenda;

    public ItemPedido() {
    }

    public ItemPedido(Integer id, Livro livro, Pedido pedido, int qtdeLivro, float precoVenda) {
        super(id);
        this.livro = livro;
        this.pedido = pedido;
        this.qtdeLivro = qtdeLivro;
        this.precoVenda = precoVenda;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQtdeLivro() {
        return qtdeLivro;
    }

    public void setQtdeLivro(int qtdeLivro) {
        this.qtdeLivro = qtdeLivro;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }
}
