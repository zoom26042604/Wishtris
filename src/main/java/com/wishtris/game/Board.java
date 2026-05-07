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
        int[][] shape = tetromino.getShape().getShape();
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
        int[][] shape = tetromino.getShape().getShape();
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
}
