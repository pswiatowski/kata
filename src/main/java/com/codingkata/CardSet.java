package com.codingkata;

import java.util.ArrayList;

/**
 * Created by pswiatowski on 1/29/18.
 */
public class CardSet {

    private static final String SOLDIER_CARD = "S";
    private static final String HORSEMAN_CARD = "H";
    public static final String CANNON_CARD = "C";
    public static final String JOKER_CARD = "J";
    private ArrayList<String> cardSet;
    private int cardSetSize;

    public CardSet(ArrayList<String> cardSet, int cardSetSize) {

        this.cardSet = cardSet;
        this.cardSetSize = cardSetSize;
    }

    public boolean isValid() {
        if (cardSet.size() != cardSetSize)
            return false;

        if (cardSet.contains(JOKER_CARD)) {
            return true;
        }

        boolean threeDifferent = containsThreeDifferentCards();
        if (threeDifferent) {
            return true;
        }

        boolean threeSame = containsThreeSameCards();

        if (threeSame) {
            return true;
        }

        return false;
    }

    private boolean containsThreeSameCards() {
        int i = 0;
        for (; i < cardSetSize - 1; i++) {
            if (!cardSet.get(i).equals(cardSet.get(i + 1)))
                return false;
        }

        return i == cardSetSize - 1;
    }

    private boolean containsThreeDifferentCards() {
        return cardSet.contains(HORSEMAN_CARD) && cardSet.contains(CANNON_CARD) && cardSet.contains(SOLDIER_CARD);
    }
}
