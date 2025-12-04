package model;

// Classe base para Herança (Fase 4)
public class Curso {
    protected String nome;
    protected String codigo;
    protected int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    // Método para ser Sobrescrito (Polimorfismo - Fase 4)
    public String detalharCurso() {
        return "Curso: " + nome + " | Código: " + codigo + " | Carga Horária: " + cargaHoraria + "h";
    }

    // Método polimórfico de Relatório (Fase 6)
    public String gerarRelatorio() {
        return "\n--- Relatório do Curso ---\n" +
               detalharCurso() +
               "\n--------------------------\n";
    }
}