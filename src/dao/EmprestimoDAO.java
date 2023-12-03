package dao;
import java.util.ArrayList;
import java.util.Iterator;

import interfaces.Entity;
import models.Emprestimo;
import models.Livro;

public class EmprestimoDAO implements Entity<Emprestimo> {
	// Atributos
    private ArrayList<Emprestimo> listaDeEmprestimos = new ArrayList<Emprestimo>();
    private int ultimoIdUtilizado = 0;
    
    public ArrayList<Emprestimo> getListaDeEmprestimos() {
		return listaDeEmprestimos;
	}
    
    public ArrayList<Emprestimo> getListaDeEmprestimosPorUsuarioID(Integer id) {
    	ArrayList<Emprestimo> listaDeEmprestimosPorId = new ArrayList<Emprestimo>();

    	for (Emprestimo objeto : listaDeEmprestimos) {
    		if (objeto.getUsuario().getId() == id) {
    			listaDeEmprestimosPorId.add(objeto);
    		}
    	}

		return listaDeEmprestimosPorId;
	}

	public void setListaDeEmprestimos(ArrayList<Emprestimo> listaDeEmprestimos) {
		this.listaDeEmprestimos = listaDeEmprestimos;
	}

	@Override
	public void create(Emprestimo emprestimo) {
		if (emprestimo == null) {
			System.err.println("Empréstimo inválido!");
	    	return;
		} 
		  
	    if (listaDeEmprestimos.contains(emprestimo)) {
	    	System.err.println("Empréstimo já existe!");
	    	return;
	    }
	    
	    ultimoIdUtilizado++;
	    emprestimo.setId(ultimoIdUtilizado); 
	  
		this.listaDeEmprestimos.add(emprestimo);

		System.out.println("- Empréstimo do livro " + emprestimo.getLivro().getTitulo() + " concluído!");
		System.out.println("- Lembre-se de devolver até o dia " + emprestimo.getDataDevolucaoPrevista() + ".\n");
	}

	@Override
	public void update(Emprestimo novoEmprestimo) {
	    boolean encontrado = false;

	    for (Emprestimo emprestimo : listaDeEmprestimos) {
	        if (emprestimo.getId() == novoEmprestimo.getId()) {
	            encontrado = true;
	            emprestimo.setLivro(novoEmprestimo.getLivro());
//	            emprestimo.setDataEmprestimo(novoEmprestimo.getDataEmprestimo());
	            emprestimo.setStatus(novoEmprestimo.getStatus());
//	            emprestimo.setDataDevolucaoPrevista(novoEmprestimo.getDataDevolucao());

	            System.out.println("Empréstimo com ID " + novoEmprestimo.getId() + " atualizado com sucesso.");
	            break;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("Empréstimo com ID " + novoEmprestimo.getId() + " não encontrado para atualização.");
	    }
		
	}

	@Override
	public void delete(int id) {
		boolean removido = false;
		Iterator<Emprestimo> iterator = listaDeEmprestimos.iterator();

		while (iterator.hasNext()) {
			Emprestimo emprestimo = iterator.next();
			if (emprestimo.getId() == id) {
				iterator.remove();
				removido = true;
				System.out.println("Empréstimo com ID " + id + " removido com sucesso.");
				break;
			}
		}

		if (!removido) {
			System.out.println("Empréstimo com ID " + id + " não encontrado para remoção.");
		}
		
	}

	@Override
	public Emprestimo select(int id) {
		for (Emprestimo emprestimo : listaDeEmprestimos) {
			if (emprestimo.getId() == id) {
				return emprestimo;
			}
		}

		return null; 
	}


	@Override
	public ArrayList<Emprestimo> selectAll() {
	    return listaDeEmprestimos;
	}
}
