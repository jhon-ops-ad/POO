package model;

// Classe Abstrata para generalizar atributos comuns (Fase 5)
public abstract class Usuario {
    protected String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}