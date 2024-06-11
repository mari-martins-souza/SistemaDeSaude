package repositorio;

import entidades.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ListaDeFuncionarios {
    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static List<Funcionario> listar() {
        return funcionarios;
    }

    public static void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public static Funcionario buscarPorId(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public static void remover(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

}
