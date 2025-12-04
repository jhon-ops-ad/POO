package ui;

import model.*;
import repository.RepositorioGlobal;
import service.GestaoAcademicaService;

import java.util.Scanner;
import java.util.List;

public class MenuInterativo {

    private final RepositorioGlobal repo = RepositorioGlobal.getInstance();
    private final GestaoAcademicaService service = new GestaoAcademicaService();
    private final Scanner scanner = new Scanner(System.in);
    // Instância do Administrador para Autenticação (Fase 5)
    private final Administrador administrador = new Administrador("Admin Principal", "ADM001");

    public void iniciar() {
        System.out.println("=========================================");
        System.out.println("  BEM-VINDO AO SGE EDUCONNECT - PROTÓTIPO");
        System.out.println("=========================================");

        // Simulação de autenticação inicial para entrar no menu principal (Fase 5)
        if (autenticarAdmin()) {
            menuPrincipal();
        } else {
            System.out.println("Autenticação falhou. Encerrando o sistema.");
        }
        scanner.close(); // Fecha o Scanner ao sair
    }

    private boolean autenticarAdmin() {
        System.out.println("\n--- Autenticação do Administrador ---");
        System.out.print("Login (Registro: ADM001): ");
        String login = scanner.nextLine();
        System.out.print("Senha (admin): ");
        String senha = scanner.nextLine();

        return administrador.autenticar(login, senha);
    }

