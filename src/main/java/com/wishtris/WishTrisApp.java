package com.wishtris;

import com.wishtris.game.Board;
import com.wishtris.game.GameLoop;
import com.wishtris.model.Tetromino;
import com.wishtris.model.TetrominoFactory;
import com.wishtris.model.TetrominoShape;
import com.wishtris.ui.GameRenderer;
import com.wishtris.ui.SidePanel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WishTrisApp extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(300, 600);
        root.setCenter(canvas);
        SidePanel sidePanel = new SidePanel();
        root.setRight(sidePanel);

        Scene scene = new Scene(root, 385, 600);
        stage.setTitle("Wishtris");
        stage.setScene(scene);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        GameRenderer renderer = new GameRenderer(gc);
        Board board = new Board();
        Tetromino tetromino = TetrominoFactory.createRandom();
        GameLoop gameLoop = new GameLoop(board, tetromino, renderer);
        gameLoop.start();
        stage.show();
    }
}