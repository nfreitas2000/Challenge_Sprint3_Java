package org.example;

import org.example.DAO.ImplementacaoPaciente;
import org.example.DAO.ImplementacaoPessoa;
import org.example.Model.Paciente;
import org.example.Model.Pessoa;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*INSTÂNCIAÇÃO DE OBJETOS DE CRUD*/
        ImplementacaoPessoa pessoaCRUD = new ImplementacaoPessoa();
        ImplementacaoPaciente pacienteCRUD = new ImplementacaoPaciente();



        /*INSTÂNCIAÇÃO DE OBJETOS*/
        Scanner sc = new Scanner(System.in);

        Pessoa p = new Pessoa();
        Pessoa pessoaGenerica = new Pessoa("Eduardo", "12332112332","9999999999", "02/06/1997", "M", "solteiro", "Fundamental Completo");
        Paciente pacienteGenerico = new Paciente();

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
                    }
                    switch (inicioPaciente){
                        case 0:
                            break;
                        case 1:

                            continue;
                        case 2:
                            p.cadastrarPessoa();
                            System.out.println("=====================================================");
                            pessoaCRUD.inserirDados(p); /*ISSO PODE DAR ERRO -> SE OS DADOS NO ESTIVEREM CORRETOS, O BD VAI NEGAR A CRIAÇÃO, MAS O CÓDIGO CONTINUA DE QUALQUER JEITO*/
                            /*PARA CORRIGIR, TRATAR OS DADOS NO CADASTRO DE PESSOA*/
                            System.out.println("=====================================================");
                            p.setId_pessoa(pessoaCRUD.recuperaId(p));
                            pacienteGenerico.cadastrarPaciente(p); /*OBS: DADOS DE TIPO SANGUINEO ESTÃO ERRADOS (NÃO ACEITAM + OU -)*/
                            System.out.println("=====================================================");
                            pacienteCRUD.inserirDados(pacienteGenerico);
                            System.out.println("=====================================================");
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