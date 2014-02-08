package com.duffmanstudios.memory

/**
 * Represents a player in the game
 *
 * @author Iain Duff
 */
class Player(number: Int, game: Game) {

  def selectCards(cardOne: Int, cardTwo: Int) = {
    val cardOneXY = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(cardOne)
    val cardTwoXY = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(cardTwo)
    List(game.board.boardGrid(cardOneXY._1)(cardOneXY._2)) ++ List(game.board.boardGrid(cardTwoXY._1)(cardTwoXY._2))
  }

}
