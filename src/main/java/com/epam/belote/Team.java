package com.epam.belote;

import com.epam.belote.cards.Card;

import java.util.LinkedList;
import java.util.List;

public class Team {

    public static final int WINNING_SCORE = 151;

    private String name;
    private PlayerImpl firstPlayer;
    private PlayerImpl secondPlayer;
    private int score = 0;

    public Team(String name) {
        this.name = name;
        this.firstPlayer = new PlayerImpl(name + " - first player");
        this.secondPlayer = new PlayerImpl(name + " - second player");
    }

    private List<Card> takenCards  = new LinkedList<Card>();

    public boolean hasWinningScore() {
        return score > WINNING_SCORE;
    }

    public PlayerImpl getFirstPlayer() {
        return firstPlayer;
    }

    public PlayerImpl getSecondPlayer() {
        return secondPlayer;
    }

}
