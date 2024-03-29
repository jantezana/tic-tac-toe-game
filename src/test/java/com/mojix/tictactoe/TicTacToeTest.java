package com.mojix.tictactoe;

import com.mojix.tictactoe.businesslogic.board.TicTacToeBoard;
import com.mojix.tictactoe.businesslogic.engine.GameEngine;
import com.mojix.tictactoe.businesslogic.engine.TicTacToeGameEngine;
import com.mojix.tictactoe.businesslogic.engine.TicTacToePosition;
import com.mojix.tictactoe.businesslogic.game.TicTacToeGame;
import com.mojix.tictactoe.businesslogic.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TicTacToeTest {
    private static final Logger logger = LoggerFactory.getLogger(TicTacToeTest.class);
    private TicTacToeGame game;

    @Before
    public void setUp() {
        game = new TicTacToeGame();
        game.create("Player1", "Player2");
    }

    @Test
    public void testGameWithWinnerPlayerOne() {
        logger.info("Tic Tac Toe game test with a winner:Player1");
        Player player1 = game.getPlayers().get(0);
        Player player2 = game.getPlayers().get(1);
        TicTacToeBoard board = (TicTacToeBoard) game.getBoard();

        GameEngine ticTacToeGameEngine = new TicTacToeGameEngine();
        ticTacToeGameEngine.play(player1, board, new TicTacToePosition(1, 1));
        ticTacToeGameEngine.play(player2, board, new TicTacToePosition(2, 1));
        ticTacToeGameEngine.play(player1, board, new TicTacToePosition(0, 0));
        ticTacToeGameEngine.play(player2, board, new TicTacToePosition(2, 0));
        ticTacToeGameEngine.play(player1, board, new TicTacToePosition(2, 2));
        assertTrue(ticTacToeGameEngine.checkWinner(board));
    }

    @Test
    public void testGameWithWinnerPlayerTwo() {
        logger.info("Tic Tac Toe game test with a winner:Player2");
        Player player1 = game.getPlayers().get(0);
        Player player2 = game.getPlayers().get(1);
        TicTacToeBoard board = (TicTacToeBoard) game.getBoard();

        GameEngine ticTacToeGameEngine = new TicTacToeGameEngine();
        ticTacToeGameEngine.play(player1, board, new TicTacToePosition(1, 2));
        ticTacToeGameEngine.play(player2, board, new TicTacToePosition(0, 0));
        ticTacToeGameEngine.play(player1, board, new TicTacToePosition(1, 1));
        ticTacToeGameEngine.play(player2, board, new TicTacToePosition(1, 0));
        ticTacToeGameEngine.play(player1, board, new TicTacToePosition(0, 2));
        ticTacToeGameEngine.play(player2, board, new TicTacToePosition(2, 0));
        assertTrue(ticTacToeGameEngine.checkWinner(board));

    }

    @Test
    public void testGameWithMatch() {
        logger.info("Tic Tac Toe game test with a tie");
        Player player1 = game.getPlayers().get(0);
        Player player2 = game.getPlayers().get(1);
        TicTacToeBoard board = (TicTacToeBoard) game.getBoard();

        GameEngine ticTacToeGameEngine = new TicTacToeGameEngine();
        ticTacToeGameEngine.play(player1, board, new TicTacToePosition(1, 1));
        ticTacToeGameEngine.play(player2, board, new TicTacToePosition(0, 0));
        ticTacToeGameEngine.play(player1, board, new TicTacToePosition(2, 1));
        ticTacToeGameEngine.play(player2, board, new TicTacToePosition(0, 1));
        ticTacToeGameEngine.play(player1, board, new TicTacToePosition(0, 2));
        ticTacToeGameEngine.play(player2, board, new TicTacToePosition(2, 0));
        ticTacToeGameEngine.play(player1, board, new TicTacToePosition(1, 0));
        ticTacToeGameEngine.play(player2, board, new TicTacToePosition(1, 2));
        ticTacToeGameEngine.play(player1, board, new TicTacToePosition(2, 2));
        assertFalse(ticTacToeGameEngine.checkWinner(board));
        assertTrue(ticTacToeGameEngine.gameOver(board));
    }
}
