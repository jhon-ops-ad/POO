package model;

import service.Autenticacao;

public class Administrador extends Usuario implements Autenticacao {
    private String registro;

    public Administrador(String nome, String registro) {
        super(nome);
        this.registro = registro;
    }

    // Implementação da Autenticação para o Admin (Fase 5)
    @Override
    public boolean autenticar(String login, String senha) {
        // Simulação de autenticação: login é o registro, senha é "admin"
        return this.registro.equals(login) && senha.equals("admin");
    }
}