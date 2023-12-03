package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import interfaces.Entity;
import models.Biblioteca;
import models.Usuario;

public class UsuarioDAO implements Entity<Usuario> {
	// Atributos
	private ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
    private int ultimoIdUtilizado = 0;
    
    // Construtor
    public UsuarioDAO() { }

	public void setListaDeUsuarios(ArrayList<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}

	@Override
	public void create(Usuario usuario) {
		if (usuario == null) {
			System.err.println("Usuário Inválido!");
	    	return;
		} 
		  
	    if (listaDeUsuarios.contains(usuario)) {
	    	System.out.println("Usuário já existe!");
	    	return;
	    }

	    ultimoIdUtilizado++;
	
	    usuario.setId(ultimoIdUtilizado); 
	  
		this.listaDeUsuarios.add(usuario);
	}

	@Override
	public void update(Usuario objeto) {
	    boolean encontrado = false;

	    for (Usuario usuario : listaDeUsuarios) {
	        if (usuario.getId() == objeto.getId()) {
	            encontrado = true;
	            usuario.setEmail(usuario.getEmail());
	            usuario.setSenha(usuario.getSenha());
	            usuario.setIsAdmin(usuario.isAdmin());

	        
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
	
	@Override
	public ArrayList<Usuario> selectAll() {
		return listaDeUsuarios;
	}

	public Usuario findyByEmailAndPassword(String email, String senha) {
		for (Usuario usuario : listaDeUsuarios) {
			   if ((usuario.getEmail().equals(email)) && (usuario.getSenha().equals(senha))) {
				   if (usuario != null) {
					   usuario.setEmprestimos(Biblioteca.emprestimoDao.getListaDeEmprestimosPorUsuarioID(usuario.getId()));
					   }
				   return usuario;
			   }
	   }
		
	   return null; 
   	}

	public List<Usuario> getUsuariosAtivos() {
		List<Usuario> ativos = new ArrayList<>();
		
		for (Usuario usuario : this.listaDeUsuarios) {
			if (usuario.isAtivo()) {
				ativos.add(usuario);
			}
		}
		
		return ativos;
	}

	public void desativarUsuario(Usuario usuario) {
		for (Usuario objeto : listaDeUsuarios) {
	        if (usuario.getId() == objeto.getId()) {
	            usuario.setAtivo(false);
	            break;
	        }
	    }
	}
}
