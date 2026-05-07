package com.wishtris.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SidePanel extends VBox {
    private final Text scoreText;
    private final Button restartButton;
    private Runnable onRestart;

    public SidePanel() {
        this.setSpacing(10);
        this.setStyle("-fx-padding: 10; -fx-background-color: #1a1a1a;");

        scoreText = new Text("Score: 0");
        scoreText.setStyle("-fx-fill: white; -fx-font-size: 16;");

        restartButton = new Button("Rejouer");
        restartButton.setStyle("-fx-font-size: 14; -fx-padding: 10;");
        restartButton.setVisible(false);
        restartButton.setOnAction(e -> {
            if (onRestart != null) {
                onRestart.run();
            }
        });

        this.getChildren().addAll(scoreText, restartButton);
    }

    public void update(int score) {
        scoreText.setText("Score: " + score);
    }

    public void showRestartButton() {
        restartButton.setVisible(true);
    }

    public void hideRestartButton() {
        restartButton.setVisible(false);
    }

    public void setOnRestart(Runnable callback) {
        this.onRestart = callback;
    }
}