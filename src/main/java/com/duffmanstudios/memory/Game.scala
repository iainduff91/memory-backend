package com.duffmanstudios.memory

/**
 * Created by Student on 27/12/13.
 */
class Game(cards: Array[Card]) {

  val board = makeBoard

  def isMatch(cardOne: Card, cardTwo: Card) = (cardOne.Id == cardTwo.Id)

  def getNumCards = cards.length

  def gameOver = cards.isEmpty

  def makeBoard = new Board(cards)
}
