package com.duffmanstudios.memory

/**
 * Allows translation of card numbers selected by the player into (y,x) coordinates
 * on the game board. This was added as it is more user friendly than selecting 
 * a card by coordinates. 
 * 
 * @author Iain Duff
 */
object CardToBoardTranslator {

  def translateCardNumberIntoBoardGridLocation(cardNumber: Int) = {
    //subtract 1, as board numbers count from 0 but users enter card numbers from 1, for ease of use
    val cardNumberFromZero = cardNumber - 1
    val rowNumber = cardNumberFromZero / 4
    val columnNumber = cardNumberFromZero % 4
    (columnNumber, rowNumber)
  }
}
