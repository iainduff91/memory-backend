package com.duffmanstudios.memory

/**
 * Represents a player in the game
 *
 * @author Iain Duff
 */
class Player(number: Int, game: Game) {

  def selectCards(cardOne: Int, cardTwo: Int) = {
    checkCardNumberValid(cardOne)
    checkCardNumberValid(cardTwo)
    val cardOneXY = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(cardOne)
    val cardTwoXY = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(cardTwo)
    List(game.board.boardGrid(cardOneXY._1)(cardOneXY._2)) ++ List(game.board.boardGrid(cardTwoXY._1)(cardTwoXY._2))
  }

  def checkCardNumberValid(cardNumber: Int) = {
    if (cardNumber < 1) {
      throw new IllegalArgumentException("The card number must be 1 or above")
    } else if(cardNumber > game.board.getNumCards) {
      throw new IllegalArgumentException("The card number must be less than the total number of cards")
    }
  }
}
