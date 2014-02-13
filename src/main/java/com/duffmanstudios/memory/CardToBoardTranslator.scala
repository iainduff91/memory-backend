package com.duffmanstudios.memory

/**
 * Allows translation of card numbers selected by the player into (y,x) coordinates
 * on the game board. This was added as it is more user friendly than selecting 
 * a card by coordinates. 
 * 
 * @author Iain Duff
 */
object CardToBoardTranslator {

  def translateCardNumberIntoBoardGridLocation(cardNumber: Int, numCardsInGame: Int) = {
    checkNumberValid(cardNumber, numCardsInGame)
    //subtract 1, as board numbers count from 0 but users enter card numbers from 1, for ease of use
    val cardNumberFromZero = cardNumber - 1
    val rowNumber = cardNumberFromZero / 4
    val columnNumber = cardNumberFromZero % 4
    (columnNumber, rowNumber)
  }

  private def checkNumberValid(cardNumber: Int, numCardsInGame: Int) = {
    if (cardNumber < 1) {
      throw new IllegalArgumentException("The card number must be 1 or above")
    } else if (cardNumber > numCardsInGame) {
      throw new IllegalArgumentException("The card number must be less than the total number of cards")
    }
  }
}
