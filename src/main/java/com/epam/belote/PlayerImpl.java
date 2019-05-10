package com.epam.belote;

import com.epam.belote.bonus.Bonus;
import com.epam.belote.cards.Card;
import com.epam.belote.game.Game;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerImpl implements Player{

    private String name;
    private Team team;
    private Set<Card> playerCards = new HashSet<>();

    public PlayerImpl(String name,Team team) {
        this.name = name;
        this.team = team;
    }

    @Override
    public Bid bid() {
        return null;
    }

    @Override
    public Set<Bonus> declareBonus() {
        return null;
    }

    @Override
    public Card playCard(Card card) {
        if ( playerCards.contains(card)) {
            playerCards.remove(card);
            return card;
        }
        return null;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return name;
    }

}
