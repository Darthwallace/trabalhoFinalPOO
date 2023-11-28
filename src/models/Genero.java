package models;

public class Genero {
	private Integer id;
	private String nome;
	private String descricao;
	
	public Genero(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

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
