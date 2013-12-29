package com.duffmanstudios.memory

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by Student on 27/12/13.
 */
class CardTest extends FlatSpec with Matchers {

  "Two matching cards" must "be identified as matching" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(1)

    cardOne.Id should equal (cardTwo.Id)
  }

  "Two non-matching cards" must "be identified as not matching" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(2)

    cardOne.Id should not equal (cardTwo.Id)
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

  "equals" must "return false if cards have different IDs" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(2)

    assertResult(false)(cardOne.equals(cardTwo))
  }

  "equals" must "return true if cards have the SAME ID" in {
    val cardOne = new Card(1)
    val cardTwo = new Card(1)

    assert(cardOne.equals(cardTwo))
  }
}
