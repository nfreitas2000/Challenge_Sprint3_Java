package org.example;

import org.example.DAO.*;
import org.example.Model.Funcionario.ContaFuncionario;
import org.example.Model.Funcionario.DashBoard;
import org.example.Model.Funcionario.GerenciarPacientes;
import org.example.Model.Interacoes.CliquesLogin;
import org.example.Model.Interacoes.CliquesManuais;
import org.example.Model.Interacoes.CliquesPrincipais;
import org.example.Model.Paciente.ContaPaciente;
import org.example.Model.Paciente.Sessao;
import org.example.Model.Paciente.Teleconsulta;

import java.sql.SQLException;
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
                                contaP = contaPCRUD.recuperarLogin(user, password);

                                System.out.println("Acesso liberado!");


                                Sessao sessao = new Sessao(contaP);

                                CliquesManuais cliquesManuais = new CliquesManuais();
                                CliquesLogin cliquesLogin = new CliquesLogin();
                                CliquesPrincipais cliquesPrincipais = new CliquesPrincipais();

                                while (true) {
                                    System.out.println("=====================================================");
                                    System.out.println("Seja bem-vindo(a), " + contaP.getNm_paciente() + "!");
                                    System.out.println("O que deseja fazer?");
                                    System.out.println("0 - Voltar");
                                    System.out.println("1 - Agendar teleconsulta");
                                    System.out.println("2 - Ver consultas");
                                    System.out.println("3 - Exibir resultados");
                                    System.out.println("4 - Preciso de ajuda");
                                    System.out.println("=====================================================");
                                    System.out.print("Digite: ");
                                    try {
                                        switch (Integer.parseInt(sc.nextLine())) {
                                            case 0:
                                                cliquesPrincipais.salvarInteracoes(cliquesManuais, cliquesLogin, cliquesPrincipais, sessao);
                                                break;
                                            case 1:
                                                Teleconsulta teleconsulta = new Teleconsulta();
                                                teleconsulta.cadastrarTeleatendimento(contaP);
                                                continue;
                                            case 2:
                                                Teleconsulta teleconsulta1 = new Teleconsulta();
                                                teleconsulta1.exibirTeleconsultas(contaP);
                                                continue;
                                            case 3:
                                                System.out.println("Não há resultados disponiveis.");
                                                continue;
                                            case 4:
                                                while (true) {
                                                    System.out.println("=====================================================");
                                                    System.out.println("Com o que você precisa de ajuda?");
                                                    System.out.println("O que deseja fazer?");
                                                    System.out.println("0 - Voltar");
                                                    System.out.println("1 - Login");
                                                    System.out.println("2 - Consultas");
                                                    System.out.println("3 - Agendamento");
                                                    System.out.println("4 - Manuais");
                                                    System.out.println("5 - Outros");
                                                    System.out.println("=====================================================");
                                                    System.out.print("Digite: ");
                                                    try {
                                                        switch (Integer.parseInt(sc.nextLine())) {
                                                            case 0:
                                                                break;
                                                            case 1:
                                                                cliquesPrincipais.setCliquesLogin(cliquesPrincipais.getCliquesLogin() + 1);
                                                                while (true) {
                                                                    System.out.println("=====================================================");
                                                                    System.out.println("Quais problemas de login");
                                                                    System.out.println("0 - Voltar");
                                                                    System.out.println("1 - Cadastro");
                                                                    System.out.println("2 - Atualizar dados");
                                                                    System.out.println("=====================================================");
                                                                    System.out.print("Digite: ");
                                                                    try {
                                                                        switch (Integer.parseInt(sc.nextLine())) {
                                                                            case 0:
                                                                                break;
                                                                            case 1:
                                                                                cliquesLogin.setCliquesCadastro(cliquesLogin.getCliquesCadastro() + 1);
                                                                                System.out.println("=====================================================");
                                                                                System.out.println("Para criar sua conta, acesse o Portal do Paciente e siga o passo a passo. Caso tenha dificuldade, procure a equipe de suporte para ajudar no processo.");
                                                                                System.out.println("=====================================================");
                                                                                continue;
                                                                            case 2:
                                                                                cliquesLogin.setCliquesAtualizarDados(cliquesLogin.getCliquesAtualizarDados() + 1);
                                                                                System.out.println("=====================================================");
                                                                                System.out.println("Para realizar alterações nos dados inseridos, entre em contato com um profissional.");
                                                                                System.out.println("=====================================================");
                                                                                continue;
                                                                            default:
                                                                                System.out.println("Entrada Inválida!");
                                                                                continue;
                                                                        }
                                                                    } catch (NumberFormatException e){
                                                                        System.out.println("Entrada inválida!");
                                                                        continue;
                                                                    }
                                                                    break;
                                                                }
                                                            case 2:
                                                                cliquesPrincipais.setCliquesConsultas(cliquesPrincipais.getCliquesConsultas() + 1);
                                                                System.out.println("=====================================================");
                                                                System.out.println("Aqui você pode verificar como visualizar consultas anteriores, próximas consultas ou remarcar.");
                                                                System.out.println("=====================================================");
                                                                continue;
                                                            case 3:
                                                                cliquesPrincipais.setCliquesAgendamentos(cliquesPrincipais.getCliquesAgendamentos() + 1);
                                                                System.out.println("=====================================================");
                                                                System.out.println("Aqui você pode verificar como realizar o agemdamento de uma nova consulta.");
                                                                System.out.println("=====================================================");
                                                                continue;
                                                            case 4:
                                                                cliquesPrincipais.setCliquesManuais(cliquesPrincipais.getCliquesManuais() + 1);
                                                                while (true) {
                                                                    System.out.println("=====================================================");
                                                                    System.out.println("Esses são os manuais disponiveis:");
                                                                    System.out.println("O que deseja fazer?");
                                                                    System.out.println("0 - Voltar");
                                                                    System.out.println("1 - Portal do paciente");
                                                                    System.out.println("2 - Teleconsulta");
                                                                    System.out.println("3 - Privacidade");
                                                                    System.out.println("=====================================================");
                                                                    System.out.print("Digite: ");
                                                                    try {
                                                                        switch (Integer.parseInt(sc.nextLine())) {
                                                                            case 0:
                                                                                break;
                                                                            case 1:
                                                                                cliquesManuais.setCliquesPortalPaciente(cliquesManuais.getCliquesPortalPaciente() + 1);
                                                                                System.out.println("=====================================================");
                                                                                System.out.println("Manual do Portal do Paciente: passo a passo para acessar o sistema, visualizar consultas e atualizar informações.");
                                                                                System.out.println("=====================================================");
                                                                                continue;
                                                                            case 2:
                                                                                cliquesManuais.setCliquesGuiaTeleconsulta(cliquesManuais.getCliquesGuiaTeleconsulta() + 1);
                                                                                System.out.println("=====================================================");
                                                                                System.out.println("Manual da Teleconsulta: guia simples para entrar na consulta online e testar áudio e vídeo.");
                                                                                System.out.println("=====================================================");
                                                                                continue;
                                                                            case 3:
                                                                                cliquesManuais.setCliquesPrivacidade(cliquesManuais.getCliquesPrivacidade() + 1);
                                                                                System.out.println("=====================================================");
                                                                                System.out.println("Manual de Privacidade: como seus dados são utilizados e como garantir um acesso seguro.");
                                                                                System.out.println("=====================================================");
                                                                                continue;
                                                                        }
                                                                    } catch (NumberFormatException e){
                                                                        System.out.println("Entrada inválida!");
                                                                        continue;
                                                                    }
                                                                    break;
                                                                } continue;
                                                            case 5:
                                                                cliquesPrincipais.setCliquesOutros(cliquesPrincipais.getCliquesOutros() + 1);
                                                                System.out.println("=====================================================");
                                                                System.out.println("Aqui você encontra dúvidas frequentes, pode enviar sugestões ou falar com um atendente.");
                                                                System.out.println("=====================================================");
                                                                continue;
                                                        }
                                                    } catch (NumberFormatException e){
                                                        System.out.println("Entrada inválida!");
                                                        continue;
                                                    }
                                                    break;
                                                }
                                                continue;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Entrada inválida");
                                        continue;
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;
                                }continue;
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
                                                DashBoard dashBoard = new DashBoard();
                                                dashBoard.exibirDados();
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
            }break;

        }
    }
}