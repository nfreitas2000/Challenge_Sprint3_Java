package org.example.Model.Interacoes;

public class CliquesManuais {
    private int idCliquesManuais;
    private int CliquesPortalPaciente;
    private int CliquesGuiaTeleconsulta;
    private int CliquesPrivacidade;

    public CliquesManuais() {
    }

    public CliquesManuais(int idCliquesManuais, int cliquesPortalPaciente, int cliquesGuiaTeleconsulta, int cliquesPrivacidade) {
        this.idCliquesManuais = idCliquesManuais;
        CliquesPortalPaciente = cliquesPortalPaciente;
        CliquesGuiaTeleconsulta = cliquesGuiaTeleconsulta;
        CliquesPrivacidade = cliquesPrivacidade;
    }

    public int getCliquesPortalPaciente() {
        return CliquesPortalPaciente;
    }

    public void setCliquesPortalPaciente(int cliquesPortalPaciente) {
        CliquesPortalPaciente = cliquesPortalPaciente;
    }

    public int getCliquesGuiaTeleconsulta() {
        return CliquesGuiaTeleconsulta;
    }

    public void setCliquesGuiaTeleconsulta(int cliquesGuiaTeleconsulta) {
        CliquesGuiaTeleconsulta = cliquesGuiaTeleconsulta;
    }

    public int getCliquesPrivacidade() {
        return CliquesPrivacidade;
    }

    public void setCliquesPrivacidade(int cliquesPrivacidade) {
        CliquesPrivacidade = cliquesPrivacidade;
    }

    public int getIdCliquesManuais() {
        return idCliquesManuais;
    }

    public void setIdCliquesManuais(int idCliquesManuais) {
        this.idCliquesManuais = idCliquesManuais;
    }
}
