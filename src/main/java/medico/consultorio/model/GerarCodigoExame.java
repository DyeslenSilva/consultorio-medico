package medico.consultorio.model;

import java.util.Random;

public class GerarCodigoExame {

	public static int gerarCodigoExame() {
		Random codigoExame = new Random();
		int exmCod = codigoExame.nextInt(900000)+100000;
		return exmCod;
	}
	
	public static void main(String[] args) {
		int codigoGerado = gerarCodigoExame();
		System.out.println("Codigo gerado: "+codigoGerado);
	}
	
}
