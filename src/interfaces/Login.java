package interfaces;
import dao.UsuarioDAO;
import models.Usuario;

public abstract class Login {
	public Usuario login(String email, String senha, UsuarioDAO usuarioDao) {	
		return usuarioDao.findyByEmailAndPassword(email, senha);
	}
}
