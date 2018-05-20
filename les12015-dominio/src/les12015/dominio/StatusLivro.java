package les12015.dominio;

public class StatusLivro extends EntidadeDominio{
		private boolean status;
		private String justificativa;
		
		//_______________methods
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public String getJustificativa() {
			return justificativa;
		}
		public void setJustificativa(String justificativa) {
			this.justificativa = justificativa;
		}
		
}
