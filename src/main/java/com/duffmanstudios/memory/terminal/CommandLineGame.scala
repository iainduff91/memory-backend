package com.duffmanstudios.memory.terminal

import com.duffmanstudios.memory._
import com.duffmanstudios.memory.terminal.io.UserInputReader._
import com.duffmanstudios.memory.terminal.io.{GameDisplayUtil, UserInputReader}
import com.duffmanstudios.memory.util.GameBuilderUtil._

/**
 * Launches a terminal version of the game, for debugging purposes.
 *
 * @author Iain Duff
 */
object CommandLineGame {

  val DEFAULT_NUMBER_OF_PLAYERS = 2

  def main(args: Array[String]) {
    val numCards = getInputFromUser(ENTER_NUM_CARDS_MESSAGE, SUCCESSFUL_NUM_CARDS_READ_MESSAGE)
    val game = setUpGame(numCards, DEFAULT_NUMBER_OF_PLAYERS)

    GameDisplayUtil.printGame(game)

    while (game.winner == None) {
      try {
        val firstCardNumber = getInputFromUser("P" + game.currentPlayer.number + ": Enter your first card: ", SUCCESSFUL_CARD_SELECT_MESSAGE)
        val firstCardLocation = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(firstCardNumber, game.board.getNumCards)

        val secondCardNumber = getInputFromUser("P" + game.currentPlayer.number + ": Enter your second card: ", SUCCESSFUL_CARD_SELECT_MESSAGE)
        val secondCardLocation = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(secondCardNumber, game.board.getNumCards)
        val selectedCardPair = game.board.getCardPair(firstCardLocation, secondCardLocation)

        GameDisplayUtil.printGame(game, selectedCardPair, Array(firstCardLocation, secondCardLocation))

        if (game.isMatch(selectedCardPair(0), selectedCardPair(1))) {
          game.currentPlayer.increaseScore
          game.board.removeCards(firstCardLocation, secondCardLocation)
          println("\nMatch!\n")
          GameDisplayUtil.printGame(game)
        }

        if(game.gameOver) {
          game.winner = game.findWinner
          println("Player " + game.winner.get.number + " is the winner!")
        } else {
          game.switchPlayer()
        }

      } catch {
        case e: Exception => { println(e.getMessage) }
      }
    }
  }

  protected def setUpGame(numCards: Int, numPlayers: Int): Game = {
    val cards = generateGameCards(numCards)
    val players = generatePlayers(numPlayers)
    new Game(cards, players)
  }
}
