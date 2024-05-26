import java.util.ArrayList;
import java.util.List;

public class PacienteEmTratamento {
    public static List<Paciente> listaDePacientes = new ArrayList<>();

    public static void listar() {
        System.out.println("Lista de Pacientes:");
        for (int i = 0; i < listaDePacientes.size(); i++) {
            System.out.println((i + 1) + " - " + listaDePacientes.get(i).nome + ";");
        }
    }

    public static Paciente buscarPorId(int id) {
        if (id >= 0 && id < listaDePacientes.size()) {
            return listaDePacientes.get(id);
        } else {
            System.out.println("Paciente não encontrado.");
            return null;
        }
    }

    public static void adicionar(Paciente paciente) {
        listaDePacientes.add(paciente);
        System.out.println("Paciente adicionado com sucesso.");
    }

    public static void remover(int id) {
        if (id >= 0 && id < listaDePacientes.size()) {
            listaDePacientes.remove(id);
            System.out.println("Paciente removido com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public static void alterar(int id, double novoPeso, double novaAltura, double novaPressaoArterial, double novaFrequenciaCardiaca, String novaDietaAlimentar) {
        if (id >= 0 && id < listaDePacientes.size()) {
            Paciente paciente = listaDePacientes.get(id);
            paciente.peso = novoPeso;
            paciente.altura = novaAltura;
            paciente.pressaoArterial = novaPressaoArterial;
            paciente.frequenciaCardiaca = novaFrequenciaCardiaca;
            paciente.dietaAlimentar = novaDietaAlimentar;
            System.out.println("Informações do paciente alteradas com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

}
