package com.epam.belote.cards;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class Deck {

    private List<Card> cards = new LinkedList<>();

    public Deck() {
        for (CardType cardType : CardType.values()) {
            for ( CardSuit cardSuit : CardSuit.values()) {
                cards.add( new Card(cardType, cardSuit));
            }
        }
    }

    public Card takeCard() {
       Card card = cards.get(0);
       cards.remove(0);
       return card;
    }

    public List<Card> takeNCards(int numberOfCards) {
        List<Card> firstNCards = cards.stream().limit(numberOfCards).collect(Collectors.toList());
        for ( int countCards = 0; countCards <numberOfCards; countCards ++) {
            cards.remove(0);
        }
        return firstNCards;
    }

    public void addCardsBack(List<Card> cards) {
        this.cards.addAll(cards);
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

}
