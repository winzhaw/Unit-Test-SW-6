package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    void testInitialBoardIsEmpty() {
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', board[i][j], "Das Spielfeld sollte anfänglich leer sein.");
            }
        }
    }

    @Test
    void testPlayMoveAndSwitchPlayer() {
        assertTrue(game.playMove(0, 0), "Spieler sollte in der Lage sein, einen Zug zu machen.");
        assertEquals('O', game.getCurrentPlayer(), "Nach Spieler X sollte Spieler O an der Reihe sein.");
        assertFalse(game.playMove(0, 0), "Ein bereits besetztes Feld sollte nicht noch einmal besetzt werden können.");
        game.playMove(0, 1); // Spieler O macht einen Zug
        assertEquals('X', game.getCurrentPlayer(), "Spieler sollte nach O zu X wechseln.");
    }

    @Test
    void testWinnerRow() {
        game.playMove(0, 0); // Spieler X
        game.playMove(1, 0); // Spieler O
        game.playMove(0, 1); // Spieler X
        game.playMove(1, 1); // Spieler O
        game.playMove(0, 2); // Spieler X gewinnt
        assertEquals('X', game.checkWinner(), "Spieler X sollte gewonnen haben, indem er die erste Reihe komplettiert.");
    }

    @Test
    void testWinnerColumn() {
        game.playMove(0, 0); // Spieler X
        game.playMove(0, 1); // Spieler O
        game.playMove(1, 0); // Spieler X
        game.playMove(1, 1); // Spieler O
        game.playMove(2, 0); // Spieler X gewinnt
        assertEquals('X', game.checkWinner(), "Spieler X sollte gewonnen haben, indem er die erste Spalte komplettiert.");
    }

    @Test
    void testWinnerDiagonal() {
        game.playMove(0, 0); // Spieler X
        game.playMove(0, 1); // Spieler O
        game.playMove(1, 1); // Spieler X
        game.playMove(0, 2); // Spieler O
        game.playMove(2, 2); // Spieler X gewinnt
        assertEquals('X', game.checkWinner(), "Spieler X sollte gewonnen haben, indem er die Diagonale von links oben nach rechts unten komplettiert.");
    }

    @Test
    void testTieGame() {
        game.playMove(0, 0); // Spieler X
        game.playMove(0, 1); // Spieler O
        game.playMove(0, 2); // Spieler X
        game.playMove(1, 0); // Spieler O
        game.playMove(1, 1); // Spieler X
        game.playMove(1, 2); // Spieler O
        game.playMove(2, 0); // Spieler X
        game.playMove(2, 1); // Spieler O
        game.playMove(2, 2); // Spieler X
        assertEquals('X', game.checkWinner(), "Das Spiel sollte unentschieden enden, da alle Felder besetzt sind ohne Gewinner.");
    }
}
