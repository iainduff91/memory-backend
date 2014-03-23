package com.duffmanstudios.memory

/**
 * Represents the Game itself and contains member objects for all properties associated with a game, such as the
 * Board, Players taking part, and the Cards used in the game.
 *
 * @author Iain Duff
 */
class Game(val cards: Array[Card], val players: Array[Player]) {

  val board = makeBoard
  var currentPlayer = players(0)
  var winner: Object = None


  def this(cards: Array[Card]) = this(cards, Array(new Player(1), new Player(2)))

  def makeBoard = new Board(cards)

  def processMove(firstCardSelected: Int, secondCardSelected: Int) {
    val boardGridLocationOne = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(firstCardSelected, board.getNumCards)
    val boardGridLocationTwo = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(secondCardSelected, board.getNumCards)

    val cardPair = board.getCardPair(boardGridLocationOne, boardGridLocationTwo)
    if (isMatch(cardPair(0), cardPair(1))) {
      currentPlayer.increaseScore
      board.removeCards(boardGridLocationOne, boardGridLocationTwo)
    }

    if (gameOver) {
      winner = findWinner
    } else {
      switchPlayer()
    }
  }

  def isMatch(cardOne: Card, cardTwo: Card) = cardOne.Id == cardTwo.Id

  def gameOver = board.isEmpty

  def findWinner = {
    val playerList = players.toList
    val highestScore = playerList.map(_.score).max
    if (noClearWinner(playerList, highestScore)) {
      None
    } else {
      playerList.maxBy(_.score)
    }
  }

  protected def noClearWinner(players: List[Player], highestScore: Int) = players.toList.count(_.score == highestScore) > 1

  def switchPlayer() {
    val currentPlayerIndex = currentPlayer.number - 1
    val newPlayerIndex = (currentPlayerIndex + 1) % 2
    currentPlayer = players(newPlayerIndex)
  }
}
