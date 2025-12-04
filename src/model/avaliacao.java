package model;

public class Avaliacao {
    private double nota; // Atributo privado para Encapsulamento (Fase 3)
    private String descricao;
    private Aluno aluno; // Associação com Aluno

    public Avaliacao(String descricao, Aluno aluno) {
        this.descricao = descricao;
        this.aluno = aluno;
        this.nota = 0.0; // Inicializa com nota zero
    }

    // Método para controle e validação de nota (Encapsulamento - Fase 3)
    public boolean atribuirNota(double valor) {
        if (valor >= 0.0 && valor <= 10.0) {
            this.nota = valor;
            return true;
        }
        System.out.println("ERRO: A nota deve estar entre 0.0 e 10.0.");
        return false;
    }

    // Getters
    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String toString() {
        return "Avaliação: " + descricao + " | Aluno: " + aluno.getNome() + " | Nota: " + nota;
    }
}