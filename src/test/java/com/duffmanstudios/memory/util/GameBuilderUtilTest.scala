package com.duffmanstudios.memory.util

import com.duffmanstudios.memory.ProjectTest

/**
 * Unit tests for game creation utility methods in GameBuilderUtil
 *
 * @author Iain Duff
 */
class GameBuilderUtilTest extends ProjectTest {

  "generateGameCards" should "create a card array of the given size" in {
    GameBuilderUtil.generateGameCards(5).length should equal (5)
    GameBuilderUtil.generateGameCards(3).length should equal (3)
  }

  "generateGameCards" should "create an array of cards whose numbers ascend from 1 to the total number of cards" in {
    val numCards = 3
    val cards = GameBuilderUtil.generateGameCards(numCards)

    cards(0).Id should equal (1)
    cards(1).Id should equal (2)
    cards(2).Id should equal (3)
  }

  "generatePlayers" should "create an array of players of the given size" in {
    GameBuilderUtil.generatePlayers(2).length should equal (2)
    GameBuilderUtil.generatePlayers(4).length should equal (4)
  }

  "generatePlayers" should "create an array of players whose numbers ascend from 1 to the total number of players" in {
    val numPlayers = 2
    val players = GameBuilderUtil.generatePlayers(numPlayers)

    players(0).number should equal (1)
    players(1).number should equal (2)
  }
}
