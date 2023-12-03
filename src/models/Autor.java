package models;

public class Autor extends Pessoa {
	// Atributos
	public String nacionalidade;
	public String biografia;

	// Construtor
	public Autor(String nome, String dataNascimento, String nacionalidade, String biografia) {
		super(nome, dataNascimento);
		this.nacionalidade = nacionalidade;
		this.biografia = biografia;	
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
}
