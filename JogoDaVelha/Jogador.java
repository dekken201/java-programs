package JogoDaVelha;

public class Jogador {

    private String nome;
    private String simbolo;

    public Jogador(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public Jogador() {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public boolean comparaJogador(Jogador x) {
        return x.getSimbolo().equals(this.getSimbolo());
    }
}
