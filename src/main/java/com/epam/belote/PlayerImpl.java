package com.epam.belote;

import com.epam.belote.bonus.Bonus;
import com.epam.belote.bonus.Quad;
import com.epam.belote.bonus.Sequence;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardComparator;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import com.epam.belote.game.Game;

import java.time.temporal.Temporal;
import java.util.*;

public class PlayerImpl implements Player{


    private Team team;
    private List<Card> playerCards = new ArrayList<Card>();
    private String name;

    public PlayerImpl(String name) {
        this.name = name;
    }

    public void addCards(List<Card> cards) {
        this.playerCards.addAll(cards);
    }


    public Set<Bonus> returnSequences() {
        Set<Bonus> bonuses = new HashSet<Bonus>();

        Collections.sort(playerCards, new CardComparator());
        System.out.println(getPlayerCards().toString() );
        List<CardType> cards = new LinkedList<>();

        cards.add(playerCards.get(0).getType());
        for (int cardPosition = 1; cardPosition < playerCards.size(); cardPosition ++ ) {
            Card previousCard = playerCards.get(cardPosition - 1);
            Card currentCard = playerCards.get(cardPosition);

            if (previousCard.getType().getSequencePosition() + 1 != currentCard.getType().getSequencePosition() ||
                    !previousCard.getSuit().equals(currentCard.getSuit())) {
                if ( cards.size() > 2 ) {
                    bonuses.add(new Sequence(playerCards.get(cardPosition).getSuit(), cards ));
                }
                cards.clear();
            }
            cards.add(playerCards.get(cardPosition).getType());

            if ( cardPosition == playerCards.size() - 1 && cards.size() > 2) {
                bonuses.add(new Sequence(playerCards.get(cardPosition).getSuit(), cards ));
            }
        }
        return bonuses;
    }

    public Set<Bonus> returnQuads() {
        Set<Bonus> bonuses = new HashSet<Bonus>();

        Map<CardType, Integer> cardTypeCounter = new HashMap<CardType, Integer>();

        for (Card card : playerCards) {
            if (cardTypeCounter.containsKey(card.getType())) {
                cardTypeCounter.put(card.getType(),cardTypeCounter.get(card.getType()) + 1);
            }
            else {
                cardTypeCounter.put(card.getType(), 1);
            }
        }

        for (Map.Entry<CardType, Integer> entry : cardTypeCounter.entrySet()) {
            if (entry.getValue().equals(4)) {
                bonuses.add(new Quad(entry.getKey()));
            }
        }
        return bonuses;
    }



    @Override
    public Set<Bonus> declareBonus() {
        Set<Bonus> bonuses = new HashSet<Bonus>();
        bonuses.addAll(returnQuads());
        bonuses.addAll(returnSequences());
        return bonuses;
    }

    public int calculateBonusPoints() {
        if ( declareBonus().size() == 0){
            return 0;
        }
        return declareBonus().stream().map(Bonus::getBonus).reduce(Integer::sum).get();
    }

    @Override
    public Card playCard(Card card) {
        if ( playerCards.contains(card)) {
            playerCards.remove(card);
            return card;
        }
        return null;
    }

    public List<Card> returnCardsInDeck() {
        List<Card> cards = new LinkedList<Card>();
        cards.addAll(playerCards);
        playerCards.clear();
        return cards;
    }

    @Override
    public Bid bid() {
        return Bid.values()[new Random().nextInt(7)];
    }

    public List<Card> getPlayerCards() {
        return playerCards;
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
