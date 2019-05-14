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
    private List<Card> takenCards  = new LinkedList<Card>();

    public Team(String name) {
        this.name = name;
        this.firstPlayer = new PlayerImpl(name + " - first player");
        this.secondPlayer = new PlayerImpl(name + " - second player");
    }

    public static int roundScore(int score, Bid bid) {
        int roundNumber = 0;
        switch (bid) {
            case ALL_TRUMPS:
                roundNumber = 4;
                break;
            case NO_TRUMPS:
                roundNumber = 5;
                break;
            default:
                roundNumber = 6;
        }

        if (score % 10 > roundNumber) {
            return score / 10 + 1;
        }
        return score / 10;
    }

    public int calculateScore(Bid bid) {
        int currentRoundScore = 0;
        for ( Card card : takenCards) {
            if ( bid.equals(Bid.ALL_TRUMPS)) {
                currentRoundScore += card.getCardPoints(card.getSuit());
            }
            else {
                currentRoundScore += card.getCardPoints(bid.getSuit());
            }
        }
        return currentRoundScore;
    }

    public void addScore(Bid bid) {
        this.score += roundScore(calculateScore(bid), bid);
    }

    public List<Card> returnCardsInDeck() {
        List<Card> cards = new LinkedList<Card>();
        cards.addAll(takenCards);
        takenCards.clear();
        return cards;
    }

    public void takeCards(List<Card> cards) {
        this.takenCards.addAll(cards);
    }

    public int getScore() {
        return score;
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
