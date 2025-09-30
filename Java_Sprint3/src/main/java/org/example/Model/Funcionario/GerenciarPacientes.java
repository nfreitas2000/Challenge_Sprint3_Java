package org.example.Model.Funcionario;

import org.example.DAO.ImplementacaoContaPaciente;
import org.example.DAO.ImplementacaoPaciente;
import org.example.DAO.ImplementacaoPessoa;
import org.example.Model.Paciente.ContaPaciente;

import java.util.List;
import java.util.Scanner;

public class GerenciarPacientes {

    public void apagarPacientes(){
        Scanner sc = new Scanner(System.in);
        ImplementacaoContaPaciente contaPCRUD = new ImplementacaoContaPaciente();
        ImplementacaoPaciente pacienteCRUD = new ImplementacaoPaciente();
        ImplementacaoPessoa pessoaCRUD = new ImplementacaoPessoa();
        List<ContaPaciente> pacientes = new ImplementacaoContaPaciente().recuperarDadosTodos();

        System.out.println("=====================================================");
        System.out.println("MENU DE EXCLUSÃO");
        for (ContaPaciente p : pacientes){
            System.out.println(p.getId_conta() + " - " + p.getNm_paciente());
        }
        System.out.println("=====================================================");
        System.out.print("Digite o número da conta que deseja excluir: ");
        int idConta = Integer.parseInt(sc.nextLine());
        for (ContaPaciente p : pacientes){
            if (idConta == p.getId_conta()){
                contaPCRUD.removerDados(p);
                pacienteCRUD.removerDados(p.getPaciente());
                pessoaCRUD.removerDados(p.getPaciente().getPessoa());
            }
        }
    }

