package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import outros.ConstantesSistemas;
import outros.Utils;

public class Emprestimo {
	// Atributos
	private Integer id;
	private Integer status;
	private String dataEmprestimo;
	private String dataDevolucaoPrevista;
	private Livro livro;
	private Usuario usuario;
	
	// Construtor
	public Emprestimo(Livro livro, Usuario usuario) {
		this.status = ConstantesSistemas.EM_ANDAMENTO;
		this.dataEmprestimo = this.calculaDataEmprestimo();
		this.dataDevolucaoPrevista = this.calculaDataEntrega();
		this.livro = livro;
		this.usuario = usuario;
	}

	public String calculaDataEmprestimo() {
		LocalDate dataAtual = LocalDate.now();
		// Criando um formato desejado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Formatando a data conforme o formato desejado
        String dataFormatada = dataAtual.format(formatter);

		return dataFormatada;
	}

	public String calculaDataEntrega() {
		LocalDate dataAtual = LocalDate.now();
		// Adicionando 30 dias a data atual
        LocalDate dataDaquiA30Dias = dataAtual.plusDays(30);
		// Criando um formato desejado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Formatando a data conforme o formato desejado
        String dataFormatada = dataDaquiA30Dias.format(formatter);

		return dataFormatada;
	}

	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public String getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", status=" + Utils.retornaStatus(status) + ", dataEmprestimo=" + dataEmprestimo
				+ ", dataDevolucaoPrevista=" + dataDevolucaoPrevista + ", livro=" + livro.getTitulo() + ", usuario=" + usuario.getNome()
				+ "]";
	}
}
