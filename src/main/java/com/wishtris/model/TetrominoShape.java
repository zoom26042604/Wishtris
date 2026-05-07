package com.wishtris.model;

public enum TetrominoShape {
    I(new int[][][] {
        {{1, 1, 1, 1}},
        {{1}, {1}, {1}, {1}}
    }),
    O(new int[][][] {
        {{1, 1}, {1, 1}}
    }),
    T(new int[][][] {
        {{0, 1, 0}, {1, 1, 1}},
        {{1, 0}, {1, 1}, {1, 0}},
        {{1, 1, 1}, {0, 1, 0}},
        {{0, 1}, {1, 1}, {0, 1}}
    }),
    L(new int[][][] {
        {{1, 0}, {1, 0}, {1, 1}},
        {{1, 1, 1}, {1, 0, 0}},
        {{1, 1}, {0, 1}, {0, 1}},
        {{0, 0, 1}, {1, 1, 1}}
    }),
    J(new int[][][] {
        {{0, 1}, {0, 1}, {1, 1}},
        {{1, 0, 0}, {1, 1, 1}},
        {{1, 1}, {1, 0}, {1, 0}},
        {{1, 1, 1}, {0, 0, 1}}
    }),
    S(new int[][][] {
        {{0, 1, 1}, {1, 1, 0}},
        {{1, 0}, {1, 1}, {0, 1}}
    }),
    Z(new int[][][] {
        {{1, 1, 0}, {0, 1, 1}},
        {{0, 1}, {1, 1}, {1, 0}}
    });

    private final int[][][] rotations;

    TetrominoShape(int[][][] rotations) {
        this.rotations = rotations;
    }

    public int[][] getRotation(int index) {
        return rotations[index % rotations.length];
    }

    public int getRotationCount() {
        return rotations.length;
    }
}