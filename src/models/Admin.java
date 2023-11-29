package models;
import java.util.ArrayList;
import java.util.List;

import dao.EmprestimoDAO;
import dao.LivroDAO;
import dao.UsuarioDAO;


public class Admin extends Usuario {
    public Admin(String nome,
    			 String dataNascimento, 
    			 String email, 
    			 String senha,
    			 Boolean isAdmin,
    			 List<Emprestimo> historicoEmprestimo) {
		   super(nome, dataNascimento, email, senha, isAdmin, historicoEmprestimo);
	}
    
    
	public void criarUsuario(UsuarioDAO dao, Usuario usuario) {
		dao.create(usuario);
    }

	public ArrayList<Usuario> listarUsuarios(UsuarioDAO dao) {
		return dao.selectAll();
    }
	

	public ArrayList<Emprestimo> listarEmprestimos(EmprestimoDAO dao) {
		return dao.selectAll();
    }

	
    public void deletarUsuario(UsuarioDAO dao, int id) {
    	dao.delete(id);
    }

    public void editarUsuario(UsuarioDAO dao, Usuario usuario) {
    	dao.update(usuario);
    }

    public void criarLivro(LivroDAO dao, Livro livro) {
    	dao.create(livro);
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
