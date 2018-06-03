package les12015.dominio;

public class BandeiraCartao extends EntidadeDominio{
    private String bandeira;

    public BandeiraCartao() {
    }

    public BandeiraCartao(Integer id, String bandeira) {
        super(id);
        this.bandeira = bandeira;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
}
