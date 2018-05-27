package les12015.dominio;

public class Autor extends EntidadeDominio{
	
	public Autor() {
		super();
	}
	
	public Autor(String nomeAutor) {
		super();
		this.nomeAutor = nomeAutor;
	}

	private String nomeAutor;
	//_____________________________methods

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	
}
