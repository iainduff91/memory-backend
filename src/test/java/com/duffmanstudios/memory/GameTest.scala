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

  "makeBoard" must "create a new Board" in {
    val f = fixture
    val result = f.game.makeBoard
    assert(result.isInstanceOf[Board])
  }

  "isMatch" must "return true if both compared cards have matching IDs" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(1)
    val f = fixture

    assert(f.game.isMatch(cardOne, cardTwo))
  }

  "isMatch" must "return false if compared cards do NOT have matching IDs" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(2)
    val f = fixture

    assert(!f.game.isMatch(cardOne, cardTwo))
  }

  "switchPlayer" must "change the current player to the previous current player's opponent" in {
    val f = fixture
    f.game.currentPlayer.number should equal (1)
    f.game.switchPlayer
    f.game.currentPlayer.number should equal (2)
    f.game.switchPlayer
    f.game.currentPlayer.number should equal (1)
  }

  "gameOver" must "be true if no cards are left in the game" in {
    val noCards = new Array[Card](0)
    val f = fixture
    val game = new Game(noCards, f.players)

    assert(game.gameOver)
  }

  "gameOver" must "be false if cards are still in the game" in {
    val f = fixture
    assertResult(false)(f.game.gameOver)
  }
}