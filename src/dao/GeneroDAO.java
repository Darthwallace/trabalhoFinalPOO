package dao;
import java.util.ArrayList;
import java.util.Iterator;
import interfaces.Entity;
import models.Genero;

public class GeneroDAO implements Entity<Genero> {
	private ArrayList<Genero> listaDeGenero;
	
	public ArrayList<Genero> getListaDeGenero() {
		return listaDeGenero;
	}

	public void setListaDeGenero(ArrayList<Genero> listaDeGenero) {
		this.listaDeGenero = listaDeGenero;
	}
	
	 
	@Override
	public void create(Genero objeto) {
		if(objeto != null) {
			System.err.println("Objeto Inválido!");
	    	return;
		} 
		  
	    if (listaDeGenero.contains(objeto)) {
	    	System.err.println("Gênero já existe!");
	    	return;
	    }
	  
		this.listaDeGenero.add(objeto);
		System.err.println("Gênero cadastrado com sucesso!");
		
	}

	@Override
	public void update(Genero newObjeto) {
	    boolean encontrado = false;

	    for (Genero genero : listaDeGenero) {
	        if (genero.getId() == newObjeto.getId()) {
	            encontrado = true;
	            genero.setNome(newObjeto.getNome());
	            genero.setDescricao(newObjeto.getDescricao());
	        
	            System.out.println("Genero com ID " + newObjeto.getId() + " atualizado com sucesso.");
	            break;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("Genero com ID " + newObjeto.getId() + " não encontrado para atualização.");
	    }
		
	}

	@Override
	public void delete(int id) {
		 boolean removido = false;
		    Iterator<Genero> iterator = listaDeGenero.iterator();

		    while (iterator.hasNext()) {
		    	Genero genero = iterator.next();
		        if (genero.getId() == id) {
		            iterator.remove();
		            removido = true;
		            System.out.println("Genero com ID " + id + " removido com sucesso.");
		            break;
		        }
		    }

		    if (!removido) {
		        System.out.println("Genero com ID " + id + " não encontrado para remoção.");
		    }
		
	}

	@Override
	public Genero select(int id) {
		 for (Genero genero : listaDeGenero) {
		        if (genero.getId() == id) {
		            return genero;
		        }
		    }

	    return null; 
	}
	

	@Override
	public ArrayList<Genero> selectAll() {
		 return listaDeGenero;
	}
}
