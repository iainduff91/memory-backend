package com.duffmanstudios.memory

/**
 * Represents a single playing card in the game.
 *
 * @author Iain Duff
 * @param Id The ID used to identify whether this card matches another
 */
class Card(val Id: Int) {

  override def equals(other: Any): Boolean = {
    other.isInstanceOf[Card] &&
      other.asInstanceOf[Card].Id == this.Id
  }
}
