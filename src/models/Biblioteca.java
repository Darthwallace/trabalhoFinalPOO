package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.EmprestimoDAO;
import dao.GeneroDAO;
import dao.LivroDAO;
import dao.UsuarioDAO;
import interfaces.Login;

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
		
		// Criando uma lista vazia de empréstimos para cada usuário
        List<Emprestimo> historicoEmprestimo1 = new ArrayList<>();
        List<Emprestimo> historicoEmprestimo2 = new ArrayList<>();
        List<Emprestimo> historicoEmprestimo3 = new ArrayList<>();
		
		// Instanciando três objetos da classe Usuario
        Usuario usuario1 = new Usuario("João", "1990-01-01", 1, "joao@email.com", "senha123", false, historicoEmprestimo1);
        Usuario usuario2 = new Usuario("Maria", "1985-05-15", 2, "maria@email.com", "senha456", true, historicoEmprestimo2);
        Usuario usuario3 = new Usuario("Carlos", "1988-08-20", 3, "carlos@email.com", "senha789", false, historicoEmprestimo3);

        usuarioDao.create(usuario1);
        usuarioDao.create(usuario2);
        usuarioDao.create(usuario3);
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
			System.out.println("Digite o seu E-mail:");
			String email = entrada.nextLine();
			System.out.println("Digite a sua Senha:");
			String senha = entrada.nextLine();
			
			Usuario usuario = login(email, senha, usuarioDao);
		
			exibirInformacoesUsuario(usuario);
		}
	}
	
	// Método para exibir informações de um usuário
    public static void exibirInformacoesUsuario(Usuario usuario) {
    	
    	if (usuario == null) {
    		System.out.println("Nenhum usuário encontrado!");
    		
    		return;
    	}
    	
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
