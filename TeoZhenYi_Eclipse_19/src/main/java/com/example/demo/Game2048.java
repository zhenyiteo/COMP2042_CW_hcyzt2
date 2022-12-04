package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import java.util.Scanner;

import com.example.demo.controller.StartGameController;

/**
 * @author zhen yi teo-modified
 * @version 1.0
 * @since 1.0
 * refactoring by renaming main class into Game2048
 * represent the 2048 application
 */
public class Game2048 extends Application {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 900;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(getGameRoot(), 200, 200, Color.rgb(189, 177, 92));

    private static final Scanner input = new Scanner(System.in);

    public Button button;

    public Group getGameRoot() {
        return gameRoot;
    }

    public Scene getGameScene() {
        return gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    /**
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("2048 in Java Fx"); // title of the window

        gameRoot = new Group();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/startGame.fxml"));
        Parent root_n = loader.load();
        StartGameController controller = loader.getController();
        controller.setRoot(gameRoot);
        controller.setStage(primaryStage);

        Scene start = new Scene(root_n);
        primaryStage.setScene(start);
        primaryStage.show();
    }

    /**
     * game main class
     */
    public static void main(String[] args) {
        Application.launch(Game2048.class, args);
    }
}