package com.epam.belote.game;

import com.epam.belote.Bid;
import com.epam.belote.Player;
import com.epam.belote.PlayerImpl;
import com.epam.belote.Team;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.Deck;

import java.util.*;

public class Game {

    private static Game instance = null;

    private Team firstTeam;
    private Team secondTeam;
    private final List<PlayerImpl> playersPositions = new LinkedList<PlayerImpl>();
    private Deck deck;

    private List<Round> rounds = new ArrayList<>();

    Game(Team firstTeam,Team secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        setPlayersPositions();
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

}
