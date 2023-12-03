package models;

import outros.ConstantesSistemas;

public class Livro  {
	// Atributos
	private int id;
	private String titulo;
	private String autor;
	private String isbn;      
	private String editora;
	private String anoPublicacao;
	private Genero genero;
	private int status;

	// Construtor
	public Livro(String titulo, String autor, String isbn, String editora, String anoPublicacao, Genero genero) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.editora = editora;
		this.anoPublicacao = anoPublicacao;
		this.genero = genero;
		this.setStatus(ConstantesSistemas.CONCLUIDO);
	}

	public int getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public String getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public Genero getGenero(){
		return genero;
	}
	
	public void setGereno(Genero genero){
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", editora=" + editora
				+ ", anoPublicacao=" + anoPublicacao + ", genero=" + genero + "]";
	}
}
