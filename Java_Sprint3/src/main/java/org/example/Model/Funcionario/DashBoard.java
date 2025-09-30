package org.example.Model.Funcionario;

import org.example.DAO.ImplementacaoCliquesPrincipais;
import org.example.Model.Interacoes.CliquesPrincipais;

import java.util.List;
import java.util.Scanner;

public class DashBoard {


    public DashBoard() {}

    public void exibirDados(){
        List<CliquesPrincipais> dados = new ImplementacaoCliquesPrincipais().recuperarDadosTodos();
        Scanner sc = new Scanner(System.in);

        int cliquesLogin = 0;
        int cliquesConsultas = 0;
        int cliquesAgendamentos = 0;
        int cliquesManuais = 0;
        int cliquesOutros = 0;

        int cliquesCadastro = 0;
        int cliquesAtualizarDados = 0;

        int cliquesPortalPaciente = 0;
        int cliquesGuiaTeleconsulta = 0;
        int cliquesPrivacidade = 0;

        for (CliquesPrincipais cliques : dados){
            cliquesLogin += cliques.getCliquesLogin();
            cliquesAgendamentos += cliques.getCliquesAgendamentos();
            cliquesConsultas += cliques.getCliquesConsultas();
            cliquesManuais += cliques.getCliquesManuais();
            cliquesOutros += cliques.getCliquesOutros();

            cliquesCadastro += cliques.getLogin().getCliquesCadastro();
            cliquesAtualizarDados += cliques.getLogin().getCliquesAtualizarDados();

            cliquesPortalPaciente += cliques.getLogin().getManuais().getCliquesPortalPaciente();
            cliquesGuiaTeleconsulta += cliques.getLogin().getManuais().getCliquesGuiaTeleconsulta();
            cliquesPrivacidade += cliques.getLogin().getManuais().getCliquesPrivacidade();
        }

        while (true) {
            System.out.println("=====================================================");
            System.out.println("DashTECH");
            System.out.println("0 - Voltar");
            System.out.println("1 - Interações principais");
            System.out.println("2 - Interações de login");
            System.out.println("3 - Interações com manuais");
            System.out.println("=====================================================");
            System.out.print("Digite: ");
            try {
                switch (Integer.parseInt(sc.next())) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("=====================================================");
                        System.out.println("Cliques totais em login: " + cliquesLogin);
                        System.out.println("Cliques totais em consultas: "  + cliquesConsultas);
                        System.out.println("Cliques totais em agendamentos: " + cliquesAgendamentos) ;
                        System.out.println("Cliques totais em manuais: " + cliquesManuais);
                        System.out.println("Cliques totais em outros: " + cliquesOutros);
                        System.out.println("=====================================================");
                        continue;
                    case 2:
                        System.out.println("=====================================================");
                        System.out.println("Cliques totais em cadastro: " + cliquesCadastro);
                        System.out.println("Cliques totais em atualizar dados: "  + cliquesAtualizarDados);
                        System.out.println("=====================================================");
                        continue;
                    case 3:
                        System.out.println("=====================================================");
                        System.out.println("Cliques totais em manual do portal: " + cliquesPortalPaciente);
                        System.out.println("Cliques totais em manual de teleconsultas: "  + cliquesGuiaTeleconsulta);
                        System.out.println("Cliques totais em guia de privacidade: " + cliquesPrivacidade) ;
                        System.out.println("=====================================================");
                        continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida!");
                continue;
            }
            break;
        }
    }
}
