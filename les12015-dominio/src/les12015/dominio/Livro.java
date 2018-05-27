package les12015.dominio;

import java.util.ArrayList;

public class Livro extends EntidadeDominio {
	private String titulo;

	private String sinopse;

	private String codigoBarras;
	private Double precoVenda;
	private String isbn;
	private int qtde_estoque;
	private int qtde_venda;
	private Edicao edicao;
	private Editora editora;
	private GrupoPrecificacao grupoPrecificacao;
	private StatusLivro statusLivro;

	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	private ArrayList<Autor> autores = new ArrayList<Autor>();

	// ______________________methods

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getQtde_estoque() {
		return qtde_estoque;
	}

	public void setQtde_estoque(int qtde_estoque) {
		this.qtde_estoque = qtde_estoque;
	}

	public int getQtde_venda() {
		return qtde_venda;
	}

	public void setQtde_venda(int qtde_venda) {
		this.qtde_venda = qtde_venda;
	}

	public Edicao getEdicao() {
		return edicao;
	}

	public void setEdicao(Edicao edicao) {
		this.edicao = edicao;
	}
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public GrupoPrecificacao getGrupoPrecificacao() {
		return grupoPrecificacao;
	}

	public void setGrupoPrecificacao(GrupoPrecificacao grupoPrecificacao) {
		this.grupoPrecificacao = grupoPrecificacao;
	}

	public StatusLivro getStatusLivro() {
		return statusLivro;
	}

	public void setStatusLivro(StatusLivro statusLivro) {
		this.statusLivro = statusLivro;
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}
}