package les12015.dominio;

import java.sql.Timestamp;

public class Cupom extends EntidadeDominio{
	private String tipo_cupom;
	private float valor_cupom;
	private Timestamp dt_validade;
	private Cliente cliente;

	public String getTipo_cupom() {
		return tipo_cupom;
	}

	public void setTipo_cupom(String tipo_cupom) {
		this.tipo_cupom = tipo_cupom;
	}

	public float getValor_cupom() {
		return valor_cupom;
	}

	public void setValor_cupom(float valor_cupom) {
		this.valor_cupom = valor_cupom;
	}

	public Timestamp getDt_validade() {
		return dt_validade;
	}

	public void setDt_validade(Timestamp dt_validade) {
		this.dt_validade = dt_validade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
