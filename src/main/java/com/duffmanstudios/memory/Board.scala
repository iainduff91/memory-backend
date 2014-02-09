package com.duffmanstudios.memory

import scala.util.Random
import scala.collection.mutable._

/**
 * Represents the board on which the game cards are laid.
 *
 * @author Iain Duff
 */
class Board(cards: Array[Card]) {

  val boardGrid = layCards(cards)

  def layCards(cards: Array[Card]): Array[MutableList[Option[Card]]] = {
    var cardPairs = duplicateCards(cards)
    val cardGrid:Array[MutableList[Option[Card]]] = Array(MutableList(), MutableList(), MutableList(), MutableList())

    val random = new Random()
    val numCards = cardPairs.size
    var usedIndexes = List[Int]()
    var index = 0

    for(i <- 0 until numCards) {
      do {
        index = random.nextInt(cardPairs.size)
      } while (usedIndexes.contains(index))

      cardGrid(i % 4) = cardGrid(i % 4) ++ List(Some(cardPairs(index)))
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

  def getCardPair(cardOneXY: (Int, Int), cardTwoXY: (Int, Int)) = {
    val selectedCards: Array[Card] = new Array[Card](2)
    val errorMessage = "No card here!"
    selectedCards(0) = boardGrid(cardOneXY._1)(cardOneXY._2).getOrElse(throw new NoCardException(errorMessage))
    selectedCards(1) = boardGrid(cardTwoXY._1)(cardTwoXY._2).getOrElse(throw new NoCardException(errorMessage))
    selectedCards
  }

  def removeCards(cardOneXY: (Int, Int), cardTwoXY: (Int, Int)) {
    boardGrid(cardOneXY._1)(cardOneXY._2) = None
    boardGrid(cardTwoXY._1)(cardTwoXY._2) = None
  }

  def isEmpty = {
    var empty = false
    for (column <- boardGrid) {
      for (cell <- column) {
        if (cell.isEmpty) {
          empty = true
        }
      }
    }
    empty
  }

  def getNumCards = cards.length * 2
}
