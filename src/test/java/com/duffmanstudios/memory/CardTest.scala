package com.duffmanstudios.memory

import org.scalatest.{Matchers, FlatSpec}

/**
 * Contains unit tests for the functionality in Card
 *
 * @author Iain Duff
 */
class CardTest extends ProjectTest {

  "Two cards with matching IDs" must "be identified as having matching IDs" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(1)

    cardOne.Id should equal (cardTwo.Id)
  }

  "Two cards with non-matching IDs" must "be identified as having non-matching IDs" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(2)

    cardOne.Id should not equal cardTwo.Id
  }

  "equals" must "return true if both reference the same object" in {
    val cardOne = new Card(1)
    val cardTwo = cardOne

    assert(cardOne.equals(cardTwo))
  }

  "equals" must "return false if object to compare to is NOT a Card" in {
    val cardOne = new Card(1)
    val notACard = new String("")

    assertResult(false)(cardOne.equals(notACard))
  }

  "equals" must "return true if cards have the SAME ID" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(1)

    assert(cardOne.equals(cardTwo))
  }

  "equals" must "return false if cards have DIFFERENT IDs" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(2)

    assertResult(false)(cardOne.equals(cardTwo))
  }
}
