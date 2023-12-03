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
        Admin admin1 = new Admin("Admin", "1990-05-15", "admin@email.com", "adm123");
        
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
	
	public void menu() {
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
				System.out.println("\nNenhum usuário encontrado!");
				continue;
			}

			if (usuario.isAdmin() == false) {
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
			} else {
				boolean logadoAdmin = true;

				while(logadoAdmin) {
					Admin admin = (Admin) usuario;

					System.out.println("\n\n###########################");
					System.out.println("### B I B L I O T E C A ###");
					System.out.println("###########################\n");

					System.out.println("Bem-vindo administrador " + admin.getNome() + ", ");
					System.out.println("O que você deseja fazer ?\n");
					System.out.println("[1] - Ver livros disponiveis ?");
					System.out.println("[2] - Fazer empréstimo ?");
					System.out.println("[3] - Fazer devolução ?");

					System.out.println("[4] - Cadastrar um usuário ?");
					System.out.println("[5] - Desativar um usuário ?");

					System.out.println("[6] - Ver quais usuários estão cadastrados?");
					System.out.println("[7] - Deseja verificar os empréstimos ?");
					// System.out.println("[5] - Fazer empréstimo ?");
					// System.out.println("[6] - Deseja fazer devolução ?");
					System.out.println("[8] - Deseja se deslogar ?");
					
					String opcao = entrada.nextLine();
					boolean sair2 = false;
					
					switch(opcao) {
						case "1": // Ver livros disponiveis
							boolean sairTelaLivros = false;

							while(!sairTelaLivros) {
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
									sairTelaLivros = true;
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



						case "4": // Cadastrar um usuário
							System.out.println("\n\n\n##### CADASTRO DE NOVO USUARIO #####\n");
							String nome = Utils.printar("Digite o nome do usuário: ");
							String dataNascimento = Utils.printar("Digite a data de nascimento do usuário: (Ex.: 12/01/1999) ");
							String emailUser = Utils.printar("Digite o email do usuário: ");
							String senhaUser = Utils.printar("Digite a senha do usuário: ");
							boolean isAdmin = Utils.printar("O usuário deve ser admin? [SIM] ou [NAO]").equals("SIM") ? true : false;
							
							if (isAdmin) {
								Biblioteca.usuarioDao.create(new Admin(nome, dataNascimento, emailUser, senhaUser));
							} else {
								Biblioteca.usuarioDao.create(new Usuario(nome, dataNascimento, emailUser, senhaUser));
							}

							System.out.println("\nUsuário cadastrado com sucesso!");
							break;
						case "5":
							boolean sairTelaDesativacao = false;

							while(!sairTelaDesativacao) {
								System.out.println("\n\n\n##### DESATIVAR USUARIO #####\n");
								System.out.println(usuario.getNome() + ", aqui estão os usuários ativos: \n");

								List<Usuario> usuariosAtivos = usuarioDao.getUsuariosAtivos();

								for (int i = 0; i < usuariosAtivos.size(); i++) {
									Usuario usuarioAtivo = usuariosAtivos.get(i);
									int id = i + 1;

									System.out.println("[" + id + "] - " + usuarioAtivo.getNome() + 
										". E-mail: " + usuarioAtivo.getEmail() +
										". É administrador: " + (usuarioAtivo.isAdmin()) +
										".");
								}

								System.out.println("\n[SAIR] - Voltar ao menu anterior");

								String opcaoMenu5 = Utils.printar("\nQual usuário deseja desativar ?\n");
								int idUsuarioAtivo;

								// Valida se a opção informada é um numero inteiro
								try {
									idUsuarioAtivo = Integer.parseInt(opcaoMenu5);
								} catch (NumberFormatException  e) {
									if (opcaoMenu5.equals("SAIR") || opcaoMenu5.equals("sair")) {
										sairTelaDesativacao = true;
										break;
									}

									System.out.println("- Opção inválida!");
									continue;
								}

								// Valida se a opção informada é maior do que o numero de livros
								if (idUsuarioAtivo == 0 || idUsuarioAtivo > usuariosAtivos.size()) {
									System.out.println("- Opção inválida!");
									continue;
								}

								for (int j = 0; j < usuariosAtivos.size(); j++) {
									Usuario usuarioAtivo = usuariosAtivos.get(idUsuarioAtivo - 1);

									if (usuarioAtivo == null) {
										System.out.println("- Usuário não encontrado!");
										break;
									}

									admin.desativarUsuario(usuarioAtivo);

									System.out.println("\n- Usuário " + usuarioAtivo.getNome() + " desativado com sucesso!\n");
									break;
								}

								String opcaoSairTelaDesativacao = Utils.printar("[SAIR] - Voltar ao menu anterior");
							
								if (opcaoSairTelaDesativacao.equals("SAIR") || opcaoSairTelaDesativacao.equals("sair")) {
									sairTelaDesativacao = true;
									break;
								}
								
								break;
							}
							break;
	
						case "6":
							ArrayList<Usuario> lista = admin.listarUsuarios();
							for (Usuario user : lista) {
								System.out.println(user.toString());
							}
							break;
						case "7":
							ArrayList<Emprestimo> listaEmprestimo = admin.listarEmprestimos();
							for (Emprestimo emprestimo : listaEmprestimo) {
								System.out.println(emprestimo.toString());
							}
							break;
						// case "5":
						// 	ArrayList<Livro> listaLivros = admin.listarLivros();
						// 	for (Livro livro : listaLivros) {
						// 		System.out.println(livro.toString());
						// 	}
							
						// 	String idLivro = Utils.printar("----------- Escolha agora o id do livro para realizar o empréstimo----------");
							
						// 	Livro livroEscolhido = admin.listarPorId(Integer.parseInt(idLivro));
						// 	admin.addEmprestimo(new Emprestimo(livroEscolhido, admin));
						// 	break;
						// case "6":
						// 	System.out.println("================ Aqui estão seus empréstimos ================");
						// 	for (Emprestimo emprestimo : admin.getEmprestimos()) {
						// 		System.out.println(emprestimo.toString());
						// 	}
							
						// 	String idEmprestimo = Utils.printar("Digite o id do empréstimo que você deseja devolver");
						// 	Emprestimo emprestimoDevolvido = admin.listarEmprestimosPorId(Integer.parseInt(idEmprestimo));
						// 	admin.devolverEmprestimo(emprestimoDevolvido);
							
						// 	break;
						case "8": // Deseja se deslogar
							logadoAdmin = false;
							System.out.println("\n Você será deslogado...\n");
							break;
						default:
							System.out.println("Opção Inválida!");
					}
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
        System.out.println("isAdmin: " + usuario.isAdmin());
        System.out.println("Histórico de Empréstimos: " + usuario.getEmprestimos());
        System.out.println("----------------------------------------");
    }
}
