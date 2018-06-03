package les12015.dominio;

public class Telefone extends EntidadeDominio {
    private String ddd;
    private String numero;
    private String tipoTelefone;
    private Cliente cliente;

    public Telefone() {
    }

    public Telefone(Integer id, String numero, Cliente cliente) {
        super(id);
        this.numero = numero;
        this.cliente = cliente;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
