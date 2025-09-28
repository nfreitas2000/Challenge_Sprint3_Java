package org.example;

import org.example.DAO.ImplementacaoContaPaciente;
import org.example.Model.Paciente.ContaPaciente;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*INSTANCIA DE OBJETOS DE CRUD*/

        ImplementacaoContaPaciente contaCRUD = new ImplementacaoContaPaciente();




        /*INSTÂNCIAÇÃO DE OBJETOS*/

        Scanner sc = new Scanner(System.in);

        ContaPaciente contaP = new ContaPaciente();


        /*INSTANCIAÇÃO DE VARIÁVEIS*/

        int escolha = 0;
        int inicioPaciente = 0;

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
                System.out.println("Valor inserido inválido!");
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
                    System.out.print("Digite: ");
                    try{
                        inicioPaciente = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e){
                        System.out.println("Valor inserido inválido!");
                        continue;
                    }
                    switch (inicioPaciente){
                        case 0:
                            break;
                        case 1:
                            System.out.println("Digite o usuário: ");
                            String user = sc.nextLine();
                            System.out.println("Digite a senha: ");
                            String password = sc.nextLine();
                            if (contaP.realizarLogin(contaCRUD.recuperarLogin(user, password))){
                                System.out.println("Acesso liberado!");
                            } else {
                                System.out.println("Acesso negado!");
                            }
                            continue;
                        case 2:
                            contaP.criarContaCompleta();
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