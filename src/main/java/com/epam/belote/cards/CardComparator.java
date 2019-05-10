package com.epam.belote.cards;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    private CardSuit trump;

    CardComparator(CardSuit trump) {
        this.trump = trump;
    }

    public int compare(Card card1, Card card2) {
        return card1.getCardPoints(trump) - card2.getCardPoints(trump);
    }


}
