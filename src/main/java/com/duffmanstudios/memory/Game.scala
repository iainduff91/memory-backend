package com.duffmanstudios.memory

/**
 * Represents the Game itself and contains member objects for all properties associated with a game, such as the
 * Board, Players taking part, and the Cards used in the game.
 *
 * @author Iain Duff
 */
class Game(cards: Array[Card], players: Array[Player]) {

  val board = makeBoard
  var currentPlayer = players(0)

  def isMatch(cardOne: Card, cardTwo: Card) = cardOne.Id == cardTwo.Id

  def gameOver = cards.isEmpty

  def makeBoard = new Board(cards)

  def switchPlayer {
    val currentPlayerIndex = currentPlayer.number - 1
    val newPlayerIndex = (currentPlayerIndex + 1) % 2
    currentPlayer = players(newPlayerIndex)
  }
}
