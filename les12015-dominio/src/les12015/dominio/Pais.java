package les12015.dominio;

public class Pais extends EntidadeDominio{
    private String nome;
    private String sigla;

    public Pais() {
    }

    public Pais(Integer id, String nome, String sigla) {
        super(id);
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
