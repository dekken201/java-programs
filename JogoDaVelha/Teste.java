package JogoDaVelha;

public class Teste {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.geraTabuleiro();
        System.out.println("");


        tabuleiro.marcarPosicao(new int[]{0, 2}, "[ X ]");
        tabuleiro.marcarPosicao(new int[]{1, 2}, "[ X ]");
        tabuleiro.marcarPosicao(new int[]{2, 2}, "[ X ]");

        tabuleiro.atualizaTabuleiro();
        System.out.println(tabuleiro.checaLinhaEColuna());
    }

}
