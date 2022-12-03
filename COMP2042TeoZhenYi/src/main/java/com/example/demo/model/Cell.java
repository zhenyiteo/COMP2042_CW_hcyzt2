package com.example.demo.model;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * represents the cell class
 * @author zhen yi teo-modified
 */
public class Cell {
    private Rectangle rectangle;
    private Group root;
    private Text textClass;
    private boolean modify = false;

    public Cell(double x, double y, double scale, Group root) {
        setRectangle(new Rectangle());
        getRectangle().setX(x);
        getRectangle().setY(y);
        getRectangle().setHeight(scale);
        getRectangle().setWidth(scale);
        this.setRoot(root);
        getRectangle().setFill(Color.rgb(224, 226, 226, 0.5));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(getRectangle());

    }

    /**
     * get the cell root
     * @return Group representing cell root
     */
    public Group getRoot() {
        return root;
    }

    /**
     * set the cell root
     * @param root Group containing cell root
     */
    public void setRoot(Group root) {
        this.root = root;
    }

    /**
     * get the cell textclass
     * @return Text representing cell textclass
     */
    private Text getTextClass() {
        return textClass;
    }

    /**
     * set the textclass
     * @param textClass Text of the cell textclass
     */
    public void setTextClass(Text textClass) {
        this.textClass = textClass;
    }


    public double getX() {
        return getRectangle().getX();
    }

    public double getY() {
        return getRectangle().getY();
    }

    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }


    public boolean getModify() {
        return !modify;
    }
    public void setModify(boolean modify) {
        this.modify = modify;
    }
    public Rectangle getRectangle() {
        return rectangle;
    }
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * change cell text
     * extract method refactoring for readability
     * @param cell Cell containing cell
     */
    public void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        getRoot().getChildren().remove(cell.getTextClass());
        getRoot().getChildren().remove(textClass);

        final boolean changeCell1 = (!cell.getTextClass().getText().equals("0"));
        final boolean changeCell2 = (!textClass.getText().equals("0"));

        if (changeCell1) {
            getRoot().getChildren().add(cell.getTextClass());
        }
        if (changeCell2) {
            getRoot().getChildren().add(textClass);
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    /**
     * sum of two cell combines
     * @param cell Cell containing cell
     */

    public void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        getRoot().getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }

    /**
     * set the color of cell with different number
     * @param number int containing number
     */
    public void setColorByNumber(int number) {
        switch (number) {
            case 0 -> getRectangle().setFill(Color.rgb(224, 226, 226, 0.5));
            case 2 -> getRectangle().setFill(Color.rgb(232, 255, 100, 0.5));
            case 4 -> getRectangle().setFill(Color.rgb(232, 220, 50, 0.5));
            case 8 -> getRectangle().setFill(Color.rgb(232, 200, 44, 0.8));
            case 16 -> getRectangle().setFill(Color.rgb(232, 170, 44, 0.8));
            case 32 -> getRectangle().setFill(Color.rgb(180, 120, 44, 0.7));
            case 64 -> getRectangle().setFill(Color.rgb(180, 100, 44, 0.7));
            case 128 -> getRectangle().setFill(Color.rgb(180, 80, 44, 0.7));
            case 256 -> getRectangle().setFill(Color.rgb(180, 60, 44, 0.8));
            case 512 -> getRectangle().setFill(Color.rgb(180, 30, 44, 0.8));
            case 1024 -> getRectangle().setFill(Color.rgb(250, 0, 44, 0.8));
            case 2048 -> getRectangle().setFill(Color.rgb(250, 0, 0, 1));
        }

    }



}