package com.codingkata;

import static java.util.stream.Collectors.toList;

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
    return cardSet.size() == cardSetSize
           && (cardSet.contains(JOKER_CARD)
               || cardSet.stream().distinct().collect(toList()).size() != 2);
  }
}
