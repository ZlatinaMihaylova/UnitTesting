package com.epam.belote.game;

import com.epam.belote.Bid;
import com.epam.belote.CardDealer;
import com.epam.belote.PlayerImpl;
import com.epam.belote.Team;
import com.epam.belote.cards.Deck;

import java.util.LinkedList;
import java.util.List;

public class Game implements CardDealer {

    private static Game instance = null;

    private Team firstTeam;
    private Team secondTeam;
    private final List<PlayerImpl> playersPositions = new LinkedList<PlayerImpl>();
    private Deck deck;

    private PlayerImpl playerUnderHand;
    private Bid currentBid;
    private boolean hasValat;

    private Game() {
        this.firstTeam = new Team("Team 1");
        this.secondTeam = new Team("Team 2");
        setPlayersPositions();
        this.deck = new Deck();

        this.playerUnderHand = firstTeam.getFirstPlayer();
    }

    public static Game getInstance() {
        if ( Game.instance == null) {
            Game.instance = new Game();
        }
        return Game.instance;
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
        if ( (firstTeam.hasWinningScore() || secondTeam.hasWinningScore()) && !hasValat) {
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

    public void placeBids() {
        PlayerImpl nextPlayer = playerUnderHand;
        for (int playerCount = 0; playerCount < 4; playerCount ++) {
            Bid bid = nextPlayer.bid();

            if ( bid.getStrength() > currentBid.getStrength()) {
                currentBid = bid;
            }

            nextPlayer = getPlayerInNextPosition(playerUnderHand);
        }
    }

    @Override
    public void deal3Cards() {
        if (!currentBid.equals(Bid.PASS)) {
            dealNumberOfCards(3);
        }
    }

    public void nextRound() {
        this.playerUnderHand = getPlayerInNextPosition(playerUnderHand);
        if ( currentBid.equals(Bid.PASS)) {
            PlayerImpl nextPlayer = playerUnderHand;
            for (int playerCount = 0; playerCount <4; playerCount ++) {
                deck.addCardsBack(nextPlayer.returnCardsInDeck());
                nextPlayer = getPlayerInNextPosition(playerUnderHand);
            }
        } else {
            firstTeam.addScore(currentBid);
            deck.addCardsBack(firstTeam.returnCardsInDeck());

            secondTeam.addScore(currentBid);
            deck.addCardsBack(secondTeam.returnCardsInDeck());

        }
        this.currentBid = Bid.PASS;
    }

    public void setHasValat(boolean hasValat){
        this.hasValat = hasValat;
    }
}
