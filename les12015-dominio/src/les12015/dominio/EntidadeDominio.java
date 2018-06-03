package les12015.dominio;


import java.util.Date;

import projeto.IEntidade;

public class EntidadeDominio implements IEntidade{
	
	public EntidadeDominio() {
		super();
	}
	
	public EntidadeDominio(Integer id) {
		super();
		this.id = id;
	}
	
	private Integer id;
	private Date dtCadastro;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	
	

}
