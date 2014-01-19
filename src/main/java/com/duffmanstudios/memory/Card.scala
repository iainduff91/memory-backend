package com.duffmanstudios.memory

/**
 * Represents a single playing card in the game.
 *
 * @author Iain Duff
 * @param Id The ID used to identify whether this card matches another
 * @param fileName The fileName associated with the image this card represents
 */
class Card(val Id: Int, val fileName: String) {

  override def equals(other: Any): Boolean = {
    other.isInstanceOf[Card] &&
      other.asInstanceOf[Card].Id == this.Id &&
      other.asInstanceOf[Card].fileName.equals(this.fileName)
  }
}
