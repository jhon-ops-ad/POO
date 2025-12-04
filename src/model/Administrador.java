package model;

import service.Autenticacao;

public class Administrador extends Usuario implements Autenticacao {
    private String registro;

    public Administrador(String nome, String registro) {
        super(nome);
        this.registro = registro;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.registro.equals(login) && senha.equals("admin");
    }
}