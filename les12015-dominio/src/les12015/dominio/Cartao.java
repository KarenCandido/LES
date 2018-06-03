package les12015.dominio;

import java.sql.Timestamp;

public class Cartao extends EntidadeDominio{
    private String numero;
    private String nomeImpresso;
    private String codigoSeguranca;
    private Timestamp dataVencimento;
    private BandeiraCartao bandeiraCartao;
    private Cliente cliente;

    public Cartao() {
    }

    public Cartao(Integer id, String numero, Timestamp dataVencimento, BandeiraCartao bandeiraCartao) {
        super(id);
        this.numero = numero;
        this.dataVencimento = dataVencimento;
        this.bandeiraCartao = bandeiraCartao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeImpresso() {
        return nomeImpresso;
    }

    public void setNomeImpresso(String nomeImpresso) {
        this.nomeImpresso = nomeImpresso;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public Timestamp getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Timestamp dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BandeiraCartao getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(BandeiraCartao bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
