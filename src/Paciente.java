import java.util.List;

public class Paciente {
    private static int proximoId = 1;
    public String nome;
    public int id;
    public int idade;
    public double peso;
    public double altura;
    public double pressaoArterial;
    public double frequenciaCardiaca;
    public String dietaAlimentar;
    public List<String> atividadesFisicas;

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

    @Override
    public String toString() {
        return "Paciente{" +
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

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public String monitorarPaciente() {
        return "Paciente{" +
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

    public void registrarAtividadeFisica(String atividade) {
        atividadesFisicas.add(atividade);
    }
}
