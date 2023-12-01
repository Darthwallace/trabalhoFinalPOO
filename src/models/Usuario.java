package models;

import java.util.List;

import dao.EmprestimoDAO;
import dao.LivroDAO;
import outros.ConstantesSistemas;

public class Usuario extends Pessoa {
	public Usuario(String nome, String dataNascimento, String email,
					String senha, List<Emprestimo> historicoEmprestimo) {
		super(nome, dataNascimento);
		this.email = email;
		this.senha = senha;
		this.isAdmin = false;
		this.historicoEmprestimo = historicoEmprestimo;
	}

	private Integer Id;
	private String email;
	public String senha;
	public Boolean isAdmin;
	public List<Emprestimo> historicoEmprestimo;
	
	
	
	public void setId(Integer id) {
		Id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha(){
		return senha;
	}
	
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public Boolean getIsAdmin(){
		return isAdmin;
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
	
	public void setHistoricoEmprestimo(List<Emprestimo> historicoEmprestimo){
		this.historicoEmprestimo = historicoEmprestimo;
	}
	
	public List<Emprestimo> getHistoricoEmprestimo(){
		return historicoEmprestimo;
	}

	public Integer getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Usuario [Id=" + Id + ", email=" + email + ", senha=" + senha + ", isAdmin=" + isAdmin
				+ ", historicoEmprestimo=" + historicoEmprestimo + "]";
	}
}
