package models;

import outros.Utils;

public class Emprestimo{
	private Integer id;
	private Integer status;
	private String dataEmprestimo;
	private String dataDevolucaoPrevista;
	private Livro livro;
	private Usuario usuario;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Emprestimo(Integer status, String dataEmprestimo, String dataDevolucaoPrevista, Livro livro,
			Usuario usuario) {
		this.status = status;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		this.livro = livro;
		this.usuario = usuario;
	}

	public Integer getId(){
		return id;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataDevolucaoPrevista(String dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}
	
	public String getDataDevolucao() {
		return dataDevolucaoPrevista;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", status=" + Utils.retornaStatus(status) + ", dataEmprestimo=" + dataEmprestimo
				+ ", dataDevolucaoPrevista=" + dataDevolucaoPrevista + ", livro=" + livro.getTitulo() + ", usuario=" + usuario.getNome()
				+ "]";
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
