package com.wishtris.game;

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
}
