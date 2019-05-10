package com.epam.belote.bonus;

import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceTests {
    @Test
    public void sequenceWith3Cards(){
        List<CardType> cardList = new ArrayList<CardType>(
                Arrays.asList(CardType.JACK,CardType.QUEEN,CardType.KING));

        Assert.assertEquals(20,new Sequence(CardSuit.DIAMONDS, cardList).getBonus());
    }

    @Test
    public void sequenceWith4Cards(){
        List<CardType> cardList = new ArrayList<CardType>(
                Arrays.asList(CardType.JACK,CardType.QUEEN,CardType.KING,CardType.ACE));

        Assert.assertEquals(50,new Sequence(CardSuit.DIAMONDS, cardList).getBonus());
    }

    @Test
    public void sequenceWith5Cards(){
        List<CardType> cardList = new ArrayList<CardType>(
                Arrays.asList(CardType.TEN,CardType.JACK,CardType.QUEEN,CardType.KING,CardType.ACE));

        Assert.assertEquals(100,new Sequence(CardSuit.DIAMONDS, cardList).getBonus());
    }

}
