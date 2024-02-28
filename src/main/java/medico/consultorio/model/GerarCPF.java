package medico.consultorio.model;

import java.util.Random;

public class GerarCPF {

	public static String gerarCPF() {
		Random randCPF = new Random();
		int [] cpfArray = new int[9];
		
		for(int i=0; i<cpfArray.length; i++) {
			cpfArray[i] = randCPF.nextInt(9);
		}
		
		int primeiroDigito = calcularDigitoVerificador(cpfArray,10);
		int segundoDigito = calcularDigitoVerificador(cpfArray, 11);
		
		cpfArray = adicionarDigitoVerificador(cpfArray, primeiroDigito);
		cpfArray = adicionarDigitoVerificador(cpfArray, segundoDigito);
		
		StringBuilder cpfFormato = new StringBuilder();
		for(int i =0; i<11; i++) {
			cpfFormato.append(cpfArray[i]);
			if(i == 2 || i ==5) {
				cpfFormato.append(".");
			}else if(i==8) {
				cpfFormato.append("-");
			}
		}
		
		return cpfFormato.toString();
		
	}
	
	private static int calcularDigitoVerificador(int[]cpfArray, int multiplicador) {
		int soma = 0;
		for(int i =0; i<cpfArray.length; i++) {
			soma =+ cpfArray[i]*multiplicador;
			multiplicador--;
		}
		
		int resto = soma % 11;
		return (resto<2)?0: (11-resto);
	}
	
	private static int[] adicionarDigitoVerificador(int []array, int digito) {
		int[] newArray = new int[array.length+1];
		System.arraycopy(array, 0, newArray, 0, array.length);
		newArray[array.length] = digito;
		return newArray;
	}
	
	
	public static void main(String[] args) {
		System.out.println("CPF: "+gerarCPF());
	}
}
