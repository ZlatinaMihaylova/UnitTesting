package com.epam.belote;

import com.epam.belote.cards.Card;

import java.util.LinkedList;
import java.util.List;

public class Team {

    public static final int WINNING_SCORE = 151;

    private PlayerImpl firstPlayer;
    private PlayerImpl secondPlayer;
    private int score;

    Team(PlayerImpl firstPlayer, PlayerImpl secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
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
