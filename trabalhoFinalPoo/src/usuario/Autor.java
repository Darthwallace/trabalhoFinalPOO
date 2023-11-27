package usuario;

public class Autor extends Pessoa {
	
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
