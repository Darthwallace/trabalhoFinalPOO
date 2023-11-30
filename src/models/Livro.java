package models;

import outros.ConstantesSistemas;

public class Livro  {

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", editora=" + editora
				+ ", anoPublicacao=" + anoPublicacao + ", genero=" + genero + "]";
	}

	public Livro(String titulo, String autor, String isbn, String editora,
			String anoPublicacao, Genero genero) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.editora = editora;
		this.anoPublicacao = anoPublicacao;
		this.genero = genero;
		this.setStatus(ConstantesSistemas.CONCLUIDO);
	}

	
	private int id;
	private String titulo;
	private String autor;
	private String isbn;      
	private String editora;
	private String anoPublicacao;
	private Genero genero;
	private int status;
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public String getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public void setGereno(Genero genero){
		this.genero = genero;
	}
	
	public Genero getGenero(){
		return genero;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
