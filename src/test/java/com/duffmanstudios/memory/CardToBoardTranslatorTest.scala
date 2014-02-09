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

    val translatedFirst = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(first)
    val translatedSecond = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(second)
    val translatedThird = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(third)
    val translatedFourth = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(fourth)
    val translatedLast = CardToBoardTranslator.translateCardNumberIntoBoardGridLocation(last)

    translatedFirst should equal ((0, 0))
    translatedSecond should equal ((1, 0))
    translatedThird should equal ((2, 0))
    translatedFourth should equal ((3, 0))
    translatedLast should equal ((1, 2))
  }
}
