package com.duffmanstudios.memory

import org.scalatest._
import scala.collection.mutable.Stack

/**
 * Created by Student on 27/12/13.
 */
class GameTest extends FlatSpec with Matchers {

  def fixture = new {
    val cardsList = Array(new Card(1), new Card(1), new Card(2), new Card(2))
    val game = new Game(cardsList)
  }

  "A Stack" should "remove items in last-in first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  it should "throw NoSuchElementException if an empty statck is popped" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop();
    }
  }

  "isMatch" must "return true if both compared cards have matching IDs" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(1)

    val f = fixture
    f.game.isMatch(cardOne, cardTwo) should be (true)
  }

  "isMatch" must "return false if compared cards do NOT have matching IDs" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(2)

    val f = fixture
    f.game.isMatch(cardOne, cardTwo) should be (false)
  }

  "gameOver" must "be true if no cards are left in the game" in {
    val noCards = new Array[Card](0)
    val game = new Game(noCards)

    assert(game.gameOver)
  }

  "gameOver" must "be false if cards are still in the game" in {
    val f = fixture
    assertResult(false)(f.game.gameOver)
  }
  
  "makeBoard" must "create a new Board" in {
    val f = fixture
    val result = f.game.makeBoard
    assert(result.isInstanceOf[Board])
  }
}