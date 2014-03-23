package com.duffmanstudios.memory

import com.duffmanstudios.memory.util.GameBuilderUtil

/**
 * Contains unit tests for the functionality in Board
 *
 * @author Iain Duff
 */
class GameTest extends ProjectTest {
  
  "2-parameter Game constructor" should "create a new Game with the given players and cards" in {
    val cards = GameBuilderUtil.createGameCardArray(4)
    val players = Array(new Player(1), new Player(2), new Player(3))

    val game = new Game(cards, players)

    game.cards.length should be (cards.length)
    game.players.length should be (players.length)
  }

  "1-parameter Game constructor" should "create a new Game with the given cards and 2 players" in {
    val cards = GameBuilderUtil.createGameCardArray(5)

    val game = new Game(cards)

    game.cards.length should be (cards.length)
    game.players.length should be (2)
  }

  "makeBoard" must "create a new Board" in {
    val f = defaultGameFixture
    val result = f.game.makeBoard
    assert(result.isInstanceOf[Board])
  }

  "isMatch" must "return true if both compared cards have matching IDs" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(1)
    val f = defaultGameFixture

    assert(f.game.isMatch(cardOne, cardTwo))
  }

  "isMatch" must "return false if compared cards do NOT have matching IDs" in {
    val f = defaultGameFixture

    assert(!f.game.isMatch(cardOne, cardTwo))
  }

  "processMove" should "check the validity of players' moves" in {
    val f = defaultGameFixture
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
    val sf = fixture(1)

    sf.game.players(0).score should be (0)

    sf.game.processMove(1, 2)

    sf.game.players(0).score should be (1)
  }

  "processMove" should "remove the card pair if they match" in {
    val sf = fixture(1)

    sf.game.processMove(1, 2)

    sf.game.board.isEmpty should be (true)
  }

  "processMove" should "NOT remove the card pair if they don't match" in {
    val f = fixture(2)

    val firstCard = 1
    //ensure first and second cards don't match
    val secondCard = if (f.game.board.boardGrid(0)(0).get.Id != f.game.board.boardGrid(1)(0).get.Id) {
      2
    } else {
      3
    }

    f.game.processMove(firstCard, secondCard)

    f.game.board.boardGrid(firstCard - 1)(0).isEmpty should be (false)
    f.game.board.boardGrid(secondCard - 1)(0).isEmpty should be (false)
  }

  "processMove" should "NOT increase a player's score if a match isn't found" in {
    val f = fixture(3)

    val firstCardSelected = 1
    //ensures that the first and second cards selected will NOT match
    val secondCardSelected = if (f.game.board.boardGrid(0)(0).get.Id != f.game.board.boardGrid(1)(0).get.Id) {
      2
    } else {
      3
    }

    f.game.processMove(firstCardSelected, secondCardSelected)

    f.game.players(0).score should be (0)
  }

  "processMove" should "correctly identify the winner if the game is over" in {
    val sf = fixture(1)

    //select the only 2 cards in the game
    sf.game.processMove(1, 2)

    sf.game.winner should equal (sf.game.players(0))
  }

  "processMove" should "not identify a winner if the game is not over" in {
    val f = defaultGameFixture

    //ensures that player 1 will always have a higher score than player 2 in this test
    f.game.players(0).increaseScore
    f.game.processMove(1, 2)

    f.game.winner should be (None)
  }

  "processMove" should "switch the current player at the end of the move if the game is NOT over" in {
    val f = defaultGameFixture

    f.game.processMove(1, 2)

    f.game.currentPlayer should be (f.game.players(1))
  }

  "processMove" should "not switch player if the game IS over" in {
    val sf = fixture(1)

    sf.game.processMove(1, 2)

    sf.game.currentPlayer should be (sf.game.players(0))
  }

  "switchPlayer" must "change the current player to the previous current player's opponent" in {
    val f = defaultGameFixture
    f.game.currentPlayer.number should equal (1)
    f.game.switchPlayer()
    f.game.currentPlayer.number should equal (2)
    f.game.switchPlayer()
    f.game.currentPlayer.number should equal (1)
  }

  "gameOver" must "be true if no cards are left in the game" in {
    val sf = fixture(1)

    //remove the only 2 cards in the game, so the game is then over
    sf.game.processMove(1, 2)
    
    assert(sf.game.gameOver)
  }

  "gameOver" must "be false if cards are still in the game" in {
    val f = defaultGameFixture
    assertResult(false)(f.game.gameOver)
  }

  "findWinner" must "return the player who has the highest score" in {
    val f = defaultGameFixture
    f.game.players(0).increaseScore

    f.game.findWinner should be (f.game.players(0))
  }

  "findWinner" must "return None if the match results in a draw" in {
    val f = defaultGameFixture
    f.game.findWinner should be (None)
  }

}