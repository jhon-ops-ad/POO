package model;

import service.Autenticacao;

// Implementa a interface de Autenticação (Fase 5)
public class Aluno extends Usuario implements Autenticacao {
    private String matricula;
    private Curso curso;

    public Aluno(String nome, String matricula, Curso curso) {
        super(nome);
        this.matricula = matricula;
        this.curso = curso;
    }

    // Getters
    public String getMatricula() {
        return matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    // Métodos (Fase 5 - Interface)
    @Override
    public boolean autenticar(String login, String senha) {
        // Simulação de autenticação: login é a matrícula, senha é "123"
        return this.matricula.equals(login) && senha.equals("123");
    }

    // Método polimórfico de Relatório (Fase 6)
    public String gerarRelatorio() {
        return "\n--- Relatório do Aluno ---\n" +
               "Nome: " + nome + "\n" +
               "Matrícula: " + matricula + "\n" +
               "Curso: " + curso.getNome() + " (" + curso.getCodigo() + ")" +
               "\n--------------------------\n";
    }
}