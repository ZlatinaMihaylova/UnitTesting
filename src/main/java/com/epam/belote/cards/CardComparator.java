package com.epam.belote.cards;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {


    public int compare(Card card1, Card card2) {
        if ( card1.getSuit().equals(card2.getSuit())) {
            return card1.getType().getSequencePosition() - card2.getType().getSequencePosition();
        }
        return card1.getSuit().compareTo(card2.getSuit());
    }


}
