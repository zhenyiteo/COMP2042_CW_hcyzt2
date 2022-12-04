package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.GameScene;
import com.example.demo.model.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * represent the fxml scene builder for start game scene
 * skeleton for controller class
 * @author zhen yi teo
 * @version 1.0
 * @since 1.0
 */
public class StartGameController {
    @FXML
    private TextField usernameText;
    @FXML
    private ComboBox backBox;
    @FXML
    private Button startButton;

    private Group root;
    private Stage primaryStage;

    public void setRoot(Group root) {
        this.root = root;
    }

    public void setStage(Stage stage) {
        this.primaryStage = stage;
    }

    private List<Account> accounts = new ArrayList<>();

    public void initialize() {
        loadScore();

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            //choose colour theme
            public void handle(ActionEvent event) {
                String back = (String) backBox.getValue();
                Color color = Color.WHITE;
                Account o;

                if (back == null)
                    color = Color.WHITE;
                else if (back.equals("pink"))
                    color = Color.PINK;
                //insert username,else username = 'player'
                if (usernameText.getText().length() == 0)
                    o = new Account("player");
                else
                    o = new Account(usernameText.getText());
                //setting the game scene
                accounts.add(o);
                Group gameRoot = root;
                Scene gameScene = new Scene(gameRoot, 900, 700, color);
                primaryStage.setScene(gameScene);
                primaryStage.show();

                GameScene game = new GameScene();
                game.init(gameScene, gameRoot, primaryStage, o, accounts);
            }
        });
    }


    private void loadScore() {
        BufferedReader reader;

        try {
            //get the filePath path of file File
            String filePath = new File("").getAbsolutePath();
            //reading data from the text file
            reader = new BufferedReader(new FileReader(filePath +
                    "/src/main/resources/highscores.txt"));
            String line = reader.readLine();
            while (line != null) {
                String name = line.split(" ", 2)[0];
                String score = line.split(" ", 2)[1];
                Account o = new Account(name);
                o.addToScore(Integer.parseInt(score));
                accounts.add(o);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace(); //help to trace exception
        }
    }
}