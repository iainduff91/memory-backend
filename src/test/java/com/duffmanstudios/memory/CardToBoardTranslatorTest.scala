package com.duffmanstudios.memory

/**
 * Contains unit tests for the CardToBoardTranslator
 *
 * @author Iain Duff
 */
class CardToBoardTranslatorTest extends ProjectTest {

  "translateCardNumberIntoBoardGridLocation" must "return the correct location in the board depending on the card number selected" in {
    val first = 1
    val second = 2
    val third = 3
    val fourth = 4
    val last = game.board.getNumCards
    val totalNumCards = game.board.getNumCards

    val translatedFirst = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(first, totalNumCards)
    val translatedSecond = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(second, totalNumCards)
    val translatedThird = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(third, totalNumCards)
    val translatedFourth = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(fourth, totalNumCards)
    val translatedLast = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(last, totalNumCards)

    translatedFirst should equal ((0, 0))
    translatedSecond should equal ((1, 0))
    translatedThird should equal ((2, 0))
    translatedFourth should equal ((3, 0))
    translatedLast should equal ((1, 2))
  }

    "checkNumberValid" must "throw an IllegalArgumentException when the card number is below zero" in {
      val totalNumOfCards = game.board.getNumCards
      val illegalNumber = 0
      intercept[IllegalArgumentException] {
        CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(illegalNumber, totalNumOfCards)
      }
    }

    "checkNumberValid" must "throw an IllegalArgumentException when the card number is greater than the total number of cards" in {
      val totalNumOfCards = game.board.getNumCards
      val illegalNumber = totalNumOfCards + 1

      intercept[IllegalArgumentException] {
        CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(illegalNumber, totalNumOfCards)
      }
    }

    "checkNumberValid" must "NOT throw an Exception if the card number is between 1 and the total number of cards inclusive" in {
      val validNumberOne = 1
      val validNumberTwo = 5
      val validNumberThree = game.board.getNumCards
      val totalCardsInGame = game.board.getNumCards

      try {
        CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(validNumberOne, totalCardsInGame)
        CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(validNumberTwo, totalCardsInGame)
        CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(validNumberThree, totalCardsInGame)
      } catch {
        case e: IllegalArgumentException => fail("Exceptions thrown for valid numbers")
      }
    }
}
