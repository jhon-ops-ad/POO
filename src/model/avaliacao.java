package model;

public class Avaliacao {
    private double nota;
    private String descricao;
    private Aluno aluno;

    public Avaliacao(String descricao, Aluno aluno) {
        this.descricao = descricao;
        this.aluno = aluno;
        this.nota = 0.0;
    }

    public boolean atribuirNota(double valor) {
        if (valor >= 0.0 && valor <= 10.0) {
            this.nota = valor;
            return true;
        }
        System.out.println("ERRO: A nota deve estar entre 0.0 e 10.0.");
        return false;
    }

    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    @Override
    public String toString() {
        return "Avaliação: " + descricao + " | Aluno: " + aluno.getNome() + " | Nota: " + nota;
    }
}