package com.wishtris.game;

import com.wishtris.model.TetrominoFactory;
import com.wishtris.model.Tetromino;
import com.wishtris.ui.GameRenderer;
import javafx.animation.AnimationTimer;
import com.wishtris.ui.InputHandler;

public class GameLoop extends AnimationTimer {
    private final long DROP_INTERVAL = 500_000_000;
    private long lastDropTime = 0;

    private final Board board;
    private final InputHandler inputHandler;
    private Tetromino currentTetromino;
    private final GameRenderer renderer;

    public GameLoop(Board board, Tetromino currentTetromino, GameRenderer renderer, InputHandler inputHandler) {
        this.board = board;
        this.inputHandler = inputHandler;
        this.currentTetromino = currentTetromino;
        this.renderer = renderer;
    }

    @Override
    public void handle(long now) {
        if (paused)
            return;
        if (now - lastDropTime < DROP_INTERVAL) {
            return;
        }
        lastDropTime = now;

        if (board.canMove(currentTetromino, 0, 1)) {
            currentTetromino.moveDown();
            renderer.render(board, currentTetromino);
            return;
        }

        board.merge(currentTetromino);
        currentTetromino = TetrominoFactory.createRandom();
        inputHandler.setTetromino(currentTetromino);
        renderer.render(board, currentTetromino);
    }

    private boolean paused = false;

    public void togglePause() {
        paused = !paused;
    }

    public void setTetromino(Tetromino tetromino) {
        this.currentTetromino = tetromino;
    }
}
