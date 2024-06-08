package repositorio;

import entidades.Consulta;
import entidades.Nutricionista;

import java.util.ArrayList;
import java.util.List;

public class ListaDeConsultas {
    private static List<Consulta> consultas = new ArrayList<>();

    public static List<Consulta> listar() {
        return consultas;
    }

    public static Consulta buscarPorId(int id) {
        if (id >= 0 && id < consultas.size()) {
            return consultas.get(id);
        } else {
            return null;
        }
    }

    public static void adicionar(Consulta consulta) {
        consultas.add(consulta);
        Nutricionista nutricionista = ListaDeNutricionistas.buscarPorNome(consulta.getNomeNutricionista());
        if (nutricionista != null) {
            nutricionista.incrementarNumeroDeConsultas();
        }
    }

    public static void remover(int id) {
        if (id >= 0 && id < consultas.size()) {
            consultas.remove(id);
        }
    }

    public static void alterar(int id, Consulta novaConsulta) {
        if (id >= 0 && id < consultas.size()) {
            consultas.set(id, novaConsulta);
        }
    }

}
