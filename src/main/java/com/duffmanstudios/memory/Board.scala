package com.duffmanstudios.memory

import scala.util.Random

/**
 * Created by Student on 28/12/13.
 */
class Board(cards: Array[Card]) {


  def layCards(cards: Array[Card]): Array[List[Card]] = {
    var cardPairs = duplicateCards(cards)
    val cardGrid:Array[List[Card]] = Array(List(), List(), List(), List())

    val random = new Random()
    val numCards = cardPairs.size

    for(i <- 0 until numCards) {
      val index = random.nextInt(cardPairs.size)
      cardGrid(i % 4) = cardGrid(i % 4) ++ List(cardPairs(index))
      cardPairs = cardPairs.diff(List(index))
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
