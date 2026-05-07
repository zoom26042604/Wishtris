package com.wishtris.ui;

import com.wishtris.game.Board;
import com.wishtris.game.GameLoop;
import com.wishtris.model.Tetromino;
import com.wishtris.model.TetrominoFactory;

import javafx.scene.input.KeyEvent;

public class InputHandler {
    private final Board board;
    private Tetromino tetromino;
    private final GameRenderer renderer;
    private GameLoop gameLoop;

    public InputHandler(Board board, Tetromino tetromino, GameRenderer renderer, GameLoop gameLoop) {
        this.board = board;
        this.tetromino = tetromino;
        this.renderer = renderer;
        this.gameLoop = gameLoop;
    }

    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
            case DOWN -> moveDown();
            case UP -> rotate();
            case SPACE -> hardDrop();
            case P -> gameLoop.togglePause();
            default -> {
            }
        }
        renderer.render(board, tetromino);
    }

    private void moveLeft() {
        if (board.canMove(tetromino, -1, 0)) {
            tetromino.moveLeft();
        }
    }

    private void moveRight() {
        if (board.canMove(tetromino, 1, 0)) {
            tetromino.moveRight();
        }
    }

    private void moveDown() {
        if (board.canMove(tetromino, 0, 1)) {
            tetromino.moveDown();
        }
    }

    private void rotate() {
        tetromino.rotate();
        if (!board.canMove(tetromino, 0, 0)) {
            tetromino.rotate();
            tetromino.rotate();
            tetromino.rotate();
        }
        renderer.render(board, tetromino);
    }

    private void hardDrop() {
        while (board.canMove(tetromino, 0, 1)) {
            tetromino.moveDown();
        }
        board.merge(tetromino);
        tetromino = TetrominoFactory.createRandom();
        gameLoop.setTetromino(tetromino);
        renderer.render(board, tetromino);
    }

    public void setTetromino(Tetromino tetromino) {
        this.tetromino = tetromino;
    }

    public void setGameLoop(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }
}