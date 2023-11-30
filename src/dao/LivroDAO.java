package dao;
import java.util.ArrayList;
import java.util.Iterator;
import interfaces.Entity;
import models.Livro;
import models.Usuario;
import outros.ConstantesSistemas;


public class LivroDAO implements Entity<Livro> {
	private ArrayList<Livro> listaDeLivros = new ArrayList<Livro>();
	private int ultimoIdUtilizado = 0;

	public ArrayList<Livro> getListaDeLivros() {
		ArrayList<Livro> listaConcluida = new ArrayList<>();

		for (Livro livro : listaDeLivros) {
			if (livro.getStatus() == ConstantesSistemas.CONCLUIDO)
				listaConcluida.add(livro);
		}
		
		return listaConcluida;
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
	    
	    
	    ultimoIdUtilizado++;
	    objeto.setId(ultimoIdUtilizado);
	  
		this.listaDeLivros.add(objeto);
		System.out.println("Livro cadastrado com sucesso!");
	}

	@Override
	public void update(Livro objeto) {
	    boolean encontrado = false;

	    for (Livro livro : listaDeLivros) {
	        if (livro.getId() == objeto.getId()) {
	            encontrado = true;
	            livro.setTitulo(objeto.getTitulo());
	            livro.setAutor(objeto.getAutor());
	            livro.setStatus(objeto.getStatus());
	         
	        
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
