package com.wishtris.game;

public class GameState {
    private int score = 0;
    private int totalLines = 0;
    private boolean gameOver = false;

    public void addLines(int lines) {
        totalLines += lines;
        score += switch (lines) {
            case 1 -> 100;
            case 2 -> 300;
            case 3 -> 500;
            case 4 -> 800;
            default -> 0;
        };
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver() {
        gameOver = true;
    }

    public void reset() {
        score = 0;
        totalLines = 0;
        gameOver = false;
    }
}