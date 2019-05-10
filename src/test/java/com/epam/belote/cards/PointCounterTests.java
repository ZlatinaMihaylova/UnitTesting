package com.epam.belote.cards;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PointCounterTests {

    @Test
    public void JackAndQueen(){
        List<Card> list = Arrays.asList(new Card(CardType.JACK,CardSuit.DIAMONDS),(new Card(CardType.QUEEN,CardSuit.DIAMONDS)));
        Assert.assertEquals(5,new PointsCounter(list).calculateTeamPoints(CardSuit.CLUBS));
    }

    @Test
    public void JackAndQueenTrumps(){
        List<Card> list = Arrays.asList(new Card(CardType.JACK,CardSuit.DIAMONDS),(new Card(CardType.QUEEN,CardSuit.DIAMONDS)));
        Assert.assertEquals(23,new PointsCounter(list).calculateTeamPoints(CardSuit.DIAMONDS));
    }


}
