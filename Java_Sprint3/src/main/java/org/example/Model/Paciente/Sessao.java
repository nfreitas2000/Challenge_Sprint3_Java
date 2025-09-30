package org.example.Model.Paciente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sessao {
    private LocalDateTime dateTime = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private int id_sessao;
    private String status = "L";
    private String dt_inicio = dateTime.format(formatter);
    private String tempo = "00:15:02";
    private ContaPaciente contaPaciente;

    public Sessao(int id_sessao, String status, String dt_inicio, ContaPaciente contaPaciente) {
        this.id_sessao = id_sessao;
        this.status = status;
        this.dt_inicio = dt_inicio;
        this.contaPaciente = contaPaciente;
    }

    public Sessao(ContaPaciente contaPaciente) {
        this.contaPaciente = contaPaciente;
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

    public int getId_sessao() {
        return id_sessao;
    }

    public void setId_sessao(int id_sessao) {
        this.id_sessao = id_sessao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(String dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public ContaPaciente getContaPaciente() {
        return contaPaciente;
    }

    public void setContaPaciente(ContaPaciente contaPaciente) {
        this.contaPaciente = contaPaciente;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }
}
