package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dao.EmprestimoDAO;
import dao.GeneroDAO;
import dao.LivroDAO;
import dao.UsuarioDAO;
import interfaces.Login;
import outros.ConstantesSistemas;
import outros.Utils;

//TODO- Adicionar validacao para caso o id do livro nao exista

public class Biblioteca extends Login {
	public static UsuarioDAO usuarioDao;
	public static GeneroDAO generoDao;
	public static LivroDAO livroDao;
	public static EmprestimoDAO emprestimoDao;

	// Construtor
	public Biblioteca() {
		usuarioDao = new UsuarioDAO();
		generoDao = new GeneroDAO();
		livroDao = new LivroDAO();
		emprestimoDao = new EmprestimoDAO();

		//Instanciando três objetos da classe Usuario e Admin
        Usuario usuario1 = new Usuario("João", "1990-01-01", "joao@email.com", "senha123");
        Usuario usuario2 = new Usuario("Maria", "1985-05-15", "maria@email.com", "senha456");
        Admin admin1 = new Admin("Admin1", "1990-05-15", "admin@gmail.com", "adm123");
        
        usuarioDao.create(usuario1);
        usuarioDao.create(usuario2);
        usuarioDao.create(admin1);
        
        // Instanciando alguns gêneros
        Genero genero1 = new Genero("Aventura", "Livros de aventura");
        Genero genero2 = new Genero("Ficção Científica", "Livros de ficção científica");
        Genero genero3 = new Genero("Romance", "Romance");
        
        generoDao.create(genero1);
        generoDao.create(genero2);
        
        // Instanciando alguns livros
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "978-8578277109", "Martins Fontes", "1954", genero1);
        Livro livro2 = new Livro("A Revolução dos Bichos", "George Orwell", "978-0451526342", "Penguin Books", "1945", genero2);
        Livro livro3 = new Livro("Dom Quixote", "Miguel de Cervantes", "978-0140449099", "Penguin Classics", "1605", genero3);
        Livro livro4 = new Livro("Orgulho e Preconceito", "Jane Austen", "978-0141439518", "Penguin Classics", "1813", genero2);
        Livro livro5 = new Livro("O Hobbit", "J.R.R. Tolkien", "978-8578277109", "WMF Martins Fontes", "1937", genero2);

        livroDao.create(livro1);
        livroDao.create(livro2);
        livroDao.create(livro3);
        livroDao.create(livro4);
        livroDao.create(livro5);
        
        //Instanciando Emprestimo
        livro1.setStatus(ConstantesSistemas.EM_ANDAMENTO);
        Emprestimo emprestimo1 = new Emprestimo(livro1, usuario1);
        
        Emprestimo emprestimo2 = new Emprestimo(livro2, usuario2);
        livro2.setStatus(ConstantesSistemas.EM_ANDAMENTO);
        
        Emprestimo emprestimo3 = new Emprestimo(livro3, admin1);
        livro3.setStatus(ConstantesSistemas.EM_ANDAMENTO);
        
        emprestimoDao.create(emprestimo1);
        emprestimoDao.create(emprestimo2);
        emprestimoDao.create(emprestimo3);
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
			System.out.println("\n\n###########################");
			System.out.println("### B I B L I O T E C A ###");
			System.out.println("###########################\n");
			System.out.println("Bem-vindo ao sistema de gerênciamento de biblioteca.\n");
			System.out.println("Faça login para acessar:\n");
			
			String email = Utils.printar("- Digite o seu E-mail");
			String senha = Utils.printar("- Digite a sua Senha:");
			Usuario usuario = login(email, senha, usuarioDao);
			
			if (usuario == null) {
				System.out.println("Nenhum usuário encontrado!");
				continue;
			}

