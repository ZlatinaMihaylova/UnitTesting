package com.epam.belote;

import com.epam.belote.cards.CardSuit;

public enum Bid {
    PASS(null,1),
    CLUBS_TRUMP(CardSuit.CLUBS,2),
    DIAMONDS_TRUMP(CardSuit.DIAMONDS,3),
    HEARTS_TRUMP(CardSuit.HEARTS,4),
    SPADES_TRUMP(CardSuit.SPADES,5),
    NO_TRUMPS(null,6),
    ALL_TRUMPS(null,7);

    private CardSuit suit;
    private int strength;

    Bid(CardSuit suit, int strength) {
        this.suit = suit;
        this.strength = strength;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int getStrength() {
        return strength;
    }
}
