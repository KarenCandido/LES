package les12015.dominio;

public class GrupoPrecificacao extends EntidadeDominio{
		private String nomeGrupo;
		private Double porcentagemLucro;
		//______________________________methods
		public String getNomeGrupo() {
			return nomeGrupo;
		}
		public void setNomeGrupo(String nomegrupo) {
			this.nomeGrupo = nomegrupo;
		}
		public Double getPorcentagemLucro() {
			return porcentagemLucro;
		}
		public void setPorcentagem_lucro(Double porcentagemLucro) {
			this.porcentagemLucro = porcentagemLucro;
		}
		
}
