//Nessa classe foram criadas regras (metodos) para receber os dados de acordo com o tipo do funcionario

import java.util.Scanner;

public class Regras {

    //metodo para receber a entrada dos dados basicos de cada funcionario da lista dinamica (Nome e matricula), e atribuir a cada um o valor da constante (Salario Base)
    public static void preencherDadosBasicos(
        Scanner entrada,
        Funcionario funcPadrao) {

    System.out.print("Nome:\n");
    funcPadrao.funcNome = Entrada.lerNomesValidos(entrada, "Digite o nome completo> ");

    System.out.print("Matrícula:> ");
    funcPadrao.funcMatricula = entrada.nextLine();
    funcPadrao.salarioBase = Funcionario.SAL_FUNCIONARIOS;
    
}

//metodo para receber a entrada dos dados do funcionario de vendas (e calcular sua comissão)
public static void preencherDadosComissionado(
        Scanner entrada,
        Funcionario funcionario) {

    System.out.print("Valor das vendas (em R$): ");
    funcionario.funcVendas = Entrada.lerDouble(entrada, "digite o valor total> ");

    System.out.print("Comissão (%): ");
    funcionario.comissaoPorcentagem = Entrada.lerInteiroPositivo(entrada, "Digite apenas a porcentagem da comissão> ");
    funcionario.comissaoFinal = (funcionario.comissaoPorcentagem * funcionario.funcVendas) / 100;
    funcionario.salarioFinal = Funcionario.SAL_FUNCIONARIOS + funcionario.comissaoFinal;


}

//metodo para receber a entrada dos dados do funcionario de produção e calcular seu bônus
public static void preencherDadosProducao(
        Scanner entrada,
        Funcionario funcionario) {

    System.out.print("Quantidade de peças: ");
    funcionario.funcPecas = Entrada.lerInteiroPositivo(entrada, "digite a quantidade de peças> ");

    System.out.print("Valor da peça (em R$): ");
    funcionario.valorPeca = Entrada.lerDouble(entrada, "Digite o valor da peça> ");
    funcionario.bonusFinal = (funcionario.valorPeca * funcionario.funcPecas);
    funcionario.salarioFinal = Funcionario.SAL_FUNCIONARIOS + funcionario.bonusFinal;


}

 
    
}
