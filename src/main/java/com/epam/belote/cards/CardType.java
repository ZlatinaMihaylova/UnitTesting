package com.epam.belote.cards;

public enum CardType {

    SEVEN(1),
    EIGHT(2),
    NINE(3),
    TEN(4),
    JACK(5),
    QUEEN(6),
    KING(7),
    ACE(8);

    private int sequencePosition;

    CardType(int sequencePosition) {
        this.sequencePosition = sequencePosition;
    }

    public int getSequencePosition() {
        return sequencePosition;
    }
}
