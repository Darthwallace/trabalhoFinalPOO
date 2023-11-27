package models;
import java.time.LocalDate;

public class Emprestimo extends Livro{
	
	public Integer status;
	public LocalDate dataEmprestimo;
	public LocalDate dataDevolucaoPrevista;
	public Livro livro;
	public Usuario usuario;
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}
	
	public LocalDate getDataDevolucao() {
		return dataDevolucaoPrevista;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}

}
