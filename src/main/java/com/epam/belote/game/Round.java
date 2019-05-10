package com.epam.belote.game;

import com.epam.belote.Bid;

public class Round {

    private final Bid trump;

    Round(Bid trump) {
        this.trump = trump;
    }

    public boolean isValat() {
        return false;
    }
}
