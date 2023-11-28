package outros;
//import biblioteca.Livro;
//import biblioteca.Biblioteca;

public class Relatorio {

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
