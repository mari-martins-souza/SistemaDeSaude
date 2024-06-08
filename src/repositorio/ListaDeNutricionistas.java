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

    public static Nutricionista buscarPorNome(String nome) {
        for (Nutricionista nutricionista : nutricionistas) {
            if (nutricionista.getNome().equals(nome)) {
                return nutricionista;
            }
        }
        return null;
    }
}