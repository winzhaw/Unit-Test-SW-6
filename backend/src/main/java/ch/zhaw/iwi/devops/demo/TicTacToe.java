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

    public boolean playMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            switchPlayer();
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    public char checkWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }
        // Check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        // Check for a tie
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return '-';
                }
            }
        }
        return 'T'; // Tie
    }
}
