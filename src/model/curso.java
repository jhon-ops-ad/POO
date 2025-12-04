package model;

public class Curso {
    protected String nome;
    protected String codigo;
    protected int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String detalharCurso() {
        return "Curso: " + nome + " | Código: " + codigo + " | Carga Horária: " + cargaHoraria + "h";
    }

    public String gerarRelatorio() {
        return "\n--- Relatório do Curso ---\n" +
               detalharCurso() +
               "\n--------------------------\n";
    }
}