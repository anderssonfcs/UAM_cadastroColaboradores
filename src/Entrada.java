//Nessa classe foram colocados metodos que criam regras de entrada do usuário, restringindo o que será aceito, se numero string, inteiro ou numero decimal,  
//alem de uma regra de saida para representcacao de valores com 2 casas decimais

import java.util.Locale;
import java.util.Scanner;

public class Entrada {

    //regra criada para restringir entrada de registro a apenas letras e espacos
    public static String lerNomesValidos(Scanner entrada, String mensagem) {

    while (true) {

        System.out.print(mensagem);
        String nomeValido = entrada.nextLine().trim();

        if (nomeValido.matches("[\\p{L} ]+")) {
            return nomeValido;
        }

        System.out.println("Digite apenas letras e espaços> ");
    }
}
    
    //regra criada para restringir entrada de registro a apenas numeros inteiros
    public static int lerInteiroPositivo(Scanner entrada, String mensagem) {

        String entradaUsuario;
        int numeroInt;

        while (true) {

            System.out.print(mensagem);
            entradaUsuario = entrada.nextLine();

            try {
                numeroInt = Integer.parseInt(entradaUsuario);

                if (numeroInt >= 0) {
                    return numeroInt;
                }

                System.out.println("*** Digite um número positivo! *** ");

            } catch (NumberFormatException e) {
                System.out.println("*** Digite apenas números inteiros *** ");
            }
        }
    }

    //regra criada para para ler um número decimal (double) digitado pelo usuário, validar a entrada e impedir valores negativos
    public static double lerDouble(Scanner entrada, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entradaUsuario = entrada.nextLine();

            try {
                double numeroDouble = Double.parseDouble(entradaUsuario.replace(",", "."));

                if (numeroDouble < 0) {
                System.out.println("*** Não são permitidos valores negativos! *** ");
                continue;
                }

            return numeroDouble;

        } catch (NumberFormatException e) {
            System.out.println("*** Digite um número válido! *** ");
        }
    }
}

    //regra para converter um número double em uma String formatada com exatamente 2 casas decimais.
    public static String formatar2Casas(double valor) { 
        return String.format(Locale.US, "%.2f", valor); 
    } 

     

}