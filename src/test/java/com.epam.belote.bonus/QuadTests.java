package com.epam.belote.bonus;

import com.epam.belote.cards.CardType;

import org.junit.Assert;
import org.junit.Test;

public class QuadTests {

    @Test
    public void quadWithJacks(){
        Assert.assertEquals(200,new Quad(CardType.JACK).getBonus());
    }

    @Test
    public void quadWithNines(){
        Assert.assertEquals(150,new Quad(CardType.NINE).getBonus());
    }

    @Test
    public void quadWithQueens(){
        Assert.assertEquals(100,new Quad(CardType.QUEEN).getBonus());
    }

}
