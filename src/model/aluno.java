package model;

import service.Autenticacao;

public class Aluno extends Usuario implements Autenticacao {
    private String matricula;
    private Curso curso;

    public Aluno(String nome, String matricula, Curso curso) {
        super(nome);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.matricula.equals(login) && senha.equals("123");
    }

    public String gerarRelatorio() {
        return "\n--- Relatório do Aluno ---\n" +
               "Nome: " + nome + "\n" +
               "Matrícula: " + matricula + "\n" +
               "Curso: " + curso.getNome() + " (" + curso.getCodigo() + ")" +
               "\n--------------------------\n";
    }
}