package com.duffmanstudios.memory

import scala.util.Random

/**
 * Represents the board on which the game cards are laid.
 *
 * @author Iain Duff
 */
class Board(cards: Array[Card]) {

  val boardGrid = layCards(cards)

  def layCards(cards: Array[Card]): Array[List[Card]] = {
    var cardPairs = duplicateCards(cards)
    val cardGrid:Array[List[Card]] = Array(List(), List(), List(), List())

    val random = new Random()
    val numCards = cardPairs.size
    var usedIndexes = List[Int]()
    var index = 0

    for(i <- 0 until numCards) {
      do {
        index = random.nextInt(cardPairs.size)
      } while (usedIndexes.contains(index))

      cardGrid(i % 4) = cardGrid(i % 4) ++ List(cardPairs(index))
      usedIndexes = usedIndexes ++ List(index)
    }
    cardGrid
  }

  def duplicateCards(cards: Array[Card]): List[Card] = {
    var cardPairs: List[Card] = List()
    for (card <- cards) {
      val duplicate = new Card(card.Id)
      cardPairs = cardPairs ++ List(card, duplicate)
    }
    cardPairs
  }
}
