package com.codingkata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * Created by pswiatowski on 1/29/18.
 */
public class CardsTests {

  public static final String HORSEMAN_CARD = "H";
  public static final String JOKER_CARD = "J";
  private static final String CANNON_CARD = "C";
  private static final String SOLDIER_CARD = "S";

  private int cardSetSize;

  @Before
  public void setUp() throws Exception {
    cardSetSize = 3;
  }

  @Test
  public void setsShouldContainThreeCards() throws Exception {

    ArrayList<String> cardSetList = Lists.newArrayList(HORSEMAN_CARD, HORSEMAN_CARD, JOKER_CARD);

    CardSet cardSet = new CardSet(cardSetList, cardSetSize);

    boolean isValid = cardSet.isValid();

    assertThat(isValid).isEqualTo(true);
  }

  @Test
  public void setsShouldNotContainTwoCards() throws Exception {
    CardSet cardSet = new CardSet(Lists.newArrayList(HORSEMAN_CARD, JOKER_CARD), cardSetSize);

    boolean isValid = cardSet.isValid();

    assertThat(isValid).isEqualTo(false);
  }

  @Test
  public void isValidShouldReturnTrueWhenSetContainsThreeHorsemanCards() throws Exception {

    CardSet cardSet = new CardSet(Lists.newArrayList(HORSEMAN_CARD, HORSEMAN_CARD, HORSEMAN_CARD), cardSetSize);

    boolean isValid = cardSet.isValid();

    assertThat(isValid).isEqualTo(true);

  }

  @Test
  public void isValidShouldReturnFalseWhenSetContainsTwoOfTheSameAndOneDifferent() throws Exception {

    String sameCard = HORSEMAN_CARD;
    String differentCard = CANNON_CARD;
    CardSet cardSet = new CardSet(Lists.newArrayList(sameCard, sameCard, differentCard), cardSetSize);

    boolean isValid = cardSet.isValid();

    assertThat(isValid).isEqualTo(false);

  }

  @Test
  public void isValidShouldReturnFalseWhenSetContainsTwoHorsemenAndOneSoldier() throws Exception {

    String sameCard = HORSEMAN_CARD;
    String differentCard = SOLDIER_CARD;
    CardSet cardSet = new CardSet(Lists.newArrayList(sameCard, sameCard, differentCard), cardSetSize);

    boolean isValid = cardSet.isValid();

    assertThat(isValid).isEqualTo(false);

  }

  @Test
  public void isValidShouldReturnTrueWhenSetContainsTwoSameAndOneJoker() throws Exception {
    String sameCard = SOLDIER_CARD;
    String jokerCard = JOKER_CARD;

    CardSet cardSet = new CardSet(Lists.newArrayList(sameCard, sameCard, jokerCard), cardSetSize);

    boolean isValid = cardSet.isValid();

    assertThat(isValid).isEqualTo(true);
  }

  @Test
  public void isValidShouldReturnTrueWhenSetContainsThreeDifferentCards() throws Exception {
    String sameCard = SOLDIER_CARD;

    CardSet cardSet = new CardSet(Lists.newArrayList(sameCard, HORSEMAN_CARD, CANNON_CARD), cardSetSize);

    boolean isValid = cardSet.isValid();

    assertThat(isValid).isEqualTo(true);
  }

  @Test
  public void isValidShouldReturnTrueWhenSetContainsThreeSoldiers() throws Exception {
    String sameCard = SOLDIER_CARD;

    CardSet cardSet = new CardSet(Lists.newArrayList(sameCard, sameCard, sameCard), cardSetSize);

    boolean isValid = cardSet.isValid();

    assertThat(isValid).isEqualTo(true);
  }

  @Test
  public void isValidShouldReturnTrueWhenSetContainsThreeCannons() throws Exception {
    String sameCard = CANNON_CARD;

    CardSet cardSet = new CardSet(Lists.newArrayList(sameCard, sameCard, sameCard), cardSetSize);

    boolean isValid = cardSet.isValid();

    assertThat(isValid).isEqualTo(true);
  }
}
