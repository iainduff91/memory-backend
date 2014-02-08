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
    val cardTwo = 4
    val selectedCards = player.selectCards(cardOne, cardTwo)

    assert(selectedCards(0).equals(boardGrid(0)(0)))
    assert(selectedCards(1).equals(boardGrid(3)(0)))
  }
}