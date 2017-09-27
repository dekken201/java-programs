package JogoDaVelha;

import java.util.Scanner;

public class Jogo {

    Tabuleiro tabuleiro = new Tabuleiro();
    Scanner in = new Scanner(System.in);
    boolean quemJoga = true;

    public void iniciarJogo() {
        tabuleiro.geraTabuleiro();
        boolean loop = true;
        while (loop) {
            System.out.println("Digite o nome do jogador 1");
            Jogador p1 = new Jogador(in.next(), escolheSimbolo());
            System.out.println("Digite o nome do jogador 2");
            Jogador p2 = new Jogador(in.next(), escolheSimbolo());

            if (p1.comparaJogador(p2) == true) {
                System.err.println("Símbolos iguais! Escolha novamente>>");
            } else {
                loop = false;
            }

            while (tabuleiro.checaFim() == false) {
                quemJoga = !quemJoga; //troca o jogador da vez
                while (!tabuleiro.marcarPosicao(escolherPosicao(quemJoga(p1, p2)), quemJoga(p1, p2).getSimbolo())){
                    System.err.println("Posição já ocupada! Tente novamente."); 
                }
                tabuleiro.atualizaTabuleiro();

            }
            if (tabuleiro.tabuleiroCompleto() == false) {
                System.err.println("Jogo finalizado. Vencedor: " + quemJoga(p1, p2).getNome());
            } else {
                System.err.println("Deu velha!");
            }
        }

    }

    public String escolheSimbolo() {

        String simbolo = "";
        boolean loop = true;
        while (loop) {

            System.out.println("Escolha seu símbolo. '0' para bola, '1' para X.");
            int opcao = in.nextInt();

            if (opcao == 0) {
                simbolo = "[ O ]";
                loop = false;
            } else if (opcao == 1) {
                simbolo = "[ X ]";
                loop = false;
            } else {
                System.err.println("Opção inválida!");
            }
        }
        return simbolo;
    }

    public int[] escolherPosicao(Jogador p) {
        boolean loop = true;
        int x = 0;
        int y = 0;
        while (loop) {
            System.out.println("Digite a posição que deseja marcar:");
            System.out.println("Posições de 1 a 9, da esquerda para a direita, cima para baixo.");
            int opcao = in.nextInt();
            if (opcao > 0 && opcao <= 3) {
                x = 0;
                y = opcao - 1;
                loop = false;
            } else if (opcao > 3 && opcao <= 6) {
                x = 1;
                y = opcao - 4;
                loop = false;
            } else if (opcao > 6 && opcao <= 9) {
                x = 2;
                y = opcao - 7;
                loop = false;
            } else {
                System.err.println("Posição inválida!");
            }
        }
        return new int[]{x, y};
    }

    public Jogador quemJoga(Jogador p1, Jogador p2) {
        if (quemJoga == false) {
            System.out.println("Jogador da vez: " + p1.getNome());
            return p1;
        } else {
            System.out.println("Jogador da vez: " + p2.getNome());
            return p2;
        }
    }
}
