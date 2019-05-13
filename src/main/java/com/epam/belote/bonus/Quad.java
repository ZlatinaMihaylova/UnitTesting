package com.epam.belote.bonus;

import com.epam.belote.cards.CardType;

import java.util.Objects;

/**
 * A Quad bonus is declared whenever the player has 4 cards of the same type, e.g. four Kings
 */
public class Quad implements Bonus {
    private final CardType cardType;

    public Quad(CardType cardType) {
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public int getBonus() {
        switch (cardType) {
            case JACK:
                return 200;
            case NINE:
                return 150;
                default:
                    return 100;
        }
        // returns 200 when the player has 4 Jacks
        // returns 150 when the player has 4 nines
        // returns 100 when the player has 4 tens, queens, kings or aces
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quad quad = (Quad) o;
        return cardType == quad.cardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType);
    }
}
