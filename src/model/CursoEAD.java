package model;

public class CursoEAD extends Curso {
    private String plataformaVirtual;

    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataformaVirtual) {
        super(nome, codigo, cargaHoraria);
        this.plataformaVirtual = plataformaVirtual;
    }

    @Override
    public String detalharCurso() {
        return super.detalharCurso() + " | Modalidade: EAD | Plataforma: " + plataformaVirtual;
    }
}