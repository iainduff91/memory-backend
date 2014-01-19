package com.duffmanstudios.memory

import org.scalatest.{FlatSpec, Matchers}

/**
 * Contains variables and functionality shared across all unit tests in the application.
 *
 * @author Iain Duff
 */
class ProjectTest extends FlatSpec with Matchers {

  val defaultFileName = "example.png"
  val cardsList = Array(new Card(1, defaultFileName), new Card(1, defaultFileName),
    new Card(2, defaultFileName), new Card(2, defaultFileName))
  val game = new Game(cardsList)
  val board = new Board(cardsList)

}
