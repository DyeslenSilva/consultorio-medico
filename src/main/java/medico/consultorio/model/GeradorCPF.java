package medico.consultorio.model;

import java.util.Random;

public class GeradorCPF {

    public static String gerarCPF() {
        // Gera 9 dígitos aleatórios para os números do CPF
        Random random = new Random();
        int digito1 = random.nextInt(10);
        int digito2 = random.nextInt(10);
        int digito3 = random.nextInt(10);
        int digito4 = random.nextInt(10);
        int digito5 = random.nextInt(10);
        int digito6 = random.nextInt(10);
        int digito7 = random.nextInt(10);
        int digito8 = random.nextInt(10);
        int digito9 = random.nextInt(10);

        // Calcula os dois dígitos verificadores
        int verificador1 = (digito1 * 10 + digito2 * 9 + digito3 * 8 + digito4 * 7 + digito5 * 6 + digito6 * 5 + digito7 * 4 + digito8 * 3 + digito9 * 2) % 11;
        if (verificador1 == 10) {
            verificador1 = 0;
        }

        int verificador2 = (digito1 * 11 + digito2 * 10 + digito3 * 9 + digito4 * 8 + digito5 * 7 + digito6 * 6 + digito7 * 5 + digito8 * 4 + digito9 * 3 + verificador1 * 2) % 11;
        if (verificador2 == 10) {
            verificador2 = 0;
        }

        // Retorna o CPF sem máscara
        return String.format("%d%d%d%d%d%d%d%d%d%d%d", digito1, digito2, digito3, digito4, digito5, digito6, digito7, digito8, digito9, verificador1, verificador2);
    }

    public static void main(String[] args) {
        String cpfGerado = gerarCPF();
        System.out.println("CPF gerado: " + cpfGerado);
    }
}
