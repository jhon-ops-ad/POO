package repository;

import model.Aluno;
import model.Curso;
import model.Professor;
import model.Turma;
import java.util.ArrayList;
import java.util.List;

public class RepositorioGlobal {
    private final List<Aluno> alunos = new ArrayList<>();
    private final List<Professor> professores = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();
    private final List<Turma> turmas = new ArrayList<>();

    private static RepositorioGlobal instance;

    private RepositorioGlobal() {}

    public static RepositorioGlobal getInstance() {
        if (instance == null) {
            instance = new RepositorioGlobal();
        }
        return instance;
    }

    public void adicionarAluno(Aluno aluno) { this.alunos.add(aluno); }
    public void adicionarProfessor(Professor professor) { this.professores.add(professor); }
    public void adicionarCurso(Curso curso) { this.cursos.add(curso); }
    public void adicionarTurma(Turma turma) { this.turmas.add(turma); }

    public List<Aluno> getAlunos() { return alunos; }
    public List<Professor> getProfessores() { return professores; }
    public List<Curso> getCursos() { return cursos; }
    public List<Turma> getTurmas() { return turmas; }

    public Curso buscarCursoPorCodigo(String codigo) {
        return cursos.stream().filter(c -> c.getCodigo().equalsIgnoreCase(codigo)).findFirst().orElse(null);
    }

    public Professor buscarProfessorPorRegistro(String registro) {
        return professores.stream().filter(p -> p.getRegistro().equalsIgnoreCase(registro)).findFirst().orElse(null);
    }

    public Aluno buscarAlunoPorMatricula(String matricula) {
        return alunos.stream().filter(a -> a.getMatricula().equalsIgnoreCase(matricula)).findFirst().orElse(null);
    }

    public Turma buscarTurmaPorCodigo(String codigo) {
        return turmas.stream().filter(t -> t.getCodigo().equalsIgnoreCase(codigo)).findFirst().orElse(null);
    }
}