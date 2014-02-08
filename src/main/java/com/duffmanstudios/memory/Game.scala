package com.duffmanstudios.memory

/**
 * Represents the Game itself and contains member objects for all properties associated with a game, such as the
 * Board, Players taking part, and the Cards used in the game.
 *
 * @author Iain Duff
 */
class Game(cards: Array[Card]) {

  val board = makeBoard

  def isMatch(cardOne: Card, cardTwo: Card) = cardOne.Id == cardTwo.Id

  /**
   * @return Double the number of cards passed into Game, because the number of cards is duplicated when the board is set up.
   */
  def getNumCards = cards.length * 2

  def gameOver = cards.isEmpty

  def makeBoard = new Board(cards)
}
