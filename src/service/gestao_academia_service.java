package service;

import model.Aluno;
import model.Avaliacao;
import model.Turma;

// Classe de serviço para centralizar as operações de negócio (Fase 7)
public class GestaoAcademicaService {

    // Simula a atribuição de nota em uma avaliação de uma turma (Fase 3)
    public boolean registrarNota(Turma turma, Aluno aluno, String descricaoAvaliacao, double nota) {
        if (!turma.getListaAlunos().contains(aluno)) {
            System.out.println("ERRO: Aluno não pertence a esta turma.");
            return false;
        }

        // 1. Cria a avaliação (com o aluno associado)
        Avaliacao avaliacao = new Avaliacao(descricaoAvaliacao, aluno);

        // 2. Tenta atribuir a nota, validando-a internamente (Encapsulamento - Fase 3)
        if (avaliacao.atribuirNota(nota)) {
            // 3. Se a nota for válida, adiciona a avaliação à lista da turma
            turma.adicionarAvaliacao(avaliacao);
            System.out.println("Nota de " + nota + " para " + aluno.getNome() + " em " + descricaoAvaliacao + " registrada com sucesso.");
            return true;
        }
        return false;
    }

    // Método de Relatório de Turma (Exemplo de uso do modelo)
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