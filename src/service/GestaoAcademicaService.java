package service;

import model.Aluno;
import model.Avaliacao;
import model.Turma;

public class GestaoAcademicaService {

    public boolean registrarNota(Turma turma, Aluno aluno, String descricaoAvaliacao, double nota) {
        if (!turma.getListaAlunos().contains(aluno)) {
            System.out.println("ERRO: Aluno não pertence a esta turma.");
            return false;
        }

        Avaliacao avaliacao = new Avaliacao(descricaoAvaliacao, aluno);

        if (avaliacao.atribuirNota(nota)) {
            turma.adicionarAvaliacao(avaliacao);
            System.out.println("Nota de " + nota + " para " + aluno.getNome() + " registrada com sucesso.");
            return true;
        }
        return false;
    }

    public void gerarRelatorioTurma(Turma turma) {
        System.out.println(turma.getResumoTurma());

        System.out.println("--- Alunos da Turma ---");
        if (turma.getListaAlunos().isEmpty()) {
            System.out.println("Nenhum aluno matriculado.");
        } else {
            for (Aluno aluno : turma.getListaAlunos()) {
                System.out.println("- " + aluno.getNome() + " (Matrícula: " + aluno.getMatricula() + ")");
            }
        }
        System.out.println("-----------------------");

        System.out.println("\n--- Avaliações e Notas ---");
        if (turma.getListaAvaliacoes().isEmpty()) {
            System.out.println("Nenhuma avaliação registrada.");
        } else {
            for (Avaliacao av : turma.getListaAvaliacoes()) {
                System.out.println(av.toString());
            }
        }
        System.out.println("--------------------------");
    }
}