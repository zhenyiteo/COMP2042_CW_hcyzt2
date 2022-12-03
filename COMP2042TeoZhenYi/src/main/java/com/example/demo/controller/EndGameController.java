package com.example.demo.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Account;


/**
 * represent the fxml scene builder for end game scene
 * skeleton for controller class
 * @author zhen yi teo
 * @version 1.0
 * @since 1.0
 */
public class EndGameController {

    @FXML
    private Text nameText1;

    @FXML
    private Text nameText2;

    @FXML
    private Text nameText3;

    @FXML
    private Text nameText4;
    @FXML
    private Text nameText5;

    @FXML
    private Button quitButton;

    @FXML
    private Text scoreText1;

    @FXML
    private Text scoreText2;

    @FXML
    private Text scoreText3;

    @FXML
    private Text scoreText4;
    @FXML
    private Text scoreText5;

    @FXML
    private Text selfScore;



    private Group root;

    private List<Account> playerScore;

    public void setRoot(Group root) {
        this.root = root;
    }

    /**
     * set the player scores
     * @param scores List containing player scores
     */
    public void setPlayerScores(List<Account> scores) {
        this.playerScore = scores;
    }

    /**
     * print the scores at the end game
     * @param score long containing current player scores and five high scores
     */
    public void drawScore(long score) {
        selfScore.setText(Long.toString(score));
        Collections.sort(playerScore);

        nameText1.setText(playerScore.get(0).getUserName());
        scoreText1.setText(Long.toString(playerScore.get(0).getScore()));

        nameText2.setText(playerScore.get(1).getUserName());
        scoreText2.setText(Long.toString(playerScore.get(1).getScore()));

        nameText3.setText(playerScore.get(2).getUserName());
        scoreText3.setText(Long.toString(playerScore.get(2).getScore()));

        nameText4.setText(playerScore.get(3).getUserName());
        scoreText4.setText(Long.toString(playerScore.get(3).getScore()));

        nameText5.setText(playerScore.get(4).getUserName());
        scoreText5.setText(Long.toString(playerScore.get(4).getScore()));
    }

    /**
     * initialize method to call the method for quit game prompt
     */
    public void initialize() {
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    root.getChildren().clear();
                    System.exit(0); // close the program
                }
            }
        });

    }
}