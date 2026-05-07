package com.wishtris.game;

import com.wishtris.model.Tetromino;

public class Board {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;

    private final int[][] grid;

    public Board() {
        grid = new int[HEIGHT][WIDTH];
    }

    public int[][] getGrid() {
        return grid;
    }

    public boolean canMove(Tetromino tetromino, int dx, int dy) {
        int[][] shape = tetromino.getMatrix();
        int x = tetromino.getX() + dx;
        int y = tetromino.getY() + dy;

        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (shape[row][col] != 0) {
                    int newX = x + col;
                    int newY = y + row;

                    if (newX < 0 || newX >= WIDTH || newY < 0 || newY >= HEIGHT) {
                        return false;
                    }
                    if (grid[newY][newX] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public void merge(Tetromino tetromino) {
        int[][] shape = tetromino.getMatrix();
        int x = tetromino.getX();
        int y = tetromino.getY();

        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (shape[row][col] != 0) {
                    grid[y + row][x + col] = tetromino.getColor();
                }
            }
        }
    }

    public int clearLines() {
        int linesCleared = 0;
        for (int row = HEIGHT - 1; row >= 0; row--) {
            if (isLineFull(row)) {
                removeLine(row);
                row++;
                linesCleared++;
            }
        }
        return linesCleared;
    }

    private boolean isLineFull(int row) {
        for (int col = 0; col < WIDTH; col++) {
            if (grid[row][col] == 0)
                return false;
        }
        return true;
    }

    private void removeLine(int row) {
        for (int r = row; r > 0; r--) {
            grid[r] = grid[r - 1].clone();
        }
        grid[0] = new int[WIDTH];
    }

    public void reset() {
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                grid[row][col] = 0;
            }
        }
    }
}
