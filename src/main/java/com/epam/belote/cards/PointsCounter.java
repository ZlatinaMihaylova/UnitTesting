package com.epam.belote.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointsCounter {

    private List<Card> teamCards;

    PointsCounter(List<Card> teamCards) {
        this.teamCards = teamCards;
    }

    public int calculateTeamPoints(final CardSuit trump) {
        return teamCards.stream().map(card -> card.getCardPoints(trump)).reduce((a,b) -> a+b).get();
    }

    public static void main(String[] args) {
        List<Card> list = Arrays.asList(new Card(CardType.JACK,CardSuit.DIAMONDS),(new Card(CardType.QUEEN,CardSuit.DIAMONDS)));
        System.out.println(new PointsCounter(list).calculateTeamPoints(CardSuit.DIAMONDS));

    }
}
