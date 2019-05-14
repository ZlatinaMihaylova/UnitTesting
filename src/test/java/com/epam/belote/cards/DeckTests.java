package com.epam.belote.cards;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeckTests {

    Deck deck;

    @Before
    public void initialize() {
        deck = new Deck();
    }

    @Test
    public void deckCreationSize(){
        Deck deck = new Deck();
        Assert.assertEquals(32, deck.getCards().size());
    }

    @Test
    public void checkAllCardsAreDifferent(){
        boolean sameCardTwice = false;

        for ( int checkingCard = 0; checkingCard < deck.getCards().size() - 1; checkingCard ++) {
            for ( int secondCard = checkingCard + 1; secondCard < deck.getCards().size(); secondCard ++) {
                if (deck.getCards().get(checkingCard).equals(deck.getCards().get(secondCard))) {
                    sameCardTwice = true;
                }
            }
        }
        Assert.assertFalse(sameCardTwice);
    }

    @Test
    public void takeOneCard(){
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.SEVEN, CardSuit.CLUBS)));

        Assert.assertEquals(cards, deck.takeNCards(1));
    }

    @Test
    public void takeFirstTreeCardsCards(){
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.SEVEN, CardSuit.CLUBS),
                        new Card(CardType.SEVEN, CardSuit.DIAMONDS),
                        new Card(CardType.SEVEN, CardSuit.HEARTS)));

        Assert.assertEquals(cards, deck.takeNCards(3));
    }

    @Test
    public void takeFirstTreeCardsCardsAgain(){
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.SEVEN, CardSuit.CLUBS),
                        new Card(CardType.SEVEN, CardSuit.DIAMONDS),
                        new Card(CardType.SEVEN, CardSuit.HEARTS)));

        deck.takeNCards(3);
        Assert.assertEquals(29, deck.getCards().size());
    }

    @Test
    public void addCardsBackTest(){
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

        deck.takeNCards(32);
        deck.addCardsBack(cards);
        Assert.assertEquals(8,deck.getCards().size());
    }

    @Test
    public void testShuffle() {
        deck.shuffle();
        Assert.assertFalse(deck.getCards().equals(new Deck().getCards()));
    }

    @Test
    public void testShuffleAllCardsDifferen() {
        deck.shuffle();
        boolean sameCardTwice = false;

        for ( int checkingCard = 0; checkingCard < deck.getCards().size() - 1; checkingCard ++) {
            for ( int secondCard = checkingCard + 1; secondCard < deck.getCards().size(); secondCard ++) {
                if (deck.getCards().get(checkingCard).equals(deck.getCards().get(secondCard))) {
                    sameCardTwice = true;
                }
            }
        }
        Assert.assertFalse(sameCardTwice);
    }

    @Test
    public void testShuffleAllCardsAreInDeck() {
        deck.shuffle();

        Deck testDeck = new Deck();

        Assert.assertTrue(deck.getCards().containsAll(testDeck.getCards()));
    }

    @Test
    public void testCutDeckSize() {
        deck.cut(10);
        Assert.assertEquals(32,deck.getCards().size());
    }

    @Test
    public void testCutDeckException() {
        boolean catchException = false;
        try {
            deck.cut(50);
        }
        catch(IllegalArgumentException e) {
            catchException = true;
        }

        Assert.assertTrue(catchException);
    }

    @Test
    public void testCut() {
        Card card = new Card(CardType.ACE, CardSuit.SPADES);
        deck.cut(31);
        Assert.assertEquals(card, deck.takeCard());
    }

    @Test
    public void testCutAgain() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.ACE, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.CLUBS),
                        new Card(CardType.SEVEN, CardSuit.DIAMONDS)));
        deck.cut(31);
        Assert.assertEquals(cards, deck.takeNCards(3));
    }

    @Test
    public void testCutAllCardsAreInDeck() {
        deck.cut(20);

        Deck testDeck = new Deck();

        Assert.assertTrue(deck.getCards().containsAll(testDeck.getCards()));
    }
}
