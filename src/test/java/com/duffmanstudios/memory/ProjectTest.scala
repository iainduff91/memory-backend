package com.duffmanstudios.memory

import org.scalatest.{FlatSpec, Matchers}

/**
 * Contains variables and functionality shared across all unit tests in the application.
 *
 * @author Iain Duff
 */
class ProjectTest extends FlatSpec with Matchers {


  def defaultGameFixture = fixture(5)

  def fixture(numCards: Int) = new {
    val cardsList = populateCardsList(numCards)
    val players = Array(new Player(1), new Player(2))
    val game = new Game(cardsList, players)
  }

  def populateCardsList(numCards: Int) = {
    val cards = new Array[Card](numCards)
    for (i <- 0 until numCards) {
      cards(i) = new Card(i)
    }
    cards
  }
}
