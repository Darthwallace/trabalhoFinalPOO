package interfaces;

import java.util.List;

import dao.UsuarioDAO;
import models.Emprestimo;
import models.Usuario;

public abstract class Login {

	public Usuario login(String email, String senha, UsuarioDAO usuarioDao) {
		List<Emprestimo> emprestimos = new java.util.ArrayList<Emprestimo>();
		
		return usuarioDao.findyByEmailAndPassword(email, senha);
	}
}
