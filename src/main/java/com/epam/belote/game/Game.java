package com.epam.belote.game;

import com.epam.belote.*;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.Deck;

import java.util.*;

public class Game implements CardDealer {

    private Team firstTeam;
    private Team secondTeam;
    private final List<PlayerImpl> playersPositions = new LinkedList<PlayerImpl>();
    private Deck deck;

    private PlayerImpl playerUnderHand;

    private List<Round> rounds = new ArrayList<>();

    Game() {
        this.firstTeam = new Team("Team 1");
        this.secondTeam = new Team("Team 2");
        setPlayersPositions();
        this.deck = new Deck();

        this.playerUnderHand = firstTeam.getFirstPlayer();
    }

    void setPlayersPositions() {
        playersPositions.add(firstTeam.getFirstPlayer());
        playersPositions.add(secondTeam.getFirstPlayer());
        playersPositions.add(firstTeam.getSecondPlayer());
        playersPositions.add(secondTeam.getSecondPlayer());
    }

    PlayerImpl getPlayerInNextPosition(PlayerImpl player) {
        if (playersPositions.indexOf(player) < 3)  {
            return playersPositions.get(playersPositions.indexOf(player) + 1);
        }
        else {
            return playersPositions.get(0);
        }
    }

    public boolean checkForWinning() {
        if ( (firstTeam.hasWinningScore() || secondTeam.hasWinningScore()) && !rounds.get(rounds.size() - 1).isValat()) {
            return true;
        }
        return false;
    }

    private void dealNumberOfCards(int cardsNumber) {
        PlayerImpl nextPlayer = playerUnderHand;
        for (int playerCount = 0; playerCount <4; playerCount ++) {
            nextPlayer.addCards(deck.takeNCards(cardsNumber));
            nextPlayer = getPlayerInNextPosition(playerUnderHand);
        }
    }

    @Override
    public void deal5Cards() {
        dealNumberOfCards(3);
        dealNumberOfCards(2);
    }

    @Override
    public void deal3Cards() {
        dealNumberOfCards(3);
    }
}
