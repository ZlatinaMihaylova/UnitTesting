package com.epam.belote.cards;

import com.epam.belote.bonus.Quad;
import org.junit.Assert;
import org.junit.Test;

public class DeckTests {

    @Test
    public void deckCreationSize(){
        Assert.assertEquals(32, Deck.getInstance().getCards().size());
    }

    @Test
    public void checkAllCardsAreDifferent(){

    }

}
