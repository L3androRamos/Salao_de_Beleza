package modelo;

public class Cliente {
    private String nome;
    private int numeroDeContato;

    public Cliente(String nome, int numeroDeContato) {
        this.nome = nome;
        this.numeroDeContato = numeroDeContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeContato() {
        return numeroDeContato;
    }

    public void setNumeroDeContato(int numeroDeContato) {
        this.numeroDeContato = numeroDeContato;
    }
}
