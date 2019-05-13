package com.epam.belote.bonus;

import com.epam.belote.cards.CardComparator;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.max;
import static java.util.Collections.unmodifiableList;

/**
 * The Sequence bonus is declared when the player has a sequence of three or more cards of the same suit, for example Jack, Queen and King of Spades
 */
public class Sequence implements Bonus {
    private final CardSuit suit;
    private final List<CardType> cards;

    public Sequence(CardSuit suit, List<CardType> cards) {
        this.suit = suit;
        this.cards = unmodifiableList(cards);
    }

    public CardSuit getSuit() {
        return suit;
    }

    public List<CardType> getCards() {
        return cards;
    }

    public int getBonus() {

        switch (cards.size()) {
            case 3:
                return 20;
            case 4:
                return 50;
                default:
                    return 100;
        }
        // returns 20 for 3 cards sequence
        // returns 50 for 4 cards sequence
        // return 100 for 5 or more cards sequence

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sequence sequence = (Sequence) o;
        return suit == sequence.suit &&
                Objects.equals(cards, sequence.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, cards);
    }
}
