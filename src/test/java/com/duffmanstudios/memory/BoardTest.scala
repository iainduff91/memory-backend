package com.duffmanstudios.memory

import org.scalatest.{Matchers, FlatSpec}

/**
 * Contains unit tests for testing the functionality in Board.
 *
 * @author Iain Duff
 */
class BoardTest extends ProjectTest {

  "duplicateCards" must "create a list containing 2 of each given card" in {
    val expectedNumberOfCards = 2 * cardsList.length
    val result = board.duplicateCards(cardsList)
    assertResult(expectedNumberOfCards)(result.size)
    assertResult(cardsList(0).Id)(result(0).Id)
    assertResult(cardsList(0).Id)(result(1).Id)
    assertResult(cardsList(1).Id)(result(2).Id)
    assertResult(cardsList(1).Id)(result(3).Id)
  }

  "layCards" must "create a grid with 4 columns" in {
    val cardGrid = board.layCards(cardsList)
    assertResult(4)(cardGrid.length)
  }

  "layCards" must "create a grid with 2 of each card" in {
    val expectedNumberOfCards = 2 * cardsList.length
    val cardGrid = board.layCards(cardsList)

    val actualNumberOfCards = cardGrid(0).length + cardGrid(1).length + cardGrid(2).length + cardGrid(3).length
    assertResult(expectedNumberOfCards)(actualNumberOfCards)
  }

  "layCards" must "create a grid with cards in a random order" in {
    val laidBoard = board.layCards(cardsList)
    val concatenatedResult = "" + laidBoard(0)(0).Id + laidBoard(1)(0).Id + laidBoard(2)(0).Id +
          laidBoard(3)(0).Id

    assert(!concatenatedResult.equals("1122"))
  }


  
}
