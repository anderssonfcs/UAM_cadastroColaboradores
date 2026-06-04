import java.util.ArrayList;
import java.util.Scanner;


public class ProgramaRH {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        int quantidade;
        int cadastrados = 0;
        System.out.print("\n\n============ BEM VINDO AO SISTEMA DE CALCULO DE FOLHA DE PAGAMENTO ===============\n\n>> Quantos funcionários deseja cadastrar? ");

        quantidade = Entrada.lerInteiroPositivo(entrada, " \n\n>> Digite a quantidade> "); //aqui sera definida a quantidade de funcionarios que o usuario pratende cadastrar

        if (quantidade == 0) { //se o usuario digitar 0, o programa entende que não havera nenhum cadastro e se encerrará
        System.out.println("\n========= FIM ===========\n");
        return;
        }
        

        for (int i = 0; i < quantidade; i++) { //loop criado para receber os valores de cada objeto do funcionario

            Funcionario novoFuncionario = new Funcionario();  //Essa linha cria uma nova instância da classe Funcionario e armazena sua referência na variável novoFuncionario

            System.out.println("\n=== Funcionário " + (i + 1 +" ==="));


            //Mostra um menu de escolha do usuario
            novoFuncionario.funcCategoria = Entrada.lerInteiroPositivo(entrada, "\n>> INFORME A CATEGORIA DO TRABALHADOR:\n\nDigite * 1 * para FUNCIONARIO PADRÃO\n"
            + "Digite * 2 * para FUNCIONARIO COMISSIONADO\nDigite * 3 * para FUNCIONARIO DE PRODUÇÃO\nDigite * 4 * para GERAR A FOLHA DE PAGAMENTO\n\n>> ");

            switch (novoFuncionario.funcCategoria) { //restringe o usuário a escolher apenas as opções mostradas no menu

                case 1:

                    Regras.preencherDadosBasicos(entrada, novoFuncionario); //chama a classe Regras pra receber a entrada das informações basicas do funcionario
                    cadastrados ++;

                    break;

                case 2:

                    Regras.preencherDadosBasicos(entrada, novoFuncionario);

                    Regras.preencherDadosComissionado(entrada, novoFuncionario); //chama a classe Regras pra receber a entrada das informações do funcionario de Vendas
                    
                    cadastrados ++;
 
                    break;

                case 3:

                    Regras.preencherDadosBasicos(entrada, novoFuncionario);

                    Regras.preencherDadosProducao(entrada, novoFuncionario); //chama a classe Regras pra receber a entrada das informações do funcionario de Produção

                    cadastrados ++;

                    break;

                case 4: // opção criada em caso do usuario queirer encerrar o cadastro de funcionarios e ver o resultado
                    
                    i = quantidade; 
                    continue;

                default:
                    System.out.println("*** Categoria inválida! ***");
                    i--; // repete o cadastro
                    continue;
            }

            listaFuncionarios.add(novoFuncionario); // adiciona os valores atribuidos a cada objeto do novo funcionario cadastrado à lista de funcionarios
            

        }

       

        System.out.println("\n======= FOLHA DE PAGAMENTO ==========");

        System.out.println("\nTotal de pessoas cadastradas =  " + cadastrados);

        for (Funcionario f : listaFuncionarios) {       //percorre a lista inteira, retornando o valor de cada objeto que é chamado

            System.out.println("\nNome: " + f.funcNome);
            System.out.println("Matrícula: " + f.funcMatricula);
            
            if (f.funcCategoria == 1) {  //mostra na tela apenas as informações do funcionario padrão

                System.out.println("Salario fixo: R$" + Entrada.formatar2Casas (f.salarioBase));
                System.out.println("Extras: " + Entrada.formatar2Casas (f.salarioExtras));
                System.out.println("Salario final: R$" + Entrada.formatar2Casas (f.salarioBase));

            }

            if (f.funcCategoria == 2) { //mostra na tela as informações do funcionario de Vendas
                System.out.println("Salario fixo R$: " + Entrada.formatar2Casas (f.salarioBase));
                System.out.println("Valor das vendas: R$" + Entrada.formatar2Casas (f.funcVendas));
                System.out.println("Comissão (em %): " + f.comissaoPorcentagem + "%");
                System.out.println("Salario final: R$" + Entrada.formatar2Casas (f.salarioFinal));
            }

            if (f.funcCategoria == 3) { //mostra na tela as informações do funcionario de Produção
                System.out.println("Salario fixo: R$" + Entrada.formatar2Casas (f.salarioBase));
                System.out.println("Peças fabricadas: " + f.funcPecas);
                System.out.println("Valor por peça: R$" + Entrada.formatar2Casas (f.valorPeca));
                System.out.println("Salario: final R$" + Entrada.formatar2Casas (f.salarioFinal));
            }
        }

         System.out.println("\n========= FIM ===========\n");

        entrada.close();
    }


}







 
