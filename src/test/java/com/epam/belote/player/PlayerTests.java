package com.epam.belote.player;

import com.epam.belote.Bid;
import com.epam.belote.PlayerImpl;
import com.epam.belote.bonus.Bonus;
import com.epam.belote.bonus.Quad;
import com.epam.belote.bonus.Sequence;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerTests {

    PlayerImpl player;

    @Before
    public void initialize() {
        player = new PlayerImpl("");
    }

    @Test
    public void addCards() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES)));

        player.addCards(cards);
        Assert.assertTrue(player.getPlayerCards().contains(new Card(CardType.QUEEN, CardSuit.SPADES)));
    }

    @Test
    public void returnSequence() {
        Bonus result = new Sequence(CardSuit.SPADES, Arrays.asList(
                CardType.TEN,
                CardType.JACK,
                CardType.QUEEN
        ));

        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.TEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertTrue(player.returnSequences().contains(result));
    }

    @Test
    public void returnQuad() {
        Bonus result = new Quad(CardType.JACK);

        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertTrue(player.returnQuads().contains(result));
    }



    @Test
    public void declareSequenceAndQuad() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertEquals(2, player.declareBonus().size());
    }

    @Test
    public void declareNoBonus() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.EIGHT, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.SEVEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertEquals(0, player.declareBonus().size());
    }

    @Test
    public void calculateBonusPointsQuadTest() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.QUEEN, CardSuit.CLUBS),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.QUEEN, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertEquals(300,player.calculateBonusPoints());
    }

    @Test
    public void calculateBonusPointsTierceAndQuinte() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.TEN, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.DIAMONDS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.KING, CardSuit.SPADES),
                        new Card(CardType.ACE, CardSuit.SPADES)));

        player.addCards(cards);
        Assert.assertEquals(120,player.calculateBonusPoints());
    }

    @Test
    public void calculateBonusPointsQuinteAndQuad() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.TEN, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.TEN, CardSuit.CLUBS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.TEN, CardSuit.HEARTS),
                        new Card(CardType.KING, CardSuit.SPADES),
                        new Card(CardType.ACE, CardSuit.SPADES)));

        player.addCards(cards);
        Assert.assertEquals(200,player.calculateBonusPoints());
    }

    @Test
    public void calculateBonusPointsSequenceTest() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.NINE, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.TEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.CLUBS)));

        player.addCards(cards);
        Assert.assertEquals(20,player.calculateBonusPoints());
    }

    @Test
    public void playCard() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.TEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.CLUBS)));

        player.addCards(cards);
        Card card = player.playCard();
        Assert.assertFalse(player.getPlayerCards().contains(card));
    }

    @Test
    public void playerHasNoCardsThrowingException() {
        boolean thrown = false;

        try {
            player.playCard();
        } catch (IllegalStateException e) {
            thrown = true;
        }

        Assert.assertTrue(thrown);
    }

    @Test
    public void returnCardsInDeck() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.SPADES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.TEN, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.DIAMONDS),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.CLUBS)));

        player.addCards(cards);
        player.returnCardsInDeck();
        Assert.assertTrue(player.getPlayerCards().isEmpty());
    }

    @Test
    public void biding() {
        PlayerImpl player = Mockito.mock(PlayerImpl.class);
        Bid expected = Bid.ALL_TRUMPS;
        Mockito.when(player.bid()).thenReturn(Bid.ALL_TRUMPS);

        Assert.assertEquals(expected,player.bid());
    }
}
