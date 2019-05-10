package com.epam.belote.cards;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Deck {

    private static Deck deck  = null;
    private List<Card> cards = new ArrayList<Card>();

    private Deck() {
        for (CardType cardType : CardType.values()) {
            for ( CardSuit cardSuit : CardSuit.values()) {
                cards.add( new Card(cardType, cardSuit));
            }
        }
    }

    static Deck getInstance() {
        if ( deck == null) {
            deck = new Deck();
        }
        return deck;
    }

    public Card takeCard() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public List<Card> getCards() {
        return unmodifiableList(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void cut(int cutNumber) throws IllegalArgumentException {
        if ( cutNumber < 0 || cutNumber > 32) {
            throw new IllegalArgumentException("Wrong cut number!");
        }
        for (int cutCount = 0; cutCount < cutNumber; cutCount ++) {
            Card firstCard = cards.get(0);
            for ( int cardNumber = 0; cardNumber < cards.size() - 1; cardNumber ++) {
                cards.set(cardNumber, cards.get(cardNumber + 1));
            }
            cards.set(cards.size() - 1, firstCard);
        }
    }

    public static void main(String[] args) {



    }

}
