package outros;

public class Relatorio {
	// Atributos
	public static int totalLivros;
	public int totalDeEmprestimos;
	
	public void setTotalLivros(int totalLivros) {
		Relatorio.totalLivros = totalLivros;
	}
	
	public int getTotalLivros() {
		return totalLivros;
	}
	
	public void setTotalDeEmprestimos(int totalDeEmprestimos) {
		this.totalDeEmprestimos = totalDeEmprestimos;
	}
	
	public int getTotalDeEmprestimos() {
		return totalDeEmprestimos;
	}
}