			if (usuario.getIsAdmin() == false) {
				boolean logado = true;

				while(logado) {
					System.out.println("\n\n###########################");
					System.out.println("### B I B L I O T E C A ###");
					System.out.println("###########################\n");
					System.out.println("Bem-vindo " + usuario.getNome() + ", ");
					System.out.println("O que você deseja fazer ?\n");
					System.out.println("[1] - Ver livros disponíveis ?");
					System.out.println("[2] - Fazer empréstimo ?");
					System.out.println("[3] - Fazer devolução ?");
					System.out.println("[4] - Deseja se deslogar ?\n");
					
					String opcao = entrada.nextLine();
								
					switch(opcao) {
						case "1": // Ver livros disponiveis
							boolean sair = false;

							while(!sair) {
								System.out.println("\n\n\n##### LISTA DE LIVROS DISPONIVEIS #####\n");
								ArrayList<Livro> listaLivros = livroDao.getListaDeLivros();

								if (listaLivros.size() == 0) {
									System.out.println( "\n- No momento, todos os livros estão emprestados!\n");
								}
								
								for (int i = 0; i < listaLivros.size(); i++) {
									Livro livro = listaLivros.get(i);
									System.out.println( (i + 1) + " - Título: " + livro.getTitulo() + ". Autor: " + livro.getAutor() + ". Publicacao: " + livro.getAnoPublicacao() + ". Genero: " + livro.getGenero().getNome() + ". ISBN: " + livro.getIsbn());
								}
								
								String opcaoMenu2 = Utils.printar("\n[SAIR] - Voltar ao menu anterior");
								
								if (opcaoMenu2.equals("SAIR") || opcaoMenu2.equals("sair")) {
									sair = true;
									break;
								}

								System.out.println("- Opção inválida!");
							}
							break;
						case "2": // Fazer emprestimo
							boolean sairTelaEmprestimo = false;

							while(!sairTelaEmprestimo) {
								System.out.println("\n\n\n##### EMPRESTIMO DE LIVRO #####\n");
								System.out.println(usuario.getNome() + ", esses são os livros que estão disponíveis: \n");
								
								ArrayList<Livro> listaLivros = livroDao.getListaDeLivros();

								if (listaLivros.size() == 0) {
									System.out.println( "\n- No momento, todos os livros estão emprestados!\n");
								}
									
								for (int i = 0; i < listaLivros.size(); i++) {
									Livro livro = listaLivros.get(i);

									int id = i + 1;

									System.out.println("[" + id + "] - " + livro.getTitulo() + ", " + livro.getAutor());
								}

								System.out.println("\n[SAIR] - Voltar ao menu anterior");

								String opcao2Menu2 = Utils.printar("\nQual livro você deseja pegar emprestado?\n");
								int idLivroEscolhido;
								
								// Valida se a opção informada é um numero inteiro
								try {
									idLivroEscolhido = Integer.parseInt(opcao2Menu2);
								} catch (NumberFormatException  e) {
									if (opcao2Menu2.equals("SAIR") || opcao2Menu2.equals("sair")) {
										sairTelaEmprestimo = true;
										break;
									}

									System.out.println("- Opção inválida!");
									continue;
								}

								// Valida se a opção informada é maior do que o numero de livros
								if (idLivroEscolhido > listaLivros.size()) {
									System.out.println("- Opção inválida!");
									continue;
								}

								for (int j = 0; j < listaLivros.size(); j++) {
									Livro livro = listaLivros.get(idLivroEscolhido - 1);

									if (livro == null) {
										System.out.println("- Livro não encontrado!");
										break;
									}

									Emprestimo emprestimo = new Emprestimo(livro, usuario);
									usuario.addEmprestimo(emprestimo);
									break;
								}

								String opcaoSairTelaEmprestimo = Utils.printar("[SAIR] - Voltar ao menu anterior");
							
								if (opcaoSairTelaEmprestimo.equals("SAIR") || opcaoSairTelaEmprestimo.equals("sair")) {
									sairTelaEmprestimo = true;
									break;
								}
								
							}
							break;
						
						case "3": // Fazer devolução
							boolean sairTelaDevolucao = false;
							while(!sairTelaDevolucao) {
								System.out.println("\n\n\n##### DEVOLUCAO DE LIVRO #####\n");
								System.out.println(usuario.getNome() + ", aqui estão seus empréstimos: \n");

								List<Emprestimo> emprestimosPendentes = emprestimoDao.getEmprestimosPendentes(usuario);

								if (emprestimosPendentes.size() == 0) {
									System.out.println( "\n- No momento, não há livros pendentes para devolução!\n");
								}

								for (int i = 0; i < emprestimosPendentes.size(); i++) {
									Emprestimo emprestimo = emprestimosPendentes.get(i);
									Livro livro = emprestimo.getLivro();

									int id = i + 1;

									System.out.println("[" + id + "] - " + livro.getTitulo() + 
										". Data do empréstimo: " + emprestimo.getDataEmprestimo() +
										". Data de devolução: " + emprestimo.getDataDevolucaoPrevista() +
										".");
								}

								System.out.println("\n[SAIR] - Voltar ao menu anterior");

								String opcaoMenu3 = Utils.printar("\nQual livro você deseja devolver?\n");
								int idLivroDevolvido;

								// Valida se a opção informada é um numero inteiro
								try {
									idLivroDevolvido = Integer.parseInt(opcaoMenu3);
								} catch (NumberFormatException  e) {
									if (opcaoMenu3.equals("SAIR") || opcaoMenu3.equals("sair")) {
										sairTelaDevolucao = true;
										break;
									}

									System.out.println("- Opção inválida!");
									continue;
								}

								// Valida se a opção informada é maior do que o numero de livros
								if (idLivroDevolvido == 0 || idLivroDevolvido > emprestimosPendentes.size()) {
									System.out.println("- Opção inválida!");
									continue;
								}

								for (int j = 0; j < emprestimosPendentes.size(); j++) {
									Emprestimo emprestimo = emprestimosPendentes.get(idLivroDevolvido - 1);
									Livro livro = emprestimo.getLivro();

									if (livro == null) {
										System.out.println("- Emprestimo não encontrado!");
										break;
									}

									usuario.devolverEmprestimo(emprestimo);

									System.out.println("\n- Devolução do livro " + livro.getTitulo() + " concluído!\n");
									break;
								}

								String opcaoSairTelaDevolucao = Utils.printar("[SAIR] - Voltar ao menu anterior");
							
								if (opcaoSairTelaDevolucao.equals("SAIR") || opcaoSairTelaDevolucao.equals("sair")) {
									sairTelaEmprestimo = true;
									break;
								}

								break;
							}
							break;

						case "4": // Deseja se deslogar
							logado = false;
							System.out.println("\n Você será deslogado...\n");
							break;
							
						default:
							System.out.println("Opção Inválida!");
					}
				}
			}
			
