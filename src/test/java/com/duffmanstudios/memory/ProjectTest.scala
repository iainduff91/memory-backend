package com.duffmanstudios.memory

import org.scalatest.{FlatSpec, Matchers}
import com.duffmanstudios.memory.util.GameBuilderUtil

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
    val cardsList = GameBuilderUtil.generateGameCards(numCards)
    val game = new Game(cardsList)
  }
}
