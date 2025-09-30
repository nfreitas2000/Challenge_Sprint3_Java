package org.example.Model.Paciente;

import org.example.DAO.ImplementacaoFuncionario;
import org.example.DAO.ImplementacaoTeleatendimento;
import org.example.Model.Funcionario.Funcionario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Teleconsulta {
    private LocalDateTime dateTime = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private int id_teleatendimento;
    private String dt_teleatendimento = dateTime.format(formatter);;
    private String tempo_teleatendimento = "00:15:00";
    private String questao_tratada;
    private Funcionario funcionario;
    private ContaPaciente paciente;

    public Teleconsulta(int id_teleatendimento, String dt_teleatendimento, String tempo_teleatendimento, String questao_tratada, Funcionario funcionario, ContaPaciente paciente) {
        this.id_teleatendimento = id_teleatendimento;
        this.dt_teleatendimento = dt_teleatendimento;
        this.tempo_teleatendimento = tempo_teleatendimento;
        this.questao_tratada = questao_tratada;
        this.funcionario = funcionario;
        this.paciente = paciente;
    }

    public Teleconsulta() {
    }

    public int getId_teleatendimento() {
        return id_teleatendimento;
    }

    public void setId_teleatendimento(int id_teleatendimento) {
        this.id_teleatendimento = id_teleatendimento;
    }

    public String getDt_teleatendimento() {
        return dt_teleatendimento;
    }

    public void setDt_teleatendimento(String dt_teleatendimento) {
        this.dt_teleatendimento = dt_teleatendimento;
    }

    public String getTempo_teleatendimento() {
        return tempo_teleatendimento;
    }

    public void setTempo_teleatendimento(String tempo_teleatendimento) {
        this.tempo_teleatendimento = tempo_teleatendimento;
    }

    public String getQuestao_tratada() {
        return questao_tratada;
    }

    public void setQuestao_tratada(String questao_tratada) {
        this.questao_tratada = questao_tratada;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ContaPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(ContaPaciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public void cadastrarTeleatendimento(ContaPaciente o){
        setPaciente(o);
        ImplementacaoTeleatendimento teleatendimentoCRUD = new ImplementacaoTeleatendimento();
        List<Funcionario> f = new ImplementacaoFuncionario().recuperarDadosTodos();
        Scanner sc = new Scanner(System.in);

        while (true){

            System.out.println("=====================================================");
            System.out.println("Qual será a área médica tratada:");
            System.out.println("1 - Reabilitação motora");
            System.out.println("2 - Reabilitação visual");
            System.out.println("3 - Reabilitação psicologica");
            System.out.println("4 - Reabilitação auditiva");
            System.out.println("=====================================================");
            System.out.print("Digite: ");
            try {
                switch (Integer.parseInt(sc.nextLine())){
                    case 1:
                        setQuestao_tratada("Reabilitação motora");
                        break;
                    case 2:
                        setQuestao_tratada("Reabilitação visual");
                        break;
                    case 3:
                        setQuestao_tratada("Reabilitação psicologica");
                        break;
                    case 4:
                        setQuestao_tratada("Reabilitação auditiva");
                        break;
                }
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida!");
                continue;
            }
            break;
        }
        while (true){
            System.out.println("=====================================================");
            System.out.println("MENU DE PROFISSIONAIS");
            for (Funcionario funcionario : f){
                System.out.println(funcionario.getId_funcionario() + " - " + funcionario.getPessoa().getNome());
            }
            System.out.println("=====================================================");
            System.out.print("Digite o número de quem irá te atender: ");
            try {
                int idConta = Integer.parseInt(sc.nextLine());
                for (Funcionario funcionario1 : f){
                    if (idConta == funcionario1.getId_funcionario()){
                        setFuncionario(funcionario1);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida");
                continue;
            }
            break;
        }

        teleatendimentoCRUD.inserirDados(this);
    }

    public void exibirTeleconsultas(ContaPaciente o){
        List<Teleconsulta> l = new ImplementacaoTeleatendimento().recuperarDadosTodos();
        Scanner sc = new Scanner(System.in);

        for (Teleconsulta teleconsulta : l){
            if (teleconsulta.getPaciente().getId_conta() == o.getId_conta()){
                System.out.println("Paciente: " + o.getNm_paciente());
                System.out.println("Data: " + teleconsulta.getDt_teleatendimento());
                System.out.println("Questão: " + teleconsulta.getQuestao_tratada());
                System.out.println("Profissional: " + teleconsulta.getFuncionario().getPessoa().getNome());
                System.out.println("=====================================================");
            }
        }
        System.out.println("Digite 0 para voltar: ");
        sc.nextLine();
    }
}
