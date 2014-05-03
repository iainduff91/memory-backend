package com.duffmanstudios.memory.terminal.io

import com.duffmanstudios.memory.{Game, Player, Card, Board}

/**
 * Contains utility methods for displaying the game in the command line.
 *
 * @author Iain Duff
 */
object GameDisplayUtil {

  private val REMOVED_CARD_CHARACTER = " "
  private val FACE_DOWN_CHARACTER = "X"

  def printGame(game: Game) {
    printScores(game.players)
    printBoard(game.board)
  }

  def printGame(game: Game, selectedCards: Array[Card], selectedCardLocations: Array[(Int, Int)]) {
    printScores(game.players)
    printBoard(game.board, selectedCards, selectedCardLocations)
  }

  def printScores(players: Array[Player]) {
    println("P1: " + players(0).score + "\t\t\tP2: " + players(1).score)
  }

  def printBoard(board: Board) {
    printBoard(board, Array(), Array())
  }

  def printBoard(board: Board, selectedCards: Array[Card], selectedCardLocations: Array[(Int, Int)]) {
    val boardToDisplay = buildBoardForDisplay(board, selectedCards, selectedCardLocations)
    for (i <- 0 until board.boardGrid.length) {
      for (j <- 0 until board.boardGrid(i).length) {
        print(boardToDisplay(i)(j))
        print(REMOVED_CARD_CHARACTER)
      }
      println()
    }
  }

  def buildBoardForDisplay(board: Board): Array[Array[String]] = {
    buildBoardForDisplay(board, Array(), Array())
  }

  def buildBoardForDisplay(board: Board, selectedCards: Array[Card], selectedCardLocations: Array[(Int, Int)]): Array[Array[String]] = {
    val boardToDisplay = new Array[Array[String]](board.boardGrid.length)
    for (i <- 0 until board.boardGrid.length) {
      boardToDisplay(i) = new Array[String](board.boardGrid(i).length)
      for (j <- 0 until board.boardGrid(i).length) {
        boardToDisplay(i)(j) = getUnselectedCardValue(board.boardGrid(i)(j))
        if (cardsHaveBeenSelected(selectedCards, selectedCardLocations)) {
          val locationOfSelectedCard = getSelectedCard(i, j, selectedCards, selectedCardLocations)
          if (cardIsOneOfTheSelectedCards(locationOfSelectedCard)) {
            boardToDisplay(i)(j) = selectedCards(locationOfSelectedCard).Id.toString
          }
        }
      }
    }
    boardToDisplay
  }

  private def getUnselectedCardValue(card: Option[Card]) = {
    if (card == None) {
      REMOVED_CARD_CHARACTER
    } else {
      FACE_DOWN_CHARACTER
    }
  }

  private def cardsHaveBeenSelected(selectedCards: Array[Card], selectedCardLocations: Array[(Int, Int)]) = {
    selectedCards.nonEmpty && selectedCardLocations.nonEmpty
  }

  private def getSelectedCard(boardColumn: Int,
        boardRow: Int, 
        selectedCards: Array[Card], 
        selectedCardLocations: Array[(Int, Int)]): Int = {
    
    if (boardColumn == selectedCardLocations(0)._1 && boardRow == selectedCardLocations(0)._2) {
      0
    } else if (boardColumn == selectedCardLocations(1)._1 && boardRow == selectedCardLocations(1)._2) {
      1
    } else {
      -1
    }
  }

  private def cardIsOneOfTheSelectedCards(locationOfSelectedCard: Int) = locationOfSelectedCard != -1
}