    public void atualizarDados(){
        Scanner sc = new Scanner(System.in);
        ImplementacaoContaPaciente contaPCRUD = new ImplementacaoContaPaciente();
        ImplementacaoPaciente pacienteCRUD = new ImplementacaoPaciente();
        ImplementacaoPessoa pessoaCRUD = new ImplementacaoPessoa();
        List<ContaPaciente> pacientes = new ImplementacaoContaPaciente().recuperarDadosTodos();

        while (true) {
            System.out.println("=====================================================");
            System.out.println("MENU DE EDIÇÃO");
            System.out.println("0 - Voltar");
            for (ContaPaciente p : pacientes) {
                System.out.println(p.getId_conta() + " - " + p.getNm_paciente());
            }
            System.out.println("=====================================================");
            System.out.print("Digite o número da conta que deseja editar: ");
            try {
                int idConta = Integer.parseInt(sc.nextLine());
                if (idConta == 0){
                    break;
                }
                for (ContaPaciente p : pacientes) {
                    if (idConta == p.getId_conta()) {
                        ContaPaciente contaSelecionada = new ContaPaciente(p.getId_conta(), p.getPaciente(), p.getNm_paciente(), p.getSenha());
                        while (true) {
                            System.out.println("=====================================================");
                            System.out.println("Qual dado da conta " + idConta + " você deseja editar?");
                            System.out.println("0 - Voltar");
                            System.out.println("1 - Dados pessoais");
                            System.out.println("2 - Dados medicos");
                            System.out.println("3 - Dados de login");
                            System.out.println("=====================================================");
                            System.out.print("Digite: ");
                            try {
                                switch (Integer.parseInt(sc.nextLine())) {
                                    case 0:
                                        break;
                                    case 1:
                                        while (true) {
                                            String dado = "";
                                            System.out.println("=====================================================");
                                            System.out.println("Selecione o dado: ");
                                            System.out.println("0 - Voltar");
                                            System.out.println("1 - Nome");
                                            System.out.println("2 - CPF");
                                            System.out.println("3 - RG");
                                            System.out.println("4 - Data de nascimento");
                                            System.out.println("5 - Sexo");
                                            System.out.println("6 - Estado Civil");
                                            System.out.println("7 - Escolaridade");
                                            System.out.println("=====================================================");
                                            System.out.print("Digite: ");
                                            try {
                                                switch (Integer.parseInt(sc.nextLine())) {
                                                    case 0:
                                                        break;
                                                    case 1:
                                                        while (true) {
                                                            System.out.println("Digite seu nome: ");
                                                            dado = sc.nextLine();
                                                            if (dado.isEmpty()){
                                                                System.out.println("Insira um nome!");
                                                                continue;
                                                            }
                                                            pessoaCRUD.atualizarDados(contaSelecionada.getPaciente().getPessoa(), "nm_pessoa", dado);
                                                            break;
                                                        }
                                                        continue;
                                                    case 2:
                                                        while (true) {
                                                            System.out.println("Digite o novo cpf (somente números): ");
                                                            dado = sc.nextLine();
                                                            if (dado.length() == 11) {
                                                                dado = dado.substring(0, 3) + "." + dado.substring(3, 6) + "." + dado.substring(6, 9) + "-" + dado.substring(9);
                                                                pessoaCRUD.atualizarDados(contaSelecionada.getPaciente().getPessoa(), "cpf", dado);
                                                            } else {
                                                                System.out.println("O CPF deve ter 11 digitos!");
                                                                continue;
                                                            }
                                                            break;
                                                        }
                                                        continue;
                                                    case 3:
                                                        while (true) {
                                                            System.out.println("Digite o novo rg (somenente números): ");
                                                            dado = sc.nextLine();
                                                            if (dado.length() == 9){
                                                                dado = dado.substring(0, 2) + "." + dado.substring(2, 5) + "." + dado.substring(5, 8) + "-" + dado.substring(8);
                                                                pessoaCRUD.atualizarDados(contaSelecionada.getPaciente().getPessoa(), "rg", dado);
                                                            } else {
                                                                System.out.println("O RG deve ter 9 digitos!");
                                                                continue;
                                                            }
                                                            break;
                                                        }
                                                        continue;
                                                    case 4:
                                                        System.out.println("Digite a data de nascimento: ");
                                                        dado = sc.nextLine();
                                                        pessoaCRUD.atualizarDados(contaSelecionada.getPaciente().getPessoa(), "dt_nascimento", dado);
                                                        continue;
                                                    case 5:
                                                        while (true) {
                                                            System.out.println("Selecione o sexo: ");
                                                            System.out.println("1 - Masculino");
                                                            System.out.println("2 - Feminino");
                                                            System.out.println("3 - Indefinido");
                                                            System.out.print("Digite: ");
                                                            try {
                                                                switch (Integer.parseInt(sc.nextLine())) {
                                                                    case 1:
                                                                        dado = "M";
                                                                        break;
                                                                    case 2:
                                                                        dado = "F";
                                                                        break;
                                                                    case 3:
                                                                        dado = "I";
                                                                        break;
                                                                    default:
                                                                        System.out.println("Entrada inválida!");
                                                                        continue;
                                                                }
                                                            } catch (NumberFormatException e){
                                                                System.out.println("Entrada inválida!");
                                                                continue;
                                                            }
                                                            break;
                                                        }
                                                        pessoaCRUD.atualizarDados(contaSelecionada.getPaciente().getPessoa(), "sx_pessoa", dado);
                                                        continue;
                                                    case 6:
                                                        while (true) {
                                                            System.out.println("Selecione o estado civil: ");
                                                            System.out.println("1 - Solteiro(a)");
                                                            System.out.println("2 - Casado(a)");
                                                            System.out.println("3 - Divorciado(a)");
                                                            System.out.println("4 - Viúvo(a)");
                                                            System.out.print("Digite: ");
                                                            try {
                                                                switch (Integer.parseInt(sc.nextLine())) {
                                                                    case 1:
                                                                        dado = ("solteiro");
                                                                        break;
                                                                    case 2:
                                                                        dado = ("casado");
                                                                        break;
                                                                    case 3:
                                                                        dado = ("divorciado");
                                                                        break;
                                                                    case 4:
                                                                        dado = ("viúvo");
                                                                        break;
                                                                    default:
                                                                        System.out.println("Entrada inválida!");
                                                                        continue;
                                                                }
                                                            } catch (NumberFormatException e){
                                                                System.out.println("Entrada inválida!");
                                                                continue;
                                                            }
                                                            break;
                                                        }
                                                        pessoaCRUD.atualizarDados(contaSelecionada.getPaciente().getPessoa(), "estado_civil", dado);
                                                        continue;
                                                    case 7:
                                                        while (true) {
                                                            System.out.println("Selecione sua escolaridade: ");
                                                            System.out.println("1 - Ensino Fundamental Incompleto");
                                                            System.out.println("2 - Ensino Fundamental Cursando");
                                                            System.out.println("3 - Ensino Fundamental Concluído");
                                                            System.out.println("4 - Ensino Médio Incompleto");
                                                            System.out.println("5 - Ensino Médio Cursando");
                                                            System.out.println("6 - Ensino Médio Concluído");
                                                            System.out.println("7 - Ensino Superior Incompleto");
                                                            System.out.println("8 - Ensino Superior Cursando");
                                                            System.out.println("9 - Ensino Superior Concluído");
                                                            System.out.println("10 - Pós-Graduação Incompleto");
                                                            System.out.println("11 - Pós-Graduação Cursando");
                                                            System.out.println("12 - Pós-Graduação Concluído");
                                                            System.out.print("Digite: ");

                                                            try {
                                                                switch (Integer.parseInt(sc.nextLine())) {
                                                                    case 1:
                                                                        dado = ("Ensino Fundamental Incompleto");
                                                                        break;
                                                                    case 2:
                                                                        dado = ("Ensino Fundamental Cursando");
                                                                        break;
                                                                    case 3:
                                                                        dado = ("Ensino Fundamental Concluído");
                                                                        break;
                                                                    case 4:
                                                                        dado = ("Ensino Médio Incompleto");
                                                                        break;
                                                                    case 5:
                                                                        dado = ("Ensino Médio Cursando");
                                                                        break;
                                                                    case 6:
                                                                        dado = ("Ensino Médio Concluído");
                                                                        break;
                                                                    case 7:
                                                                        dado = ("Ensino Superior Incompleto");
                                                                        break;
                                                                    case 8:
                                                                        dado = ("Ensino Superior Cursando");
                                                                        break;
                                                                    case 9:
                                                                        dado = ("Ensino Superior Concluído");
                                                                        break;
                                                                    case 10:
                                                                        dado = ("Pós-Graduação Incompleto");
                                                                        break;
                                                                    case 11:
                                                                        dado = ("Pós-Graduação Cursando");
                                                                        break;
                                                                    case 12:
                                                                        dado = ("Pós-Graduação Concluído");
                                                                        break;
                                                                    default:
                                                                        System.out.println("Entrada inválida!");
                                                                        continue;
                                                                }
                                                            } catch (NumberFormatException e) {
                                                                System.out.println("Entrada inválida!");
                                                                continue;
                                                            }
                                                            break;
                                                        }
                                                        pessoaCRUD.atualizarDados(contaSelecionada.getPaciente().getPessoa(), "escolaridade", dado);
                                                        continue;
                                                    default:
                                                        System.out.println("Entrada inválida!");
                                                        continue;
                                                }
                                            } catch (NumberFormatException e) {
                                                System.out.println("Entrada inválida!");
                                                continue;
                                            }
                                            break;
                                        }
                                    case 2:
                                        while (true) {
                                            String dado = "";
                                            System.out.println("=====================================================");
                                            System.out.println("Selecione o dado: ");
                                            System.out.println("0 - Voltar");
                                            System.out.println("1 - Histórico médico");
                                            System.out.println("2 - Grupo Snaguíneo");
                                            System.out.println("3 - Altura");
                                            System.out.println("4 - Peso");
                                            System.out.println("=====================================================");
                                            System.out.print("Digite: ");
                                            try {
                                                switch (Integer.parseInt(sc.nextLine())) {
                                                    case 0:
                                                        break;
                                                    case 1:
                                                        while (true) {
                                                            System.out.println("O paciente possui histórico médico:");
                                                            System.out.println("1 - Sim");
                                                            System.out.println("2 - Não");
                                                            System.out.print("Digite: ");
                                                            try {
                                                                switch (Integer.parseInt(sc.nextLine())) {
                                                                    case 1:
                                                                        System.out.print("Digite qual o diagnostico: ");
                                                                        dado = sc.nextLine();
                                                                        pacienteCRUD.atualizarDados(contaSelecionada.getPaciente(), "historico_medico", dado);
                                                                        break;
                                                                    case 2:
                                                                        dado = "";
                                                                        pacienteCRUD.atualizarDados(contaSelecionada.getPaciente(), "historico_medico", dado);
                                                                        break;
                                                                    default:
                                                                        System.out.println("Entrada inválida!");
                                                                        continue;
                                                                }
                                                            } catch (NumberFormatException e) {
                                                                System.out.println("Entrada inválida!");
                                                            }
                                                            break;
                                                        }continue;
                                                    case 2:
                                                        while (true) {
                                                            System.out.println("Selecione o tipo sanguíneo: ");
                                                            System.out.println("1 - A+");
                                                            System.out.println("2 - A-");
                                                            System.out.println("3 - B+");
                                                            System.out.println("4 - B-");
                                                            System.out.println("5 - AB+");
                                                            System.out.println("6 - AB-");
                                                            System.out.println("7 - O+");
                                                            System.out.println("8 - O-");
                                                            System.out.print("Digite: ");
                                                            try {
                                                                ;
                                                                switch (Integer.parseInt(sc.nextLine())) {
                                                                    case 1:
                                                                        dado = ("A+");
                                                                        break;
                                                                    case 2:
                                                                        dado = ("A-");
                                                                        break;
                                                                    case 3:
                                                                        dado = ("B+");
                                                                        break;
                                                                    case 4:
                                                                        dado = ("B-");
                                                                        break;
                                                                    case 5:
                                                                        dado = ("AB+");
                                                                        break;
                                                                    case 6:
                                                                        dado = ("AB-");
                                                                        break;
                                                                    case 7:
                                                                        dado = ("O+");
                                                                        break;
                                                                    case 8:
                                                                        dado = ("O-");
                                                                        break;
                                                                    default:
                                                                        System.out.println("Entrada inválida!");
                                                                        continue;
                                                                }
                                                            } catch (NumberFormatException e) {
                                                                System.out.println("Entrada inválida! Digite apenas números.");
                                                            }
                                                            pacienteCRUD.atualizarDados(contaSelecionada.getPaciente(), "grupo_sanguineo", dado);
                                                            break;
                                                        }continue;
                                                    case 3:
                                                        System.out.print("Qual a altura: ");
                                                            dado = sc.nextLine();
                                                            pacienteCRUD.atualizarDados(contaSelecionada.getPaciente(), "altura", dado);
                                                            continue;
                                                    case 4:
                                                        System.out.print("Qual seu peso: ");
                                                        dado = sc.nextLine();
                                                        pacienteCRUD.atualizarDados(contaSelecionada.getPaciente(), "peso", dado);
                                                        continue;
                                                }
                                            } catch (NumberFormatException e) {
                                                System.out.println("Entrada inválida!");
                                            }
                                            break;
                                        }
                                    case 3:
                                        while (true) {
                                            String dado;
                                            System.out.println("=====================================================");
                                            System.out.println("Selecione o dado: ");
                                            System.out.println("0 - Voltar");
                                            System.out.println("1 - Usuário");
                                            System.out.println("2 - Senha");
                                            System.out.println("=====================================================");
                                            System.out.print("Digite: ");
                                            try {
                                                switch (Integer.parseInt(sc.nextLine())) {
                                                    case 0:
                                                        break;
                                                    case 1:
                                                        System.out.println("Digite o novo usuário: ");
                                                        dado = sc.nextLine();
                                                        System.out.println(dado);
                                                        contaPCRUD.atualizarDados(contaSelecionada, "nm_usuario", dado);
                                                        continue;
                                                    case 2:
                                                        System.out.println("Digite a nova senha: ");
                                                        dado = sc.nextLine();
                                                        contaPCRUD.atualizarDados(contaSelecionada, "senha", dado);
                                                        continue;
                                                }
                                            } catch (NumberFormatException e){
                                                System.out.println("Entrada inválida!");
                                                continue;
                                            }
                                            break;
                                        }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida!");
                                continue;
                            }
                            break;
                        }
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida!");
                continue;
            }
            break;
        }
    }

    public void exibirPacientes(){
        List<ContaPaciente> l = new ImplementacaoContaPaciente().recuperarDadosTodos();
        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================================");
        System.out.println("MENU DE SELEÇÃO");
        for (ContaPaciente contas : l){
            System.out.println(contas.getId_conta() + " - " + contas.getNm_paciente());
        }
        System.out.println("=====================================================");
        System.out.print("Digite o número da conta que deseja exibir os dados: ");
        int idConta = Integer.parseInt(sc.nextLine());
        for (ContaPaciente conta : l){
            if (idConta == conta.getId_conta()){
                while (true) {
                    System.out.println("=====================================================");
                    System.out.println("Qual dado da conta " + idConta + " você deseja editar?");
                    System.out.println("0 - Voltar");
                    System.out.println("1 - Dados pessoais");
                    System.out.println("2 - Dados medicos");
                    System.out.println("3 - Dados de login");
                    System.out.println("=====================================================");
                    System.out.print("Digite: ");
                    try {
                        switch (Integer.parseInt(sc.nextLine())){
                            case 0:
                                break;
                            case 1:
                                System.out.println("Nome: " + conta.getPaciente().getPessoa().getNome());
                                System.out.println("CPF: " + conta.getPaciente().getPessoa().getCpf());
                                System.out.println("RG: " + conta.getPaciente().getPessoa().getRg());
                                System.out.println("Data de Nascimento: " + conta.getPaciente().getPessoa().getDt_nascimento());
                                System.out.println("Sexo: " + conta.getPaciente().getPessoa().getSx_pessoa());
                                System.out.println("Estado Civil: " + conta.getPaciente().getPessoa().getEstado_civil());
                                System.out.println("Escolaridade: " + conta.getPaciente().getPessoa().getEscolaridade());
                                System.out.println("=====================================================");
                                System.out.println("Digite 0 para voltar: ");
                                sc.nextLine();
                                continue;
                            case 2:
                                System.out.println("Histórico Médico: " + conta.getPaciente().getHistoricoMedico());
                                System.out.println("Grupo Sanguineo: " + conta.getPaciente().getGrupoSanguineo());
                                System.out.println("Altura: " + conta.getPaciente().getAltura());
                                System.out.println("Peso: " + conta.getPaciente().getPeso());
                                System.out.println("=====================================================");
                                System.out.println("Digite 0 para voltar: ");
                                sc.nextLine();
                                continue;
                            case 3:
                                System.out.println("Usuário: " + conta.getNm_paciente());
                                System.out.println("Senha: " + conta.getSenha());
                                System.out.println("=====================================================");
                                System.out.println("Digite 0 para voltar: ");
                                sc.nextLine();
                                continue;
                            default:
                                System.out.println("Entrada Inválida");
                                continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada Inválida");
                        continue;
                    }
                    break;
                }
            }
        }
    }
}


