package medico.cirurgias.model;

import java.util.Random;

public class GerarIdEspecialidade {

	public static int gerarIdEspecialidade() {
		Random idEspecialidade = new Random();
			return idEspecialidade.nextInt(9000)+1000;
	}
	
	public static void main(String[] args) {
		System.out.println("ID: "+gerarIdEspecialidade());
	}
	
}
