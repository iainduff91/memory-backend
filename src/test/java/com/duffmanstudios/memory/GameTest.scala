package com.duffmanstudios.memory

import scala.collection.mutable.Stack

/**
 * Contains unit tests for the functionality in Board
 *
 * @author Iain Duff
 */
class GameTest extends ProjectTest {

  "A Stack" should "remove items in last-in first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop();
    }
  }

  "isMatch" must "return true if both compared cards have matching IDs" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(1)

    assert(game.isMatch(cardOne, cardTwo))
  }

  "isMatch" must "return false if compared cards do NOT have matching IDs" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(2)

    assert(!game.isMatch(cardOne, cardTwo))
  }

  "gameOver" must "be true if no cards are left in the game" in {
    val noCards = new Array[Card](0)
    val game = new Game(noCards, players)

    assert(game.gameOver)
  }

  "gameOver" must "be false if cards are still in the game" in {
    assertResult(false)(game.gameOver)
  }
  
  "makeBoard" must "create a new Board" in {
    val result = game.makeBoard
    assert(result.isInstanceOf[Board])
  }
}