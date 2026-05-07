package com.wishtris.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import com.wishtris.game.Board;

public class GameRenderer {
    private final GraphicsContext gc;
    private static final int CELL_SIZE = 30;

    public GameRenderer(GraphicsContext gc) {
        this.gc = gc;
    }

    public void render(Board board) {
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
}
}
