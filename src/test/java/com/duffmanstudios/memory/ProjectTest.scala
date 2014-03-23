package com.duffmanstudios.memory

import org.scalatest.{FlatSpec, Matchers}

/**
 * Contains variables and functionality shared across all unit tests in the application.
 *
 * @author Iain Duff
 */
class ProjectTest extends FlatSpec with Matchers {

  val cardOne = new Card(1)
  val cardTwo = new Card(2)

  def defaultGameFixture = fixture(5)

  def fixture(numCards: Int) = new {
    val cardsList = createCardArray(numCards)
    val game = new Game(cardsList)
  }

  def createCardArray(numCards: Int) = {
    val cards = new Array[Card](numCards)
    for (i <- 0 until numCards) {
      cards(i) = new Card(i)
    }
    cards
  }
}
