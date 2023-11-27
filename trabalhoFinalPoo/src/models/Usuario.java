package models;
import java.util.List;

public class Usuario extends Emprestimo {

	public String email;
	public String senha;
	public Boolean isAdmin;
	public List<Emprestimo> historicoEmprestimo;
	
	
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
	
}
