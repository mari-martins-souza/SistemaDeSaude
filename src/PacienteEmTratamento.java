import java.util.ArrayList;
import java.util.List;

public class PacienteEmTratamento {
    public static List<Paciente> listaDePacientes = new ArrayList<>();

    public static void listar() {
        for (int i = 0; i < listaDePacientes.size(); i++) {
            System.out.println("ID: " + i + " - " + listaDePacientes.get(i));
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

    public static void alterar(int id, Paciente novoPaciente) {
        if (id >= 0 && id < listaDePacientes.size()) {
            listaDePacientes.set(id, novoPaciente);
            System.out.println("Paciente alterado com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
