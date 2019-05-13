package com.epam.belote;

import com.epam.belote.cards.Card;
import com.epam.belote.game.Game;

import java.util.LinkedList;
import java.util.List;

public class Team {

    public static final int WINNING_SCORE = 151;

    private String name;
    private PlayerImpl firstPlayer;
    private PlayerImpl secondPlayer;
    private int score = 0;
    private List<Card> takenCards  = new LinkedList<Card>();

    public Team(String name) {
        this.name = name;
        this.firstPlayer = new PlayerImpl(name + " - first player");
        this.secondPlayer = new PlayerImpl(name + " - second player");
    }

    public void addScore(Bid bid) {
        int roundScore = 0;
        for ( Card card : takenCards) {
            if ( bid.equals(Bid.ALL_TRUMPS)) {
                roundScore += card.getCardPoints(card.getSuit());
            }
            else {
                roundScore += card.getCardPoints(bid.getSuit());
            }
        }
        score += roundScore / 10;
    }

    public List<Card> returnCardsInDeck() {
        List<Card> cards = new LinkedList<Card>();
        cards.addAll(takenCards);
        takenCards.clear();
        return cards;
    }



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
