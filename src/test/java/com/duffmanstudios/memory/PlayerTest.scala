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
    val cardOneXY = (0, 0)
    val cardTwoXY = (3, 0)
    val selectedCards = player.selectCards(cardOneXY, cardTwoXY)

    assert(selectedCards(0).equals(boardGrid(0)(0)))
    assert(selectedCards(1).equals(boardGrid(3)(0)))
  }
}