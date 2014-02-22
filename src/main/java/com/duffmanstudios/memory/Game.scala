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

  def processMove(firstCardSelected: Int, secondCardSelected: Int) {
    val boardGridLocationOne = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(firstCardSelected, board.getNumCards)
    val boardGridLocationTwo = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(secondCardSelected, board.getNumCards)

    val cardPair = board.getCardPair(boardGridLocationOne, boardGridLocationTwo)
    if (isMatch(cardPair(0), cardPair(1))) {
      currentPlayer.increaseScore
      board.removeCards(boardGridLocationOne, boardGridLocationTwo)
    }
  }

  def switchPlayer {
    val currentPlayerIndex = currentPlayer.number - 1
    val newPlayerIndex = (currentPlayerIndex + 1) % 2
    currentPlayer = players(newPlayerIndex)
  }
}
