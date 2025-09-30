package org.example.Model.Interacoes;

public class CliquesLogin {
    private int cliquesCadastro;
    private int cliquesAtualizarDados;
    private CliquesManuais Manuais;

    public CliquesLogin(CliquesManuais manuais) {
        Manuais = manuais;
    }

    public CliquesLogin() {
    }

    public int getCliquesCadastro() {
        return cliquesCadastro;
    }

    public void setCliquesCadastro(int cliquesCadastro) {
        this.cliquesCadastro = cliquesCadastro;
    }

    public int getCliquesAtualizarDados() {
        return cliquesAtualizarDados;
    }

    public void setCliquesAtualizarDados(int cliquesAtualizarDados) {
        this.cliquesAtualizarDados = cliquesAtualizarDados;
    }

    public CliquesManuais getManuais() {
        return Manuais;
    }

    public void setManuais(CliquesManuais manuais) {
        Manuais = manuais;
    }
}
