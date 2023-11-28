package models;

public class Autor extends Pessoa {
	public Autor(String nome, String dataNascimento, String nacionalidade, String biografia) {
		super(nome, dataNascimento);
		this.nacionalidade = nacionalidade;
		this.biografia = biografia;	
		// TODO Auto-generated constructor stub
	}

	public String nacionalidade;
	public String biografia;
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	public String getBiografia() {
		return biografia;
	}
}
