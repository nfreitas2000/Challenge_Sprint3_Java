package org.example.Model.Paciente;

import org.example.Model.Pessoa;

import java.util.Scanner;

public class Paciente{
    int id_paciente;
    Pessoa pessoa;
    String historicoMedico;
    String grupoSanguineo;
    double altura;
    double peso;

    public Paciente(Pessoa pessoa, String historicoMedico, String grupoSanguineo, double altura, double peso) {
        this.pessoa = pessoa;
        this.historicoMedico = historicoMedico;
        this.grupoSanguineo = grupoSanguineo;
        this.altura = altura;
        this.peso = peso;
    }

    public Paciente(int id_paciente, Pessoa pessoa, String historicoMedico, String grupoSanguineo, double altura, double peso) {
        this.id_paciente = id_paciente;
        this.pessoa = pessoa;
        this.historicoMedico = historicoMedico;
        this.grupoSanguineo = grupoSanguineo;
        this.altura = altura;
        this.peso = peso;
    }
    

    public Paciente() {
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    /*METODOS */

    public void cadastrarPaciente(Pessoa pessoa) {
        setPessoa(pessoa);
        Scanner sc = new Scanner(System.in);
        String diagnostico;
        while (true) {
            diagnostico = "";
            try {
                System.out.print("Qual a sua altura: ");
                setAltura(Float.parseFloat(sc.nextLine()));
                System.out.print("Qual seu peso: ");
                setPeso(Float.parseFloat(sc.nextLine()));
                System.out.print("Qual o seu tipo sanguineo*: ");
                setGrupoSanguineo(sc.nextLine());
                System.out.print("Possui algum diagnostico médico que deve ser considerado (y/n): ");
                diagnostico = sc.nextLine().strip().toLowerCase();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Tente novamente!");
            }
        }
        if (diagnostico.equals("y")) {
            System.out.print("Descreva o diagnostico: ");
            setHistoricoMedico(sc.nextLine());
        }
    }
}
