package models;
//import biblioteca.Biblioteca;
//import usuario.Usuario;

public class Livro extends Genero {

	public String titulo;
	public String autor;
	public String isbn;      
	public String editora;
	public String anoPublicacao;
	public Genero genero;
	
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
