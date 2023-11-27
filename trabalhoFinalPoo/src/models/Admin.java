package models;
import java.util.HashMap;
import java.util.Map;


public class Admin extends Usuario {
	
	private Map<String, String> usuarios;
    private Map<String, String> livros;

    public Admin() {
        this.usuarios = new HashMap<>();
        this.livros = new HashMap<>();
    }

    public void criarUsuario(String nome, String id) {
        usuarios.put(id, nome);
        System.out.println("Usuário criado: " + nome + " (ID: " + id + ")");
    }

    public void deletarUsuario(String id) {
        if (usuarios.containsKey(id)) {
            String nome = usuarios.get(id);
            usuarios.remove(id);
            System.out.println("Usuário deletado: " + nome + " (ID: " + id + ")");
        } else {
            System.out.println("Usuário não encontrado com o ID: " + id);
        }
    }

    public void editarUsuario(String id, String novoNome) {
        if (usuarios.containsKey(id)) {
            usuarios.put(id, novoNome);
            System.out.println("Usuário editado com sucesso (ID: " + id + ")");
        } else {
            System.out.println("Usuário não encontrado com o ID: " + id);
        }
    }

    public void criarLivro(String titulo, String isbn) {
        livros.put(isbn, titulo);
        System.out.println("Livro criado: " + titulo + " (ISBN: " + isbn + ")");
    }

    public void deletarLivro(String isbn) {
        if (livros.containsKey(isbn)) {
            String titulo = livros.get(isbn);
            livros.remove(isbn);
            System.out.println("Livro deletado: " + titulo + " (ISBN: " + isbn + ")");
        } else {
            System.out.println("Livro não encontrado com o ISBN: " + isbn);
        }
    }

    public void editarLivro(String isbn, String novoTitulo) {
        if (livros.containsKey(isbn)) {
            livros.put(isbn, novoTitulo);
            System.out.println("Livro editado com sucesso (ISBN: " + isbn + ")");
        } else {
            System.out.println("Livro não encontrado com o ISBN: " + isbn);
        }
    }

    public void gerarRelatorio() {
        System.out.println("----- Relatório -----");
        System.out.println("Usuários:");
        for (Map.Entry<String, String> entry : usuarios.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Nome: " + entry.getValue());
        }

        System.out.println("\nLivros:");
        for (Map.Entry<String, String> entry : livros.entrySet()) {
            System.out.println("ISBN: " + entry.getKey() + ", Título: " + entry.getValue());
        }
        System.out.println("---------------------");
    }

    public static void main(String[] args) {
        Admin admin = new Admin();

        admin.criarUsuario("Wallace", "123");
        admin.criarUsuario("Guilherme", "456");
        admin.criarLivro("SMD em açao", "978-3-16-148410-0");

        admin.gerarRelatorio();

        admin.deletarUsuario("123");
        admin.editarLivro("978-3-16-148410-0", "Novo Título do Livro");

        admin.gerarRelatorio();
    } 
}
