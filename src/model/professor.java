package model;

import service.Autenticacao;

// Implementa a interface de Autenticação (Fase 5)
public class Professor extends Usuario implements Autenticacao {
    private String especialidade;
    private String registro;

    public Professor(String nome, String especialidade, String registro) {
        super(nome);
        this.especialidade = especialidade;
        this.registro = registro;
    }

    // Getters
    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    // Métodos (Fase 5 - Interface)
    @Override
    public boolean autenticar(String login, String senha) {
        // Simulação de autenticação: login é o registro, senha é "prof456"
        return this.registro.equals(login) && senha.equals("prof456");
    }

    // Método polimórfico de Relatório (Fase 6)
    public String gerarRelatorio() {
        return "\n--- Relatório do Professor ---\n" +
               "Nome: " + nome + "\n" +
               "Registro: " + registro + "\n" +
               "Especialidade: " + especialidade +
               "\n----------------------------\n";
    }
}