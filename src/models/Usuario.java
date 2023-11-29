package models;

import java.util.List;

public class Usuario extends Pessoa {
	public Usuario(String nome, String dataNascimento, String email,
					String senha, Boolean isAdmin, List<Emprestimo> historicoEmprestimo) {
		super(nome, dataNascimento);
		this.email = email;
		this.senha = senha;
		this.isAdmin = isAdmin;
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
