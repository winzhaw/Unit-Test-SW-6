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
    @Test
    void testAttemptToTakeOccupiedField() {
    game.playMove(0, 0); // Spieler X nimmt das Feld (0,0)
    assertFalse(game.playMove(0, 0), "Spieler O sollte nicht in der Lage sein, ein bereits von Spieler X besetztes Feld zu nehmen.");
    assertEquals('X', game.getBoard()[0][0], "Das Feld (0,0) sollte immer noch von Spieler X besetzt sein.");
}

    @Test
    void testAttemptToTakeMultipleOccupiedFields() {
    game.playMove(1, 1); // Spieler X nimmt das Feld (1,1)
    assertFalse(game.playMove(1, 1), "Spieler O sollte nicht in der Lage sein, ein bereits von Spieler X besetztes Feld zu nehmen.");
    game.playMove(2, 2); // Spieler O nimmt das Feld (2,2)
    assertFalse(game.playMove(2, 2), "Spieler X sollte nicht in der Lage sein, ein bereits von Spieler O besetztes Feld zu nehmen.");
    assertEquals('X', game.getBoard()[1][1], "Das Feld (1,1) sollte von Spieler X besetzt sein.");
    assertEquals('O', game.getBoard()[2][2], "Das Feld (2,2) sollte von Spieler O besetzt sein.");
}
    @Test
    void testPlayerSwitchAfterEachMove() {
    game.playMove(0, 0); // Spieler X nimmt das Feld (0,0)
    assertEquals('O', game.getCurrentPlayer(), "Nach dem Zug von Spieler X sollte Spieler O an der Reihe sein.");
    game.playMove(1, 1); // Spieler O nimmt das Feld (1,1)
    assertEquals('X', game.getCurrentPlayer(), "Nach dem Zug von Spieler O sollte Spieler X an der Reihe sein.");
}
    @Test
    void testDetectTie() {
    game.playMove(0, 0); // X
    game.playMove(0, 1); // O
    game.playMove(0, 2); // X
    game.playMove(1, 0); // O
    game.playMove(1, 1); // X
    game.playMove(1, 2); // O
    game.playMove(2, 0); // X
    game.playMove(2, 1); // O
    game.playMove(2, 2); // X
    assertEquals('X', game.checkWinner(), "Das Spiel sollte unentschieden enden, wenn alle Felder besetzt sind ohne Gewinner.");
}


}
