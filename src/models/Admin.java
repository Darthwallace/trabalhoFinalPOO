package models;
import java.util.ArrayList;
import java.util.List;

import dao.EmprestimoDAO;
import dao.LivroDAO;
import dao.UsuarioDAO;
import outros.ConstantesSistemas;

public class Admin extends Usuario {
	// Construtor
    public Admin(String nome, String dataNascimento, String email, String senha) {
		super(nome, dataNascimento, email, senha);
		   
		this.isAdmin = true;
	}
    
	public void criarUsuario (Usuario usuario) {
		Biblioteca.usuarioDao.create(usuario);
    }

	public ArrayList<Usuario> listarUsuarios() {
		return Biblioteca.usuarioDao.selectAll();
    }
	
	public ArrayList<Emprestimo> listarEmprestimos() {
		ArrayList<Emprestimo> emprestimosQueNaoSaoConcluidos = new ArrayList<Emprestimo>();
		
		for (Emprestimo objeto: Biblioteca.emprestimoDao.selectAll()) {
			if (objeto.getStatus() != ConstantesSistemas.CONCLUIDO) {
				emprestimosQueNaoSaoConcluidos.add(objeto);
			}
		}
		
		return emprestimosQueNaoSaoConcluidos;
    }
	
	public Emprestimo listarEmprestimosPorId(int id) {
		return Biblioteca.emprestimoDao.select(id);
    }

    public void deletarUsuario(int id) {
    	if (this.getId() == id) {
    		System.err.println("Não é permitido excluir seu próprio usuário");
    		return;
    	} 
    	
    	Biblioteca.usuarioDao.delete(id);
    }

    public void editarUsuario(UsuarioDAO dao, Usuario usuario) {
    	dao.update(usuario);
    }

    public void criarLivro(LivroDAO dao, Livro livro) {
    	dao.create(livro);
    }
    
    public ArrayList<Livro> listarLivros() {
    	return Biblioteca.livroDao.getListaDeLivros();
    }
    
    public Livro listarPorId(Integer id) {
    	return Biblioteca.livroDao.select(id);
    }

    public void deletarLivro(LivroDAO dao, int id) {
    	dao.delete(id);
    }

    public void editarLivro(LivroDAO dao, Livro livro) {
    	dao.update(livro);
    }

    public void gerarRelatorio() {
    	//TO-DO
    }
}
