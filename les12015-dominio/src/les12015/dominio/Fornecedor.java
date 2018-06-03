package les12015.dominio;

public class Fornecedor extends EntidadeDominio{
    private String nome;

    public Fornecedor() {
    }

    public Fornecedor(Integer id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
