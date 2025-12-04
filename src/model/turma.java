package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor; // Associação (Fase 2)
    private Curso curso; // Associação (Fase 2)
    private List<Aluno> listaAlunos; // Associação (Fase 2)
    private List<Avaliacao> listaAvaliacoes; // Associação para Fase 3

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
        this.listaAvaliacoes = new ArrayList<>();
    }

    // Métodos para adicionar/remover alunos (Fase 2)
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

    // Método para associar avaliações (Fase 3)
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        listaAvaliacoes.add(avaliacao);
    }

    // Método para mostrar resumo da turma (Fase 2)
    public String getResumoTurma() {
        return "\n--- Resumo da Turma " + codigo + " ---\n" +
               "Curso: " + curso.detalharCurso() + "\n" +
               "Professor: " + professor.getNome() + " (" + professor.getEspecialidade() + ")\n" +
               "Alunos Matriculados: " + listaAlunos.size() +
               "\n-------------------------------\n";
    }

    // Getters
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