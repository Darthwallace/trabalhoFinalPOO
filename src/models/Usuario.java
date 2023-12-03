package models;

import java.util.List;

import dao.EmprestimoDAO;
import dao.LivroDAO;
import outros.ConstantesSistemas;

public class Usuario extends Pessoa {
	// Atributos
	private Integer id;
	private String email;
	public String senha;
	public Boolean isAdmin;
	public List<Emprestimo> historicoEmprestimo;

	// Construtor
	public Usuario(String nome, String dataNascimento, String email, String senha, List<Emprestimo> historicoEmprestimo) {
		super(nome, dataNascimento);
		this.email = email;
		this.senha = senha;
		this.isAdmin = false;
		this.historicoEmprestimo = historicoEmprestimo;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha(){
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getIsAdmin(){
		return isAdmin;
	}
	
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Emprestimo> getHistoricoEmprestimo(){
		return historicoEmprestimo;
	}
	
	public void setHistoricoEmprestimo(List<Emprestimo> historicoEmprestimo){
		this.historicoEmprestimo = historicoEmprestimo;
	}
	
	public void criarEmprestimo(Emprestimo emprestimo) {
	    Biblioteca.emprestimoDao.create(emprestimo);
	    emprestimo.getLivro().setStatus(ConstantesSistemas.EM_ANDAMENTO);
	    Biblioteca.livroDao.update(emprestimo.getLivro());
    }
	
	public void devolverEmprestimo(Emprestimo emprestimo) {
		emprestimo.setStatus(ConstantesSistemas.CONCLUIDO);
	    Biblioteca.emprestimoDao.update(emprestimo);
	    emprestimo.getLivro().setStatus(ConstantesSistemas.CONCLUIDO);
	    Biblioteca.livroDao.update(emprestimo.getLivro());
    }

	@Override
	public String toString() {
		return "Usuario [Id=" + id + ", email=" + email + ", senha=" + senha + ", isAdmin=" + isAdmin
				+ ", historicoEmprestimo=" + historicoEmprestimo + "]";
	}
}
