import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar um novo paciente");
            System.out.println("2 - Listar todos os pacientes");
            System.out.println("3 - Alterar informações do paciente");
            System.out.println("4 - Mostrar informações de um paciente");
            System.out.println("5 - Registrar atividade física para um paciente");
            System.out.println("6 - Remover paciente");
            System.out.println("7 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    alterarPaciente();
                    break;
                case 4:
                    mostrarPaciente();
                    break;
                case 5:
                    registrarAtividade();
                    break;
                case 6:
                    removerPaciente();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarPaciente() {
        System.out.println("Digite o nome do paciente:");
        String nome = scanner.nextLine();

        System.out.println("Digite a idade do paciente:");
        int idade = scanner.nextInt();

        System.out.println("Digite o peso do paciente:");
        double peso = scanner.nextDouble();

        System.out.println("Digite a altura do paciente:");
        double altura = scanner.nextDouble();

        System.out.println("Digite a pressão arterial do paciente:");
        double pressaoArterial = scanner.nextDouble();

        System.out.println("Digite a frequência cardíaca do paciente:");
        double frequenciaCardiaca = scanner.nextDouble();

        scanner.nextLine();  // consome a linha restante

        System.out.println("Digite a dieta alimentar do paciente:");
        String dietaAlimentar = scanner.nextLine();

        System.out.println("Digite as atividades físicas do paciente (separadas por vírgula):");
        String atividadesFisicasString = scanner.nextLine();
        List<String> atividadesFisicas = Arrays.asList(atividadesFisicasString.split(","));

        Paciente novoPaciente = new Paciente(nome, idade, peso, altura, pressaoArterial, frequenciaCardiaca, dietaAlimentar, atividadesFisicas);
        PacienteEmTratamento.adicionar(novoPaciente);
    }

    private static void listarPacientes() {
        PacienteEmTratamento.listar();
    }

    private static void alterarPaciente() {
        System.out.println("Digite o ID do paciente que deseja alterar:");
        int id = scanner.nextInt();
        Paciente pacienteExistente = PacienteEmTratamento.buscarPorId(id);

        if (pacienteExistente != null) {
            System.out.println("Digite o novo peso do paciente:");
            pacienteExistente.peso = scanner.nextDouble();

            System.out.println("Digite a nova altura do paciente:");
            pacienteExistente.altura = scanner.nextDouble();

            System.out.println("Digite a nova pressão arterial do paciente:");
            pacienteExistente.pressaoArterial = scanner.nextDouble();

            System.out.println("Digite a nova frequência cardíaca do paciente:");
            pacienteExistente.frequenciaCardiaca = scanner.nextDouble();

            scanner.nextLine();  // consome a linha restante

            System.out.println("Digite a nova dieta alimentar do paciente:");
            pacienteExistente.dietaAlimentar = scanner.nextLine();
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }




    private static void mostrarPaciente() {
        System.out.println("Digite o ID do paciente que deseja visualizar:");
        int id = scanner.nextInt();
        Paciente paciente = PacienteEmTratamento.buscarPorId(id);

        if (paciente != null) {
            System.out.println(paciente.monitorarPaciente());
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void registrarAtividade() {
        System.out.println("Digite o ID do paciente que deseja registrar uma atividade física:");
        int id = scanner.nextInt();
        scanner.nextLine();  // consome a linha restante

        System.out.println("Digite a atividade física:");
        String atividade = scanner.nextLine();

        Paciente paciente = PacienteEmTratamento.buscarPorId(id);
        if (paciente != null) {
            paciente.registrarAtividadeFisica(atividade);
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void removerPaciente() {
        System.out.println("Digite o ID do paciente que deseja remover:");
        int id = scanner.nextInt();
        PacienteEmTratamento.remover(id);
    }


}