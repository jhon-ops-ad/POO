package model;

public class CursoPresencial extends Curso {
    private String salaDeAula;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String salaDeAula) {
        super(nome, codigo, cargaHoraria);
        this.salaDeAula = salaDeAula;
    }

    @Override
    public String detalharCurso() {
        return super.detalharCurso() + " | Modalidade: Presencial | Sala: " + salaDeAula;
    }
}