package org.example;

import org.example.DAO.ImplementacaoContaFuncionario;
import org.example.DAO.ImplementacaoContaPaciente;
import org.example.Model.Funcionario.ContaFuncionario;
import org.example.Model.Funcionario.GerenciarPacientes;
import org.example.Model.Paciente.ContaPaciente;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*INSTANCIA DE OBJETOS DE CRUD*/

        ImplementacaoContaPaciente contaPCRUD = new ImplementacaoContaPaciente();
        ImplementacaoContaFuncionario contaFCRUD = new ImplementacaoContaFuncionario();

        /*INSTÂNCIAÇÃO DE OBJETOS*/

        Scanner sc = new Scanner(System.in);

        GerenciarPacientes gerenciarPacientes = new GerenciarPacientes();

        ContaPaciente contaP = new ContaPaciente();
        ContaFuncionario contaF = new ContaFuncionario();

        /*INSTANCIAÇÃO DE VARIÁVEIS*/

        int escolha = 0;
        int inicioPaciente = 0;
        int inicioFuncionario = 0;

        while (true){
            System.out.println("=====================================================");
            System.out.println("Seja bem-vindo ao sistema AxcessTech!");
            System.out.println("Deseja realizar uma simulação como:");
            System.out.println("0 - Encerrar");
            System.out.println("1 - Portal do Paciente");
            System.out.println("2 - Portal do Funcionário");
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
                            if (contaP.realizarLogin(contaPCRUD.recuperarLogin(user, password))){
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
                    System.out.println("=====================================================");
                    System.out.println("0 - Voltar");
                    System.out.println("1 - Realizar Login");
                    System.out.println("2 - Realizar Cadastro");
                    System.out.println("=====================================================");
                    System.out.print("Digite: ");
                    try{
                        inicioFuncionario = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e){
                        System.out.println("Valor inserido inválido!");
                        continue;
                    }
                    switch (inicioFuncionario){
                        case 0:
                            break;
                        case 1:
                            System.out.println("Digite o usuário: ");
                            String user = sc.nextLine();
                            System.out.println("Digite a senha: ");
                            String password = sc.nextLine();
                            if (contaF.realizarLogin(contaFCRUD.recuperarLogin(user, password))){
                                while (true){
                                    System.out.println("Acesso liberado!");
                                    System.out.println("=====================================================");
                                    System.out.println("Seja bem-vindo, " + user + "!");
                                    System.out.println("O que deseja fazer?");
                                    System.out.println("0 - Voltar");
                                    System.out.println("1 - Acessar gerenciador de pacientes");
                                    System.out.println("2 - Acessar Dashboard");
                                    System.out.println("=====================================================");
                                    System.out.print("Digite: ");
                                    try {
                                        switch (Integer.parseInt(sc.nextLine())){
                                            case 0:
                                                break;
                                            case 1:
                                                while (true) {
                                                    System.out.println("=====================================================");
                                                    System.out.println("Você deseja:");
                                                    System.out.println("0 - Voltar");
                                                    System.out.println("1 - Apagar dados de pacientes");
                                                    System.out.println("2 - Atulizar dados de pacientes");
                                                    System.out.println("3 - Visualizar dados dos pacientes");
                                                    System.out.println("=====================================================");
                                                    System.out.print("Digite: ");
                                                    try {
                                                        switch (Integer.parseInt(sc.nextLine())) {
                                                            case 0:
                                                                break;
                                                            case 1:
                                                                gerenciarPacientes.apagarPacientes();
                                                            case 2:
                                                                gerenciarPacientes.atualizarDados();
                                                            case 3:
                                                                gerenciarPacientes.exibirPacientes();
                                                            default:
                                                                System.out.println("Entrada inválida! Tente novamente.");
                                                                continue;
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Entrada inválida! Tente novamente.");
                                                        continue;
                                                    }break;
                                                }
                                            case 2:
                                                continue;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Entrada inválida! Tente novamente.");
                                        continue;
                                    }break;
                                }
                            } else {
                                System.out.println("Acesso negado!");
                            }
                            continue;
                        case 2:
                            contaF.criarContaCompleta();
                            continue;
                        default:
                            System.out.println("=====================================================");
                            System.out.println("Item não reconhecido. Tente novamente.");
                            break;
                    }
                default:
                    System.out.println("=====================================================");
                    System.out.println("Item não reconhecido. Tente novamente.");
                    continue;
            }

        }
    }
}