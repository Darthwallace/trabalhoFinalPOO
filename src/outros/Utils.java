package outros;

import java.util.Scanner;

public class Utils {
	public static String printar(String valor) {
		System.out.println(valor);
		Scanner entrada = new Scanner(System.in);
		String input = entrada.nextLine();
		return input;
	}
}
