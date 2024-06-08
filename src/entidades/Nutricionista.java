package entidades;

import java.util.List;

public class Nutricionista extends Funcionario {
    private List<String> certificacoes;
    private int numeroDeConsultas;
    private int tempoDeExperiencia;

    public Nutricionista() {
    }

    public Nutricionista(String nome, int idade, Endereco endereco, double salario, List<String> certificacoes, int numeroDeConsultas, int tempoDeExperiencia) {
        super(nome, idade, endereco, salario);
        this.certificacoes = certificacoes;
        this.numeroDeConsultas = numeroDeConsultas;
        this.tempoDeExperiencia = tempoDeExperiencia;
    }

    public List<String> getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(List<String> certificacoes) {
        this.certificacoes = certificacoes;
    }

    public int getNumeroDeConsultas() {
        return numeroDeConsultas;
    }

    public void setNumeroDeConsultas(int numeroDeConsultas) {
        this.numeroDeConsultas = numeroDeConsultas;
    }

    public int getTempoDeExperiencia() {
        return tempoDeExperiencia;
    }

    public void setTempoDeExperiencia(int tempoDeExperiencia) {
        this.tempoDeExperiencia = tempoDeExperiencia;
    }

}
