package com.epam.belote.cards;

import org.junit.Assert;
import org.junit.Test;

public class CardTests {

    @Test
    public void  testPointsJackTrump() {
        Card card = new Card(CardType.JACK, CardSuit.SPADES);
        Assert.assertEquals(20, card.getCardPoints(CardSuit.SPADES));
    }

    @Test
    public void  testPointsJackNotTrump() {
        Card card = new Card(CardType.JACK, CardSuit.SPADES);
        Assert.assertEquals(2, card.getCardPoints(CardSuit.DIAMONDS));
    }
}
