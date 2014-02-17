package com.duffmanstudios.memory

/**
 * Represents a player in the game
 *
 * @author Iain Duff
 */
class Player(val number: Int) {

  var score = 0

  def selectCards(cardOne: Int, cardTwo: Int) = {
    val selectedCards = new Array[Int](2)
    selectedCards(0) = cardOne
    selectedCards(1) = cardTwo
    selectedCards
  }

  def increaseScore = {
    score += 1
    score
  }

}
