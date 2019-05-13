package com.epam.belote.cards;

import com.epam.belote.bonus.Quad;
import org.junit.Assert;
import org.junit.Test;

public class DeckTests {

    @Test
    public void deckCreationSize(){
        Deck deck = new Deck();
        Assert.assertEquals(32, deck.getCards().size());
    }

    @Test
    public void checkAllCardsAreDifferent(){

    }

}
