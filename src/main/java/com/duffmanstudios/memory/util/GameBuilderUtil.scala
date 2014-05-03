package com.duffmanstudios.memory.util

import com.duffmanstudios.memory.{Player, Card}

/**
 * Contains utility methods for creating a new game, such as creating an array of game cards.
 *
 * @author Iain Duff
 */
object GameBuilderUtil {

  def generateGameCards(numCards: Int) = {
    val cards = new Array[Card](numCards)
    for (i <- 0 until numCards) {
      cards(i) = new Card(i+1)
    }
    cards
  }

  def generatePlayers(numPlayers: Int): Array[Player] = {
    val players = new Array[Player](numPlayers)
    for (i <- 0 until numPlayers) {
      players(i) = new Player(i + 1)
    }
    players
  }

}
