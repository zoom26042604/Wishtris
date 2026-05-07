package com.wishtris.game;

import com.wishtris.model.TetrominoFactory;
import com.wishtris.model.Tetromino;
import com.wishtris.ui.GameRenderer;
import javafx.animation.AnimationTimer;
import com.wishtris.ui.InputHandler;
import com.wishtris.game.GameState;
import com.wishtris.ui.SidePanel;

public class GameLoop extends AnimationTimer {
    private final long DROP_INTERVAL = 500_000_000;
    private long lastDropTime = 0;

    private final Board board;
    private final InputHandler inputHandler;
    private Tetromino currentTetromino;
    private final GameRenderer renderer;
    private final GameState gameState;
    private final SidePanel sidePanel;

    public GameLoop(Board board, Tetromino currentTetromino, GameRenderer renderer, InputHandler inputHandler, SidePanel sidePanel) {
        this.board = board;
        this.inputHandler = inputHandler;
        this.currentTetromino = currentTetromino;
        this.renderer = renderer; 
        this.sidePanel = sidePanel;
        this.gameState = new GameState();
        this.renderer.setGameState(this.gameState);
        this.inputHandler.setGameState(this.gameState);
        sidePanel.update(gameState.getScore(), gameState.getLevel());
    }

    @Override
    public void handle(long now) {
        if (paused)
            return;
        if (now - lastDropTime < DROP_INTERVAL)
            return;
        lastDropTime = now;

        if (board.canMove(currentTetromino, 0, 1)) {
            currentTetromino.moveDown();
            renderer.render(board, currentTetromino);
            return;
        }

        board.merge(currentTetromino);
        int lines = board.clearLines();
        gameState.addLines(lines);
        sidePanel.update(gameState.getScore(), gameState.getLevel());
        currentTetromino = TetrominoFactory.createRandom();
        inputHandler.setTetromino(currentTetromino);

        if (!board.canMove(currentTetromino, 0, 0)) {
            gameState.setGameOver();
            sidePanel.showRestartButton();
            stop();
            renderer.renderGameOver(gameState.getScore());
            return;
        }

        renderer.render(board, currentTetromino);
    }

    private boolean paused = false;

    public void togglePause() {
        paused = !paused;
    }

    public void setTetromino(Tetromino tetromino) {
        this.currentTetromino = tetromino;
    }

    public boolean isGameOver() {
        return gameState.isGameOver();
    }

    public void restart() {
        board.reset();
        gameState.reset();
        currentTetromino = TetrominoFactory.createRandom();
        inputHandler.setTetromino(currentTetromino);
        paused = false;
        lastDropTime = 0;
        sidePanel.hideRestartButton();
        sidePanel.update(gameState.getScore(), gameState.getLevel());
        start();
    }
}
