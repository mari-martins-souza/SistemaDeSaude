package entidades;

import java.util.List;

public class Nutricionista extends Funcionario {
    private List<String> certificacoes;
    private static int nextId = 1;
    private int id;
    private int numeroDeConsultas;
    private int tempoDeExperiencia;

    public Nutricionista() {
        this.id = nextId++;
    }

    public Nutricionista(String nome, int idade, Endereco endereco, double salario, List<String> certificacoes, int numeroDeConsultas, int tempoDeExperiencia) {
        super(nome, idade, endereco, salario);
        this.certificacoes = certificacoes;
        this.numeroDeConsultas = numeroDeConsultas;
        this.tempoDeExperiencia = tempoDeExperiencia;
        this.id = nextId++;
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

    public void adicionarAnoExperiencia() {
        this.tempoDeExperiencia += 1;
    }

    public void adicionarCertificacao(String certificacao) {
        this.certificacoes.add(certificacao);
    }

    public void incrementarNumeroDeConsultas() {
        this.numeroDeConsultas += 1;
    }

}
