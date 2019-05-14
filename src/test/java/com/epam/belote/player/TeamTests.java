package com.epam.belote.player;

import com.epam.belote.Bid;
import com.epam.belote.Team;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamTests {

    Team team;

    @Before
    public void initialize() {
        team = new Team("");
    }

    @Test
    public void roundScoreDownAllTrumpsTest() {
        Assert.assertEquals(12, Team.roundScore(124, Bid.ALL_TRUMPS));
    }

    @Test
    public void roundScoreUpAllTrumpsTest() {
        Assert.assertEquals(13, Team.roundScore(125, Bid.ALL_TRUMPS));
    }

    @Test
    public void roundScoreDownNoTrumpsTest() {
        Assert.assertEquals(12, Team.roundScore(125, Bid.NO_TRUMPS));
    }

    @Test
    public void roundScoreUpNoTrumpsTest() {
        Assert.assertEquals(13, Team.roundScore(126, Bid.NO_TRUMPS));
    }

    @Test
    public void roundScoreDownClubsTrumpsTest() {
        Assert.assertEquals(12, Team.roundScore(126, Bid.CLUBS_TRUMP));
    }

    @Test
    public void roundScoreUpClubsTrumpsTest() {
        Assert.assertEquals(13, Team.roundScore(127, Bid.CLUBS_TRUMP));
    }

    @Test
    public void calculateAllTrumpsScore() {
        List<Card> cards = new ArrayList<Card>(
            Arrays.asList(
                    new Card(CardType.QUEEN, CardSuit.SPADES),
                    new Card(CardType.SEVEN, CardSuit.HEARTS),
                    new Card(CardType.ACE, CardSuit.HEARTS),
                    new Card(CardType.JACK, CardSuit.CLUBS)));
        team.takeCards(cards);
        Assert.assertEquals(34,team.calculateScore(Bid.ALL_TRUMPS));
    }

    @Test
    public void calculateNoTrumpsScore() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.ACE, CardSuit.HEARTS),
                        new Card(CardType.JACK, CardSuit.CLUBS)));
        team.takeCards(cards);
        Assert.assertEquals(16,team.calculateScore(Bid.NO_TRUMPS));
    }

    @Test
    public void calculateClubsTrumpScore() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.ACE, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.CLUBS)));
        team.takeCards(cards);
        Assert.assertEquals(34,team.calculateScore(Bid.CLUBS_TRUMP));
    }

    @Test
    public void addScoreTest() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.ACE, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.CLUBS)));
        team.takeCards(cards);
        team.addScore(Bid.CLUBS_TRUMP);
        Assert.assertEquals(3, team.getScore());
    }

    @Test
    public void addScoreNoTrumpsTest() {
        List<Card> cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(CardType.QUEEN, CardSuit.SPADES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.ACE, CardSuit.SPADES),
                        new Card(CardType.JACK, CardSuit.CLUBS)));
        team.takeCards(cards);
        team.addScore(Bid.NO_TRUMPS);
        Assert.assertEquals(2, team.getScore());
    }

}
