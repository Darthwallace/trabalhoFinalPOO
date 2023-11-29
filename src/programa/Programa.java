package programa;

import models.Biblioteca;

public class Programa {	
	public static void main(String[] args) {
		Biblioteca.startup();
		Biblioteca biblioteca = new Biblioteca();
		
		biblioteca.menuLogin();

		
//		/*
//		 * Criando classes DAO
//		 */
//		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
//		GeneroDAO     generoDao = new GeneroDAO();
//		LivroDAO      livroDao = new LivroDAO();
//		UsuarioDAO    usuarioDao = new UsuarioDAO();
//		
//		/*
//		 * Fim classes DAO
//		 */
//		
//		
//		/*
//		 * Criando classes models
//		 */
//		
//		Pessoa pessoa1 = new Pessoa("Guilherme", "27/08/2002");
//		ArrayList<Emprestimo> listaDeEmprestimos = null;
//        Admin admin = new Admin("Admin", "01/01/2000", 1, "admin@example.com", "senhaAdmin", true, listaDeEmprestimos);
//        
//    
//        Autor autor1 = new Autor("Stephen King", "21/09/1947", "Americano", "Stephen King é um autor renomado de ficção de terror.");
//        Autor autor2 = new Autor("J.K. Rowling", "31/07/1965", "Britânico", "J.K. Rowling é famosa por escrever a série de livros Harry Potter.");
//        Autor autor3 = new Autor("Agatha Christie", "15/09/1890", "Britânico", "Agatha Christie foi uma escritora conhecida por suas histórias de mistério e crime.");
//        
//        Genero genero1 = new Genero(1, "Aventura", "Livros de aventura");
//        Genero genero2 = new Genero(2, "Ficção Científica", "Livros de ficção científica");
//
//        Livro livro1 = new Livro(1, "O Senhor dos Anéis", "Uma grande saga de fantasia", "O Senhor dos Anéis", "J.R.R. Tolkien", "978-8578277109", "Martins Fontes", "1954", genero1);
//        Livro livro2 = new Livro(2, "Fundação", "Uma saga de ficção científica", "Fundação", "Isaac Asimov", "978-8576573233", "Aleph", "1951", genero2);
        
        /*
		 * Fim das classes models
		 */
	}
}
