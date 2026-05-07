package com.wishtris.model;

public class Tetromino {
    private TetrominoShape shape;
    private int x;
    private int y;
    private int color;

    public Tetromino(TetrominoShape shape, int color) {
        this.shape = shape;
        this.color = color;
        this.x = 3; 
        this.y = 0; 
    }
}
