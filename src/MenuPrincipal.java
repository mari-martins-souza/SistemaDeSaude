import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Paciente> listaDePacientes = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    PacienteEmTratamento.listar();
                    break;
                case 3:
                    alterarPaciente();
                    break;
                case 4:
                    exibirInfoPaciente();
                    break;
                case 5:
                    registrarAtividadeFisica();
                    break;
                case 6:
                    removerPaciente();
                    break;
                case 7:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 7);
    }

    private static void exibirMenu() {
        System.out.println("------- MENU -------");
        System.out.println("1 - Cadastrar um novo paciente");
        System.out.println("2 - Listar todos os pacientes");
        System.out.println("3 - Alterar informações do paciente");
        System.out.println("4 - Mostrar informações de um paciente");
        System.out.println("5 - Registrar atividade física para um paciente");
        System.out.println("6 - Remover paciente");
        System.out.println("7 - Sair do programa");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarPaciente() {
        System.out.println("------ Cadastro de Paciente ------");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();
        System.out.print("Pressão Arterial: ");
        double pressaoArterial = scanner.nextDouble();
        System.out.print("Frequência Cardíaca: ");
        double frequenciaCardiaca = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Dieta Alimentar: ");
        String dietaAlimentar = scanner.nextLine();
        List<String> atividadesFisicas = new ArrayList<>();
        listaDePacientes.add(new Paciente(nome, idade, peso, altura, pressaoArterial, frequenciaCardiaca, dietaAlimentar, atividadesFisicas));
        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void alterarPaciente() {
        System.out.println("------ Alteração de Paciente ------");
        PacienteEmTratamento.listar();
        System.out.print("Digite o ID do paciente que deseja alterar: ");
        int id = scanner.nextInt();
        if (id >= 0 && id < listaDePacientes.size()) {
            scanner.nextLine(); // Limpar o buffer
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            System.out.print("Nova idade: ");
            int idade = scanner.nextInt();
            System.out.print("Novo peso: ");
            double peso = scanner.nextDouble();
            System.out.print("Nova altura: ");
            double altura = scanner.nextDouble();
            System.out.print("Nova pressão arterial: ");
            double pressaoArterial = scanner.nextDouble();
            System.out.print("Nova frequência cardíaca: ");
            double frequenciaCardiaca = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer
            System.out.print("Nova dieta alimentar: ");
            String dietaAlimentar = scanner.nextLine();
            Paciente novoPaciente = new Paciente(nome, idade, listaDePacientes.get(id).peso, listaDePacientes.get(id).altura,
                    listaDePacientes.get(id).pressaoArterial, listaDePacientes.get(id).frequenciaCardiaca,
                    listaDePacientes.get(id).dietaAlimentar, listaDePacientes.get(id).atividadesFisicas);
            PacienteEmTratamento.alterar(id, novoPaciente);
        } else {
            System.out.println("ID de paciente inválido.");
        }
    }

    private static void exibirInfoPaciente() {
        System.out.println("------ Informações de Paciente ------");
        PacienteEmTratamento.listar();
        System.out.print("Digite o ID do paciente que deseja visualizar: ");
        int id = scanner.nextInt();
        if (id >= 0 && id < listaDePacientes.size()) {
            System.out.println(listaDePacientes.get(id));
        } else {
            System.out.println("ID de paciente inválido.");
        }
    }

    private static void registrarAtividadeFisica() {
        System.out.println("------ Registro de Atividade Física ------");
        PacienteEmTratamento.listar();
        System.out.print("Digite o ID do paciente que realizou a atividade física: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        if (id >= 0 && id < listaDePacientes.size()) {
            System.out.print("Atividade Física realizada: ");
            String atividade = scanner.nextLine();
            listaDePacientes.get(id).registrarAtividadeFisica(atividade);
            System.out.println("Atividade física registrada com sucesso para o paciente " + listaDePacientes.get(id).nome);
        } else {
            System.out.println("ID de paciente inválido.");
        }
    }

    private static void removerPaciente() {
        System.out.println("------ Remoção de Paciente ------");
        PacienteEmTratamento.listar();
        System.out.print("Digite o ID do paciente que deseja remover: ");
        int id = scanner.nextInt();
        if (id >= 0 && id < listaDePacientes.size()) {
            PacienteEmTratamento.remover(id);
        } else {
            System.out.println("ID de paciente inválido.");
        }
    }
}
