package com.example.demo.model;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;

/**
 * represents the highscore account class
 * @author zhen yi teo-modified
 */
public class Account implements Comparable<Account> {

    private long score = 0;
    private String userName;
    private static ArrayList<Account> accounts = new ArrayList<>();

    /**
     *creates player username
     * @param userName The player's name
     */
    public Account(String userName) {
        this.userName = userName;
    }

    /**
     * get player username
     * @return A string represent the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param o the object to be compared.
     * @return  compare
     */
    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

    /**
     * add score
     * @param score the player score
     */
    public void addToScore(long score) {
        this.score = score;
    }

    /**
     * get player score
     * @return a long returning score
     */
    public long getScore() {
        return score;
    }



    static Account accountHaveBeenExist(String userName) {
        for (Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                return account;
            }
        }
        return null;
    }

    static Account makeNewAccount(String userName) {
        Account account = new Account(userName);
        accounts.add(account);
        return account;
    }
}