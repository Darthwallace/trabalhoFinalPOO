package models;

public class Genero {
	// Atributos
	private Integer id;
	private String nome;
	private String descricao;
	
	// Construtor
	public Genero(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
