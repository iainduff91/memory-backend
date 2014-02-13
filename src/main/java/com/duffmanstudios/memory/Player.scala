package com.duffmanstudios.memory

/**
 * Represents a player in the game
 *
 * @author Iain Duff
 */
class Player(number: Int) {

  def selectCards(cardOne: Int, cardTwo: Int) = {
    val selectedCards = new Array[Int](2)
    selectedCards(0) = cardOne
    selectedCards(1) = cardTwo
    selectedCards
  }

}
