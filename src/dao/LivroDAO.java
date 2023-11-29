package dao;
import java.util.ArrayList;
import java.util.Iterator;
import interfaces.Entity;
import models.Livro;
import models.Usuario;


public class LivroDAO implements Entity<Livro> {
	private ArrayList<Livro> listaDeLivros = new ArrayList<Livro>();;

	public ArrayList<Livro> getListaDeLivros() {
		return listaDeLivros;
	}

	public void setListaDeLivros(ArrayList<Livro> listaDeLivros) {
		this.listaDeLivros = listaDeLivros;
	}
	

	@Override
	public void create(Livro objeto) {
		if(objeto == null) {
			System.err.println("Livro Inválido!");
	    	return;
		} 
		  
	    if (listaDeLivros.contains(objeto)) {
	    	System.err.println("Livro já existe!");
	    	return;
	    }
	  
		this.listaDeLivros.add(objeto);
		System.out.println("Livro cadastrado com sucesso!");
	}

	@Override
	public void update(Livro objeto) {
	    boolean encontrado = false;

	    for (Livro livro : listaDeLivros) {
	        if (livro.getId() == objeto.getId()) {
	            encontrado = true;
	            livro.setNome(objeto.getNome());
	            livro.setDescricao(objeto.getDescricao());
	            livro.setAutor(objeto.getAutor());

	        
	            System.out.println("livro com ID " + objeto.getId() + " atualizado com sucesso.");
	            break;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("livro com ID " + objeto.getId() + " não encontrado para atualização.");
	    }
	}

	@Override
	public void delete(int id) {
		 boolean removido = false;
		    Iterator<Livro> iterator = listaDeLivros.iterator();

		    while (iterator.hasNext()) {
		    	Livro livro = iterator.next();
		        if (livro.getId() == id) {
		            iterator.remove();
		            removido = true;
		            System.out.println("Livro com ID " + id + " removido com sucesso.");
		            break;
		        }
		    }

		    if (!removido) {
		        System.out.println("Livro com ID " + id + " não encontrado para remoção.");
		    }
		
	}

	@Override
	public Livro select(int id) {
		 for (Livro livro : listaDeLivros) {
		        if (livro.getId() == id) {
		            return livro;
		        }
		    }

	    return null; 
	}

	@Override
	public ArrayList<Livro> selectAll() {
		 return listaDeLivros;
	}
}
