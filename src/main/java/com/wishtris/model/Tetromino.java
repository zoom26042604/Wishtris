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

    public TetrominoShape getShape() {
        return shape;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColor() {
        return color;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    private int rotationIndex = 0;

    public int[][] getMatrix() {
        return shape.getRotation(rotationIndex);
    }

    public void rotate() {
        rotationIndex = (rotationIndex + 1) % shape.getRotationCount();
    }
}
