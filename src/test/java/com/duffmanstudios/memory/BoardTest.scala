package com.duffmanstudios.memory

import org.scalatest.{Matchers, FlatSpec}

/**
 * Contains unit tests for testing the functionality in Board.
 *
 * @author Iain Duff
 */
class BoardTest extends ProjectTest {

  "duplicateCards" must "create a list containing 2 of each given card" in {
    val f = fixture
    val expectedNumberOfCards = 2 * f.cardsList.length
    val result = f.game.board.duplicateCards(f.cardsList)
    assertResult(expectedNumberOfCards)(result.size)
    assertResult(f.cardsList(0).Id)(result(0).Id)
    assertResult(f.cardsList(0).Id)(result(1).Id)
    assertResult(f.cardsList(1).Id)(result(2).Id)
    assertResult(f.cardsList(1).Id)(result(3).Id)
  }

  "layCards" must "create a grid with 4 columns" in {
    val f = fixture
    val cardGrid = f.game.board.boardGrid
    assertResult(4)(cardGrid.length)
  }

  "layCards" must "create a grid with 2 of each card" in {
    val f = fixture
    val expectedNumberOfCards = 2 * f.cardsList.length
    val cardGrid = f.game.board.boardGrid

    val actualNumberOfCards = cardGrid(0).length + cardGrid(1).length + cardGrid(2).length + cardGrid(3).length
    assertResult(expectedNumberOfCards)(actualNumberOfCards)
  }

  "layCards" must "create a grid with cards in a random order" in {
    val f = fixture
    val laidBoard = f.game.board.boardGrid
    val concatenatedResult = "" +
      laidBoard(0)(0).get.Id + laidBoard(1)(0).get.Id + laidBoard(2)(0).get.Id + laidBoard(3)(0).get.Id +
      laidBoard(0)(1).get.Id + laidBoard(1)(1).get.Id + laidBoard(2)(1).get.Id + laidBoard(3)(1).get.Id +
      laidBoard(0)(2).get.Id + laidBoard(1)(2).get.Id

    assert(!concatenatedResult.equals("1122334455"))
  }

  "getCardPair" must "return the cards at the selected locations" in {
    val cards = Array(new Card(1), new Card(2), new Card(3))
    val board = new Board(cards)

    var selectedCards: Array[Card] = board.getCardPair((0, 0), (1, 0))
    assert(selectedCards(0).equals(board.boardGrid(0)(0).get) && selectedCards(1).equals(board.boardGrid(1)(0).get))

    selectedCards = board.getCardPair((2, 0), (3, 0))
    assert(selectedCards(0).equals(board.boardGrid(2)(0).get) && selectedCards(1).equals(board.boardGrid(3)(0).get))

    selectedCards = board.getCardPair((0, 1), (1, 1))
    assert(selectedCards(0).equals(board.boardGrid(0)(1).get) && selectedCards(1).equals(board.boardGrid(1)(1).get))
  }

  it should "throw NoCardException when a valid location holding no card is selected" in {
    val cards = Array(new Card(1), new Card(2))
    val board = new Board(cards)
    val removedLocationOne = (0, 0)
    val removedLocationTwo = (1, 0)
    board.removeCards(removedLocationOne, removedLocationTwo)

    intercept[NoCardException] {
      board.getCardPair(removedLocationTwo, (2, 0))
    }

    intercept[NoCardException] {
      board.getCardPair((3, 0), removedLocationOne)
    }

    intercept[NoCardException] {
      board.getCardPair(removedLocationOne, removedLocationTwo)
    }
  }

  "removeCards" must "remove a card from a location on the board" in {
    val gameCards = Array(new Card(1), new Card(2), new Card(3))
    val board = new Board(gameCards)

    board.removeCards((0, 0), (1, 0))
    assert(board.boardGrid(0)(0).isEmpty && board.boardGrid(1)(0).isEmpty)

    board.removeCards((2, 0), (3, 0))
    assert(board.boardGrid(2)(0).isEmpty && board.boardGrid(3)(0).isEmpty)

    board.removeCards((0, 1), (1, 1))
    assert(board.boardGrid(0)(1).isEmpty && board.boardGrid(1)(1).isEmpty)
  }

  "isEmpty" must "return true if the number of cards on the board is zero" in {
    val oneCardArray: Array[Card] = Array(new Card(1))
    val board = new Board(oneCardArray)
    val cardOneLocation = (0, 0)
    val cardTwoLocation = (1, 0)
    board.removeCards(cardOneLocation, cardTwoLocation)
    board.isEmpty should be (true)
  }

  "isEmpty" must "return false if there are still cards on the board" in {
    val f = fixture
    f.game.board.isEmpty should be (false)
  }

  "getNumCards" must "return the correct number of cards" in {
    val f = fixture
    f.game.board.getNumCards should equal (10)
  }
}
