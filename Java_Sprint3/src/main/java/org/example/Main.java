package org.example;

import org.example.DAO.ImplementacaoPessoa;
import org.example.Model.Pessoa;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*INSTÂNCIAÇÃO DE OBJETOS DE CRUD*/
        ImplementacaoPessoa pessoaCRUD = new ImplementacaoPessoa();


        /*INSTÂNCIAÇÃO DE OBJETOS*/
        Scanner sc = new Scanner(System.in);

        /*INSTANCIAÇÃO DE VARIÁVEIS*/

        int escolha = 10;

        while (true){
            System.out.println("=====================================================");
            System.out.println("Seja bem-vindo ao sistema AxcessTech!");
            System.out.println("Deseja realizar uma simulação como:");
            System.out.println("0 - Encerrar");
            System.out.println("1 - Aplicativo (Paciente)");
            System.out.println("2 - Dashboard (Gestor)");
            System.out.println("=====================================================");
            System.out.print("Digite: ");
            try {
                escolha = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inserido inválido!");;
            }
            switch (escolha){
                case 0:
                    break;
                case 1:
                    System.out.println("=====================================================");
                    System.out.println("0 - Voltar");
                    System.out.println("1 - Realizar Login");
                    System.out.println("2 - Realizar Cadastro");
                    System.out.println("=====================================================");
                    System.out.println("Digite: ");
                    int inicioPaciente = Integer.parseInt(sc.nextLine());
                    switch (inicioPaciente){
                        case 0:
                            break;
                        case 1:
                        case 2:
                            Pessoa p = new Pessoa();
                            p.cadastrarPessoa();
                            pessoaCRUD.inserirDados(p);
                            continue;
                        default:
                            System.out.println("=====================================================");
                            System.out.println("Item não reconhecido. Tente novamente.");
                            break;
                    }
                    break;
                case 2:
                default:
                    System.out.println("=====================================================");
                    System.out.println("Item não reconhecido. Tente novamente.");
                    continue;
            }
            break;
        }
    }
}