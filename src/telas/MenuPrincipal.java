package telas;

import entidades.Nutricionista;
import entidades.Paciente;
import repositorio.ListaDeConsultas;
import repositorio.ListaDeFuncionarios;
import repositorio.ListaDePacientes;
import entidades.Funcionario;
import entidades.Endereco;
import entidades.Consulta;
import repositorio.ListaDeNutricionistas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

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
            System.out.println("7 - Cadastrar um novo funcionário");
            System.out.println("8 - Cadastrar um novo nutricionista");
            System.out.println("9 - Listar todos os funcionários");
            System.out.println("10 - Criar nova consulta");
            System.out.println("11 - Listar todas as consultas");
            System.out.println("12 - Realizar consulta");
            System.out.println("13 - Sair");

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
                    cadastrarFuncionario();
                    break;
                case 8:
                    cadastrarNutricionista();
                    break;
                case 9:
                    listarFuncionarios();
                    break;
                case 10:
                    criarConsulta();
                    break;
                case 11:
                    listarConsultas();
                    break;
                case 12:
                    realizarConsulta();
                    break;
                case 13:
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

        scanner.nextLine();

        System.out.println("Digite a dieta alimentar do paciente:");
        String dietaAlimentar = scanner.nextLine();

        System.out.println("Digite as atividades físicas do paciente (separadas por vírgula):");
        String atividadesFisicasString = scanner.nextLine();
        List<String> atividadesFisicas = new ArrayList<>(Arrays.asList(atividadesFisicasString.split(",")));

        Paciente novoPaciente = new Paciente(nome, idade, peso, altura, pressaoArterial, frequenciaCardiaca, dietaAlimentar, atividadesFisicas);
        ListaDePacientes.adicionar(novoPaciente);
    }

    private static void listarPacientes() {
        if (ListaDePacientes.temPacientes()) {
            ListaDePacientes.listar();
        } else {
            System.out.println("Não há pacientes cadastrados.");
        }
    }

    private static void alterarPaciente() {
        System.out.println("Digite o ID do paciente que deseja alterar:");
        int id = scanner.nextInt();
        Paciente pacienteExistente = ListaDePacientes.buscarPorId(id);

        if (pacienteExistente != null) {
            System.out.println("Digite o novo peso do paciente:");
            double novoPeso = scanner.nextDouble();
            pacienteExistente.setPeso(novoPeso);

            System.out.println("Digite a nova altura do paciente:");
            double novaAltura = scanner.nextDouble();
            pacienteExistente.setAltura(novaAltura);

            System.out.println("Digite a nova pressão arterial do paciente:");
            double novaPressaoArterial = scanner.nextDouble();
            pacienteExistente.setPressaoArterial(novaPressaoArterial);

            System.out.println("Digite a nova frequência cardíaca do paciente:");
            double novaFrequenciaCardiaca = scanner.nextDouble();
            pacienteExistente.setFrequenciaCardiaca(novaFrequenciaCardiaca);

            scanner.nextLine();

            System.out.println("Digite a nova dieta alimentar do paciente:");
            String novaDietaAlimentar = scanner.nextLine();
            pacienteExistente.setDietaAlimentar(novaDietaAlimentar);

        } else {
            System.out.println("entidades.Paciente não encontrado.");
        }
    }


    private static void mostrarPaciente() {
        System.out.println("Digite o ID do paciente que deseja visualizar:");
        int id = scanner.nextInt();
        Paciente paciente = ListaDePacientes.buscarPorId(id);

        if (paciente != null) {
            System.out.println(paciente.monitorarPaciente());
        } else {
            System.out.println("entidades.Paciente não encontrado.");
        }
    }

    private static void registrarAtividade() {
        System.out.println("Digite o ID do paciente que deseja registrar uma atividade física:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a atividade física:");
        String atividade = scanner.nextLine();

        Paciente paciente = ListaDePacientes.buscarPorId(id);
        if (paciente != null) {
            paciente.registrarAtividadeFisica(atividade);
        } else {
            System.out.println("entidades.Paciente não encontrado.");
        }
    }

    private static void removerPaciente() {
        System.out.println("Digite o ID do paciente que deseja remover:");
        int id = scanner.nextInt();
        ListaDePacientes.remover(id);
        System.out.println("entidades.Paciente removido com sucesso");
    }

    private static void cadastrarFuncionario() {
        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.nextLine();

        System.out.println("Digite a idade do funcionário:");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o cep do endereço do funcionário:");
        String cep = scanner.nextLine();

        System.out.println("Digite o logradouro do endereço do funcionário:");
        String logradouro = scanner.nextLine();

        System.out.println("Digite o numero do endereço do funcionário:");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a cidade do endereço do funcionário:");
        String cidade = scanner.nextLine();

        System.out.println("Digite o estado do endereço do funcionário:");
        String estado = scanner.nextLine();

        System.out.println("Digite o salário do funcionário:");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        Endereco endereco = new Endereco(logradouro, estado, cidade, numero, cep);

        Funcionario funcionario = new Funcionario(nome, idade, endereco, salario);

        ListaDeFuncionarios.adicionar(funcionario);
    }

    private static void cadastrarNutricionista() {
        System.out.println("Digite o nome do nutricionista:");
        String nome = scanner.nextLine();

        System.out.println("Digite a idade do nutricionista:");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o cep do endereço do nutricionista:");
        String cep = scanner.nextLine();

        System.out.println("Digite o logradouro do endereço do nutricionista:");
        String logradouro = scanner.nextLine();

        System.out.println("Digite o numero do endereço do nutricionista:");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a cidade do endereço do nutricionista:");
        String cidade = scanner.nextLine();

        System.out.println("Digite o estado do endereço do nutricionista:");
        String estado = scanner.nextLine();

        System.out.println("Digite o salário do nutricionista:");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite o tempo de experiência do nutricionista:");
        int tempoDeExperiencia = scanner.nextInt();
        scanner.nextLine();

        List<String> certificacoes = new ArrayList<>();
        String continuar = "S";
        while (continuar.equalsIgnoreCase("S")) {
            System.out.println("Digite uma certificação do nutricionista:");
            String certificacao = scanner.nextLine();
            certificacoes.add(certificacao);

            System.out.println("O nutricionista possui mais certificações? (S/N)");
            continuar = scanner.nextLine();
        }

        Endereco endereco = new Endereco(logradouro, estado, cidade, numero, cep);

        Nutricionista nutricionista = new Nutricionista(nome, idade, endereco, salario, certificacoes, 0, tempoDeExperiencia);

        ListaDeNutricionistas.adicionar(nutricionista);
    }

    private static void criarConsulta() {
        System.out.println("Digite a data da consulta (formato dd/MM/yyyy):");
        String data = scanner.nextLine();

        System.out.println("Digite a hora da consulta (formato HH:mm):");
        String hora = scanner.nextLine();

        String dataHoraStr = data + "T" + hora;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, formatter);

        System.out.println("Digite o nome do paciente:");
        String nomePaciente = scanner.nextLine();

        System.out.println("Digite o nome do nutricionista:");
        String nomeNutricionista = scanner.nextLine();

        Paciente paciente = null;
        for (Paciente p : ListaDePacientes.getPacientes()) {
            if (p.getNome().equals(nomePaciente)) {
                paciente = p;
                break;
            }
        }

        Nutricionista nutricionista = null;
        for (Nutricionista n : ListaDeNutricionistas.listar()) {
            if (n.getNome().equals(nomeNutricionista)) {
                nutricionista = n;
                break;
            }
        }

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        if (nutricionista == null) {
            System.out.println("Nutricionista não encontrado.");
            return;
        }

        Consulta consulta = new Consulta(nutricionista.getNome(), paciente.getNome(), dataHora);
        System.out.println("Consulta criada com sucesso!");

        ListaDeConsultas.adicionar(consulta);
    }

    private static void listarFuncionarios() {
        List<Funcionario> funcionarios = ListaDeFuncionarios.listar();
        List<Nutricionista> nutricionistas = ListaDeNutricionistas.listar();

        if (funcionarios.isEmpty() && nutricionistas.isEmpty()) {
            System.out.println("Não há funcionários ou nutricionistas cadastrados.");
        } else {
            System.out.println("Lista de Funcionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome());
            }

            System.out.println("\nLista de Nutricionistas:");
            for (Nutricionista nutricionista : nutricionistas) {
                System.out.println("ID: " + nutricionista.getId() + ", Nome: " + nutricionista.getNome());
            }
        }
    }

    private static void listarConsultas() {
        List<Consulta> consultas = ListaDeConsultas.listar();

        if (consultas.isEmpty()) {
            System.out.println("Não há consultas cadastradas.");
        } else {
            System.out.println("Lista de Consultas:");
            for (Consulta consulta : consultas) {
                String realizada = consulta.isConsultaRealizada() ? "Sim" : "Não";
                System.out.println("ID: " + consulta.getId() +
                        ", Data e Hora: " + consulta.getDataHora() +
                        ", Nome do Nutricionista: " + consulta.getNomeNutricionista() +
                        ", Nome do Paciente: " + consulta.getNomePaciente() +
                        ", Consulta Realizada: " + realizada);
            }
        }
    }

    private static void realizarConsulta() {
        System.out.println("Digite o ID da consulta que deseja realizar:");
        int idConsulta = scanner.nextInt();
        scanner.nextLine();

        Consulta consulta = ListaDeConsultas.buscarPorId(idConsulta);

        if (consulta == null) {
            System.out.println("Consulta não encontrada.");
        } else {
            consulta.setConsultaRealizada(true);
            System.out.println("Consulta realizada com sucesso!");
        }
    }


}