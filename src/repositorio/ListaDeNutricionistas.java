package repositorio;

import entidades.Nutricionista;

import java.util.ArrayList;
import java.util.List;

public class ListaDeNutricionistas {
    private static List<Nutricionista> nutricionistas = new ArrayList<>();

    public static List<Nutricionista> listar() {
        return nutricionistas;
    }

    public static void adicionar(Nutricionista nutricionista) {
        nutricionistas.add(nutricionista);
    }

    public static Nutricionista buscarPorId(int id) {
        for (Nutricionista nutricionista : nutricionistas) {
            if (nutricionista.getId() == id) {
                return nutricionista;
            }
        }
        return null;
    }

    public static void remover(Nutricionista nutricionista) {
        nutricionistas.remove(nutricionista);
    }

}