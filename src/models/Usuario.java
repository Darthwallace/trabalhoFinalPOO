package models;

import java.util.ArrayList;
import java.util.List;

import dao.EmprestimoDAO;
import dao.LivroDAO;
import outros.ConstantesSistemas;

public class Usuario extends Pessoa {
	// Atributos
	private Integer id;
	private String email;
	private String senha;
	protected Boolean isAdmin;
	private Boolean ativo;
	private List<Emprestimo> emprestimos;

	// Construtor
	public Usuario(String nome, String dataNascimento, String email, String senha) {
		super(nome, dataNascimento);
		this.email = email;
		this.senha = senha;
		this.isAdmin = false;
		this.ativo = true;
		this.emprestimos = new ArrayList<>();
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
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean isAdmin(){
		return this.isAdmin;
	}
	
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean isAtivo(){
		return this.ativo;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Emprestimo> getEmprestimos(){
		return this.emprestimos;
	}
	
	public void setEmprestimos(List<Emprestimo> emprestimos){
		this.emprestimos = emprestimos;
	}
	
	public void addEmprestimo(Emprestimo emprestimo) {
		this.emprestimos.add(emprestimo);
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
				+ ", historicoEmprestimo=" + emprestimos + "]";
	}
}
