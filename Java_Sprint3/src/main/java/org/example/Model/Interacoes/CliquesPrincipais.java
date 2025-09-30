package org.example.Model.Interacoes;

import org.example.Model.Paciente.Sessao;

public class CliquesPrincipais {
    private int cliquesLogin = 0;
    private int cliquesConsultas = 0;
    private int cliquesAgendamentos = 0;
    private int cliquesManuais = 0;
    private int cliquesOutros = 0;
    private CliquesLogin login;
    private Sessao sessao;

    public CliquesPrincipais() {
    }

    public CliquesPrincipais(Sessao sessao, CliquesLogin login) {
        this.sessao = sessao;
        this.login = login;
    }

    public int getCliquesLogin() {
        return cliquesLogin;
    }

    public void setCliquesLogin(int cliquesLogin) {
        this.cliquesLogin = cliquesLogin;
    }

    public int getCliquesConsultas() {
        return cliquesConsultas;
    }

    public void setCliquesConsultas(int cliquesConsultas) {
        this.cliquesConsultas = cliquesConsultas;
    }

    public int getCliquesAgendamentos() {
        return cliquesAgendamentos;
    }

    public void setCliquesAgendamentos(int cliquesAgendamentos) {
        this.cliquesAgendamentos = cliquesAgendamentos;
    }

    public int getCliquesManuais() {
        return cliquesManuais;
    }

    public void setCliquesManuais(int cliquesManuais) {
        this.cliquesManuais = cliquesManuais;
    }

    public int getCliquesOutros() {
        return cliquesOutros;
    }

    public void setCliquesOutros(int cliquesOutros) {
        this.cliquesOutros = cliquesOutros;
    }

    public CliquesLogin getLogin() {
        return login;
    }

    public void setLogin(CliquesLogin login) {
        this.login = login;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
}
