package com.duffmanstudios.memory

/**
 * Contains unit tests addressing the functionality of Player
 *
 * @author Iain Duff
 */
class PlayerTest extends ProjectTest {

  def playerFixture = new {
    val player = new Player(1)
  }

  "selectCards" must "return the cards selected by the player" in {
    val fixture = playerFixture
    val selectedCardOne = 1
    val selectedCardTwo = 4

    val selectedCards = fixture.player.selectCards(selectedCardOne, selectedCardTwo)

    selectedCards(0) should equal (1)
    selectedCards(1) should equal (4)
  }

  "A player's score" must "start at zero" in {
    val fixture = playerFixture
    fixture.player.score should be (0)
  }

  "incrementScore" must "add one to a player's score" in {
    val fixture = playerFixture
    fixture.player.increaseScore
    fixture.player.score should be (1)
  }
}