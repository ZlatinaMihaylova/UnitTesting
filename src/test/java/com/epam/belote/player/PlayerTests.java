package com.epam.belote.player;

import com.epam.belote.Player;
import com.epam.belote.PlayerImpl;
import com.epam.belote.bonus.Bonus;
import com.epam.belote.bonus.Quad;
import com.epam.belote.bonus.Sequence;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PlayerTests {

    @Test
    public void addCards() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES)));

        PlayerImpl player = new PlayerImpl("");
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

        PlayerImpl player = new PlayerImpl("");
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

        PlayerImpl player = new PlayerImpl("");
        player.addCards(cards);
        Assert.assertTrue(player.returnQuads().contains(result));
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

        PlayerImpl player = new PlayerImpl("");
        player.addCards(cards);
        player.returnCardsInDeck();
        Assert.assertTrue(player.getPlayerCards().isEmpty());
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

        PlayerImpl player = new PlayerImpl("");
        player.addCards(cards);
        Assert.assertEquals(2, player.declareBonus().size());
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

        PlayerImpl player = new PlayerImpl("");
        player.addCards(cards);
        Assert.assertEquals(300,player.calculateBonusPoints());
    }

    @Test
    public void calculateBonusPointsSequenceTest() {
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

        PlayerImpl player = new PlayerImpl("");
        player.addCards(cards);
        Assert.assertEquals(40,player.calculateBonusPoints());
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

        PlayerImpl player = new PlayerImpl("");
        player.playCard(new Card(CardType.QUEEN, CardSuit.HEARTS));
        Assert.assertFalse(player.getPlayerCards().contains(new Card(CardType.QUEEN, CardSuit.HEARTS)));
    }
}
