package les12015.dominio;

public class Edicao {
	
	private String ano;
	private int numero;
	
	private int numeroPagina;
	private Dimensoes dimensoes;
	
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int edicao) {
		this.numero = edicao;
	}
	
	public int getNumeroPagina() {
		return numeroPagina;
	}
	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
	public Dimensoes getDimensoes() {
		return dimensoes;
	}
	public void setDimensoes(Dimensoes dimensoes) {
		this.dimensoes = dimensoes;
	}
	
	
	
	
	
	
	
}
