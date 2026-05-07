package com.wishtris.model;

import java.util.Random;

public class TetrominoFactory {
    private static final Random random = new Random();
    private static final TetrominoShape[] shapes = TetrominoShape.values();

    public static Tetromino createRandom() {
        TetrominoShape shape = shapes[random.nextInt(shapes.length)];
        return new Tetromino(shape, shape.ordinal() + 1);
    }
}