			if (usuario instanceof Admin) {
				while(true) {
					Admin admin = (Admin) usuario; 

					System.out.println("Bem-vindo administrador: " + admin.getNome());
					System.out.println("O que você deseja fazer ?");
					System.out.println("1 - Cadastrar um usuário ?");
					System.out.println("2 - Excluir um usuário ?");
					System.out.println("3 - Ver quais usuários estão cadastrados?");
					System.out.println("4 - Deseja verificar os empréstimos ?");
					System.out.println("5 - Fazer empréstimo ?");
					System.out.println("6 - Deseja fazer devolução ?");
					System.out.println("7 - Deseja se deslogar ?");
					
					String opcao = entrada.nextLine();
					boolean sair = false;
					
					switch(opcao) {
					case "1":
						String nome = Utils.printar("Digite o nome do usuário");
						String dataNascimento = Utils.printar("Digite a data de nascimento do usuário");
						String emailUser = Utils.printar("Digite o email do usuário");
						String senhaUser = Utils.printar("Digite a senha do usuário");
						boolean isAdmin = Utils.printar("O usuário deve ser admin? SIM ou NAO").equals("SIM") ? true : false;
						
						if (isAdmin) {
							//admin.criarUsuario(new Admin(nome, dataNascimento, emailUser, senhaUser, new ArrayList<>()));
							Biblioteca.usuarioDao.create(new Admin(nome, dataNascimento, emailUser, senhaUser));
						} else {
							//admin.criarUsuario(new Usuario(nome, dataNascimento, emailUser, senhaUser, new ArrayList<>()));
							Biblioteca.usuarioDao.create(new Usuario(nome, dataNascimento, emailUser, senhaUser));
						}
						
						System.out.println("Usuário criado com sucesso !!!!");
						break;
					case "2":
						String id = Utils.printar("Qual é id do usuário ?");
						admin.deletarUsuario(Integer.parseInt(id));
						break;
					case "3":
						ArrayList<Usuario> lista = admin.listarUsuarios();
						  for (Usuario user : lista) {
							  System.out.println(user.toString());
						  }
						break;
					case "4":
						ArrayList<Emprestimo> listaEmprestimo = admin.listarEmprestimos();
						  for (Emprestimo emprestimo : listaEmprestimo) {
							  System.out.println(emprestimo.toString());
						  }
						break;
					case "5":
						ArrayList<Livro> listaLivros = admin.listarLivros();
						for (Livro livro : listaLivros) {
							System.out.println(livro.toString());
						 }
						
						String idLivro = Utils.printar("----------- Escolha agora o id do livro para realizar o empréstimo----------");
						
						Livro livroEscolhido = admin.listarPorId(Integer.parseInt(idLivro));
						admin.addEmprestimo(new Emprestimo(livroEscolhido, admin));
						break;
					case "6":
					    System.out.println("================ Aqui estão seus empréstimos ================");
						for (Emprestimo emprestimo : admin.getEmprestimos()) {
							  System.out.println(emprestimo.toString());
						 }
						
						String idEmprestimo = Utils.printar("Digite o id do empréstimo que você deseja devolver");
						Emprestimo emprestimoDevolvido = admin.listarEmprestimosPorId(Integer.parseInt(idEmprestimo));
						admin.devolverEmprestimo(emprestimoDevolvido);
						
						break;
					case "7":
						sair = true;
						break;
					default:
						System.out.println("Opção Inválida!");
					}
					if (sair) break;
				}
			}
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
        System.out.println("Histórico de Empréstimos: " + usuario.getEmprestimos());
        System.out.println("----------------------------------------");
    }
}
