package com.epam.belote;

public interface CardDealer {
    /**
     * The dealer initially deals 5 cards to each player and waits for the players to bid on trump. If all the players
     * pass then the games does not take place, hence {@link #deal3Cards()} must be never invoked
     */
    public void deal5Cards();

    /**
     * After the players have agreed on on the trump the dealer deals 3 additional cards to each player
     */
    public void deal3Cards();
}
