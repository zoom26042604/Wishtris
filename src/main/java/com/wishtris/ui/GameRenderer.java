package com.wishtris.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import com.wishtris.game.Board;
import com.wishtris.model.Tetromino;

public class GameRenderer {
    private final GraphicsContext gc;
    private static final int CELL_SIZE = 30;

    public GameRenderer(GraphicsContext gc) {
        this.gc = gc;
    }

    public void render(Board board, Tetromino tetromino) {
    gc.setFill(Color.BLACK);
    gc.fillRect(0, 0, 300, 600);

    int[][] grid = board.getGrid();
    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
            if (grid[row][col] != 0) {
                gc.setFill(Color.BLUE);
                gc.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            } else {
                gc.setStroke(Color.DARKGRAY);
                gc.strokeRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    int[][] matrix = tetromino.getShape().getShape();
    for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] != 0) {
                gc.setFill(Color.CYAN);
                gc.fillRect(
                    (tetromino.getX() + col) * CELL_SIZE,
                    (tetromino.getY() + row) * CELL_SIZE,
                    CELL_SIZE, CELL_SIZE
                );
            }
        }
    }
}
}
