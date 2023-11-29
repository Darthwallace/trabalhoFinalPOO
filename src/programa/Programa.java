package programa;

import models.Biblioteca;

public class Programa {	
	public static void main(String[] args) {
		Biblioteca.startup();
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.menuLogin();
	}
}
