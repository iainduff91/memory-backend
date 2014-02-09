package com.duffmanstudios.memory

/**
 * Contains unit tests addressing the functionality of Player
 *
 * @author Iain Duff
 */
class PlayerTest extends ProjectTest {

  "selectCards" must "return the cards in the locations selected on the board" in {
    val boardGrid = game.board.boardGrid
    val player = new Player(1, game)
    val cardOne = 1
    val cardTwo = game.board.getNumCards
    val selectedCards = player.selectCards(cardOne, cardTwo)

    assert(selectedCards(0).equals(boardGrid(0)(0)))
    assert(selectedCards(1).equals(boardGrid(1)(2)))
  }

  "selectCards" must "throw an IllegalArgumentException when one or more of the card numbers is either below zero" in {
    val player = new Player(1, game)
    val illegalNumber = 0
    intercept[IllegalArgumentException] {
      player.selectCards(illegalNumber, 2)
    }

    intercept[IllegalArgumentException] {
      player.selectCards(1, illegalNumber)
    }

    intercept[IllegalArgumentException] {
      player.selectCards(illegalNumber, illegalNumber)
    }
  }

  "selectCards" must "throw an IllegalArgumentException when one or more of the card numbers is greater than the total number of cards" in {
    val player = new Player(1, game)
    val illegalNumber = game.board.getNumCards + 1
    intercept[IllegalArgumentException] {
      player.selectCards(illegalNumber, 1)
    }

    intercept[IllegalArgumentException] {
      player.selectCards(1, illegalNumber)
    }

    intercept[IllegalArgumentException] {
      player.selectCards(illegalNumber, illegalNumber)
    }
  }
}