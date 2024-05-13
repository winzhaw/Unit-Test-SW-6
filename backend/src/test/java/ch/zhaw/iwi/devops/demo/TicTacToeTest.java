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
}
