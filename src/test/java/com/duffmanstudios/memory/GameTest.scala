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

  "processMove" should "check the validity of players' moves" in {
    val f = fixture
    val valid = 1
    val invalid = -1

    intercept[IllegalArgumentException] {
      f.game.processMove(invalid, valid)
    }

    intercept[IllegalArgumentException] {
      f.game.processMove(valid, invalid)
    }
  }

  "processMove" should "increase a player's score if a match is found" in {
    val cards = Array(new Card(1))
    val players = Array(new Player(1), new Player(2))
    val game = new Game(cards, players)

    players(0).score should be (0)

    game.processMove(1, 2)

    players(0).score should be (1)
  }

  "processMove" should "remove the card pair if they match" in {
    val cards = Array(new Card(1))
    val players = Array(new Player(1), new Player(2))
    val game = new Game(cards, players)

    game.processMove(1, 2)

    game.board.isEmpty should be (true)
  }

  "processMove" should "NOT remove the card pair if they don't match" in {
    val cards = Array(new Card(1), new Card(2))
    val players = Array(new Player(1), new Player(2))
    val game = new Game(cards, players)

    val firstCard = 1
    //ensure first and second cards don't match
    val secondCard = if (game.board.boardGrid(0)(0).get.Id != game.board.boardGrid(1)(0).get.Id) {
      2
    } else {
      3
    }

    game.processMove(firstCard, secondCard)

    game.board.boardGrid(firstCard - 1)(0).isEmpty should be (false)
    game.board.boardGrid(secondCard - 1)(0).isEmpty should be (false)
  }

  "processMove" should "NOT increase a player's score if a match isn't found" in {
    val cards = Array(new Card(1), new Card(2), new Card(3))
    val players = Array(new Player(1), new Player(2))
    val game = new Game(cards, players)

    val firstCardSelected = 1
    //ensures that the first and second cards selected will NOT match
    val secondCardSelected = if (game.board.boardGrid(0)(0).get.Id != game.board.boardGrid(1)(0).get.Id) {
      2
    } else {
      3
    }

    game.processMove(firstCardSelected, secondCardSelected)

    players(0).score should be (0)
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