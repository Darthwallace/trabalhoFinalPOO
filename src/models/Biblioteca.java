package models;
import java.util.ArrayList;

//TODO -  IMPLEMENTAR EMPRESTIMO PARA USUARIOS NORMAIS, IMPLEMENTAR, ENTREGA

import java.util.List;
import java.util.Scanner;

import dao.EmprestimoDAO;
import dao.GeneroDAO;
import dao.LivroDAO;
import dao.UsuarioDAO;
import interfaces.Login;
import outros.Utils;

public class Biblioteca extends Login {
	public static UsuarioDAO usuarioDao;
	public static GeneroDAO generoDao;
	public static LivroDAO livroDao;
	public static EmprestimoDAO emprestimoDao;

	public static void startup() {
		usuarioDao = new UsuarioDAO();
		generoDao = new GeneroDAO();
		livroDao = new LivroDAO();
		emprestimoDao = new EmprestimoDAO();

		
		// Instanciando três objetos da classe Usuario e Admin
        Usuario usuario1 = new Usuario("João", "1990-01-01", "joao@email.com", "senha123", false, new ArrayList<>());
        Usuario usuario2 = new Usuario("Maria", "1985-05-15", "maria@email.com", "senha456", true,  new ArrayList<>());
        Usuario usuario3 = new Usuario("Carlos", "1988-08-20", "carlos@email.com", "senha789", false, new ArrayList<>());
        Admin admin1 = new Admin("Admin1", "1990-05-15", "admin1@example.com", "senha123", true, new ArrayList<>());
        Admin admin2 = new Admin("Admin2", "1985-10-22", "admin2@example.com", "senha456", true, new ArrayList<>());
        
        usuarioDao.create(usuario1);
        usuarioDao.create(usuario2);
        usuarioDao.create(usuario3);
        usuarioDao.create(admin1);
        usuarioDao.create(admin2);
        
        // Instanciando alguns gêneros
        Genero genero1 = new Genero(1, "Aventura", "Livros de aventura");
        Genero genero2 = new Genero(2, "Ficção Científica", "Livros de ficção científica");
        
        generoDao.create(genero1);
        generoDao.create(genero2);
        
        // Instanciando alguns livros
        Livro livro1 = new Livro(1, "O Senhor dos Anéis", "Uma grande saga de fantasia", "O Senhor dos Anéis", "J.R.R. Tolkien", "978-8578277109", "Martins Fontes", "1954", genero1);
        Livro livro2 = new Livro(2, "Fundação", "Uma saga de ficção científica", "Fundação", "Isaac Asimov", "978-8576573233", "Aleph", "1951", genero2);
        livroDao.create(livro1);
        livroDao.create(livro2);
   
	}
	
	public List<Livro> listaLivros;
	public List<Usuario> listaUsuarios;
	public List<Emprestimo> listaEmprestimos;
	
	public void setListaLivros(List<Livro> listaLivros){
		this.listaLivros = listaLivros;
	}
	
	public List<Livro> getListaLivros(){
		return listaLivros;
	}
	
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public List<Usuario> getListaUsuarios(){
		return listaUsuarios;
	}
	
	public void setListaEmprestimo(List<Emprestimo> listaEmprestimos) {
		this.listaEmprestimos = listaEmprestimos;
	}
	
	public List<Emprestimo> getListaEmprestimos(){
		return listaEmprestimos;
	}
	
	public void menuLogin() {
		Scanner entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n### B I B L I O T E C A ###\n");
			System.out.println("Bem-vindo as sistema de gerênciamento de biblioteca.\n");
			System.out.println("Faça login para acessar:\n");
			
			String email = Utils.printar("Digite o seu E-mail");
			String senha = Utils.printar("Digite a sua Senha:");
			Usuario usuario = login(email, senha, usuarioDao);
			
			if (usuario == null) {
				System.out.println("Nenhum usuário encontrado!");
				continue;
			}
			
			if (usuario instanceof Admin) {
				Admin admin = (Admin) usuario; // Downcast para a classe mais específica

				System.out.println("Bem-vindo administrador: " + admin.getNome());
				System.out.println("O que você deseja fazer ?");
				System.out.println("1 - Cadastrar um usuário ?");
				System.out.println("2 - Excluir um usuário ?");
				System.out.println("3 - Ver quais usuários estão cadastrados?");
				System.out.println("4 - Deseja verificar os empréstimos ?");
				
				
				String opcao = entrada.nextLine();
				switch(opcao) {
				case "1":
					String nome = Utils.printar("Digite o nome do usuário");
					String dataNascimento = Utils.printar("Digite a data de nascimento do usuário");
					String emailUser = Utils.printar("Digite o email do usuário");
					String senhaUser = Utils.printar("Digite a senha do usuário");
					boolean isAdmin = Utils.printar("O usuário deve ser admin? SIM ou NAO") == "SIM" ? true : false;
					
					admin.criarUsuario(usuarioDao,  new Usuario(nome, dataNascimento, emailUser, senhaUser, isAdmin,  new ArrayList<>()));
					System.out.println("Usuário criado com sucesso !!!!");
					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					break;
				default:
					System.out.println("Opção Inválida!");
				}
				
			}
			
			exibirInformacoesUsuario(usuario);
		}
	}
	
	// Método para exibir informações de um usuário
    public static void exibirInformacoesUsuario(Usuario usuario) { 	
    	System.out.println("Bem-vindo novamente :) :) " + usuario.getNome());
    	System.out.println("Aqui em baixo estão suas informações:");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
        System.out.println("ID: " + usuario.getId());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Senha: " + usuario.getSenha());
        System.out.println("isAdmin: " + usuario.getIsAdmin());
        System.out.println("Histórico de Empréstimos: " + usuario.getHistoricoEmprestimo());
        System.out.println("----------------------------------------");
    }
}
