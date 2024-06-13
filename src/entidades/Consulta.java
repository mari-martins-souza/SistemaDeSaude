package entidades;

import java.time.LocalDateTime;

public class Consulta {
    private static int proximoId = 1;
    private int id;
    private String nomeNutricionista;
    private String nomePaciente;
    private LocalDateTime dataHora;
    private boolean consultaRealizada;

    public Consulta(String nomeNutricionista, String nomePaciente, LocalDateTime dataHora) {
        this.id = proximoId++;
        this.nomeNutricionista = nomeNutricionista;
        this.nomePaciente = nomePaciente;
        this.dataHora = dataHora;
        this.consultaRealizada = false;
    }

    public int getId() {
        return id;
    }

    public String getNomeNutricionista() {
        return nomeNutricionista;
    }

    public void setNomeNutricionista(String nomeNutricionista) {
        this.nomeNutricionista = nomeNutricionista;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }

}
