package com.duffmanstudios.memory

import org.scalatest.{FlatSpec, Matchers}

/**
 * Contains variables and functionality shared across all unit tests in the application.
 *
 * @author Iain Duff
 */
class ProjectTest extends FlatSpec with Matchers {

  val cardsList = Array(new Card(1), new Card(1), new Card(2), new Card(2), new Card(3))
  val players = Array(new Player(1), new Player(2))
  val game = new Game(cardsList, players)
}
