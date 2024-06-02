package repositorio;

import entidades.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteEmTratamento {
    private static List<Paciente> pacientes = new ArrayList<>();

    public static List<Paciente> getPacientes() { return pacientes; }

    public static void listar() {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getId() + " - " + paciente.getNome() + ";");
        }
    }


    public static Paciente buscarPorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }


    public static void adicionar(Paciente paciente) {
        pacientes.add(paciente);
    }

    public static void remover(int id) {
        Paciente pacienteParaRemover = buscarPorId(id);
        if (pacienteParaRemover != null) {
            pacientes.remove(pacienteParaRemover);
        }
    }


    public static void alterar(Paciente pacienteAlterado) {
        Paciente pacienteExistente = buscarPorId(pacienteAlterado.getId());
        if (pacienteExistente != null) {
            pacientes.remove(pacienteExistente);
            pacientes.add(pacienteAlterado);
        }
    }

    public static boolean temPacientes() {
        return !pacientes.isEmpty();
    }

}