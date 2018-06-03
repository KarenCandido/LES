package les12015.dominio;

public class Categoria extends EntidadeDominio{
	
	
		public Categoria() {
			super();
		}

		public Categoria(Integer id, String nomeCategoria) {
			super(id);
			this.nomeCategoria = nomeCategoria;
		}

		private String nomeCategoria;
		//___________________mathods

		public String getNomeCategoria() {
			return nomeCategoria;
		}

		public void setNomeCategoria(String nomecategoria) {
			this.nomeCategoria = nomecategoria;
		}
		
}