    private void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastro de Entidades");
            System.out.println("2. Gerenciamento de Turmas");
            System.out.println("3. Registrar Avaliação");
            System.out.println("4. Gerar Relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1 -> menuCadastro();
                case 2 -> menuTurmas();
                case 3 -> registrarAvaliacao();
                case 4 -> menuRelatorios();
                case 0 -> System.out.println("Obrigado por utilizar o SGE EduConnect. Até mais!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void menuCadastro() {
        int opcao;
        do {
            System.out.println("\n--- CADASTRO DE ENTIDADES ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Curso");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> cadastrarProfessor();
                case 3 -> cadastrarCurso();
                case 0 -> {}
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void cadastrarAluno() {
        System.out.println("\n--- CADASTRO DE ALUNO ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula (Ex: 2024001): ");
        String matricula = scanner.nextLine();
        System.out.print("Código do Curso (Ex: INF101): ");
        String codCurso = scanner.nextLine();

        Curso curso = repo.buscarCursoPorCodigo(codCurso);

        if (curso != null) {
            Aluno aluno = new Aluno(nome, matricula, curso);
            repo.adicionarAluno(aluno);
            System.out.println("✅ Aluno " + nome + " cadastrado com sucesso no curso de " + curso.getNome() + ".");
        } else {
            System.out.println("❌ Erro: Curso com código " + codCurso + " não encontrado. Cadastre o curso primeiro.");
        }
    }

    private void cadastrarProfessor() {
        System.out.println("\n--- CADASTRO DE PROFESSOR ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("Registro (Ex: P123): ");
        String registro = scanner.nextLine();

        Professor professor = new Professor(nome, especialidade, registro);
        repo.adicionarProfessor(professor);
        System.out.println("✅ Professor " + nome + " cadastrado com registro " + registro + ".");
    }

    private void cadastrarCurso() {
        System.out.println("\n--- CADASTRO DE CURSO ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Código (Ex: MAT102): ");
        String codigo = scanner.nextLine();
        System.out.print("Carga Horária: ");
        int ch = lerInteiro();
        scanner.nextLine();

        System.out.print("Modalidade (1-Presencial, 2-EAD): ");
        int modalidade = lerInteiro();
        scanner.nextLine();

        Curso curso;
        if (modalidade == 1) {
            System.out.print("Sala de Aula: ");
            String sala = scanner.nextLine();
            curso = new CursoPresencial(nome, codigo, ch, sala);
        } else if (modalidade == 2) {
            System.out.print("Plataforma Virtual: ");
            String plataforma = scanner.nextLine();
            curso = new CursoEAD(nome, codigo, ch, plataforma);
        } else {
            System.out.println("Modalidade inválida. Curso cadastrado como genérico.");
            curso = new Curso(nome, codigo, ch);
        }

        repo.adicionarCurso(curso);
        System.out.println("✅ Curso " + nome + " (" + curso.detalharCurso() + ") cadastrado com sucesso.");
    }

    private void menuTurmas() {
        int opcao;
        do {
            System.out.println("\n--- GERENCIAMENTO DE TURMAS ---");
            System.out.println("1. Criar Turma");
            System.out.println("2. Associar Aluno à Turma");
            System.out.println("3. Ver Resumo da Turma");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> criarTurma();
                case 2 -> associarAlunoTurma();
                case 3 -> verResumoTurma();
                case 0 -> {}
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void criarTurma() {
        System.out.println("\n--- CRIAR TURMA ---");
        System.out.print("Código da Turma (Ex: T01): ");
        String codTurma = scanner.nextLine();

        System.out.print("Código do Curso (Ex: INF101): ");
        String codCurso = scanner.nextLine();
        Curso curso = repo.buscarCursoPorCodigo(codCurso);

        System.out.print("Registro do Professor (Ex: P123): ");
        String regProf = scanner.nextLine();
        Professor professor = repo.buscarProfessorPorRegistro(regProf);

        if (repo.buscarTurmaPorCodigo(codTurma) != null) {
            System.out.println("❌ Erro: Turma com este código já existe.");
            return;
        }

        if (curso != null && professor != null) {
            Turma turma = new Turma(codTurma, professor, curso);
            repo.adicionarTurma(turma);
            System.out.println("✅ Turma " + codTurma + " criada com sucesso (Professor: " + professor.getNome() + ", Curso: " + curso.getNome() + ").");
        } else {
            System.out.println("❌ Erro: Curso ou Professor não encontrados.");
        }
    }

    private void associarAlunoTurma() {
        System.out.println("\n--- ASSOCIAR ALUNO À TURMA ---");
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        Aluno aluno = repo.buscarAlunoPorMatricula(matricula);

        System.out.print("Código da Turma: ");
        String codTurma = scanner.nextLine();
        Turma turma = repo.buscarTurmaPorCodigo(codTurma);

        if (aluno != null && turma != null) {
            if (turma.adicionarAluno(aluno)) {
                System.out.println("✅ Aluno " + aluno.getNome() + " associado à Turma " + turma.getCodigo() + " com sucesso.");
            }
        } else {
            System.out.println("❌ Erro: Aluno ou Turma não encontrados.");
        }
    }

    private void verResumoTurma() {
        System.out.println("\n--- RESUMO DA TURMA ---");
        System.out.print("Código da Turma: ");
        String codTurma = scanner.nextLine();
        Turma turma = repo.buscarTurmaPorCodigo(codTurma);

        if (turma != null) {
            service.gerarRelatorioTurma(turma);
        } else {
            System.out.println("❌ Erro: Turma não encontrada.");
        }
    }

    private void registrarAvaliacao() {
        System.out.println("\n--- REGISTRAR AVALIAÇÃO (NOTA) ---");
        System.out.print("Código da Turma: ");
        String codTurma = scanner.nextLine();
        Turma turma = repo.buscarTurmaPorCodigo(codTurma);

        if (turma == null) {
            System.out.println("❌ Erro: Turma não encontrada.");
            return;
        }

        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        Aluno aluno = repo.buscarAlunoPorMatricula(matricula);

        if (aluno == null || !turma.getListaAlunos().contains(aluno)) {
            System.out.println("❌ Erro: Aluno não encontrado ou não matriculado nesta turma.");
            return;
        }

        System.out.print("Descrição da Avaliação: ");
        String descricao = scanner.nextLine();
        System.out.print("Nota (0.0 a 10.0): ");
        double nota = lerDouble();
        scanner.nextLine();

        // Usa o serviço para aplicar a regra de negócio (Fase 3 - Encapsulamento)
        service.registrarNota(turma, aluno, descricao, nota);
    }

    private void menuRelatorios() {
        int opcao;
        do {
            System.out.println("\n--- RELATÓRIOS (Fase 6 - Polimorfismo) ---");
            System.out.println("1. Relatório de Todos os Alunos");
            System.out.println("2. Relatório de Todos os Professores");
            System.out.println("3. Relatório de Todos os Cursos");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> gerarRelatorioGeral(repo.getAlunos());
                case 2 -> gerarRelatorioGeral(repo.getProfessores());
                case 3 -> gerarRelatorioGeral(repo.getCursos());
                case 0 -> {}
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Método genérico para gerar relatórios (Polimorfismo - Fase 6)
    private void gerarRelatorioGeral(List<?> lista) {
        if (lista.isEmpty()) {
            System.out.println("Não há dados cadastrados para gerar este relatório.");
            return;
        }

        System.out.println("\n==================================");
        System.out.println(">>> RELATÓRIO GERAL DE ENTIDADES <<<");
        System.out.println("==================================");

        for (Object item : lista) {
            // Uso de Pattern Matching for instanceof (Java 16+)
            if (item instanceof Aluno aluno) {
                System.out.println(aluno.gerarRelatorio());
            } else if (item instanceof Professor professor) {
                System.out.println(professor.gerarRelatorio());
            } else if (item instanceof Curso curso) {
                System.out.println(curso.gerarRelatorio());
            }
        }
    }

    // Funções auxiliares para leitura segura
    private int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.next(); // descarta a entrada inválida
            System.out.print("Tente novamente: ");
        }
        int valor = scanner.nextInt();
        return valor;
    }

    private double lerDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, digite um número decimal (use ponto).");
            scanner.next(); // descarta a entrada inválida
            System.out.print("Tente novamente: ");
        }
        double valor = scanner.nextDouble();
        return valor;
    }
}