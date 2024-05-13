package ch.zhaw.iwi.devops.demo;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        initializeBoard();
        currentPlayer = 'X'; // X beginnt immer
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
