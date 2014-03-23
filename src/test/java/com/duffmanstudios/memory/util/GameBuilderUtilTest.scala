package com.duffmanstudios.memory.util

import com.duffmanstudios.memory.ProjectTest

/**
 * Unit tests for game creation utility methods in GameBuilderUtil
 *
 * @author Iain Duff
 */
class GameBuilderUtilTest extends ProjectTest {

  "createCardsArray" should "create a card array of the given size" in {
    GameBuilderUtil.createGameCardArray(5).length should equal (5)
    GameBuilderUtil.createGameCardArray(3).length should equal (3)
  }

  "createCardsArray" should "create an array of cards whose numbers ascend from 1 to the total number of cards" in {
    val numCards = 3
    val cards = GameBuilderUtil.createGameCardArray(numCards)

    cards(0).Id should equal (1)
    cards(1).Id should equal (2)
    cards(2).Id should equal (3)
  }
}
