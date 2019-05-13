package com.epam.belote.cards;


public class Card {
    private final CardType type;
    private final CardSuit suit;

    public Card(CardType type, CardSuit suit) {
        this.type = type;
        this.suit = suit;
    }

    public CardType getType() {
        return type;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int getCardPoints(CardSuit trump) {
        if (type == CardType.JACK && suit == trump) {
            return 20;
        }
        if (type == CardType.JACK && suit != trump) {
            return 2;
        }
        if (type == CardType.NINE && suit == trump) {
            return 14;
        }
        if (type == CardType.ACE) {
            return 11;
        }
        if ( type == CardType.TEN) {
            return 10;
        }
        if ( type == CardType.KING) {
            return 4;
        }
        if ( type == CardType.QUEEN) {
            return 3;
        }
        else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return type == card.type &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return type.hashCode() * suit.hashCode();
    }

    @Override
    public String toString() {
        return "Card{" +
                "type=" + type +
                ", suit=" + suit +
                '}';
    }
}
