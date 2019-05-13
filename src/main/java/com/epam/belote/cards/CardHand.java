package com.epam.belote.cards;

import com.epam.belote.Player;
import com.epam.belote.PlayerImpl;

import java.util.Map;
import java.util.TreeMap;

public class CardHand {

    private Map<Card, Player> hand;
    private CardSuit trump;

    CardHand(Map<Card, Player> hand, CardSuit trump) {
        this.hand = new TreeMap<>(new CardComparator());
        this.hand = hand;
        this.trump = trump;
    }

    public void takeHand() {

        Player p = hand.entrySet().stream().sorted().findFirst().get().getValue();
        System.out.println(p);
    }

    public static void main(String[] args) {
        Player p1 = new PlayerImpl("p1");
        Player p2 = new PlayerImpl("p2");
        Player p3 = new PlayerImpl("p3");
        Player p4 = new PlayerImpl("p4");

        CardHand hand = new CardHand(new TreeMap<Card, Player>(){{
            put(new Card(CardType.JACK,CardSuit.DIAMONDS), p1);
            put(new Card(CardType.JACK,CardSuit.CLUBS), p1);
            put(new Card(CardType.JACK,CardSuit.HEARTS), p1);
            put(new Card(CardType.JACK,CardSuit.SPADES), p1);
        }},CardSuit.DIAMONDS);

        hand.takeHand();
    }

}
