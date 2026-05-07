package com.wishtris.ui;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SidePanel extends VBox {
    private final Text scoreText;
    private final Text levelText;

    public SidePanel() {
        this.setSpacing(10);
        this.setStyle("-fx-padding: 10; -fx-background-color: #1a1a1a;");

        scoreText = new Text("Score: 0");
        scoreText.setStyle("-fx-fill: white; -fx-font-size: 16;");

        levelText = new Text("Niveau: 1");
        levelText.setStyle("-fx-fill: white; -fx-font-size: 16;");

        this.getChildren().addAll(scoreText, levelText);
    }

    public void update(int score, int level) {
        scoreText.setText("Score: " + score);
        levelText.setText("Niveau: " + level);
    }
}