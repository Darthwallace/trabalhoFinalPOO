package dao;
import java.util.ArrayList;
import java.util.Iterator;
import interfaces.Entity;
import models.Usuario;


public class UsuarioDAO implements Entity<Usuario>{
	private ArrayList<Usuario> listaDeUsuarios;

	public ArrayList<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	public void setListaDeUsuarios(ArrayList<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}

	@Override
	public void create(Usuario objeto) {
		if(objeto != null) {
			System.err.println("Usuário Inválido!");
	    	return;
		} 
		  
	    if (listaDeUsuarios.contains(objeto)) {
	    	System.err.println("Usuário já existe!");
	    	return;
	    }
	  
		this.listaDeUsuarios.add(objeto);
		System.err.println("Usuário cadastrado com sucesso!");
		
	}

	@Override
	public void update(Usuario objeto) {
	    boolean encontrado = false;

	    for (Usuario usuario : listaDeUsuarios) {
	        if (usuario.getId() == objeto.getId()) {
	            encontrado = true;
	            usuario.setEmail(usuario.getEmail());
	            usuario.setSenha(usuario.getSenha());
	            usuario.setIsAdmin(usuario.getIsAdmin());

	        
	            System.out.println("Usuario com ID " + objeto.getId() + " atualizado com sucesso.");
	            break;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("Usuario com ID " + objeto.getId() + " não encontrado para atualização.");
	    }
		
	}

	@Override
	public void delete(int id) {
		 boolean removido = false;
		    Iterator<Usuario> iterator = listaDeUsuarios.iterator();

		    while (iterator.hasNext()) {
		    	Usuario usuario = iterator.next();
		        if (usuario.getId() == id) {
		            iterator.remove();
		            removido = true;
		            System.out.println("Usuario com ID " + id + " removido com sucesso.");
		            break;
		        }
		    }

		    if (!removido) {
		        System.out.println("Usuario com ID " + id + " não encontrado para remoção.");
		    }
		
	}

	@Override
	public Usuario select(int id) {
		 for (Usuario usuario : listaDeUsuarios) {
		        if (usuario.getId() == id) {
		            return usuario;
		        }
		    }

	    return null; 
	}
	
	public Usuario findyByEmailAndPassword(String email, String senha) {
		 for (Usuario usuario : listaDeUsuarios) {
		        if (usuario.getEmail() == email && usuario.getSenha() == senha) {
		            return usuario;
		        }
		    }

	    return null; 
	}

	@Override
	public ArrayList<Usuario> selectAll() {
		 return listaDeUsuarios;
	}
}
