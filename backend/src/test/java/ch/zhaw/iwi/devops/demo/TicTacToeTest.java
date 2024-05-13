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
