package model;

import service.Autenticacao;

public class Professor extends Usuario implements Autenticacao {
    private String especialidade;
    private String registro;

    public Professor(String nome, String especialidade, String registro) {
        super(nome);
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.registro.equals(login) && senha.equals("prof456");
    }

    public String gerarRelatorio() {
        return "\n--- Relatório do Professor ---\n" +
               "Nome: " + nome + "\n" +
               "Registro: " + registro + "\n" +
               "Especialidade: " + especialidade +
               "\n----------------------------\n";
    }
}