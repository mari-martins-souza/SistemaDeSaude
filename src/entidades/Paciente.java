package entidades;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private static int proximoId = 1;
    private String nome;
    private int id;
    private int idade;
    private double peso;
    private double altura;
    private double pressaoArterial;
    private double frequenciaCardiaca;
    private String dietaAlimentar;
    private List<String> atividadesFisicas;

    public Paciente(String nome, int idade, double peso, double altura,
                    double pressaoArterial, double frequenciaCardiaca,
                    String dietaAlimentar, List<String> atividadesFisicas) {
        this.id = proximoId++;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.pressaoArterial = pressaoArterial;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.dietaAlimentar = dietaAlimentar;
        this.atividadesFisicas = atividadesFisicas;
    }

    public Paciente() {
        this.id = proximoId++;
        this.nome = "";
        this.idade = 0;
        this.peso = 0.0;
        this.altura = 0.0;
        this.pressaoArterial = 0.0;
        this.frequenciaCardiaca = 0.0;
        this.dietaAlimentar = "";
        this.atividadesFisicas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "entidades.Paciente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", altura=" + altura +
                ", pressaoArterial=" + pressaoArterial +
                ", frequenciaCardiaca=" + frequenciaCardiaca +
                ", dietaAlimentar='" + dietaAlimentar + '\'' +
                ", atividadesFisicas=" + atividadesFisicas +
                '}';
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public int getIdade() { return idade; }
    public double getPeso() { return peso; }
    public double getAltura() { return altura; }
    public double getPressaoArterial() { return pressaoArterial; }
    public double getFrequenciaCardiaca() { return frequenciaCardiaca; }
    public String getDietaAlimentar() { return dietaAlimentar; }

    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setPeso(double peso) { this.peso = peso; }
    public void setAltura(double altura) { this.altura = altura; }
    public void setPressaoArterial(double pressaoArterial) { this.pressaoArterial = pressaoArterial; }
    public void setFrequenciaCardiaca(double frequenciaCardiaca) { this.frequenciaCardiaca = frequenciaCardiaca; }
    public void setDietaAlimentar(String dietaAlimentar) { this.dietaAlimentar = dietaAlimentar; }


    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public String monitorarPaciente() {
        return "entidades.Paciente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", altura=" + altura +
                ", pressaoArterial=" + pressaoArterial +
                ", frequenciaCardiaca=" + frequenciaCardiaca +
                ", dietaAlimentar='" + dietaAlimentar + '\'' +
                ", atividadesFisicas=" + atividadesFisicas +
                ", IMC=" + calcularIMC() +
                '}';
    }

    public List<String> getAtividadesFisicas() { return atividadesFisicas; }

    public void registrarAtividadeFisica(String atividade) {
        atividadesFisicas.add(atividade);
    }

}
