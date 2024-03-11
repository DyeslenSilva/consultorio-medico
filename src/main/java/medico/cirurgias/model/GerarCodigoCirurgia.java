package medico.cirurgias.model;

import java.util.Random;

public class GerarCodigoCirurgia {

	public static int gerarCodigoCirurgia() {
		Random codigoCirurgia= new Random();
		return codigoCirurgia.nextInt(90000)+10000;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Codigo da Cirurgia "+gerarCodigoCirurgia());
	}
}
