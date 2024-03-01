package medico.consultorio.model;

import java.util.Random;

public class GerarCRM {

	public static String gerarRegistroMedico() {
		Random crm = new Random();
		int numCRM = crm.nextInt(900000) + (100000);
		return String.valueOf(numCRM);
	}
	
	public static void main(String[] args) {
		System.out.println("Registro medico gerado: "+gerarRegistroMedico());
	}
}
