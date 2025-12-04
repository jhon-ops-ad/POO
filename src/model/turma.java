package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;
    private List<Avaliacao> listaAvaliacoes;

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
        this.listaAvaliacoes = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (listaAlunos.contains(aluno)) {
            System.out.println("Aluno já está matriculado nesta turma.");
            return false;
        }
        return listaAlunos.add(aluno);
    }

    public boolean removerAluno(Aluno aluno) {
        return listaAlunos.remove(aluno);
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        listaAvaliacoes.add(avaliacao);
    }

    public String getResumoTurma() {
        return "\n--- Resumo da Turma " + codigo + " ---\n" +
               "Curso: " + curso.detalharCurso() + "\n" +
               "Professor: " + professor.getNome() + " (" + professor.getEspecialidade() + ")\n" +
               "Alunos Matriculados: " + listaAlunos.size() +
               "\n-------------------------------\n";
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public List<Avaliacao> getListaAvaliacoes() {
        return listaAvaliacoes;
    }
}