package models;

public class Genero {
	
	private Integer id;
	public String nome;
	public String descricao;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
