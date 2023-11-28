package models;
import java.time.LocalDate;
import java.util.List;

import dao.UsuarioDAO;
import interfaces.Login;

public class Usuario extends Pessoa implements Login {
	public Usuario(String nome, String dataNascimento,
					Integer id, String email,
					String senha, Boolean isAdmin,List<Emprestimo> historicoEmprestimo) {
		super(nome, dataNascimento);
		Id = id;
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
	public boolean login(String email, String password, UsuarioDAO usuario) {
		Usuario user = usuario.findyByEmailAndPassword(email, password);
		if (user != null) return true;
		else return false;
		
	}
	
}
