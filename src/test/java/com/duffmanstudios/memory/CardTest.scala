package com.duffmanstudios.memory

import org.scalatest.{Matchers, FlatSpec}

/**
 * Contains unit tests for the functionality in Card
 *
 * @author Iain Duff
 */
class CardTest extends ProjectTest {

  "Two cards with matching IDs" must "be identified as having matching IDs" in {
    val cardOne = new Card(1, defaultFileName)
    val cardTwo = new Card(1, defaultFileName)

    cardOne.Id should equal (cardTwo.Id)
  }

  "Two cards with non-matching IDs" must "be identified as having non-matching IDs" in {
    val cardOne = new Card(1, defaultFileName)
    val cardTwo = new Card(2, defaultFileName)

    cardOne.Id should not equal cardTwo.Id
  }

  "Two cards with matching filenames" must "be identified as having matching filenames" in {
    val cardOne = new Card(1, "file_1.png")
    val cardTwo = new Card(2, "file_1.png")

    cardOne.fileName should equal (cardTwo.fileName)
  }

  "Two cards with non-matching filenames" must "be identified as having non-matching filenames" in {
    val cardOne = new Card(1, "file_1.png")
    val cardTwo = new Card(1, "file_2.png")

    cardOne.fileName should not equal cardTwo.fileName
  }

  "equals" must "return true if both reference the same object" in {
    val cardOne = new Card(1, defaultFileName)
    val cardTwo = cardOne

    assert(cardOne.equals(cardTwo))
  }

  "equals" must "return false if object to compare to is NOT a Card" in {
    val cardOne = new Card(1, defaultFileName)
    val notACard = new String("")

    assertResult(false)(cardOne.equals(notACard))
  }

  "equals" must "return true if cards have the SAME ID and SAME FILENAME" in {
    val cardOne = new Card(1, defaultFileName)
    val cardTwo = new Card(1, defaultFileName)

    assert(cardOne.equals(cardTwo))
  }

  "equals" must "return false if cards have DIFFERENT IDs but SAME FILENAME" in {
    val cardOne = new Card(1, defaultFileName)
    val cardTwo = new Card(2, defaultFileName)

    assertResult(false)(cardOne.equals(cardTwo))
  }

  "equals" must "return false if cards have SAME ID but DIFFERENT FILENAMES" in {
    val cardOne = new Card(1, "example.png")
    val cardTwo = new Card(1, "different_name.png")

    assert(!cardOne.equals(cardTwo))
  }

  "equals" must "return false if cards have DIFFERENT IDs and DIFFERENT FILENAMES" in {
    val cardOne = new Card(1, "file_1.png")
    val cardTwo = new Card(2, "file_2.png")

    assert(!cardOne.equals(cardTwo))
  }
}
