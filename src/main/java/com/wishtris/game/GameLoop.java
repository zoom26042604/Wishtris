package com.wishtris.game;

import com.wishtris.model.TetrominoFactory;
import com.wishtris.model.Tetromino;
import com.wishtris.ui.GameRenderer;
import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {
    private final long DROP_INTERVAL = 500_000_000;
    private long lastDropTime = 0;

    private final Board board;
    private Tetromino currentTetromino;
    private final GameRenderer renderer;

    public GameLoop(Board board, Tetromino currentTetromino, GameRenderer renderer) {
        this.board = board;
        this.currentTetromino = currentTetromino;
        this.renderer = renderer;
    }

    @Override
    public void handle(long now) {
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
        renderer.render(board, currentTetromino);
    }
}
