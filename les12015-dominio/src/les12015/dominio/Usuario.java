package les12015.dominio;

public class Usuario extends EntidadeDominio {
	private String email;
	private String senha;
	private String tipoUsuario;

    public Usuario() {
    }

    public Usuario(Integer id, String email) {
        super(id);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
