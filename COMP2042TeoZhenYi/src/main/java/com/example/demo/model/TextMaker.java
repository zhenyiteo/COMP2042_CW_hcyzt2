package com.example.demo.model;
import com.example.demo.GameScene;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *creating text model in cell
 * @author zhen yi teo-modified
 */
public class TextMaker {
    private static TextMaker singleInstance = null;

    private TextMaker() {

    }

    /**
     * @return single instance
     */
    public static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    /**
     * creating text model
     * @param input string containing input
     * @param xCell double containing xCell
     * @param yCell double containing yCell
     * @param root Group containing root
     * @return Text representing text
     */
    public Text madeText(String input, double xCell, double yCell, Group root) {
        double length = GameScene.getLENGTH();
        double fontSize = (3 * length) / 7.0;
        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (1.2)* length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.WHITE);

        return text;
    }

    /**
     * changing of two text
     * @param first Text containing first text
     * @param second Text containing second text
     */
    static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);
    }

}