package com.duffmanstudios.memory

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by Student on 28/12/13.
 */
class BoardTest extends FlatSpec with Matchers {

  def fixture = new {
    val cardsList = Array(new Card(1), new Card(2))
    val board = new Board(cardsList)
  }

  "duplicateCards" must "create a list containing 2 of each given card" in {
    val f = fixture
    val expectedNumberOfCards = 2 * f.cardsList.length
    val result = f.board.duplicateCards(f.cardsList)
    assertResult(expectedNumberOfCards)(result.size)
    assertResult(f.cardsList(0).Id)(result(0).Id)
    assertResult(f.cardsList(0).Id)(result(1).Id)
    assertResult(f.cardsList(1).Id)(result(2).Id)
    assertResult(f.cardsList(1).Id)(result(3).Id)
  }

  "layCards" must "create a grid with 4 columns" in {
    val f = fixture
    val cardGrid = f.board.layCards(f.cardsList)
    assertResult(4)(cardGrid.length)
  }

  "layCards" must "create a grid with 2 of each card" in {
    val f = fixture
    val expectedNumberOfCards = 2 * f.cardsList.length
    val cardGrid = f.board.layCards(f.cardsList)

    val actualNumberOfCards = cardGrid(0).length + cardGrid(1).length + cardGrid(2).length + cardGrid(3).length
    assertResult(expectedNumberOfCards)(actualNumberOfCards)
  }

  "layCards" must "create a grid with cards in a random order" in {
    fail("to be completed")
  }
  
}
