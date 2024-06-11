package entidades;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private static int nextId = 1;
    private int id;
    private String nome;
    private int idade;
    private Endereco endereco;
    private double salario;

    public Funcionario() {
        this.id = nextId++;
    }

    public Funcionario(String nome, int idade, Endereco endereco, double salario) {
        this.id = nextId++;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    private static List<String> nomesUsados = new ArrayList<>();

    public void setNome(String nome) {
        if (nomesUsados.contains(nome)) {
            throw new IllegalArgumentException("Nome já está em uso");
        } else {
            this.nome = nome;
            nomesUsados.add(nome);
        }
    }
}
