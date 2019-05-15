package com.epam.belote.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GameTests {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = Game.getInstance();
    }


    @Test
    public void deal5Card() {
        game.deal5Cards();

        Assert.assertEquals(12, game.getDeck().getCards().size());
    }
/*
    @Test
    public void placeBids() throws Exception {
        PlayerImpl player = Mockito.mock(PlayerImpl.class);
        Mockito.when(player.bid()).thenReturn(Bid.CLUBS_TRUMP);
        PowerMockito.whenNew(PlayerImpl.class).withAnyArguments().thenReturn(player);

        Bid expectedBid = Bid.CLUBS_TRUMP;
        Game game = Game.getInstance();
        game.placeBids();
        Assert.assertEquals(expectedBid, game.getCurrentBid());
    }
*/

}
