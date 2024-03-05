	package medico.consultorio.model;

import java.security.SecureRandom;
import java.util.Base64;

public class GeradorToken {
 
	private static final String ALPHANUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	
	public static String gerarToken(int tamanho) {
			StringBuilder token = new StringBuilder(tamanho);
			SecureRandom random = new SecureRandom();
			
			for(int i=0; i<tamanho; i++) {
				int randomIndex = random.nextInt(ALPHANUMERIC_CHARS.length());
				char randomChar = ALPHANUMERIC_CHARS.charAt(randomIndex);
				token.append(randomChar);
			}
			
			return token.toString();
	}
	
	public static void main(String[] args) {
		String token = gerarToken(10);
		System.out.println("Token: "+token);
	}
}
