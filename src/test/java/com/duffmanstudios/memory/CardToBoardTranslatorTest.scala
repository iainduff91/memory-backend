package com.duffmanstudios.memory

/**
 * Contains unit tests for the CardToBoardTranslator
 *
 * @author Iain Duff
 */
class CardToBoardTranslatorTest extends ProjectTest {

  val totalNumberOfCards = game.board.getNumCards

  "translateCardNumberIntoBoardGridLocation" must "return the cell in the first column of the first row for the very first card" in {
    val numberOfFirstCard = 1

    val translated = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(numberOfFirstCard, totalNumberOfCards)

    translated should equal ((0, 0))
  }

  "translateCardNumberIntoBoardGridLocation" must "return the cell in the second column of the first row for the second card" in {
    val numberOfSecondCard = 2

    val translated = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(numberOfSecondCard, totalNumberOfCards)

    translated should equal ((1, 0))
  }

  "translateCardNumberIntoBoardGridLocation" must "return the cell in the third column of the first row for the third card" in {
    val numberOfThirdCard = 3

    val translated = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(numberOfThirdCard, totalNumberOfCards)

    translated should equal ((2, 0))
  }

  "translateCardNumberIntoBoardGridLocation" must "return the cell in the fourth column of the first row for the fourth card" in {
    val numberOfFourthCard = 4

    val translated = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(numberOfFourthCard, totalNumberOfCards)

    translated should equal ((3, 0))
  }

  "translateCardNumberIntoBoardGridLocation" must "return the tenth location on the board (working left to right then down a row) for the tenth card in the game" in {
    val numberOfTenthCard = 10

    val translated = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(numberOfTenthCard, totalNumberOfCards)

    translated should equal((1, 2))
  }

    "checkNumberValid" must "throw an IllegalArgumentException when the card number is below zero" in {
      val illegalNumber = 0
      intercept[IllegalArgumentException] {
        CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(illegalNumber, totalNumberOfCards)
      }
    }

    "checkNumberValid" must "throw an IllegalArgumentException when the card number is greater than the total number of cards" in {
      val illegalNumber = totalNumberOfCards + 1

      intercept[IllegalArgumentException] {
        CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(illegalNumber, totalNumberOfCards)
      }
    }

    "checkNumberValid" must "NOT throw an Exception if the card number is between 1 and the total number of cards inclusive" in {
      val validNumberOne = 1
      val validNumberTwo = 5
      val validNumberThree = totalNumberOfCards

      try {
        CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(validNumberOne, totalNumberOfCards)
        CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(validNumberTwo, totalNumberOfCards)
        CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(validNumberThree, totalNumberOfCards)
      } catch {
        case e: IllegalArgumentException => fail("Exceptions thrown for valid numbers")
      }
    }
}
