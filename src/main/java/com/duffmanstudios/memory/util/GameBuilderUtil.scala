package com.duffmanstudios.memory.util

import com.duffmanstudios.memory.Card

/**
 * Contains utility methods for creating a new game, such as creating an array of game cards.
 *
 * @author Iain Duff
 */
object GameBuilderUtil {

  def createGameCardArray(numCards: Int) = {
    val cards = new Array[Card](numCards)
    for (i <- 0 until numCards) {
      cards(i) = new Card(i+1)
    }
    cards
  }
}
