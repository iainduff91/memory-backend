package com.duffmanstudios.memory

/**
 * Contains unit tests addressing the functionality of Player
 *
 * @author Iain Duff
 */
class PlayerTest extends ProjectTest {

  "selectCards" must "return the cards selected by the player" in {
    val player = new Player (1)
    val selectedCardOne = 1
    val selectedCardTwo = 4

    val selectedCards = player.selectCards(selectedCardOne, selectedCardTwo)

    selectedCards(0) should equal (1)
    selectedCards(1) should equal (4)
  }
}