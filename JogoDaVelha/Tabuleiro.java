package JogoDaVelha;

public class Tabuleiro {

    private String[][] tabuleiro = new String[3][3];

    public void geraTabuleiro() {
        System.out.println("JOGO DA VELHA:");
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = "[   ]";
                System.out.print(tabuleiro[linha][coluna]);
            }
            System.out.print("\n");
        }
    }

    public void atualizaTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(tabuleiro[linha][coluna]);
            }
            System.out.print("\n");
        }
    }

    public boolean checaFim() {
        if (checaLinhaEColuna() == true || checaDiagonal() == true) {
            return true;
        } else if (tabuleiroCompleto() == true) {
            return true;
        }
        return false;
    }

    public boolean checaLinhaEColuna() {
        for (int x = 0; x < 3; x++) {
            if (tabuleiro[0][x].equals(tabuleiro[1][x]) && tabuleiro[1][x].equals(tabuleiro[2][x])) {
                if (tabuleiro[2][x].equals("[ X ]") || tabuleiro[2][x].equals("[ O ]")) {
                    return true;
                }
            } else if (tabuleiro[x][0].equals(tabuleiro[x][1]) && tabuleiro[x][1].equals(tabuleiro[x][2])) {
                if (tabuleiro[x][2].equals("[ X ]") || tabuleiro[x][2].equals("[ O ]")) {
                    return true;
                }
            }

        }
        return false;

    }

    public boolean checaDiagonal() {
        if (tabuleiro[0][0].equals(tabuleiro[1][1])) {
            if (tabuleiro[1][1].equals(tabuleiro[2][2])) {
                if (tabuleiro[2][2].equals("[ X ]") || tabuleiro[2][2].equals("[ O ]")) {
                    return true;
                }
            }
        } else if (tabuleiro[0][2].equals(tabuleiro[1][1])) {
            if (tabuleiro[1][1].equals(tabuleiro[2][0])) {
                if (tabuleiro[2][0].equals("[ X ]") || tabuleiro[2][0].equals("[ O ]")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean tabuleiroCompleto() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna].equals("[   ]")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean marcarPosicao(int[] pos, String simbolo) {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (linha == pos[0] && coluna == pos[1]) {
                    if (!tabuleiro[linha][coluna].equals("[   ]")) {
                        return false;
                    } else {
                        tabuleiro[linha][coluna] = simbolo;
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
