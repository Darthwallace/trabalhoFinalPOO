package models;

public class Livro extends Genero {

	public Livro(Integer id, String nome, String descricao, String titulo, String autor, String isbn, String editora,
			String anoPublicacao, Genero genero) {
		super(id, nome, descricao);
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.editora = editora;
		this.anoPublicacao = anoPublicacao;
		this.genero = genero;
	}

	private String titulo;
	private String autor;
	private String isbn;      
	private String editora;
	private String anoPublicacao;
	private Genero genero;
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	
}
