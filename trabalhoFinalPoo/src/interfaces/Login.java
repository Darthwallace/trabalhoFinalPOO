package interfaces;

import dao.UsuarioDAO;

public interface Login {
	public boolean login(String email, String password, UsuarioDAO usuario);
}


