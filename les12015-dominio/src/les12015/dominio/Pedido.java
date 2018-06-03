package les12015.dominio;

import java.sql.Timestamp;
import java.util.List;

import les12015.dominio.Livro;

public class Pedido extends EntidadeDominio {
	private Timestamp dataPedido;
	private String statusPedido;
	private Float valorFrete;
	private Endereco endereco;
	private Cliente cliente;

    public Pedido() {
    }

    public Pedido(Integer id, String statusPedido) {
        super(id);
        this.statusPedido = statusPedido;
    }

    public Timestamp getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Timestamp dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Float getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Float valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
