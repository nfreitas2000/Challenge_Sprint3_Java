package org.example.Model;

import org.example.DAO.ImplementacaoPessoa;

import java.util.Scanner;

public class Pessoa {
    private int id_pessoa;
    private String nome;
    private String cpf;
    private String rg;
    private String dt_nascimento;
    private String sx_pessoa;
    private String estado_civil;
    private String escolaridade;

    /*CONSTRUTORES ============================================================*/

    public Pessoa(String nome, String cpf, String rg, String dt_nascimento, String sx_pessoa, String estado_civil, String escolaridade) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dt_nascimento = dt_nascimento;
        this.sx_pessoa = sx_pessoa;
        this.estado_civil = estado_civil;
        this.escolaridade = escolaridade;
    }

    public Pessoa(int id_pessoa, String nome, String cpf, String rg, String dt_nascimento, String sx_pessoa, String estado_civil, String escolaridade) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dt_nascimento = dt_nascimento;
        this.sx_pessoa = sx_pessoa;
        this.estado_civil = estado_civil;
        this.escolaridade = escolaridade;
    }

    public Pessoa() {
    }

    /*GETTERS AND SETTERS ============================================================*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getSx_pessoa() {
        return sx_pessoa;
    }

    public void setSx_pessoa(String sx_pessoa) {
        this.sx_pessoa = sx_pessoa;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    /*METODOS ============================================================*/

    public void cadastrarPessoa(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Digite seu nome: ");
            String entradaNome = sc.nextLine();
            if (entradaNome.isEmpty()){
                System.out.println("Insira um nome!");
                continue;
            }
            setNome(entradaNome);
            break;
        }
        while (true) {
            System.out.println("Digite seu cpf (somente números): ");
            String entradacpf = sc.nextLine();
            if (entradacpf.length() == 11) {
                entradacpf = entradacpf.substring(0, 3) + "." + entradacpf.substring(3, 6) + "." + entradacpf.substring(6, 9) + "-" + entradacpf.substring(9);
                setCpf(entradacpf);
            } else {
                System.out.println("O CPF deve ter 11 digitos!");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println("Digite seu rg (somenente números): ");
            String entradaRg = sc.nextLine();
            if (entradaRg.length() == 9){
                entradaRg = entradaRg.substring(0, 2) + "." + entradaRg.substring(2, 5) + "." + entradaRg.substring(5, 8) + "-" + entradaRg.substring(8);
                setRg(entradaRg);
            } else {
                System.out.println("O RG deve ter 9 digitos!");
                continue;
            }
            break;
        }
        System.out.println("Digite sua data de nascimento (DD/MM/YYYY): ");
        setDt_nascimento(sc.nextLine());
        while (true) {
            System.out.println("Selecione seu sexo: ");
            System.out.println("1 - Masculino");
            System.out.println("2 - Feminino");
            System.out.println("3 - Indefinido");
            System.out.print("Digite: ");
            try {
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1:
                        setSx_pessoa("M");
                        break;
                    case 2:
                        setSx_pessoa("F");
                        break;
                    case 3:
                        setSx_pessoa("I");
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
        while (true) {
            System.out.println("Selecione seu estado civil: ");
            System.out.println("1 - Solteiro(a)");
            System.out.println("2 - Casado(a)");
            System.out.println("3 - Divorciado(a)");
            System.out.println("4 - Viúvo(a)");
            System.out.print("Digite: ");
            try {
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1:
                        setEstado_civil("solteiro");
                        break;
                    case 2:
                        setEstado_civil("casado");
                        break;
                    case 3:
                        setEstado_civil("divorciado");
                        break;
                    case 4:
                        setEstado_civil("viúvo");
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
                        setEscolaridade("Ensino Fundamental Incompleto");
                        break;
                    case 2:
                        setEscolaridade("Ensino Fundamental Cursando");
                        break;
                    case 3:
                        setEscolaridade("Ensino Fundamental Concluído");
                        break;
                    case 4:
                        setEscolaridade("Ensino Médio Incompleto");
                        break;
                    case 5:
                        setEscolaridade("Ensino Médio Cursando");
                        break;
                    case 6:
                        setEscolaridade("Ensino Médio Concluído");
                        break;
                    case 7:
                        setEscolaridade("Ensino Superior Incompleto");
                        break;
                    case 8:
                        setEscolaridade("Ensino Superior Cursando");
                        break;
                    case 9:
                        setEscolaridade("Ensino Superior Concluído");
                        break;
                    case 10:
                        setEscolaridade("Pós-Graduação Incompleto");
                        break;
                    case 11:
                        setEscolaridade("Pós-Graduação Cursando");
                        break;
                    case 12:
                        setEscolaridade("Pós-Graduação Concluído");
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

    }
}
