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
                    gc.setFill(getPieceColor(grid[row][col]));
                    gc.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                } else {
                    gc.setStroke(Color.DARKGRAY);
                    gc.strokeRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }

        int[][] matrix = tetromino.getMatrix();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != 0) {
                    gc.setFill(getPieceColor(tetromino.getColor()));
                    gc.fillRect(
                            (tetromino.getX() + col) * CELL_SIZE,
                            (tetromino.getY() + row) * CELL_SIZE,
                            CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }

    private Color getPieceColor(int colorId) {
        return switch (colorId) {
            case 1 -> Color.CYAN;
            case 2 -> Color.YELLOW;
            case 3 -> Color.PURPLE;
            case 4 -> Color.ORANGE;
            case 5 -> Color.BLUE;
            case 6 -> Color.GREEN;
            case 7 -> Color.RED;
            default -> Color.WHITE;
        };
    }

    public void renderGameOver(int score) {
        gc.setFill(Color.rgb(0, 0, 0, 0.7));
        gc.fillRect(0, 0, 300, 600);
        gc.setFill(Color.WHITE);
        gc.setFont(javafx.scene.text.Font.font(24));
        gc.fillText("GAME OVER", 70, 280);
        gc.setFont(javafx.scene.text.Font.font(16));
        gc.fillText("Score : " + score, 100, 320);
    }
}
