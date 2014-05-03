package com.duffmanstudios.memory.terminal.io

import com.duffmanstudios.memory.{Card, ProjectTest}

/**
 * Contains unit tests for the functionality in GameDisplayUtil, which is used to display the
 * game in the command line.
 *
 * @author Iain Duff
 */
class GameDisplayUtilTest extends ProjectTest{

  "buildBoardForDisplay" should "return a board of 4 columns adding up to the total number of cards on the board" in {
    val boardScreenOutput = createNewDisplayBoard()

    boardScreenOutput.length should be (4)

    var cardCount = 0
    for (i <- 0 until boardScreenOutput.length) {
      cardCount += boardScreenOutput(i).length
    }

    val expectedNumberOfCards = 24
    cardCount should be (expectedNumberOfCards)
  }

  "buildBoardForDisplay" should "return <space> for removed cards, otherwise 'X'" in {
    val boardScreenOutput = createDisplayBoardWithCardsRemoved((0, 0), (1, 0))

    for (i <- 0 until boardScreenOutput.length) {
      for (j <- 0 until boardScreenOutput(i).length) {
        if ((i == 0 && j == 0) || (i == 1 && j == 0)) {
          boardScreenOutput(i)(j) should equal (" ")
        } else {
          boardScreenOutput(i)(j) should equal ("X")
        }
      }
    }
  }

  "buildBoardForDisplay (with selected cards)" should "return 'X' for non-selected cards and the card numbers for the selected cards" in {
    val numUniqueCards = 12
    val f = fixture(numUniqueCards)

    val selectedCards = Array(new Card(6), new Card(8))
    val boardLocationsOfSelectedCards = Array((0,0), (3, 5))

    val boardScreenOutput = GameDisplayUtil.buildBoardForDisplay(f.game.board, selectedCards, boardLocationsOfSelectedCards)

    boardScreenOutput(0)(0) should be (selectedCards(0).Id.toString)
    boardScreenOutput(3)(5) should be (selectedCards(1).Id.toString)

    boardScreenOutput(0)(1) should be ("X")
  }

  private def createNewDisplayBoard() = {
    val numUniqueCards = 12
    val f = fixture(numUniqueCards)
    GameDisplayUtil.buildBoardForDisplay(f.game.board)
  }

  private def createDisplayBoardWithCardsRemoved(locationOne: (Int, Int), locationTwo: (Int, Int)) = {
    val numUniqueCards = 7
    val f = fixture(numUniqueCards)
    f.game.board.removeCards(locationOne, locationTwo)
    GameDisplayUtil.buildBoardForDisplay(f.game.board)
  }
}
